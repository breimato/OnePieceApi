package es.api.onepiece.adapters.outbound.persistence.mapper.debut;

import es.api.onepiece.adapters.outbound.persistence.entities.DebutEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.ChapterMapper;
import es.api.onepiece.core.internal.domain.debut.Debut;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface DebutMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {ChapterMapper.class, EpisodeMapper.class, SagaMapper.class}
)
public interface DebutMapper {

    /**
     * To debut.
     *
     * @param entity the entity
     * @return the debut
     */
    Debut toDebut(DebutEntity entity);
}
