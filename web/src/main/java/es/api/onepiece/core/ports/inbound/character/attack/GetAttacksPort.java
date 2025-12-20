package es.api.onepiece.core.ports.inbound.character.attack;

import es.api.onepiece.core.internal.domain.character.Attack;

import java.util.List;

/**
 * The Interface GetAttacksPort.
 */
public interface GetAttacksPort {

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
    Attack findById(Integer id);
}
