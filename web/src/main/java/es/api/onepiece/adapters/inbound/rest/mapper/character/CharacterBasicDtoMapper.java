package es.api.onepiece.adapters.inbound.rest.mapper.character;

import es.api.onepiece.core.internal.domain.character.BaseCharacter;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.CharacterBasicDto;
import java.util.List;

/**
 * The Interface CharacterBasicDtoMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface CharacterBasicDtoMapper {

    /**
     * To dto.
     *
     * @param baseCharacter the base character
     * @return the character basic dto
     */
    CharacterBasicDto toCharacterBasicDto(BaseCharacter baseCharacter);

    /**
     * To dto list.
     *
     * @param baseCharacters the base characters
     * @return the list
     */
    List<CharacterBasicDto> toCharacterBasicDtoList(List<BaseCharacter> baseCharacters);
}
