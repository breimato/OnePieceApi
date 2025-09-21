package es.api.onepiece.adapters.outbound.persistence.mapper.sword;

import es.api.onepiece.adapters.outbound.persistence.entities.sword.SwordCategoryEntity;
import es.api.onepiece.core.internal.domain.sword.SwordCategory;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface SwordCategoryMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = { SwordCategoryTypeEnumMapper.class }
)
public interface SwordCategoryMapper {
    
    /**
     * To sword category.
     *
     * @param entity the entity
     * @return the sword category
     */
    @Mapping(source = "name", target = "type")
    SwordCategory toSwordCategory(SwordCategoryEntity entity);
}
