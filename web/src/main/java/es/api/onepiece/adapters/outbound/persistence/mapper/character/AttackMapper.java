package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.AttackEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterSummaryEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.character.TransformationEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.DebutMapper;
import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.vo.character.attack.CreateAttackVo;
import es.api.onepiece.core.internal.vo.character.attack.UpdateAttackVo;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Objects;

/**
 * The Interface AttackMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring", uses = {
        DebutMapper.class, TransformationMapper.class })
public interface AttackMapper {

    /**
     * To attack.
     *
     * @param attackEntity the entity
     * @return the attack
     */
    @Mapping(target = "character", ignore = true)
    Attack toAttack(AttackEntity attackEntity);

    /**
     * To attack list.
     *
     * @param attackEntities the entities
     * @return the list
     */
    List<Attack> toAttackList(List<AttackEntity> attackEntities);

    /**
     * To attack entity from create vo.
     *
     * @param createAttackVo the create attack vo
     * @return the attack entity
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "character", source = "characterId", qualifiedByName = "characterIdToCharacterSummaryEntity")
    @Mapping(target = "transformation", source = "transformationId", qualifiedByName = "transformationIdToTransformationEntity")
    @Mapping(target = "debut", source = "debutId", qualifiedByName = "debutIdToDebutEntity")
    AttackEntity toAttackEntity(CreateAttackVo createAttackVo);

    /**
     * To attack entity from update vo.
     *
     * @param updateAttackVo the update attack vo
     * @return the attack entity
     */
    @Mapping(target = "character", source = "characterId", qualifiedByName = "characterIdToCharacterSummaryEntity")
    @Mapping(target = "transformation", source = "transformationId", qualifiedByName = "transformationIdToTransformationEntity")
    @Mapping(target = "debut", source = "debutId", qualifiedByName = "debutIdToDebutEntity")
    AttackEntity toAttackEntity(UpdateAttackVo updateAttackVo);

    /**
     * Character id to character summary entity.
     *
     * @param characterId the character id
     * @return the character summary entity
     */
    @Named("characterIdToCharacterSummaryEntity")
    default CharacterSummaryEntity characterIdToCharacterSummaryEntity(Integer characterId) {
        if (Objects.isNull(characterId)) {
            return null;
        }
        final var characterSummaryEntity = new CharacterSummaryEntity();
        characterSummaryEntity.setId(characterId);
        return characterSummaryEntity;
    }

    /**
     * Transformation id to transformation entity.
     *
     * @param transformationId the transformation id
     * @return the transformation entity
     */
    @Named("transformationIdToTransformationEntity")
    default TransformationEntity transformationIdToTransformationEntity(Integer transformationId) {
        if (Objects.isNull(transformationId)) {
            return null;
        }
        final var transformationEntity = new TransformationEntity();
        transformationEntity.setId(transformationId);
        return transformationEntity;
    }

    /**
     * Debut id to debut entity.
     *
     * @param debutId the debut id
     * @return the debut entity
     */
    @Named("debutIdToDebutEntity")
    default DebutEntity debutIdToDebutEntity(Integer debutId) {
        if (Objects.isNull(debutId)) {
            return null;
        }
        final var debutEntity = new DebutEntity();
        debutEntity.setId(debutId);
        return debutEntity;
    }
}
