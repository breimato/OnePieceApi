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
import org.openapitools.model.CreateCharacterRequestDto;
import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;

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
     * To character dto (from CharacterSummary).
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
    CharacterDto summaryToCharacterDto(CharacterSummary characterSummary);

    /**
     * To character dto list.
     *
     * @param characterSummaryList the character summaries
     * @return the list
     */
    List<CharacterDto> summaryToCharacterDtoList(List<CharacterSummary> characterSummaryList);

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
     * To create character affiliation vo.
     *
     * @param characterAffiliationDto the character affiliation dto
     * @return the create character affiliation vo
     */
    CharacterAffiliationVo toCreateCharacterAffiliationVo(
            CharacterAffiliationDto characterAffiliationDto);

    default CharacterStatusTypeEnum mapStatusId(final Integer statusId) {
        return CharacterStatusTypeEnum.getById(statusId);
    }

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
