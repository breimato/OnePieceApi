package es.api.onepiece.core.internal.usecases.character.transformation;

import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.ports.outbound.character.transformation.FindTransformationsPersistencePort;
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
 * The Class GetTransformationsUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class GetTransformationsUseCaseTest {

    /** The get transformations use case. */
    @InjectMocks
    GetTransformationsUseCase getTransformationsUseCase;

    /** The find transformations persistence port. */
    @Mock
    FindTransformationsPersistencePort findTransformationsPersistencePort;

    /**
     * Test find all when called then returns all transformations.
     */
    @Test
    void testFindAll_whenCalled_thenReturnsAllTransformations() {

        // Given
        final var transformations = Instancio.ofList(Transformation.class).size(3).create();

        // When
        when(this.findTransformationsPersistencePort.findAll()).thenReturn(transformations);

        final var result = this.getTransformationsUseCase.findAll();

        // Then
        verify(this.findTransformationsPersistencePort, times(1)).findAll();

        assertThat(result).isEqualTo(transformations);
    }

    /**
     * Test find by id when valid id then returns transformation.
     */
    @Test
    void testFindById_whenValidId_thenReturnsTransformation() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var transformation = Instancio.create(Transformation.class);

        // When
        when(this.findTransformationsPersistencePort.findById(id)).thenReturn(transformation);

        final var result = this.getTransformationsUseCase.findById(id);

        // Then
        verify(this.findTransformationsPersistencePort, times(1)).findById(id);

        assertThat(result).isEqualTo(transformation);
    }
}
