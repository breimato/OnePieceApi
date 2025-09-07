package es.api.onepiece.adapters.inbound.rest.mapper.character;

import org.openapitools.model.CharacterDto;
import es.api.onepiece.core.internal.domain.character.Character;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * The Interface CharacterDtoMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring"
)
public interface CharacterDtoMapper {

    /**
     * To character V 1 dto.
     *
     * @param character the character
     * @return the character dto
     */
    CharacterDto toCharacterV1Dto(Character character);

    /**
     * To character V 1 dto list.
     *
     * @param characters the characters
     * @return the list
     */
    List<CharacterDto> toCharacterV1DtoList(List<Character> characters);
}
