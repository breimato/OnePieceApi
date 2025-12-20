package es.api.onepiece.core.internal.usecases.character.attack;

import es.api.onepiece.core.ports.inbound.character.attack.DeleteAttackPort;
import es.api.onepiece.core.ports.outbound.character.attack.DeleteAttackPersistencePort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The Class DeleteAttackUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteAttackUseCase implements DeleteAttackPort {

    /** The delete attack persistence port. */
    private final DeleteAttackPersistencePort deleteAttackPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(@NotNull final Integer id) {
        this.deleteAttackPersistencePort.execute(id);
    }
}
