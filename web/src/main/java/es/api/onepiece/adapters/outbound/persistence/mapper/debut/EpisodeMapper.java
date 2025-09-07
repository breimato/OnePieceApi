package es.api.onepiece.adapters.outbound.persistence.mapper.debut;

import es.api.onepiece.adapters.outbound.persistence.entities.EpisodeEntity;
import es.api.onepiece.core.internal.domain.debut.Episode;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface EpisodeMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring"
)
public interface EpisodeMapper {

    /**
     * To episode.
     *
     * @param entity the entity
     * @return the episode
     */
    Episode toEpisode(EpisodeEntity entity);
}
