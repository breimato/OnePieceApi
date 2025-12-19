package es.api.onepiece.core.internal.services;

import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import es.api.onepiece.core.internal.vo.character.UpdateCharacterVo;
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

    /**
     * Check update rules.
     *
     * @param updateCharacterVo the update character vo
     */
    void checkUpdateRules(@Valid UpdateCharacterVo updateCharacterVo);
}
