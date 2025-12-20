package es.api.onepiece.adapters.inbound.rest.mapper;

import es.api.onepiece.core.internal.domain.debut.Episode;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.EpisodeDto;
import java.util.List;

/**
 * The Interface EpisodeDtoMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface EpisodeDtoMapper {

    /**
     * To dto.
     *
     * @param episode the episode
     * @return the episode dto
     */
    EpisodeDto toEpisodeDto(Episode episode);

    /**
     * To dto list.
     *
     * @param episodes the episodes
     * @return the list
     */
    List<EpisodeDto> toEpisodeDtoList(List<Episode> episodes);
}
