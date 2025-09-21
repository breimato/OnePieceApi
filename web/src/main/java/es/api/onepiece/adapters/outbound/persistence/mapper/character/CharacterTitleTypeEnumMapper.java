package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.core.internal.domain.character.enums.CharacterTitleTypeEnum;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface CharacterTitleTypeEnumMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        implementationName = "CharacterTitleTypeEnumMapperFromPersistence")
public interface CharacterTitleTypeEnumMapper {

    /**
     * To enum.
     *
     * @param title the title
     * @return the character title type enum
     */
    default CharacterTitleTypeEnum toEnum(String title) {
        return CharacterTitleTypeEnum.getByName(title);
    }
}
