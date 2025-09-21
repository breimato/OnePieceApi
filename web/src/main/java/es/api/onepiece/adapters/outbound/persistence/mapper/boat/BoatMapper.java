package es.api.onepiece.adapters.outbound.persistence.mapper.boat;

import es.api.onepiece.adapters.outbound.persistence.entities.boat.BoatEntity;
import es.api.onepiece.core.internal.domain.boat.Boat;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface BoatMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {BoatTypeEnumMapper.class, es.api.onepiece.adapters.outbound.persistence.mapper.debut.DebutMapper.class}
)
public interface BoatMapper {

    /**
     * To boat.
     *
     * @param entity the entity
     * @return the boat
     */
    Boat toBoat(BoatEntity entity);
}
