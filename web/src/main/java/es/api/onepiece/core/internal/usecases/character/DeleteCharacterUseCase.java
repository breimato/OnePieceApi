package es.api.onepiece.core.internal.usecases.character;

import es.api.onepiece.core.ports.inbound.character.DeleteCharacterPort;
import es.api.onepiece.core.ports.outbound.character.DeleteCharacterPersistencePort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The Class DeleteCharacterUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteCharacterUseCase implements DeleteCharacterPort {

    /** The delete character persistence port. */
    private final DeleteCharacterPersistencePort deleteCharacterPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(@NotNull final Integer id) {
        this.deleteCharacterPersistencePort.execute(id);
    }
}
