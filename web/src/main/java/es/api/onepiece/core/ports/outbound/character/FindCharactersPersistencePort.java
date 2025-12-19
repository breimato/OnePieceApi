package es.api.onepiece.core.ports.outbound.character;

import java.util.List;
import es.api.onepiece.core.internal.domain.character.CharacterSummary;
import es.api.onepiece.core.internal.domain.character.Character;
import jakarta.validation.constraints.NotNull;

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
    Character findById(@NotNull Integer id);

    /**
     * Exists.
     *
     * @param id the id
     * @return the boolean
     */
    boolean exists(@NotNull Integer id);
}
