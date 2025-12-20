package es.api.onepiece.adapters.outbound.persistence.repository.character;

import es.api.onepiece.adapters.outbound.persistence.mapper.character.CharacterMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper;
import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.FruitException;
import es.api.onepiece.core.exceptions.HakiException;
import es.api.onepiece.core.exceptions.SwordException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.vo.character.UpdateCharacterVo;
import es.api.onepiece.core.ports.outbound.character.FindCharactersPersistencePort;
import es.api.onepiece.core.ports.outbound.character.UpdateCharacterPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * The Class CharacterUpdateRepository.
 */
@Component
@RequiredArgsConstructor
public class CharacterUpdateRepository implements UpdateCharacterPersistencePort {

    /** The Find character persistence port. */
    private final FindCharactersPersistencePort findCharacterPersistencePort;

    /** The character my batis mapper. */
    private final CharacterMyBatisMapper characterMyBatisMapper;

    /** The character mapper. */
    private final CharacterMapper characterMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Character execute(@Valid final UpdateCharacterVo updateCharacterVo) {

        final var characterExists = this.findCharacterPersistencePort.exists(updateCharacterVo.getId());

        if (BooleanUtils.isFalse(characterExists)) {

            throw new CharacterException(
                     ExceptionMessageConstants.CHARACTER_NOT_FOUND_CODE_ERROR,
                     ExceptionMessageConstants.CHARACTER_NOT_FOUND_MESSAGE_ERROR);
        }

        final var characterEntity = this.characterMapper.toCharacterEntityFromUpdateVo(updateCharacterVo);
        this.characterMyBatisMapper.updateCharacter(characterEntity);

        this.updateRelatedEntities(updateCharacterVo.getId(), updateCharacterVo);

        final var updatedCharacterEntity = this.characterMyBatisMapper.getCharacterById(updateCharacterVo.getId());

        return this.characterMapper.toCharacter(updatedCharacterEntity);
    }

    /**
     * Update related entities.
     *
     * @param characterId       the character id
     * @param updateCharacterVo the update character vo
     */
    private void updateRelatedEntities(final Integer characterId, final UpdateCharacterVo updateCharacterVo) {

        this.updateRelation(updateCharacterVo.getFruitIds(),
                () -> this.characterMyBatisMapper.deleteFruitsByCharacterId(characterId),
                () -> this.characterMyBatisMapper.insertFruits(characterId, updateCharacterVo.getFruitIds()),
                () -> new FruitException(ExceptionMessageConstants.FRUIT_UPDATE_CODE_ERROR, ExceptionMessageConstants.FRUIT_UPDATE_MESSAGE_ERROR));

        this.updateRelation(updateCharacterVo.getHakiIds(),
                () -> this.characterMyBatisMapper.deleteHakisByCharacterId(characterId),
                () -> this.characterMyBatisMapper.insertHakis(characterId, updateCharacterVo.getHakiIds()),
                () -> new HakiException(ExceptionMessageConstants.HAKI_UPDATE_CODE_ERROR, ExceptionMessageConstants.HAKI_UPDATE_MESSAGE_ERROR));

        this.updateRelation(updateCharacterVo.getTitleIds(),
                () -> this.characterMyBatisMapper.deleteTitlesByCharacterId(characterId),
                () -> this.characterMyBatisMapper.insertTitles(characterId, updateCharacterVo.getTitleIds()),
                () -> new CharacterException(ExceptionMessageConstants.TITLE_UPDATE_CODE_ERROR, ExceptionMessageConstants.TITLE_UPDATE_MESSAGE_ERROR));

        this.updateRelation(updateCharacterVo.getJobIds(),
                () -> this.characterMyBatisMapper.deleteJobsByCharacterId(characterId),
                () -> this.characterMyBatisMapper.insertJobs(characterId, updateCharacterVo.getJobIds()),
                () -> new CharacterException(ExceptionMessageConstants.JOB_UPDATE_CODE_ERROR, ExceptionMessageConstants.JOB_UPDATE_MESSAGE_ERROR));

        this.updateRelation(updateCharacterVo.getCharacterAffiliations(),
                () -> this.characterMyBatisMapper.deleteAffiliationsByCharacterId(characterId),
                () -> this.characterMyBatisMapper.insertAffiliations(characterId,
                        updateCharacterVo.getCharacterAffiliations()),
                () -> new CharacterException(ExceptionMessageConstants.AFFILIATION_UPDATE_CODE_ERROR, ExceptionMessageConstants.AFFILIATION_UPDATE_MESSAGE_ERROR));

        this.updateRelation(updateCharacterVo.getSwordIds(),
                () -> this.characterMyBatisMapper.deleteSwordsByCharacterId(characterId),
                () -> this.characterMyBatisMapper.insertSwords(characterId, updateCharacterVo.getSwordIds()),
                () -> new SwordException(ExceptionMessageConstants.SWORD_UPDATE_CODE_ERROR, ExceptionMessageConstants.SWORD_UPDATE_MESSAGE_ERROR));

        this.updateRelation(updateCharacterVo.getAttackIds(),
                () -> this.characterMyBatisMapper.deleteAttacksByCharacterId(characterId),
                () -> this.characterMyBatisMapper.insertAttacks(characterId, updateCharacterVo.getAttackIds()),
                () -> new CharacterException(ExceptionMessageConstants.ATTACK_UPDATE_CODE_ERROR, ExceptionMessageConstants.ATTACK_UPDATE_MESSAGE_ERROR));

        this.updateRelation(updateCharacterVo.getTransformationIds(),
                () -> this.characterMyBatisMapper.deleteTransformationsByCharacterId(characterId),
                () -> this.characterMyBatisMapper.insertTransformations(characterId,
                        updateCharacterVo.getTransformationIds()),
                () -> new CharacterException(ExceptionMessageConstants.TRANSFORMATION_UPDATE_CODE_ERROR, ExceptionMessageConstants.TRANSFORMATION_UPDATE_MESSAGE_ERROR));
    }

    /**
     * Update relation.
     *
     * @param <E>               the exception type
     * @param ids               the ids
     * @param deleteOperation   the delete operation
     * @param insertOperation   the insert operation
     * @param exceptionSupplier the exception supplier
     */
    private <E extends RuntimeException> void updateRelation(
            final List<?> ids,
            final Runnable deleteOperation,
            final Runnable insertOperation,
            final Supplier<E> exceptionSupplier) {
        if (Objects.nonNull(ids)) {
            try {
                deleteOperation.run();
                if (CollectionUtils.isNotEmpty(ids)) {
                    insertOperation.run();
                }
            } catch (final DataAccessException exception) {
                throw exceptionSupplier.get();
            }
        }
    }
}
