package es.api.onepiece.adapters.inbound.rest.mapper.character;

import org.apache.commons.collections4.CollectionUtils;
import org.mapstruct.*;
import org.openapitools.model.CharacterDto;
import es.api.onepiece.core.internal.domain.character.Character;
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
     * To character V 1 dto.
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
    CharacterDto toCharacterV1Dto(Character character);

    /**
     * To character dto (from BaseCharacter).
     *
     * @param baseCharacter the base character
     * @return the character dto
     */
    @Mapping(target = "fruits", source = "fruitList", qualifiedByName = "mapFruitList")
    @Mapping(target = "hakis", source = "hakiList", qualifiedByName = "mapHakiList")
    @Mapping(target = "transformations", source = "transformationList", qualifiedByName = "mapTransformationList")
    @Mapping(target = "affiliations", source = "affiliation", qualifiedByName = "mapAffiliationString")
    @Mapping(target = "titles", ignore = true)
    @Mapping(target = "jobs", ignore = true)
    @Mapping(target = "swords", ignore = true)
    @Mapping(target = "attacks", ignore = true)
    @Mapping(target = "race", ignore = true)
    @Mapping(target = "debut", ignore = true)
    CharacterDto toCharacterDto(es.api.onepiece.core.internal.domain.character.BaseCharacter baseCharacter);

    List<CharacterDto> toCharacterDtoList(
            List<es.api.onepiece.core.internal.domain.character.BaseCharacter> baseCharacters);

    /**
     * To create character vo.
     *
     * @param createCharacterRequestDto the create character request dto
     * @return the create character vo
     */
    @Mapping(target = "status", source = "statusId")
    @Mapping(target = "debutId", source = "firstAppearanceId")
    CreateCharacterVo toCreateCharacterVo(CreateCharacterRequestDto createCharacterRequestDto);

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

    @Named("mapFruitList")
    default List<org.openapitools.model.FruitDto> mapFruitList(List<String> fruitNames) {
        if (CollectionUtils.isEmpty(fruitNames)) {
            return null;
        }
        return fruitNames.stream().map(name -> {
            org.openapitools.model.FruitDto dto = new org.openapitools.model.FruitDto();
            dto.setName(name);
            return dto;
        }).toList();
    }

    @Named("mapHakiList")
    default List<org.openapitools.model.HakiDto> mapHakiList(List<String> hakiNames) {
        if (CollectionUtils.isEmpty(hakiNames)) {
            return null;
        }
        return hakiNames.stream().map(name -> {
            org.openapitools.model.HakiDto dto = new org.openapitools.model.HakiDto();
            dto.setName(name);
            return dto;
        }).toList();
    }

    @Named("mapTransformationList")
    default List<org.openapitools.model.TransformationDto> mapTransformationList(List<String> transformationNames) {
        if (CollectionUtils.isEmpty(transformationNames)) {
            return null;
        }
        return transformationNames.stream().map(name -> {
            org.openapitools.model.TransformationDto dto = new org.openapitools.model.TransformationDto();
            dto.setName(name);
            return dto;
        }).toList();
    }

    @Named("mapAffiliationString")
    default List<org.openapitools.model.AffiliationDto> mapAffiliationString(String affiliationName) {
        if (affiliationName == null) {
            return null;
        }
        org.openapitools.model.AffiliationDto dto = new org.openapitools.model.AffiliationDto();
        dto.setName(affiliationName);
        return java.util.List.of(dto);
    }
}
