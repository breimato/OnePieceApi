package es.api.onepiece.core.internal.usecases.sword;

import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.internal.vo.sword.UpdateSwordVo;
import es.api.onepiece.core.ports.inbound.sword.UpdateSwordPort;
import es.api.onepiece.core.ports.outbound.sword.UpdateSwordPersistencePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The Class UpdateSwordUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateSwordUseCase implements UpdateSwordPort {

    /** The update sword persistence port. */
    private final UpdateSwordPersistencePort updateSwordPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public Sword execute(@Valid final UpdateSwordVo updateSwordVo) {
        return this.updateSwordPersistencePort.execute(updateSwordVo);
    }
}
