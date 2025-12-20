package es.api.onepiece.core.ports.outbound.character.attack;

import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.vo.character.attack.CreateAttackVo;
import jakarta.validation.Valid;

/**
 * The Interface CreateAttackPersistencePort.
 */
public interface CreateAttackPersistencePort {

    /**
     * Execute.
     *
     * @param createAttackVo the create attack vo
     * @return the attack
     */
    Attack execute(@Valid CreateAttackVo createAttackVo);
}
