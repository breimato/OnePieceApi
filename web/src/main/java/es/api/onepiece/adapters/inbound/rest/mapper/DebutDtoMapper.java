package es.api.onepiece.adapters.inbound.rest.mapper;

import es.api.onepiece.core.internal.domain.debut.Debut;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.DebutDto;
import java.util.List;

/**
 * The Interface DebutDtoMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring", uses = {
        ChapterDtoMapper.class, EpisodeDtoMapper.class, SagaDtoMapper.class })
public interface DebutDtoMapper {

    /**
     * To dto.
     *
     * @param debut the debut
     * @return the debut dto
     */
    DebutDto toDebutDto(Debut debut);

    /**
     * To dto list.
     *
     * @param debuts the debuts
     * @return the list
     */
    List<DebutDto> toDebutDtoList(List<Debut> debuts);
}
