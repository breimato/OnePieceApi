package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.core.internal.domain.character.enums.CharacterTitleEnum;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface CharacterTitleEnumMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        implementationName = "CharacterTitleEnumMapperFromPersistence")
public interface CharacterTitleEnumMapper {

    /**
     * To enum.
     *
     * @param title the title
     * @return the character title enum
     */
    default CharacterTitleEnum toEnum(String title) {
        return CharacterTitleEnum.getByName(title);
    }
}
