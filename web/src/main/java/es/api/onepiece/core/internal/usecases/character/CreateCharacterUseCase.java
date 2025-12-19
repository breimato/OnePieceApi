package es.api.onepiece.core.internal.usecases.character;

import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.services.CharacterValidationService;
import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import es.api.onepiece.core.ports.inbound.character.CreateCharacterPort;
import es.api.onepiece.core.ports.outbound.character.CreateCharacterPersistencePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The Class CreateCharacterUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CreateCharacterUseCase implements CreateCharacterPort {

    /** The create character persistence port. */
    private final CreateCharacterPersistencePort createCharacterPersistencePort;

    /** The validate character service. */
    private final CharacterValidationService characterValidationService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Character execute(@Valid final CreateCharacterVo createCharacterVo) {
        this.characterValidationService.checkCreationRules(createCharacterVo);
        return this.createCharacterPersistencePort.execute(createCharacterVo);
    }
}
