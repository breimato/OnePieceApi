package es.api.onepiece.core.ports.inbound.character.attack;

import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.vo.character.attack.UpdateAttackVo;
import jakarta.validation.Valid;

/**
 * The Interface UpdateAttackPort.
 */
public interface UpdateAttackPort {

    /**
     * Execute.
     *
     * @param updateAttackVo the update attack vo
     * @return the attack
     */
    Attack execute(@Valid UpdateAttackVo updateAttackVo);
}
