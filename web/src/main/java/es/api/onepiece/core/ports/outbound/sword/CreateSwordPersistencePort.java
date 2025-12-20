package es.api.onepiece.core.ports.outbound.sword;

import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.internal.vo.sword.CreateSwordVo;
import jakarta.validation.Valid;

/**
 * The Interface CreateSwordPersistencePort.
 */
public interface CreateSwordPersistencePort {

    /**
     * Execute.
     *
     * @param createSwordVo the create sword vo
     * @return the sword
     */
    Sword execute(@Valid CreateSwordVo createSwordVo);
}
