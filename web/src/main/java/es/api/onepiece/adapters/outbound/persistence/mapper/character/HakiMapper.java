package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.HakiEntity;
import es.api.onepiece.core.internal.domain.character.Haki;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.enums.HakiTypeEnumMapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface HakiMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {HakiTypeEnumMapper.class}
)
public interface HakiMapper {
    
    /**
     * To haki.
     *
     * @param entity the entity
     * @return the haki
     */
    @Mapping(source = "name", target = "type")
    Haki toHaki(HakiEntity entity);
}
