package es.api.onepiece.core.ports.inbound.character.attack;

import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.vo.character.attack.CreateAttackVo;
import jakarta.validation.Valid;

/**
 * The Interface CreateAttackPort.
 */
public interface CreateAttackPort {

    /**
     * Execute.
     *
     * @param createAttackVo the create attack vo
     * @return the attack
     */
    Attack execute(@Valid CreateAttackVo createAttackVo);
}
