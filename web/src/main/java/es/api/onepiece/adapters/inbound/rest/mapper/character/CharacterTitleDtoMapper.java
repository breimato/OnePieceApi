package es.api.onepiece.adapters.inbound.rest.mapper.character;

import es.api.onepiece.core.internal.domain.character.CharacterTitle;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.CharacterTitleDto;
import java.util.List;

/**
 * The Interface CharacterTitleDtoMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring"
)
public interface CharacterTitleDtoMapper {

    /**
     * To dto.
     *
     * @param characterTitle the character title
     * @return the character title dto
     */
    @Mapping(source = "title", target = "title")
    CharacterTitleDto toDto(CharacterTitle characterTitle);

    /**
     * To dto list.
     *
     * @param titles the titles
     * @return the list
     */
    List<CharacterTitleDto> toDtoList(List<CharacterTitle> titles);
}
