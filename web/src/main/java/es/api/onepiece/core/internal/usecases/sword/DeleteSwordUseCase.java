package es.api.onepiece.core.internal.usecases.sword;

import es.api.onepiece.core.ports.inbound.sword.DeleteSwordPort;
import es.api.onepiece.core.ports.outbound.sword.DeleteSwordPersistencePort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The Class DeleteSwordUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteSwordUseCase implements DeleteSwordPort {

    /** The delete sword persistence port. */
    private final DeleteSwordPersistencePort deleteSwordPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(@NotNull final Integer id) {
        this.deleteSwordPersistencePort.execute(id);
    }
}
