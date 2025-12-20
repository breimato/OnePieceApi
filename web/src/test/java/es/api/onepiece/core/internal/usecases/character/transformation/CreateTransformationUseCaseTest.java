package es.api.onepiece.core.internal.usecases.character.transformation;

import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.internal.vo.character.transformation.CreateTransformationVo;
import es.api.onepiece.core.ports.outbound.character.transformation.CreateTransformationPersistencePort;
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
 * The Class CreateTransformationUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class CreateTransformationUseCaseTest {

    /** The create transformation use case. */
    @InjectMocks
    CreateTransformationUseCase createTransformationUseCase;

    /** The create transformation persistence port. */
    @Mock
    CreateTransformationPersistencePort createTransformationPersistencePort;

    /**
     * Test execute when valid then creates transformation.
     */
    @Test
    void testExecute_whenValid_thenCreatesTransformation() {

        // Given
        final var createTransformationVo = Instancio.create(CreateTransformationVo.class);
        final var transformation = Instancio.create(Transformation.class);

        // When
        when(this.createTransformationPersistencePort.execute(createTransformationVo)).thenReturn(transformation);

        final var result = this.createTransformationUseCase.execute(createTransformationVo);

        // Then
        verify(this.createTransformationPersistencePort, times(1)).execute(createTransformationVo);

        assertThat(result).isEqualTo(transformation);
    }
}
