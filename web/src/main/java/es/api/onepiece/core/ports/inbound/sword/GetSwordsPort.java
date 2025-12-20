package es.api.onepiece.core.ports.inbound.sword;

import es.api.onepiece.core.internal.domain.sword.Sword;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * The Interface GetSwordsPort.
 */
public interface GetSwordsPort {

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
}
