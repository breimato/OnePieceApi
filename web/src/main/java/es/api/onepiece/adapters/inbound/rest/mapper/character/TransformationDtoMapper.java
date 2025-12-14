package es.api.onepiece.adapters.inbound.rest.mapper.character;

import es.api.onepiece.core.internal.domain.character.Transformation;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.TransformationDto;
import java.util.List;

/**
 * The Interface TransformationDtoMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface TransformationDtoMapper {

    /**
     * To dto.
     *
     * @param transformation the transformation
     * @return the transformation dto
     */
    TransformationDto toTransformationDto(Transformation transformation);

    /**
     * To dto list.
     *
     * @param transformations the transformations
     * @return the list
     */
    List<TransformationDto> toTransformationDtoList(List<Transformation> transformations);
}
