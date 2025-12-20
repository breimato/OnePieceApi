package es.api.onepiece.adapters.outbound.persistence.mapper;

import es.api.onepiece.adapters.outbound.persistence.entities.debut.EpisodeEntity;
import es.api.onepiece.core.internal.domain.debut.Episode;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface EpisodeMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface EpisodeMapper {

    /**
     * To episode.
     *
     * @param entity the entity
     * @return the episode
     */
    Episode toEpisode(EpisodeEntity entity);

    /**
     * To episode entity.
     *
     * @param episode the episode
     * @return the episode entity
     */
    EpisodeEntity toEpisodeEntity(Episode episode);
}
