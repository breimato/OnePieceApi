package es.api.onepiece.core.ports.outbound.sword;

import jakarta.validation.constraints.NotNull;

/**
 * The Interface DeleteSwordPersistencePort.
 */
public interface DeleteSwordPersistencePort {

    /**
     * Execute.
     *
     * @param id the id
     */
    void execute(@NotNull Integer id);
}
