package es.api.onepiece.adapters.outbound.persistence.mapper.fruit;

import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * The Interface FruitMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {FruitTypeEnumMapper.class}
)
public interface FruitMapper {

    /**
     * To fruit.
     *
     * @param entity the entity
     * @return the fruit
     */
    Fruit toFruit(FruitEntity entity);

    /**
     * To fruit list.
     *
     * @param entities the entities
     * @return the list
     */
    List<Fruit> toFruitList(List<FruitEntity> entities);
}
