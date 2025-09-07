package es.api.onepiece.adapters.outbound.persistence.mapper.fruit;


import es.api.onepiece.adapters.outbound.persistence.entities.FruitTypeEntity;
import es.api.onepiece.core.internal.domain.fruit.enums.FruitTypeEnum;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


/**
 * The Interface FruitTypeEnumMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        implementationName = "FruitTypeEnumMapperFromPersistence")
public interface FruitTypeEnumMapper {

    /**
     * To fruit type enum.
     *
     * @param fruitTypeEntity the fruit type entity
     * @return the fruit type enum
     */
    default FruitTypeEnum toFruitTypeEnum(FruitTypeEntity fruitTypeEntity) {
        return FruitTypeEnum.getByName(fruitTypeEntity.getType());
    }
}
