package es.api.onepiece.adapters.outbound.persistence.repository.character.transformation;

import es.api.onepiece.adapters.outbound.persistence.mybatis.character.TransformationMyBatisMapper;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * The Class TransformationDeleteRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class TransformationDeleteRepositoryTest {

    /** The transformation delete repository. */
    @InjectMocks
    TransformationDeleteRepository transformationDeleteRepository;

    /** The transformation my batis mapper. */
    @Mock
    TransformationMyBatisMapper transformationMyBatisMapper;

    /**
     * Test execute when called then deletes transformation and attacks.
     */
    @Test
    void testExecute_whenCalled_thenDeletesTransformationAndAttacks() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        this.transformationDeleteRepository.execute(id);

        // Then
        verify(this.transformationMyBatisMapper, times(1)).deleteAttacksByTransformationId(id);
        verify(this.transformationMyBatisMapper, times(1)).deleteTransformation(id);
    }
}
