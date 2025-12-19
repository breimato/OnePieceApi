package es.api.onepiece.adapters.outbound.persistence.mapper.fruit;

import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitTypeEntity;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.vo.fruit.CreateFruitVo;
import es.api.onepiece.core.internal.vo.fruit.UpdateFruitVo;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Objects;

/**
 * The Interface FruitMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring", uses = {
        FruitTypeEnumMapper.class })
public interface FruitMapper {

    /**
     * To fruit.
     *
     * @param fruitEntity the entity
     * @return the fruit
     */
    Fruit toFruit(FruitEntity fruitEntity);

    /**
     * To fruit list.
     *
     * @param fruitEntities the entities
     * @return the list
     */
    List<Fruit> toFruitList(List<FruitEntity> fruitEntities);

    /**
     * To fruit entity from create vo.
     *
     * @param createFruitVo the create fruit vo
     * @return the fruit entity
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "type", source = "typeId", qualifiedByName = "typeIdToFruitTypeEntity")
    FruitEntity toFruitEntity(CreateFruitVo createFruitVo);

    /**
     * To fruit entity from update vo.
     *
     * @param updateFruitVo the update fruit vo
     * @return the fruit entity
     */
    @Mapping(target = "type", source = "typeId", qualifiedByName = "typeIdToFruitTypeEntity")
    FruitEntity toFruitEntity(UpdateFruitVo updateFruitVo);

    /**
     * Type id to fruit type entity.
     *
     * @param typeId the type id
     * @return the fruit type entity
     */
    @Named("typeIdToFruitTypeEntity")
    default FruitTypeEntity typeIdToFruitTypeEntity(Integer typeId) {
        if (Objects.isNull(typeId)) {
            return null;
        }
        final var fruitTypeEntity = new FruitTypeEntity();
        fruitTypeEntity.setId(typeId);
        return fruitTypeEntity;
    }
}
