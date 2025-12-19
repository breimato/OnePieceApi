package es.api.onepiece.core.ports.inbound.character;

import jakarta.validation.constraints.NotNull;

/**
 * The Interface DeleteCharacterPort.
 */
public interface DeleteCharacterPort {

    /**
     * Deletes the character.
     *
     * @param id the character id
     */
    void execute(@NotNull Integer id);
}
