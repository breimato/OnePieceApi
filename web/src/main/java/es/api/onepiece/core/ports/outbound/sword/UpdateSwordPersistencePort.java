package es.api.onepiece.core.ports.outbound.sword;

import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.internal.vo.sword.UpdateSwordVo;
import jakarta.validation.Valid;

/**
 * The Interface UpdateSwordPersistencePort.
 */
public interface UpdateSwordPersistencePort {

    /**
     * Execute.
     *
     * @param updateSwordVo the update sword vo
     * @return the sword
     */
    Sword execute(@Valid UpdateSwordVo updateSwordVo);
}
