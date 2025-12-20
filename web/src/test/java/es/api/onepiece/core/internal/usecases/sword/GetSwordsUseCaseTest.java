package es.api.onepiece.core.internal.usecases.sword;

import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.ports.outbound.sword.FindSwordsPersistencePort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class GetSwordsUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class GetSwordsUseCaseTest {

    /** The get swords use case. */
    @InjectMocks
    GetSwordsUseCase getSwordsUseCase;

    /** The find swords persistence port. */
    @Mock
    FindSwordsPersistencePort findSwordsPersistencePort;

    /**
     * Test find all when called then returns list of swords.
     */
    @Test
    void testFindAll_whenCalled_thenReturnsListOfSwords() {

        // Given
        final var swords = Instancio.ofList(Sword.class).size(3).create();

        // When
        when(this.findSwordsPersistencePort.findAll()).thenReturn(swords);

        final var result = this.getSwordsUseCase.findAll();

        // Then
        verify(this.findSwordsPersistencePort, times(1)).findAll();

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(swords);
    }

    /**
     * Test find by id when called then returns sword.
     */
    @Test
    void testFindById_whenCalled_thenReturnsSword() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var sword = Instancio.create(Sword.class);

        // When
        when(this.findSwordsPersistencePort.findById(id)).thenReturn(sword);

        final var result = this.getSwordsUseCase.findById(id);

        // Then
        verify(this.findSwordsPersistencePort, times(1)).findById(id);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(sword);
    }
}
