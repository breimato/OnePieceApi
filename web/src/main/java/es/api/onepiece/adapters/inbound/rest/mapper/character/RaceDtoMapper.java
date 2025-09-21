package es.api.onepiece.adapters.inbound.rest.mapper.character;

import es.api.onepiece.core.internal.domain.character.Race;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.RaceDto;
import java.util.List;

/**
 * The Interface RaceDtoMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring"
)
public interface RaceDtoMapper {

    /**
     * To dto.
     *
     * @param race the race
     * @return the race dto
     */
    RaceDto toDto(Race race);

    /**
     * To dto list.
     *
     * @param races the races
     * @return the list
     */
    List<RaceDto> toDtoList(List<Race> races);
}
