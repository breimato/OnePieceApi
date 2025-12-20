package es.api.onepiece.adapters.inbound.rest.mapper.sword;

import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.internal.vo.sword.CreateSwordVo;
import es.api.onepiece.core.internal.vo.sword.UpdateSwordVo;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.CreateSwordRequestDto;
import org.openapitools.model.SwordDto;
import org.openapitools.model.UpdateSwordRequestDto;

import java.util.List;

/**
 * The Interface SwordDtoMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface SwordDtoMapper {

    /**
     * To dto.
     *
     * @param sword the sword
     * @return the sword dto
     */
    @Mapping(source = "category.type", target = "category")
    SwordDto toSwordDto(Sword sword);

    /**
     * To dto list.
     *
     * @param swords the swords
     * @return the list
     */
    List<SwordDto> toSwordDtoList(List<Sword> swords);

    /**
     * To create sword vo.
     *
     * @param createSwordRequestDto the create sword request dto
     * @return the create sword vo
     */
    CreateSwordVo toCreateSwordVo(CreateSwordRequestDto createSwordRequestDto);

    /**
     * To update sword vo.
     *
     * @param id                    the id
     * @param updateSwordRequestDto the update sword request dto
     * @return the update sword vo
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "updateSwordRequestDto.name")
    @Mapping(target = "description", source = "updateSwordRequestDto.description")
    @Mapping(target = "blackSword", source = "updateSwordRequestDto.blackSword")
    @Mapping(target = "statusId", source = "updateSwordRequestDto.statusId")
    @Mapping(target = "categoryId", source = "updateSwordRequestDto.categoryId")
    @Mapping(target = "debutId", source = "updateSwordRequestDto.debutId")
    UpdateSwordVo toUpdateSwordVo(Integer id, UpdateSwordRequestDto updateSwordRequestDto);
}
