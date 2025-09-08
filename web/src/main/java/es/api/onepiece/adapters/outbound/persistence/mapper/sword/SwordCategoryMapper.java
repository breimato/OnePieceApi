package es.api.onepiece.adapters.outbound.persistence.mapper.sword;

import es.api.onepiece.adapters.outbound.persistence.entities.sword.SwordCategoryEntity;
import es.api.onepiece.core.internal.domain.sword.SwordCategory;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface SwordCategoryMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring"
)
public interface SwordCategoryMapper {
    
    /**
     * To sword category.
     *
     * @param entity the entity
     * @return the sword category
     */
    SwordCategory toSwordCategory(SwordCategoryEntity entity);
}
