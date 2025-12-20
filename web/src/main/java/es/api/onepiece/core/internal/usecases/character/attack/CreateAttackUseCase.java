package es.api.onepiece.core.internal.usecases.character.attack;

import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.vo.character.attack.CreateAttackVo;
import es.api.onepiece.core.ports.inbound.character.attack.CreateAttackPort;
import es.api.onepiece.core.ports.outbound.character.attack.CreateAttackPersistencePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The Class CreateAttackUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CreateAttackUseCase implements CreateAttackPort {

    /** The create attack persistence port. */
    private final CreateAttackPersistencePort createAttackPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public Attack execute(@Valid final CreateAttackVo createAttackVo) {
        return this.createAttackPersistencePort.execute(createAttackVo);
    }
}
