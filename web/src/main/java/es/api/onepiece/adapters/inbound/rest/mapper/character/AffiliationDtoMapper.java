package es.api.onepiece.adapters.inbound.rest.mapper.character;

import es.api.onepiece.adapters.inbound.rest.mapper.character.CharacterBasicDtoMapper;
import es.api.onepiece.adapters.inbound.rest.mapper.boat.BoatDtoMapper;
import es.api.onepiece.core.internal.domain.character.Affiliation;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.AffiliationDto;
import java.util.List;

/**
 * The Interface AffiliationDtoMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {CharacterBasicDtoMapper.class, BoatDtoMapper.class}
)
public interface AffiliationDtoMapper {

    /**
     * To dto.
     *
     * @param affiliation the affiliation
     * @return the affiliation dto
     */
    AffiliationDto toDto(Affiliation affiliation);

    /**
     * To dto list.
     *
     * @param affiliations the affiliations
     * @return the list
     */
    List<AffiliationDto> toDtoList(List<Affiliation> affiliations);
}
