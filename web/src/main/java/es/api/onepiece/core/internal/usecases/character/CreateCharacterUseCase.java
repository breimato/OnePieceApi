package es.api.onepiece.core.internal.usecases.character;

import es.api.onepiece.core.exceptions.FruitException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.ports.inbound.character.CreateCharacterPort;
import es.api.onepiece.core.ports.outbound.character.CreateCharacterPersistencePort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import es.api.onepiece.core.internal.domain.debut.Debut;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.domain.character.Race;
import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import java.util.stream.Collectors;
import java.util.Collections;

/**
 * The Class CreateCharacterUseCase.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CreateCharacterUseCase implements CreateCharacterPort {

    /** The Constant MAX_FRUITS_PER_CHARACTER. */
    private static final int MAX_FRUITS_PER_CHARACTER = 2;

    /** The create character persistence port. */
    private final CreateCharacterPersistencePort createCharacterPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public Character create(@Valid final CreateCharacterVo createCharacterVo) {

        this.validateFruits(createCharacterVo);

        return this.createCharacterPersistencePort.create(createCharacterVo);

    }

    /**
     * Validate fruits.
     *
     * @param createCharacterVo the create character vo
     * @throws FruitException if character has more than MAX_FRUITS_PER_CHARACTER
     */
    private void validateFruits(final CreateCharacterVo createCharacterVo) {
        if (createCharacterVo.getFruitIds().size() > MAX_FRUITS_PER_CHARACTER) {

            log.error(ExceptionMessageConstants.FRUITS_LIMIT_EXCEEDED_MESSAGE_ERROR);
            throw new FruitException(
                    ExceptionMessageConstants.FRUITS_LIMIT_EXCEEDED_CODE_ERROR,
                    ExceptionMessageConstants.FRUITS_LIMIT_EXCEEDED_MESSAGE_ERROR);
        }
    }
}
