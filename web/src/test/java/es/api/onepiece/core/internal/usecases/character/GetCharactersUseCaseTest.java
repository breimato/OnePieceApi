package es.api.onepiece.core.internal.usecases.character;

import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.ports.outbound.character.FindCharactersPersistencePort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The Class GetCharactersUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class GetCharactersUseCaseTest {

    /** The find characters persistence port. */
    @Mock
    FindCharactersPersistencePort findCharactersPersistencePort;

    /** The get characters use case. */
    @InjectMocks
    GetCharactersUseCase getCharactersUseCase;

    /**
     * Test find all when characters exist then returns domain list.
     */
    @Test
    void testFindAll_whenCharactersExist_thenReturnsDomainList() {
        // Given
        final var expectedCharacters = Instancio.ofList(Character.class).size(3).create();

        // When
        when(findCharactersPersistencePort.findAll()).thenReturn(expectedCharacters);
        final var actualCharacters = getCharactersUseCase.findAll();

        // Then
        verify(findCharactersPersistencePort).findAll();
        assertEquals(expectedCharacters, actualCharacters);
    }
}
