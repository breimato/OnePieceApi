package es.api.onepiece.core.ports.inbound.sword;

import jakarta.validation.constraints.NotNull;

/**
 * The Interface DeleteSwordPort.
 */
public interface DeleteSwordPort {

    /**
     * Execute.
     *
     * @param id the id
     */
    void execute(@NotNull Integer id);
}
