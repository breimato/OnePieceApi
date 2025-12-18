package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterSummaryEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterStatusEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.character.HakiEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.character.RaceEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.enums.CharacterStatusTypeEnumMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.debut.DebutMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.fruit.FruitMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.sword.SwordMapper;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.domain.character.CharacterSummary;
import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;
import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import org.mapstruct.*;

import java.util.List;

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
     * @param entity the entity
     * @return the character summary
     */
    @Mapping(target = "status", source = "status", qualifiedByName = "mapStatusEntity")
    CharacterSummary toCharacterSummary(CharacterSummaryEntity entity);

    /**
     * To character summary list.
     *
     * @param entities the entities
     * @return the list
     */
    List<CharacterSummary> toCharacterSummaryList(List<CharacterSummaryEntity> entities);

    /**
     * To character.
     *
     * @param entity the entity
     * @return the character
     */
    @Mapping(target = "status", source = "status", qualifiedByName = "mapStatusEntity")
    Character toCharacter(CharacterEntity entity);

    /**
     * To character list.
     *
     * @param entities the entities
     * @return the list
     */
    List<Character> toCharacterList(List<CharacterEntity> entities);

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
     * Map status string to enum.
     */
    @Named("mapStatusString")
    default CharacterStatusTypeEnum mapStatusString(final String status) {
        if (status == null) {
            return null;
        }
        return CharacterStatusTypeEnum.getByName(status);
    }

    /**
     * Map status entity to enum.
     */
    @Named("mapStatusEntity")
    default CharacterStatusTypeEnum mapStatusEntity(final CharacterStatusEntity entity) {
        if (entity == null) {
            return null;
        }
        return CharacterStatusTypeEnum.getByName(entity.getStatus());
    }

    /**
     * Map status enum to entity.
     */
    @Named("mapStatusEnumToEntity")
    default CharacterStatusEntity mapStatusEnumToEntity(final CharacterStatusTypeEnum statusEnum) {
        if (statusEnum == null) {
            return null;
        }
        return new CharacterStatusEntity(statusEnum.getId(), statusEnum.name());
    }

    /**
     * Map race entity using ID.
     */
    @Named("mapRaceEntity")
    default RaceEntity mapRaceEntity(final Integer id) {
        final var entity = new RaceEntity();
        entity.setId(id);
        return entity;
    }

    /**
     * Map debut entity using ID.
     */
    @Named("mapDebutEntity")
    default DebutEntity mapDebutEntity(final Integer id) {
        final var entity = new DebutEntity();
        entity.setId(id);
        return entity;
    }

    @Named("mapFruitEntityList")
    default List<FruitEntity> mapFruitEntityList(final List<Integer> ids) {
        if (ids == null) {
            return null;
        }
        return ids.stream().map(id -> {
            final var entity = new FruitEntity();
            entity.setId(id);
            return entity;
        }).toList();
    }

    @Named("mapHakiEntityList")
    default List<HakiEntity> mapHakiEntityList(final List<Integer> ids) {
        if (ids == null) {
            return null;
        }
        return ids.stream().map(id -> {
            final var entity = new HakiEntity();
            entity.setId(id);
            return entity;
        }).toList();
    }
}
