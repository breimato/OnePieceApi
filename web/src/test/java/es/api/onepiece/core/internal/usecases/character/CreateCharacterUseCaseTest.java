package es.api.onepiece.core.internal.usecases.character;

import es.api.onepiece.core.exceptions.FruitException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import es.api.onepiece.core.ports.outbound.character.CreateCharacterPersistencePort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The Class CreateCharacterUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class CreateCharacterUseCaseTest {

    /** The create character persistence port. */
    @Mock
    CreateCharacterPersistencePort createCharacterPersistencePort;

    /** The create character use case. */
    @InjectMocks
    CreateCharacterUseCase createCharacterUseCase;

    /**
     * Test create when fruits are valid then creates character.
     */
    @Test
    void testCreate_whenFruitsAreValid_thenCreatesCharacter() {
        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);
        createCharacterVo.setFruitIds(Collections.emptyList());

        final var character = Instancio.create(Character.class);

        // When
        when(this.createCharacterPersistencePort.create(createCharacterVo)).thenReturn(character);

        final var result = this.createCharacterUseCase.create(createCharacterVo);

        // Then
        verify(this.createCharacterPersistencePort, times(1)).create(createCharacterVo);

        assertThat(result).isEqualTo(character);
    }

    /**
     * Test create when fruits exceed limit then throws fruit exception.
     */
    @Test
    void testCreate_whenFruitsExceedLimit_thenThrowsFruitException() {
        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);
        final var fruitIds = Instancio.ofList(Integer.class).size(3).create();
        createCharacterVo.setFruitIds(fruitIds);

        // When
        final var exception
                = assertThrows(FruitException.class, () -> this.createCharacterUseCase.create(createCharacterVo));

        // Then
        verify(this.createCharacterPersistencePort, times(0)).create(createCharacterVo);

        assertEquals(ExceptionMessageConstants.FRUITS_LIMIT_EXCEEDED_CODE_ERROR, exception.getCode());
        assertEquals(ExceptionMessageConstants.FRUITS_LIMIT_EXCEEDED_MESSAGE_ERROR, exception.getMessage());
    }
}