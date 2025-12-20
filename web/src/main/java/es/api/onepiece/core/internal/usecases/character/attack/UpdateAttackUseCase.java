package es.api.onepiece.core.internal.usecases.character.attack;

import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.vo.character.attack.UpdateAttackVo;
import es.api.onepiece.core.ports.inbound.character.attack.UpdateAttackPort;
import es.api.onepiece.core.ports.outbound.character.attack.UpdateAttackPersistencePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The Class UpdateAttackUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateAttackUseCase implements UpdateAttackPort {

    /** The update attack persistence port. */
    private final UpdateAttackPersistencePort updateAttackPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public Attack execute(@Valid final UpdateAttackVo updateAttackVo) {
        return this.updateAttackPersistencePort.execute(updateAttackVo);
    }
}
