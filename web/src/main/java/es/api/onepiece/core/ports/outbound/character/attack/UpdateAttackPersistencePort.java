package es.api.onepiece.core.ports.outbound.character.attack;

import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.vo.character.attack.UpdateAttackVo;
import jakarta.validation.Valid;

/**
 * The Interface UpdateAttackPersistencePort.
 */
public interface UpdateAttackPersistencePort {

    /**
     * Execute.
     *
     * @param updateAttackVo the update attack vo
     * @return the attack
     */
    Attack execute(@Valid UpdateAttackVo updateAttackVo);
}
