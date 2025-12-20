package es.api.onepiece.core.internal.usecases.character.transformation;

import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.internal.vo.character.transformation.UpdateTransformationVo;
import es.api.onepiece.core.ports.outbound.character.transformation.UpdateTransformationPersistencePort;
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
 * The Class UpdateTransformationUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class UpdateTransformationUseCaseTest {

    /** The update transformation use case. */
    @InjectMocks
    UpdateTransformationUseCase updateTransformationUseCase;

    /** The update transformation persistence port. */
    @Mock
    UpdateTransformationPersistencePort updateTransformationPersistencePort;

    /**
     * Test execute when valid then updates transformation.
     */
    @Test
    void testExecute_whenValid_thenUpdatesTransformation() {

        // Given
        final var updateTransformationVo = Instancio.create(UpdateTransformationVo.class);
        final var transformation = Instancio.create(Transformation.class);

        // When
        when(this.updateTransformationPersistencePort.execute(updateTransformationVo)).thenReturn(transformation);

        final var result = this.updateTransformationUseCase.execute(updateTransformationVo);

        // Then
        verify(this.updateTransformationPersistencePort, times(1)).execute(updateTransformationVo);

        assertThat(result).isEqualTo(transformation);
    }
}
