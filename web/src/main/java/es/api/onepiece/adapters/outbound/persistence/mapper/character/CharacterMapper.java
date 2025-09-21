package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.debut.DebutMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.fruit.FruitMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.sword.SwordMapper;
import es.api.onepiece.core.internal.domain.character.Character;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * The Interface CharacterMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {FruitMapper.class, DebutMapper.class, RaceMapper.class, HakiMapper.class, CharacterTitleMapper.class, JobMapper.class, CharacterAffiliationMapper.class, AttackMapper.class, TransformationMapper.class, SwordMapper.class}
)
public interface CharacterMapper {

    /**
     * To character.
     *
     * @param entity the entity
     * @return the character
     */
    Character toCharacter(CharacterEntity entity);

    /**
     * To character list.
     *
     * @param entities the entities
     * @return the list
     */
    List<Character> toCharacterList(List<CharacterEntity> entities);
}
