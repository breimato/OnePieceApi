package es.api.onepiece.adapters.inbound.rest.mapper.character;

import es.api.onepiece.core.internal.domain.character.CharacterSummary;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.CharacterSummaryDto;

import java.util.List;

/**
 * The Interface CharacterSummaryDtoMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface CharacterSummaryDtoMapper {

    /**
     * To dto.
     *
     * @param characterSummary the character summary
     * @return the character summary dto
     */
    CharacterSummaryDto toCharacterSummaryDto(CharacterSummary characterSummary);

    /**
     * To dto list.
     *
     * @param characterSummaries the character summaries
     * @return the list
     */
    List<CharacterSummaryDto> toCharacterSummaryDtoList(List<CharacterSummary> characterSummaries);
}
