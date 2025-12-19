package es.api.onepiece.core.internal.usecases.fruit;

import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.ports.inbound.fruit.GetFruitsPort;
import es.api.onepiece.core.ports.outbound.fruit.FindFruitsPersistencePort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The Class GetFruitsUseCase.
 */
@Component
@RequiredArgsConstructor
public class GetFruitsUseCase implements GetFruitsPort {

    /** The find fruits persistence port. */
    private final FindFruitsPersistencePort findFruitsPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Fruit> findAll() {
        return this.findFruitsPersistencePort.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Fruit findById(@NotNull final Integer id) {
        return this.findFruitsPersistencePort.findById(id);
    }
}
