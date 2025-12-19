package es.api.onepiece.adapters.outbound.persistence.repository.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.CharacterMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import es.api.onepiece.core.ports.outbound.character.CreateCharacterPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

/**
 * The Class CharacterCreateRepository.
 */
@Component
@RequiredArgsConstructor
public class CharacterCreateRepository implements CreateCharacterPersistencePort {

    /** The character my batis mapper. */
    private final CharacterMyBatisMapper characterMyBatisMapper;

    /** The character mapper. */
    private final CharacterMapper characterMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Character execute(@Valid final CreateCharacterVo createCharacterVo) {

        final var characterEntity = this.characterMapper.toCharacterEntityFromVo(createCharacterVo);

        this.characterMyBatisMapper.insertCharacter(characterEntity);

        this.insertRelatedEntities(characterEntity, createCharacterVo);

        final var createdCharacterEntity = this.characterMyBatisMapper.getCharacterById(characterEntity.getId());

        return this.characterMapper.toCharacter(createdCharacterEntity);
    }

    /**
     * Insert related entities.
     *
     * @param characterEntity   the character entity
     * @param createCharacterVo the create character vo
     */
    private void insertRelatedEntities(final CharacterEntity characterEntity,
            final CreateCharacterVo createCharacterVo) {

        if (CollectionUtils.isNotEmpty(createCharacterVo.getFruitIds())) {
            this.characterMyBatisMapper.insertFruits(characterEntity.getId(), createCharacterVo.getFruitIds());
        }
        if (CollectionUtils.isNotEmpty(createCharacterVo.getHakiIds())) {
            this.characterMyBatisMapper.insertHakis(characterEntity.getId(), createCharacterVo.getHakiIds());
        }
        if (CollectionUtils.isNotEmpty(createCharacterVo.getTitleIds())) {
            this.characterMyBatisMapper.insertTitles(characterEntity.getId(), createCharacterVo.getTitleIds());
        }
        if (CollectionUtils.isNotEmpty(createCharacterVo.getJobIds())) {
            this.characterMyBatisMapper.insertJobs(characterEntity.getId(), createCharacterVo.getJobIds());
        }
        if (CollectionUtils.isNotEmpty(createCharacterVo.getCharacterAffiliations())) {
            this.characterMyBatisMapper.insertAffiliations(characterEntity.getId(),
                    createCharacterVo.getCharacterAffiliations());
        }
        if (CollectionUtils.isNotEmpty(createCharacterVo.getSwordIds())) {
            this.characterMyBatisMapper.insertSwords(characterEntity.getId(), createCharacterVo.getSwordIds());
        }
        if (CollectionUtils.isNotEmpty(createCharacterVo.getTransformationIds())) {
            this.characterMyBatisMapper.insertTransformations(characterEntity.getId(),
                    createCharacterVo.getTransformationIds());
        }
        if (CollectionUtils.isNotEmpty(createCharacterVo.getAttackIds())) {
            this.characterMyBatisMapper.insertAttacks(characterEntity.getId(), createCharacterVo.getAttackIds());
        }
    }
}
