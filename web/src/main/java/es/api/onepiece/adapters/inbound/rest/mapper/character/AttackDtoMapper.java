package es.api.onepiece.adapters.inbound.rest.mapper.character;

import es.api.onepiece.core.internal.domain.character.Attack;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.AttackDto;
import java.util.List;

/**
 * The Interface AttackDtoMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring"
)
public interface AttackDtoMapper {

    /**
     * To dto.
     *
     * @param attack the attack
     * @return the attack dto
     */
    AttackDto toDto(Attack attack);

    /**
     * To dto list.
     *
     * @param attacks the attacks
     * @return the list
     */
    List<AttackDto> toDtoList(List<Attack> attacks);
}
