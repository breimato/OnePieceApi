package es.api.onepiece.adapters.outbound.persistence.mapper.sword;

import es.api.onepiece.core.internal.domain.sword.enums.SwordCategoryTypeEnum;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface SwordCategoryTypeEnumMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        implementationName = "SwordCategoryTypeEnumMapperFromPersistence")
public interface SwordCategoryTypeEnumMapper {

    /**
     * To enum.
     *
     * @param category the category
     * @return the sword category type enum
     */
    default SwordCategoryTypeEnum toEnum(String category) {
        return SwordCategoryTypeEnum.getByName(category);
    }
}
