package es.api.onepiece.core.ports.outbound.sword;

import es.api.onepiece.core.internal.domain.sword.Sword;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * The Interface FindSwordsPersistencePort.
 */
public interface FindSwordsPersistencePort {

    /**
     * Find all.
     *
     * @return the list
     */
    List<Sword> findAll();

    /**
     * Find by id.
     *
     * @param id the id
     * @return the sword
     */
    Sword findById(@NotNull Integer id);

    /**
     * Exists.
     *
     * @param id the id
     * @return true, if successful
     */
    boolean exists(@NotNull Integer id);
}
