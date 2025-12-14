package es.api.onepiece.adapters.inbound.rest.mapper.character;

import es.api.onepiece.core.internal.domain.character.CharacterAffiliation;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.CharacterAffiliationDto;
import java.util.List;

/**
 * The Interface CharacterAffiliationDtoMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring", uses = {
        AffiliationDtoMapper.class })
public interface CharacterAffiliationDtoMapper {

    /**
     * To dto.
     *
     * @param characterAffiliation the character affiliation
     * @return the character affiliation dto
     */
    CharacterAffiliationDto toCharacterAffiliationDto(CharacterAffiliation characterAffiliation);

    /**
     * To dto list.
     *
     * @param characterAffiliations the character affiliations
     * @return the list
     */
    List<CharacterAffiliationDto> toCharacterAffiliationDtoList(List<CharacterAffiliation> characterAffiliations);
}
