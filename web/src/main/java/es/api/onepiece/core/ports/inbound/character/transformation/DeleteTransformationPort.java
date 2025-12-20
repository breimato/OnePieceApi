package es.api.onepiece.core.ports.inbound.character.transformation;

import jakarta.validation.constraints.NotNull;

/**
 * The Interface DeleteTransformationPort.
 */
public interface DeleteTransformationPort {

    /**
     * Deletes the transformation.
     *
     * @param id the id
     */
    void execute(@NotNull Integer id);
}
