package es.api.onepiece.core.internal.usecases.character.transformation;

import es.api.onepiece.core.ports.inbound.character.transformation.DeleteTransformationPort;
import es.api.onepiece.core.ports.outbound.character.transformation.DeleteTransformationPersistencePort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The Class DeleteTransformationUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteTransformationUseCase implements DeleteTransformationPort {

    /** The delete transformation persistence port. */
    private final DeleteTransformationPersistencePort deleteTransformationPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(@NotNull final Integer id) {
        this.deleteTransformationPersistencePort.execute(id);
    }
}
