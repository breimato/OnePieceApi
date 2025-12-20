package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.character.TransformationEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.DebutMapper;
import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.internal.vo.character.transformation.CreateTransformationVo;
import es.api.onepiece.core.internal.vo.character.transformation.UpdateTransformationVo;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * The Interface TransformationMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring", uses = {
        DebutMapper.class })
public interface TransformationMapper {

    /**
     * To transformation.
     *
     * @param transformationEntity the transformation entity
     * @return the transformation
     */
    @Mapping(target = "character", ignore = true)
    Transformation toTransformation(TransformationEntity transformationEntity);

    /**
     * To transformation list.
     *
     * @param transformationEntities the transformation entities
     * @return the list
     */
    List<Transformation> toTransformationList(List<TransformationEntity> transformationEntities);

    /**
     * To transformation entity.
     *
     * @param createTransformationVo the create transformation vo
     * @return the transformation entity
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "character", expression = "java(mapCharacter(createTransformationVo.getCharacterId()))")
    @Mapping(target = "debut", expression = "java(mapDebut(createTransformationVo.getDebutId()))")
    TransformationEntity toTransformationEntity(CreateTransformationVo createTransformationVo);

    /**
     * To transformation entity.
     *
     * @param updateTransformationVo the update transformation vo
     * @return the transformation entity
     */
    @Mapping(target = "character", expression = "java(mapCharacter(updateTransformationVo.getCharacterId()))")
    @Mapping(target = "debut", expression = "java(mapDebut(updateTransformationVo.getDebutId()))")
    TransformationEntity toTransformationEntity(UpdateTransformationVo updateTransformationVo);

    /**
     * Map character.
     *
     * @param characterId the character id
     * @return the character entity
     */
    default CharacterEntity mapCharacter(Integer characterId) {
        if (characterId == null) {
            return null;
        }
        final var characterEntity = new CharacterEntity();
        characterEntity.setId(characterId);
        return characterEntity;
    }

    /**
     * Map debut.
     *
     * @param debutId the debut id
     * @return the debut entity
     */
    default DebutEntity mapDebut(Integer debutId) {
        if (debutId == null) {
            return null;
        }
        final var debutEntity = new DebutEntity();
        debutEntity.setId(debutId);
        return debutEntity;
    }
}
