package es.api.onepiece.adapters.inbound.rest.mapper.fruit;

import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.vo.fruit.CreateFruitVo;
import es.api.onepiece.core.internal.vo.fruit.UpdateFruitVo;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.CreateFruitRequestDto;
import org.openapitools.model.FruitDto;
import org.openapitools.model.UpdateFruitRequestDto;

import java.util.List;

/**
 * The Interface FruitDtoMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface FruitDtoMapper {

    /**
     * To dto.
     *
     * @param fruit the fruit
     * @return the fruit dto
     */
    FruitDto toFruitDto(Fruit fruit);

    /**
     * To dto list.
     *
     * @param fruits the fruits
     * @return the list
     */
    List<FruitDto> toFruitDtoList(List<Fruit> fruits);

    /**
     * To create fruit vo.
     *
     * @param createFruitRequestDto the create fruit request dto
     * @return the create fruit vo
     */
    CreateFruitVo toCreateFruitVo(CreateFruitRequestDto createFruitRequestDto);

    /**
     * To update fruit vo.
     *
     * @param id                    the id
     * @param updateFruitRequestDto the update fruit request dto
     * @return the update fruit vo
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "updateFruitRequestDto.name")
    @Mapping(target = "description", source = "updateFruitRequestDto.description")
    @Mapping(target = "image", source = "updateFruitRequestDto.image")
    @Mapping(target = "typeId", source = "updateFruitRequestDto.typeId")
    UpdateFruitVo toUpdateFruitVo(Integer id, UpdateFruitRequestDto updateFruitRequestDto);
}
