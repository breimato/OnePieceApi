package es.api.onepiece.adapters.outbound.persistence.repository.character;

import es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.CharacterMapper;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.ports.outbound.character.FindCharactersPersistencePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The Class CharacterFindRepository.
 */
@Component
@AllArgsConstructor
public class CharacterFindRepository implements FindCharactersPersistencePort {

    /** The character my batis mapper. */
    private final CharacterMyBatisMapper characterMyBatisMapper;

    /** The character mapper. */
    private final CharacterMapper characterMapper;

    /**
     * Find all.
     *
     * @return the list
     */
    @Override
    public List<Character> findAll() {
        final var characters = this.characterMyBatisMapper.findAll();
        return this.characterMapper.toCharacterList(characters);
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the character
     */
    @Override
    public Character findById(final Integer id) {
        final var characterEntity = this.characterMyBatisMapper.getCharacterById(id);
        return this.characterMapper.toCharacter(characterEntity);
    }
}
