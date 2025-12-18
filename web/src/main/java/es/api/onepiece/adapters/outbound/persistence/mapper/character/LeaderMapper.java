package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.LeaderEntity;
import es.api.onepiece.core.internal.domain.character.Leader;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface LeaderMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface LeaderMapper {

    /**
     * To leader.
     *
     * @param entity the entity
     * @return the leader
     */
    Leader toLeader(LeaderEntity entity);
}
