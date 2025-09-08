package es.api.onepiece.adapters.outbound.persistence.mapper.character.enums;

import es.api.onepiece.core.internal.domain.character.enums.CharacterAffiliationStatusEnum;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface CharacterAffiliationStatusEnumMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        implementationName = "CharacterAffiliationStatusEnumMapperFromPersistence")
public interface CharacterAffiliationStatusEnumMapper {

    /**
     * To enum.
     *
     * @param status the status
     * @return the character affiliation status enum
     */
    default CharacterAffiliationStatusEnum toEnum(String status) {
        return CharacterAffiliationStatusEnum.getByName(status);
    }
}
