package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.RaceEntity;
import es.api.onepiece.core.internal.domain.character.Race;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface RaceMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface RaceMapper {

    /**
     * To race.
     *
     * @param entity the entity
     * @return the race
     */
    Race toRace(RaceEntity entity);

    /**
     * To race entity.
     *
     * @param race the race
     * @return the race entity
     */
    RaceEntity toRaceEntity(Race race);
}
