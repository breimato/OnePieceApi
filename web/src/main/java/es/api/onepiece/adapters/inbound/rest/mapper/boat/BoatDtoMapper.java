package es.api.onepiece.adapters.inbound.rest.mapper.boat;

import es.api.onepiece.core.internal.domain.boat.Boat;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.BoatDto;
import java.util.List;

/**
 * The Interface BoatDtoMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring"
)
public interface BoatDtoMapper {

    /**
     * To dto.
     *
     * @param boat the boat
     * @return the boat dto
     */
    @Mapping(source = "boatType", target = "type")
    BoatDto toDto(Boat boat);

    /**
     * To dto list.
     *
     * @param boats the boats
     * @return the list
     */
    List<BoatDto> toDtoList(List<Boat> boats);
}
