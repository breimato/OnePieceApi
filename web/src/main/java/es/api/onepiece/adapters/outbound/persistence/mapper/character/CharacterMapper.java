package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterSummaryEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterStatusEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.character.HakiEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.character.RaceEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.enums.CharacterStatusTypeEnumMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.DebutMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.fruit.FruitMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.sword.SwordMapper;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.domain.character.CharacterSummary;
import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;
import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import es.api.onepiece.core.internal.vo.character.UpdateCharacterVo;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Objects;

/**
 * The Interface CharacterMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring", uses = {
        FruitMapper.class, DebutMapper.class, RaceMapper.class, HakiMapper.class, CharacterTitleMapper.class,
        JobMapper.class, AttackMapper.class, TransformationMapper.class, AffiliationMapper.class,
        SwordMapper.class, CharacterStatusTypeEnumMapper.class })
public interface CharacterMapper {

    /**
     * To character summary.
     *
     * @param characterSummaryEntity the character summary entity
     * @return the character summary
     */
    @Mapping(target = "status", source = "status", qualifiedByName = "mapStatusEntity")
    CharacterSummary toCharacterSummary(CharacterSummaryEntity characterSummaryEntity);

    /**
     * To character summary list.
     *
     * @param characterSummaryEntities the character summary entities
     * @return the list
     */
    List<CharacterSummary> toCharacterSummaryList(List<CharacterSummaryEntity> characterSummaryEntities);

    /**
     * To character.
     *
     * @param characterEntity the character entity
     * @return the character
     */
    @Mapping(target = "status", source = "status", qualifiedByName = "mapStatusEntity")
    Character toCharacter(CharacterEntity characterEntity);

    /**
     * To character entity.
     *
     * @param character the character
     * @return the character entity
     */
    CharacterEntity toCharacterEntity(Character character);

    /**
     * To character entity from vo.
     *
     * @param createCharacterVo the create character vo
     * @return the character entity
     */
    @Mapping(target = "raceId", source = "raceId")
    @Mapping(target = "debutId", source = "debutId")
    @Mapping(target = "statusId", source = "status.id")
    @Mapping(target = "race", source = "raceId", qualifiedByName = "mapRaceEntity")
    @Mapping(target = "debut", source = "debutId", qualifiedByName = "mapDebutEntity")
    @Mapping(target = "status", source = "status", qualifiedByName = "mapStatusEnumToEntity")
    @Mapping(target = "fruits", source = "fruitIds", qualifiedByName = "mapFruitEntityList")
    @Mapping(target = "hakis", source = "hakiIds", qualifiedByName = "mapHakiEntityList")
    CharacterEntity toCharacterEntityFromVo(CreateCharacterVo createCharacterVo);

    /**
     * To character entity from update vo.
     *
     * @param updateCharacterVo the update character vo
     * @return the character entity
     */
    @Mapping(target = "raceId", source = "raceId")
    @Mapping(target = "debutId", source = "debutId")
    @Mapping(target = "statusId", source = "status.id")
    @Mapping(target = "race", source = "raceId", qualifiedByName = "mapRaceEntity")
    @Mapping(target = "debut", source = "debutId", qualifiedByName = "mapDebutEntity")
    @Mapping(target = "status", source = "status", qualifiedByName = "mapStatusEnumToEntity")
    @Mapping(target = "fruits", source = "fruitIds", qualifiedByName = "mapFruitEntityList")
    @Mapping(target = "hakis", source = "hakiIds", qualifiedByName = "mapHakiEntityList")
    CharacterEntity toCharacterEntityFromUpdateVo(UpdateCharacterVo updateCharacterVo);

    /**
     * Map status entity to enum.
     *
     * @param characterStatusEntity the character status entity
     * @return the character status type enum
     */
    @Named("mapStatusEntity")
    default CharacterStatusTypeEnum mapStatusEntity(final CharacterStatusEntity characterStatusEntity) {
        if (Objects.isNull(characterStatusEntity)) {
            return null;
        }
        return CharacterStatusTypeEnum.getById(characterStatusEntity.getId());
    }

    /**
     * Map status enum to entity.
     * 
     * @param characterStatusTypeEnum the character status type enum
     * @return the character status entity
     */
    @Named("mapStatusEnumToEntity")
    default CharacterStatusEntity mapStatusEnumToEntity(final CharacterStatusTypeEnum characterStatusTypeEnum) {
        if (Objects.isNull(characterStatusTypeEnum)) {
            return null;
        }
        return new CharacterStatusEntity(characterStatusTypeEnum.getId(), characterStatusTypeEnum.name());
    }

    /**
     * Map race entity using ID.
     * 
     * @param id the id
     * @return the race entity
     */
    @Named("mapRaceEntity")
    default RaceEntity mapRaceEntity(final Integer id) {
        if (Objects.isNull(id)) {
            return null;
        }
        final var raceEntity = new RaceEntity();
        raceEntity.setId(id);
        return raceEntity;
    }

    /**
     * Map debut entity using ID.
     * 
     * @param id the id
     * @return the debut entity
     */
    @Named("mapDebutEntity")
    default DebutEntity mapDebutEntity(final Integer id) {
        if (Objects.isNull(id)) {
            return null;
        }
        final var debutEntity = new DebutEntity();
        debutEntity.setId(id);
        return debutEntity;
    }

    /**
     * Map fruit entity list using IDs.
     * 
     * @param ids the ids
     * @return the list of fruit entities
     */
    @Named("mapFruitEntityList")
    default List<FruitEntity> mapFruitEntityList(final List<Integer> ids) {
        if (Objects.isNull(ids)) {
            return null;
        }
        return ids.stream().map(id -> {
            final var fruitEntity = new FruitEntity();
            fruitEntity.setId(id);
            return fruitEntity;
        }).toList();
    }

    /**
     * Map haki entity list using IDs.
     * 
     * @param ids the ids
     * @return the list of haki entities
     */
    @Named("mapHakiEntityList")
    default List<HakiEntity> mapHakiEntityList(final List<Integer> ids) {
        if (Objects.isNull(ids)) {
            return null;
        }
        return ids.stream().map(id -> {
            final var hakiEntity = new HakiEntity();
            hakiEntity.setId(id);
            return hakiEntity;
        }).toList();
    }
}
