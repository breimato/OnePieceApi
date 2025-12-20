package es.api.onepiece.adapters.outbound.persistence.repository.character.transformation;

import es.api.onepiece.adapters.outbound.persistence.entities.character.TransformationEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.TransformationMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.TransformationMyBatisMapper;
import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.internal.vo.character.transformation.UpdateTransformationVo;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The Class TransformationUpdateRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class TransformationUpdateRepositoryTest {

    /** The transformation update repository. */
    @InjectMocks
    TransformationUpdateRepository transformationUpdateRepository;

    /** The transformation my batis mapper. */
    @Mock
    TransformationMyBatisMapper transformationMyBatisMapper;

    /** The transformation mapper. */
    @Mock
    TransformationMapper transformationMapper;

    /**
     * Test execute when transformation exists then updates transformation.
     */
    @Test
    void testExecute_whenTransformationExists_thenUpdatesTransformation() {

        // Given
        final var updateTransformationVo = Instancio.create(UpdateTransformationVo.class);
        final var transformationEntity = Instancio.create(TransformationEntity.class);
        final var transformation = Instancio.create(Transformation.class);

        // When
        when(this.transformationMyBatisMapper.exists(updateTransformationVo.getId())).thenReturn(true);
        when(this.transformationMapper.toTransformationEntity(updateTransformationVo)).thenReturn(transformationEntity);
        when(this.transformationMyBatisMapper.findById(updateTransformationVo.getId()))
                .thenReturn(transformationEntity);
        when(this.transformationMapper.toTransformation(transformationEntity)).thenReturn(transformation);

        final var result = this.transformationUpdateRepository.execute(updateTransformationVo);

        // Then
        verify(this.transformationMyBatisMapper, times(1)).exists(updateTransformationVo.getId());
        verify(this.transformationMapper, times(1)).toTransformationEntity(updateTransformationVo);
        verify(this.transformationMyBatisMapper, times(1)).updateTransformation(transformationEntity);
        verify(this.transformationMyBatisMapper, times(1)).findById(updateTransformationVo.getId());
        verify(this.transformationMapper, times(1)).toTransformation(transformationEntity);

        assertThat(result).isEqualTo(transformation);
    }

    /**
     * Test execute when transformation not exists then throws exception.
     */
    @Test
    void testExecute_whenTransformationNotExists_thenThrowsException() {

        // Given
        final var updateTransformationVo = Instancio.create(UpdateTransformationVo.class);

        // When
        when(this.transformationMyBatisMapper.exists(updateTransformationVo.getId())).thenReturn(false);

        final var exception = assertThrows(CharacterException.class,
                () -> this.transformationUpdateRepository.execute(updateTransformationVo));

        // Then
        verify(this.transformationMyBatisMapper, times(1)).exists(updateTransformationVo.getId());

        assertThat(exception.getCode()).isEqualTo(ExceptionMessageConstants.TRANSFORMATION_NOT_FOUND_CODE_ERROR);
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessageConstants.TRANSFORMATION_NOT_FOUND_MESSAGE_ERROR);
    }
}
