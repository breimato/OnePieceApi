package es.api.onepiece.core.internal.usecases.fruit;

import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.vo.fruit.CreateFruitVo;
import es.api.onepiece.core.ports.inbound.fruit.CreateFruitPort;
import es.api.onepiece.core.ports.outbound.fruit.CreateFruitPersistencePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The Class CreateFruitUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CreateFruitUseCase implements CreateFruitPort {

    /** The create fruit persistence port. */
    private final CreateFruitPersistencePort createFruitPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public Fruit execute(@Valid final CreateFruitVo createFruitVo) {
        return this.createFruitPersistencePort.execute(createFruitVo);
    }
}
