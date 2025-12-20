package es.api.onepiece.adapters.inbound.rest.mapper.character;

import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.internal.vo.character.transformation.CreateTransformationVo;
import es.api.onepiece.core.internal.vo.character.transformation.UpdateTransformationVo;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.CreateTransformationRequestDto;
import org.openapitools.model.TransformationDto;
import org.openapitools.model.UpdateTransformationRequestDto;

import java.util.List;

/**
 * The Interface TransformationDtoMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface TransformationDtoMapper {

    /**
     * To transformation dto.
     *
     * @param transformation the transformation
     * @return the transformation dto
     */
    TransformationDto toTransformationDto(Transformation transformation);

    /**
     * To transformation dto list.
     *
     * @param transformations the transformations
     * @return the list
     */
    List<TransformationDto> toTransformationDtoList(List<Transformation> transformations);

    /**
     * To create transformation vo.
     *
     * @param createTransformationRequestDto the create transformation request dto
     * @return the create transformation vo
     */
    CreateTransformationVo toCreateTransformationVo(CreateTransformationRequestDto createTransformationRequestDto);

    /**
     * To update transformation vo.
     *
     * @param id                             the id
     * @param updateTransformationRequestDto the update transformation request dto
     * @return the update transformation vo
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "updateTransformationRequestDto.name")
    @Mapping(target = "description", source = "updateTransformationRequestDto.description")
    @Mapping(target = "debutId", source = "updateTransformationRequestDto.debutId")
    UpdateTransformationVo toUpdateTransformationVo(Integer id,
            UpdateTransformationRequestDto updateTransformationRequestDto);
}
