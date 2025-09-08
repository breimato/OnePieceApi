package es.api.onepiece.adapters.outbound.persistence.mapper.debut;

import es.api.onepiece.adapters.outbound.persistence.entities.debut.ChapterEntity;
import es.api.onepiece.core.internal.domain.debut.Chapter;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface ChapterMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring"
)
public interface ChapterMapper {

    /**
     * To chapter.
     *
     * @param entity the entity
     * @return the chapter
     */
    Chapter toChapter(ChapterEntity entity);
}
