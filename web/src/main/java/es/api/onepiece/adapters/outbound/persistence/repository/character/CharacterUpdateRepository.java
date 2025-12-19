package es.api.onepiece.adapters.outbound.persistence.repository.character;

import es.api.onepiece.adapters.outbound.persistence.mapper.character.CharacterMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.vo.character.UpdateCharacterVo;
import es.api.onepiece.core.ports.outbound.character.UpdateCharacterPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * The Class CharacterUpdateRepository.
 */
@Component
@RequiredArgsConstructor
public class CharacterUpdateRepository implements UpdateCharacterPersistencePort {

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

        if (Objects.nonNull(updateCharacterVo.getFruitIds())) {
            this.characterMyBatisMapper.deleteFruitsByCharacterId(characterId);
            if (CollectionUtils.isNotEmpty(updateCharacterVo.getFruitIds())) {
                this.characterMyBatisMapper.insertFruits(characterId, updateCharacterVo.getFruitIds());
            }
        }
        if (Objects.nonNull(updateCharacterVo.getHakiIds())) {
            this.characterMyBatisMapper.deleteHakisByCharacterId(characterId);
            if (CollectionUtils.isNotEmpty(updateCharacterVo.getHakiIds())) {
                this.characterMyBatisMapper.insertHakis(characterId, updateCharacterVo.getHakiIds());
            }
        }
        if (Objects.nonNull(updateCharacterVo.getTitleIds())) {
            this.characterMyBatisMapper.deleteTitlesByCharacterId(characterId);
            if (CollectionUtils.isNotEmpty(updateCharacterVo.getTitleIds())) {
                this.characterMyBatisMapper.insertTitles(characterId, updateCharacterVo.getTitleIds());
            }
        }
        if (Objects.nonNull(updateCharacterVo.getJobIds())) {
            this.characterMyBatisMapper.deleteJobsByCharacterId(characterId);
            if (CollectionUtils.isNotEmpty(updateCharacterVo.getJobIds())) {
                this.characterMyBatisMapper.insertJobs(characterId, updateCharacterVo.getJobIds());
            }
        }
        if (Objects.nonNull(updateCharacterVo.getCharacterAffiliations())) {
            this.characterMyBatisMapper.deleteAffiliationsByCharacterId(characterId);
            if (CollectionUtils.isNotEmpty(updateCharacterVo.getCharacterAffiliations())) {
                this.characterMyBatisMapper.insertAffiliations(characterId,
                        updateCharacterVo.getCharacterAffiliations());
            }
        }
        if (Objects.nonNull(updateCharacterVo.getSwordIds())) {
            this.characterMyBatisMapper.deleteSwordsByCharacterId(characterId);
            if (CollectionUtils.isNotEmpty(updateCharacterVo.getSwordIds())) {
                this.characterMyBatisMapper.insertSwords(characterId, updateCharacterVo.getSwordIds());
            }
        }
        if (Objects.nonNull(updateCharacterVo.getAttackIds())) {
            this.characterMyBatisMapper.deleteAttacksByCharacterId(characterId);
            if (CollectionUtils.isNotEmpty(updateCharacterVo.getAttackIds())) {
                this.characterMyBatisMapper.insertAttacks(characterId, updateCharacterVo.getAttackIds());
            }
        }
        if (Objects.nonNull(updateCharacterVo.getTransformationIds())) {
            this.characterMyBatisMapper.deleteTransformationsByCharacterId(characterId);
            if (CollectionUtils.isNotEmpty(updateCharacterVo.getTransformationIds())) {
                this.characterMyBatisMapper.insertTransformations(characterId,
                        updateCharacterVo.getTransformationIds());
            }
        }
    }
}
