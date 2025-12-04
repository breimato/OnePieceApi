package es.api.onepiece.adapters.outbound.persistence.mapper.debut;

import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import es.api.onepiece.core.internal.domain.debut.Debut;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface DebutMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring", uses = {
        ChapterMapper.class, EpisodeMapper.class, SagaMapper.class })
public interface DebutMapper {

    /**
     * To debut.
     *
     * @param entity the entity
     * @return the debut
     */
    Debut toDebut(DebutEntity entity);

    /**
     * To debut entity.
     *
     * @param debut the debut
     * @return the debut entity
     */
    DebutEntity toDebutEntity(Debut debut);
}
