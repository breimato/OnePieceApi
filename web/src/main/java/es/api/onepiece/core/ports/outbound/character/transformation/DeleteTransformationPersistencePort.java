package es.api.onepiece.core.ports.outbound.character.transformation;

import jakarta.validation.constraints.NotNull;

/**
 * The Interface DeleteTransformationPersistencePort.
 */
public interface DeleteTransformationPersistencePort {

    /**
     * Deletes the transformation.
     *
     * @param id the id
     */
    void execute(@NotNull Integer id);
}
