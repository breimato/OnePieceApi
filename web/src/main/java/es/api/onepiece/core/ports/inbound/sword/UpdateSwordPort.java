package es.api.onepiece.core.ports.inbound.sword;

import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.internal.vo.sword.UpdateSwordVo;
import jakarta.validation.Valid;

/**
 * The Interface UpdateSwordPort.
 */
public interface UpdateSwordPort {

    /**
     * Execute.
     *
     * @param updateSwordVo the update sword vo
     * @return the sword
     */
    Sword execute(@Valid UpdateSwordVo updateSwordVo);
}
