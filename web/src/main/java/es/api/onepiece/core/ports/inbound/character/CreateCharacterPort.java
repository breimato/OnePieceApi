package es.api.onepiece.core.ports.inbound.character;

import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import es.api.onepiece.core.internal.domain.character.Character;
import jakarta.validation.Valid;

/**
 * The Interface CreateCharacterPort.
 */
public interface CreateCharacterPort {

    /**
     * Creates the character.
     *
     * @param createCharacterVo the create character vo
     * @return the character
     */
    Character execute(@Valid CreateCharacterVo createCharacterVo);
}
