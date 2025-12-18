package es.api.onepiece.adapters.inbound.rest.mapper.character;

import es.api.onepiece.core.internal.domain.character.Leader;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.LeaderDto;

/**
 * The Interface LeaderDtoMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface LeaderDtoMapper {

    /**
     * To leader dto.
     *
     * @param leader the leader
     * @return the leader dto
     */
    LeaderDto toLeaderDto(Leader leader);
}
