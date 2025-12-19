package es.api.onepiece.core.ports.outbound.character;

import jakarta.validation.constraints.NotNull;

/**
 * The Interface DeleteCharacterPersistencePort.
 */
public interface DeleteCharacterPersistencePort {

    /**
     * Deletes the character.
     *
     * @param id the character id
     */
    void execute(@NotNull Integer id);
}
