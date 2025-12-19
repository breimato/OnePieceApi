package es.api.onepiece.core.internal.usecases.character;

import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.services.CharacterValidationService;
import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import es.api.onepiece.core.ports.outbound.character.CreateCharacterPersistencePort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

    /** The validate character service. */
    @Mock
    CharacterValidationService characterValidationService;

    /** The create character use case. */
    @InjectMocks
    CreateCharacterUseCase createCharacterUseCase;

    /**
     * Test execute when valid then creates character.
     */
    @Test
    void testExecute_whenValid_thenCreatesCharacter() {
        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);
        final var character = Instancio.create(Character.class);

        // When
        when(this.createCharacterPersistencePort.execute(createCharacterVo)).thenReturn(character);

        final var result = this.createCharacterUseCase.execute(createCharacterVo);

        // Then
        verify(this.characterValidationService, times(1)).checkCreationRules(createCharacterVo);
        verify(this.createCharacterPersistencePort, times(1)).execute(createCharacterVo);

        assertThat(result).isEqualTo(character);
    }
}