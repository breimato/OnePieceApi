package es.api.onepiece.core.internal.services;

import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import jakarta.validation.Valid;

/**
 * The Interface CharacterValidationService.
 */
public interface CharacterValidationService {

    /**
     * Check creation rules.
     *
     * @param createCharacterVo the create character vo
     */
    void checkCreationRules(@Valid CreateCharacterVo createCharacterVo);
}
