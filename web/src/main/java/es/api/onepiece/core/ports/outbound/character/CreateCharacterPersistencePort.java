package es.api.onepiece.core.ports.outbound.character;

import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import jakarta.validation.Valid;

/**
 * The Interface CreateCharacterPersistencePort.
 */
public interface CreateCharacterPersistencePort {

    /**
     * Creates the character.
     *
     * @param createCharacterVo the character
     * @return the integer (character ID)
     */
    Character execute(@Valid CreateCharacterVo createCharacterVo);
}
