package es.api.onepiece.core.internal.usecases.fruit;

import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.vo.fruit.UpdateFruitVo;
import es.api.onepiece.core.ports.inbound.fruit.UpdateFruitPort;
import es.api.onepiece.core.ports.outbound.fruit.UpdateFruitPersistencePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The Class UpdateFruitUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateFruitUseCase implements UpdateFruitPort {

    /** The update fruit persistence port. */
    private final UpdateFruitPersistencePort updateFruitPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public Fruit execute(@Valid final UpdateFruitVo updateFruitVo) {
        return this.updateFruitPersistencePort.execute(updateFruitVo);
    }
}
