package es.api.onepiece.core.internal.usecases.character.transformation;

import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.internal.vo.character.transformation.UpdateTransformationVo;
import es.api.onepiece.core.ports.inbound.character.transformation.UpdateTransformationPort;
import es.api.onepiece.core.ports.outbound.character.transformation.UpdateTransformationPersistencePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The Class UpdateTransformationUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateTransformationUseCase implements UpdateTransformationPort {

    /** The update transformation persistence port. */
    private final UpdateTransformationPersistencePort updateTransformationPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public Transformation execute(@Valid final UpdateTransformationVo updateTransformationVo) {
        return this.updateTransformationPersistencePort.execute(updateTransformationVo);
    }
}
