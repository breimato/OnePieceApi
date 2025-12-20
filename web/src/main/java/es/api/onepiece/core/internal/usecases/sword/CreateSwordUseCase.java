package es.api.onepiece.core.internal.usecases.sword;

import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.internal.vo.sword.CreateSwordVo;
import es.api.onepiece.core.ports.inbound.sword.CreateSwordPort;
import es.api.onepiece.core.ports.outbound.sword.CreateSwordPersistencePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The Class CreateSwordUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CreateSwordUseCase implements CreateSwordPort {

    /** The create sword persistence port. */
    private final CreateSwordPersistencePort createSwordPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public Sword execute(@Valid final CreateSwordVo createSwordVo) {
        return this.createSwordPersistencePort.execute(createSwordVo);
    }
}
