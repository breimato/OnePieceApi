package es.api.onepiece.adapters.outbound.persistence.mapper.sword;

import es.api.onepiece.adapters.outbound.persistence.entities.sword.SwordEntity;
import es.api.onepiece.core.internal.domain.sword.Sword;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface SwordMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {SwordCategoryMapper.class, SwordStatusEnumMapper.class, es.api.onepiece.adapters.outbound.persistence.mapper.debut.DebutMapper.class}
)
public interface SwordMapper {

    /**
     * To sword.
     *
     * @param entity the entity
     * @return the sword
     */
    Sword toSword(SwordEntity entity);
}
