package es.api.onepiece.core.internal.usecases.character.transformation;

import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.ports.inbound.character.transformation.GetTransformationsPort;
import es.api.onepiece.core.ports.outbound.character.transformation.FindTransformationsPersistencePort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The Class GetTransformationsUseCase.
 */
@Component
@RequiredArgsConstructor
public class GetTransformationsUseCase implements GetTransformationsPort {

    /** The find transformations persistence port. */
    private final FindTransformationsPersistencePort findTransformationsPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Transformation> findAll() {
        return this.findTransformationsPersistencePort.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Transformation findById(@NotNull final Integer id) {
        return this.findTransformationsPersistencePort.findById(id);
    }
}
