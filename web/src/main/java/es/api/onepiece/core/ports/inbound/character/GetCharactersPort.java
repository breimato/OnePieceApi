package es.api.onepiece.core.ports.inbound.character;

import java.util.List;
import es.api.onepiece.core.internal.domain.character.CharacterSummary;
import es.api.onepiece.core.internal.domain.character.Character;
import jakarta.validation.constraints.NotNull;

/**
 * The Interface GetCharactersPort.
 */
public interface GetCharactersPort {

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
    Character findById(@NotNull Integer id);
}
