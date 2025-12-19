package es.api.onepiece.core.ports.outbound.fruit;

import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.vo.fruit.UpdateFruitVo;
import jakarta.validation.Valid;

/**
 * The Interface UpdateFruitPersistencePort.
 */
public interface UpdateFruitPersistencePort {

    /**
     * Updates the fruit.
     *
     * @param updateFruitVo the update fruit vo
     * @return the fruit
     */
    Fruit execute(@Valid UpdateFruitVo updateFruitVo);
}
