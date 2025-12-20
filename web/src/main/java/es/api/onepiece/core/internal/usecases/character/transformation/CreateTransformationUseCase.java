package es.api.onepiece.core.internal.usecases.character.transformation;

import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.internal.vo.character.transformation.CreateTransformationVo;
import es.api.onepiece.core.ports.inbound.character.transformation.CreateTransformationPort;
import es.api.onepiece.core.ports.outbound.character.transformation.CreateTransformationPersistencePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The Class CreateTransformationUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CreateTransformationUseCase implements CreateTransformationPort {

    /** The create transformation persistence port. */
    private final CreateTransformationPersistencePort createTransformationPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public Transformation execute(@Valid final CreateTransformationVo createTransformationVo) {
        return this.createTransformationPersistencePort.execute(createTransformationVo);
    }
}
