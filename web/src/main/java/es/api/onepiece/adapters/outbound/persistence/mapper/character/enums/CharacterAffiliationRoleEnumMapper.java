package es.api.onepiece.adapters.outbound.persistence.mapper.character.enums;

import es.api.onepiece.core.internal.domain.character.enums.CharacterAffiliationRoleEnum;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface CharacterAffiliationRoleEnumMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        implementationName = "CharacterAffiliationRoleEnumMapperFromPersistence")
public interface CharacterAffiliationRoleEnumMapper {

    /**
     * To enum.
     *
     * @param role the role
     * @return the character affiliation role enum
     */
    default CharacterAffiliationRoleEnum toEnum(String role) {
        return CharacterAffiliationRoleEnum.getByName(role);
    }
}
