package es.api.onepiece.core.ports.outbound.fruit;

import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.vo.fruit.CreateFruitVo;
import jakarta.validation.Valid;

/**
 * The Interface CreateFruitPersistencePort.
 */
public interface CreateFruitPersistencePort {

    /**
     * Creates the fruit.
     *
     * @param createFruitVo the create fruit vo
     * @return the fruit
     */
    Fruit execute(@Valid CreateFruitVo createFruitVo);
}
