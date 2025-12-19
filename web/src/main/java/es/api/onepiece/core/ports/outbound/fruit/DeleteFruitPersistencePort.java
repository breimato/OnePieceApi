package es.api.onepiece.core.ports.outbound.fruit;

import jakarta.validation.constraints.NotNull;

/**
 * The Interface DeleteFruitPersistencePort.
 */
public interface DeleteFruitPersistencePort {

    /**
     * Deletes the fruit.
     *
     * @param id the fruit id
     */
    void execute(@NotNull Integer id);
}
