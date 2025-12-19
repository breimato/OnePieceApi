package es.api.onepiece.core.ports.inbound.fruit;

import jakarta.validation.constraints.NotNull;

/**
 * The Interface DeleteFruitPort.
 */
public interface DeleteFruitPort {

    /**
     * Deletes the fruit.
     *
     * @param id the fruit id
     */
    void execute(@NotNull Integer id);
}
