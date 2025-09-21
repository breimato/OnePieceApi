package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.TransformationEntity;
import es.api.onepiece.core.internal.domain.character.Transformation;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface TransformationMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {es.api.onepiece.adapters.outbound.persistence.mapper.debut.DebutMapper.class}
)
public interface TransformationMapper {

    /**
     * To transformation.
     *
     * @param entity the entity
     * @return the transformation
     */
    @Mapping(target = "character", ignore = true)
    Transformation toTransformation(TransformationEntity entity);
}
