package es.api.onepiece.core.ports.inbound.character;

import java.util.List;
import es.api.onepiece.core.internal.domain.character.Character;


/**
 * The Interface GetCharactersPort.
 */
public interface GetCharactersPort {

    /**
     * Find all.
     *
     * @return the list
     */
    List<Character> findAll();
}
