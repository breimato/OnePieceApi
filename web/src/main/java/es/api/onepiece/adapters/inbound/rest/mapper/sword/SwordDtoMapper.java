package es.api.onepiece.adapters.inbound.rest.mapper.sword;

import es.api.onepiece.core.internal.domain.sword.Sword;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.SwordDto;
import java.util.List;

/**
 * The Interface SwordDtoMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring"
)
public interface SwordDtoMapper {

    /**
     * To dto.
     *
     * @param sword the sword
     * @return the sword dto
     */
    @Mapping(source = "category.type", target = "category")
    SwordDto toDto(Sword sword);

    /**
     * To dto list.
     *
     * @param swords the swords
     * @return the list
     */
    List<SwordDto> toDtoList(List<Sword> swords);
}
