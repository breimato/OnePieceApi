package es.api.onepiece.core.ports.inbound.character;

import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.vo.character.UpdateCharacterVo;
import jakarta.validation.Valid;

/**
 * The Interface UpdateCharacterPort.
 */
public interface UpdateCharacterPort {

    /**
     * Updates the character.
     *
     * @param updateCharacterVo the update character vo
     * @return the character
     */
    Character execute(@Valid UpdateCharacterVo updateCharacterVo);
}
