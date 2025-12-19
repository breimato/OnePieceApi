package es.api.onepiece.adapters.inbound.rest.mapper.character;

import es.api.onepiece.core.internal.vo.character.CharacterAffiliationVo;
import org.apache.commons.collections4.CollectionUtils;
import org.mapstruct.*;
import org.openapitools.model.CharacterAffiliationDto;
import org.openapitools.model.CharacterDto;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.domain.character.CharacterSummary;
import es.api.onepiece.adapters.inbound.rest.mapper.boat.BoatDtoMapper;
import es.api.onepiece.adapters.inbound.rest.mapper.fruit.FruitDtoMapper;
import es.api.onepiece.adapters.inbound.rest.mapper.sword.SwordDtoMapper;
import es.api.onepiece.adapters.inbound.rest.mapper.debut.DebutDtoMapper;

import java.util.List;

import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import es.api.onepiece.core.internal.vo.character.UpdateCharacterVo;
import org.openapitools.model.CreateCharacterRequestDto;
import org.openapitools.model.UpdateCharacterRequestDto;

/**
 * The Interface CharacterDtoMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring", uses = {
        HakiDtoMapper.class,
        SwordDtoMapper.class,
        TransformationDtoMapper.class,
        AttackDtoMapper.class,
        AffiliationDtoMapper.class,
        BoatDtoMapper.class,
        FruitDtoMapper.class,
        JobDtoMapper.class,
        RaceDtoMapper.class,
        CharacterTitleDtoMapper.class,
        DebutDtoMapper.class
})
public interface CharacterDtoMapper {

    /**
     * To character V1 dto (from full Character).
     *
     * @param character the character
     * @return the character dto
     */
    @Mapping(target = "fruits", source = "fruits", qualifiedByName = "emptyListToNull")
    @Mapping(target = "hakis", source = "hakis", qualifiedByName = "emptyListToNull")
    @Mapping(target = "titles", source = "titles", qualifiedByName = "emptyListToNull")
    @Mapping(target = "jobs", source = "jobs", qualifiedByName = "emptyListToNull")
    @Mapping(target = "affiliations", source = "affiliations", qualifiedByName = "emptyListToNull")
    @Mapping(target = "swords", source = "swords", qualifiedByName = "emptyListToNull")
    @Mapping(target = "transformations", source = "transformations", qualifiedByName = "emptyListToNull")
    @Mapping(target = "attacks", source = "attacks", qualifiedByName = "emptyListToNull")
    CharacterDto toCharacterDto(Character character);

    /**
     * To character dto (from Character Summary).
     *
     * @param characterSummary the character summary
     * @return the character dto
     */
    @Mapping(target = "fruits", source = "fruits", qualifiedByName = "emptyListToNull")
    @Mapping(target = "hakis", source = "hakis", qualifiedByName = "emptyListToNull")
    @Mapping(target = "transformations", source = "transformations", qualifiedByName = "emptyListToNull")
    @Mapping(target = "affiliations", source = "affiliations", qualifiedByName = "emptyListToNull")
    @Mapping(target = "titles", source = "titles", qualifiedByName = "emptyListToNull")
    @Mapping(target = "jobs", source = "jobs", qualifiedByName = "emptyListToNull")
    @Mapping(target = "swords", source = "swords", qualifiedByName = "emptyListToNull")
    @Mapping(target = "attacks", source = "attacks", qualifiedByName = "emptyListToNull")
    @Mapping(target = "race", ignore = true)
    @Mapping(target = "debut", ignore = true)
    CharacterDto fromSummaryToCharacterDto(CharacterSummary characterSummary);

    /**
     * To create character vo.
     *
     * @param createCharacterRequestDto the create character request dto
     * @return the create character vo
     */
    @Mapping(target = "status", source = "statusId")
    @Mapping(target = "debutId", source = "firstAppearanceId")
    CreateCharacterVo toCreateCharacterVo(CreateCharacterRequestDto createCharacterRequestDto);

    /**
     * From summary to character dto list.
     *
     * @param characterSummaryList the character summary list
     * @return the list
     */
    List<CharacterDto> fromSummaryToCharacterDtoList(List<CharacterSummary> characterSummaryList);

    /**
     * To create character affiliation vo.
     *
     * @param characterAffiliationDto the character affiliation dto
     * @return the create character affiliation vo
     */
    CharacterAffiliationVo toCreateCharacterAffiliationVo(CharacterAffiliationDto characterAffiliationDto);

    /**
     * To update character vo.
     *
     * @param id                        the character id
     * @param updateCharacterRequestDto the update character request dto
     * @return the update character vo
     */
    @Mapping(target = "id", source = "id")
    @Mapping(target = "status", source = "updateCharacterRequestDto.statusId")
    @Mapping(target = "debutId", source = "updateCharacterRequestDto.firstAppearanceId")
    @Mapping(target = "name", source = "updateCharacterRequestDto.name")
    @Mapping(target = "description", source = "updateCharacterRequestDto.description")
    @Mapping(target = "height", source = "updateCharacterRequestDto.height")
    @Mapping(target = "age", source = "updateCharacterRequestDto.age")
    @Mapping(target = "bounty", source = "updateCharacterRequestDto.bounty")
    @Mapping(target = "image", source = "updateCharacterRequestDto.image")
    @Mapping(target = "raceId", source = "updateCharacterRequestDto.raceId")
    @Mapping(target = "fruitIds", source = "updateCharacterRequestDto.fruitIds")
    @Mapping(target = "hakiIds", source = "updateCharacterRequestDto.hakiIds")
    @Mapping(target = "titleIds", source = "updateCharacterRequestDto.titleIds")
    @Mapping(target = "jobIds", source = "updateCharacterRequestDto.jobIds")
    @Mapping(target = "characterAffiliations", source = "updateCharacterRequestDto.characterAffiliations")
    @Mapping(target = "swordIds", source = "updateCharacterRequestDto.swordIds")
    @Mapping(target = "transformationIds", source = "updateCharacterRequestDto.transformationIds")
    @Mapping(target = "attackIds", source = "updateCharacterRequestDto.attackIds")
    UpdateCharacterVo toUpdateCharacterVo(Integer id, UpdateCharacterRequestDto updateCharacterRequestDto);

    /**
     * Empty list to null.
     *
     * @param list the list
     * @return the list
     */
    @Named("emptyListToNull")
    default <T> List<T> emptyListToNull(final List<T> list) {
        return CollectionUtils.isEmpty(list) ? null : list;
    }
}
