package es.api.onepiece.adapters.inbound.rest.mapper.character;

import es.api.onepiece.core.internal.domain.character.Haki;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.HakiDto;
import java.util.List;

/**
 * The Interface HakiDtoMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring"
)
public interface HakiDtoMapper {

    /**
     * To dto.
     *
     * @param haki the haki
     * @return the haki dto
     */
    @Mapping(source = "description", target = "name")
    HakiDto toDto(Haki haki);

    /**
     * To dto list.
     *
     * @param hakis the hakis
     * @return the list
     */
    List<HakiDto> toDtoList(List<Haki> hakis);
}
