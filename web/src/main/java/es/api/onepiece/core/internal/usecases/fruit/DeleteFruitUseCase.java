package es.api.onepiece.core.internal.usecases.fruit;

import es.api.onepiece.core.ports.inbound.fruit.DeleteFruitPort;
import es.api.onepiece.core.ports.outbound.fruit.DeleteFruitPersistencePort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The Class DeleteFruitUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteFruitUseCase implements DeleteFruitPort {

    /** The delete fruit persistence port. */
    private final DeleteFruitPersistencePort deleteFruitPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(@NotNull final Integer id) {
        this.deleteFruitPersistencePort.execute(id);
    }
}
