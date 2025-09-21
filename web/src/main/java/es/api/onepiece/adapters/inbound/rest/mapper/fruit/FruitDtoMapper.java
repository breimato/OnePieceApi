package es.api.onepiece.adapters.inbound.rest.mapper.fruit;

import es.api.onepiece.core.internal.domain.fruit.Fruit;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.FruitDto;
import java.util.List;

/**
 * The Interface FruitDtoMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring"
)
public interface FruitDtoMapper {

    /**
     * To dto.
     *
     * @param fruit the fruit
     * @return the fruit dto
     */
    FruitDto toDto(Fruit fruit);

    /**
     * To dto list.
     *
     * @param fruits the fruits
     * @return the list
     */
    List<FruitDto> toDtoList(List<Fruit> fruits);
}
