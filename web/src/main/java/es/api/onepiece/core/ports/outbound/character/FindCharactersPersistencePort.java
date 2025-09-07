package es.api.onepiece.core.ports.outbound.character;

import java.util.List;
import es.api.onepiece.core.internal.domain.character.Character;


/**
 * The Interface FindCharactersPersistencePort.
 */
public interface FindCharactersPersistencePort {

    /**
     * Find all.
     *
     * @return the list
     */
    List<Character> findAll();
}
