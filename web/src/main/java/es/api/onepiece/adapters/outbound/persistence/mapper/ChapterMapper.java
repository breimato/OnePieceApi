package es.api.onepiece.adapters.outbound.persistence.mapper;

import es.api.onepiece.adapters.outbound.persistence.entities.debut.ChapterEntity;
import es.api.onepiece.core.internal.domain.debut.Chapter;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface ChapterMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface ChapterMapper {

    /**
     * To chapter.
     *
     * @param entity the entity
     * @return the chapter
     */
    Chapter toChapter(ChapterEntity entity);

    /**
     * To chapter entity.
     *
     * @param chapter the chapter
     * @return the chapter entity
     */
    ChapterEntity toChapterEntity(Chapter chapter);
}
