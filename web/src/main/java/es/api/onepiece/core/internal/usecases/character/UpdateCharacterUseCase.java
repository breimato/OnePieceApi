package es.api.onepiece.core.internal.usecases.character;

import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.services.CharacterValidationService;
import es.api.onepiece.core.internal.vo.character.UpdateCharacterVo;
import es.api.onepiece.core.ports.inbound.character.UpdateCharacterPort;
import es.api.onepiece.core.ports.outbound.character.UpdateCharacterPersistencePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The Class UpdateCharacterUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UpdateCharacterUseCase implements UpdateCharacterPort {

    /** The update character persistence port. */
    private final UpdateCharacterPersistencePort updateCharacterPersistencePort;

    /** The character validation service. */
    private final CharacterValidationService characterValidationService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Character execute(@Valid final UpdateCharacterVo updateCharacterVo) {
        this.characterValidationService.checkUpdateRules(updateCharacterVo);
        return this.updateCharacterPersistencePort.execute(updateCharacterVo);
    }
}
