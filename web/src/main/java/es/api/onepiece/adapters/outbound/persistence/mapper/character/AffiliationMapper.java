package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.AffiliationEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.boat.BoatMapper;
import es.api.onepiece.core.internal.domain.character.Affiliation;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.enums.CharacterAffiliationRoleEnumMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.enums.CharacterAffiliationStatusEnumMapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface AffiliationMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring", uses = {
        BoatMapper.class, CharacterAffiliationRoleEnumMapper.class,
        CharacterAffiliationStatusEnumMapper.class })
public interface AffiliationMapper {

    /**
     * To affiliation.
     *
     * @param entity the entity
     * @return the affiliation
     */
    @Mapping(target = "leader", source = "leader")
    @Mapping(target = "role", source = "role")
    @Mapping(target = "status", source = "status")
    Affiliation toAffiliation(AffiliationEntity entity);
}
