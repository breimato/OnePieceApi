package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterTitleEntity;
import es.api.onepiece.core.internal.domain.character.CharacterTitle;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface CharacterTitleMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {CharacterTitleEnumMapper.class}
)
public interface CharacterTitleMapper {

    /**
     * To character title.
     *
     * @param entity the entity
     * @return the character title
     */
    @Mapping(target = "character", ignore = true)
    CharacterTitle toCharacterTitle(CharacterTitleEntity entity);
}
