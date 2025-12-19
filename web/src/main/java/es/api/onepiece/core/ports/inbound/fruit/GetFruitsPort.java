package es.api.onepiece.core.ports.inbound.fruit;

import es.api.onepiece.core.internal.domain.fruit.Fruit;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * The Interface GetFruitsPort.
 */
public interface GetFruitsPort {

    /**
     * Find all.
     *
     * @return the list
     */
    List<Fruit> findAll();

    /**
     * Find by id.
     *
     * @param id the id
     * @return the fruit
     */
    Fruit findById(@NotNull Integer id);
}
