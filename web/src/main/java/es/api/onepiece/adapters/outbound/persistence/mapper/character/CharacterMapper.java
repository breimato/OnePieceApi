package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterSummaryEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.character.HakiEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.character.RaceEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.enums.CharacterStatusTypeEnumMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.debut.DebutMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.fruit.FruitMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.sword.SwordMapper;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.domain.character.CharacterSummary;
import es.api.onepiece.core.internal.domain.character.Race;
import es.api.onepiece.core.internal.domain.debut.Debut;
import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import org.mapstruct.*;

import java.util.Collections;
import java.util.List;

/**
 * The Interface CharacterMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring", uses = {
        FruitMapper.class, DebutMapper.class, RaceMapper.class, HakiMapper.class, CharacterTitleMapper.class,
        JobMapper.class, CharacterAffiliationMapper.class, AttackMapper.class, TransformationMapper.class,
        SwordMapper.class, CharacterStatusTypeEnumMapper.class })
public interface CharacterMapper {

    /**
     * To character.
     *
     * @param characterEntity the character entity
     * @return the character
     */
    Character toCharacter(CharacterEntity characterEntity);

    /**
     * To character list.
     *
     * @param entities the entities
     * @return the list
     */
    List<Character> toCharacterList(List<CharacterEntity> entities);

    /**
     * To character summary.
     *
     * @param entity the entity
     * @return the character summary
     */
    CharacterSummary toCharacterSummary(CharacterSummaryEntity entity);

    /**
     * To character summary list.
     *
     * @param entities the entities
     * @return the list
     */
    List<CharacterSummary> toCharacterSummaryList(List<CharacterSummaryEntity> entities);

    /**
     * To character entity.
     *
     * @param character the character
     * @return the character entity
     */
    CharacterEntity toCharacterEntity(Character character);

    /**
     * To character entity from vo.
     * Mapeamos manualmente race y debut porque los nombres y tipos no coinciden.
     * Ignoramos las listas porque se guardan en tablas separadas.
     *
     * @param createCharacterVo the create character vo
     * @return the character entity
     */
    @Mapping(target = "race", source = "raceId", qualifiedByName = "mapRaceEntity")
    @Mapping(target = "debut", source = "debutId", qualifiedByName = "mapDebutEntity")
    @Mapping(target = "fruits", source = "fruitIds", qualifiedByName = "mapFruitEntityList")
    @Mapping(target = "hakis", source = "hakiIds", qualifiedByName = "mapHakiEntityList")
    CharacterEntity toCharacterEntityFromVo(CreateCharacterVo createCharacterVo);

    /**
     * Map race entity using ID.
     * Creates a proxy entity just for the Foreign Key reference.
     */
    @Named("mapRaceEntity")
    default RaceEntity mapRaceEntity(final Integer id) {
        final var entity = new RaceEntity();
        entity.setId(id);
        return entity;
    }

    /**
     * Map debut entity using ID.
     * Creates a proxy entity just for the Foreign Key reference.
     */
    @Named("mapDebutEntity")
    default DebutEntity mapDebutEntity(final Integer id) {
        final var entity = new DebutEntity();
        entity.setId(id);
        return entity;
    }

    @Named("mapFruitEntityList")
    default List<FruitEntity> mapFruitEntityList(final List<Integer> ids) {
        return ids.stream().map(id -> {
            final var entity = new FruitEntity();
            entity.setId(id);
            return entity;
        }).toList();
    }

    @Named("mapHakiEntityList")
    default List<HakiEntity> mapHakiEntityList(final List<Integer> ids) {
        return ids.stream().map(id -> {
            final var entity = new HakiEntity();
            entity.setId(id);
            return entity;
        }).toList();
    }

}

