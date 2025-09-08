package es.api.onepiece.adapters.outbound.persistence.mapper.character.enums;

import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterStatusEntity;
import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


/**
 * The Interface CharacterStatusTypeEnumMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        implementationName = "CharacterStatusTypeEnumMapperFromPersistence")
public interface CharacterStatusTypeEnumMapper {

    /**
     * To character status type enum.
     *
     * @param characterStatusEntity the character status entity
     * @return the character status type enum
     */
    default CharacterStatusTypeEnum toCharacterStatusTypeEnum(CharacterStatusEntity characterStatusEntity) {
        return CharacterStatusTypeEnum.getByName(characterStatusEntity.getStatus());
    }
}
