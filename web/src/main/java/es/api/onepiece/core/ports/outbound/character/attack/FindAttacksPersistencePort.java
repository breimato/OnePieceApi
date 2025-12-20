package es.api.onepiece.core.ports.outbound.character.attack;

import es.api.onepiece.core.internal.domain.character.Attack;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * The Interface FindAttacksPersistencePort.
 */
public interface FindAttacksPersistencePort {

    /**
     * Find all.
     *
     * @return the list
     */
    List<Attack> findAll();

    /**
     * Find by id.
     *
     * @param id the id
     * @return the attack
     */
    Attack findById(@NotNull Integer id);

    /**
     * Exists.
     *
     * @param id the id
     * @return the boolean
     */
    boolean exists(@NotNull Integer id);
}
