package es.api.onepiece.adapters.inbound.rest.mapper.debut;

import es.api.onepiece.core.internal.domain.debut.Chapter;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.ChapterDto;
import java.util.List;

/**
 * The Interface ChapterDtoMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring"
)
public interface ChapterDtoMapper {
    
    /**
     * To dto.
     *
     * @param chapter the chapter
     * @return the chapter dto
     */
    ChapterDto toDto(Chapter chapter);

    /**
     * To dto list.
     *
     * @param chapters the chapters
     * @return the list
     */
    List<ChapterDto> toDtoList(List<Chapter> chapters);
}
