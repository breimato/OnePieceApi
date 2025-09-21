package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.AffiliationEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.boat.BoatMapper;
import es.api.onepiece.core.internal.domain.character.Affiliation;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface AffiliationMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = { BaseCharacterMapper.class, BoatMapper.class }
)
public interface AffiliationMapper {

    /**
     * To affiliation.
     *
     * @param entity the entity
     * @return the affiliation
     */
    @Mapping(target = "leader", source = "leader")
    Affiliation toAffiliation(AffiliationEntity entity);
}
