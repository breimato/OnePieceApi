package es.api.onepiece.core.ports.outbound.character;

import java.util.List;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.domain.character.CharacterSummary;

/**
 * The Interface FindCharactersPersistencePort.
 */
public interface FindCharactersPersistencePort {

    /**
     * Find all.
     *
     * @return the list
     */
    List<CharacterSummary> findAll();

    /**
     * Find by id.
     *
     * @param id the id
     * @return the character
     */
    Character findById(Integer id);
}
