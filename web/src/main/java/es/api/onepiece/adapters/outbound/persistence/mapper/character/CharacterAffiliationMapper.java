package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterAffiliationEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.enums.CharacterAffiliationRoleEnumMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.enums.CharacterAffiliationStatusEnumMapper;
import es.api.onepiece.core.internal.domain.character.CharacterAffiliation;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface CharacterAffiliationMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {AffiliationMapper.class, CharacterAffiliationStatusEnumMapper.class, CharacterAffiliationRoleEnumMapper.class}
)
public interface CharacterAffiliationMapper {

    /**
     * To character affiliation.
     *
     * @param entity the entity
     * @return the character affiliation
     */
    @Mapping(target = "character", ignore = true)
    CharacterAffiliation toCharacterAffiliation(CharacterAffiliationEntity entity);
}
