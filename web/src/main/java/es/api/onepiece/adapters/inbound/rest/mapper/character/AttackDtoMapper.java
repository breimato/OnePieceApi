package es.api.onepiece.adapters.inbound.rest.mapper.character;

import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.vo.character.attack.CreateAttackVo;
import es.api.onepiece.core.internal.vo.character.attack.UpdateAttackVo;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.AttackDto;
import org.openapitools.model.CreateAttackRequestDto;
import org.openapitools.model.UpdateAttackRequestDto;

import java.util.List;

/**
 * The Interface AttackDtoMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface AttackDtoMapper {

    /**
     * To dto.
     *
     * @param attack the attack
     * @return the attack dto
     */
    AttackDto toAttackDto(Attack attack);

    /**
     * To dto list.
     *
     * @param attacks the attacks
     * @return the list
     */
    List<AttackDto> toAttackDtoList(List<Attack> attacks);

    /**
     * To create attack vo.
     *
     * @param createAttackRequestDto the create attack request dto
     * @return the create attack vo
     */
    CreateAttackVo toCreateAttackVo(CreateAttackRequestDto createAttackRequestDto);

    /**
     * To update attack vo.
     *
     * @param id                     the id
     * @param updateAttackRequestDto the update attack request dto
     * @return the update attack vo
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "updateAttackRequestDto.name")
    @Mapping(target = "description", source = "updateAttackRequestDto.description")
    @Mapping(target = "characterId", source = "updateAttackRequestDto.characterId")
    @Mapping(target = "transformationId", source = "updateAttackRequestDto.transformationId")
    @Mapping(target = "debutId", source = "updateAttackRequestDto.debutId")
    UpdateAttackVo toUpdateAttackVo(Integer id, UpdateAttackRequestDto updateAttackRequestDto);
}
