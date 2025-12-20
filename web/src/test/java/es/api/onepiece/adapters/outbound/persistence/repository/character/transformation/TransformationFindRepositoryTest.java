package es.api.onepiece.adapters.outbound.persistence.repository.character.transformation;

import es.api.onepiece.adapters.outbound.persistence.entities.character.TransformationEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.TransformationMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.TransformationMyBatisMapper;
import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.character.Transformation;
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
 * The Class TransformationFindRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class TransformationFindRepositoryTest {

    /** The transformation my batis mapper. */
    @Mock
    TransformationMyBatisMapper transformationMyBatisMapper;

    /** The transformation find repository. */
    @InjectMocks
    TransformationFindRepository transformationFindRepository;

    /** The transformation mapper. */
    @Mock
    TransformationMapper transformationMapper;

    /**
     * Test find all when called then returns all transformations.
     */
    @Test
    void testFindAll_whenCalled_thenReturnsAllTransformations() {

        // Given
        final var transformationEntities = Instancio.ofList(TransformationEntity.class).size(3).create();
        final var transformations = Instancio.ofList(Transformation.class).size(3).create();

        // When
        when(this.transformationMyBatisMapper.findAll()).thenReturn(transformationEntities);
        when(this.transformationMapper.toTransformationList(transformationEntities)).thenReturn(transformations);

        final var result = this.transformationFindRepository.findAll();

        // Then
        verify(this.transformationMyBatisMapper, times(1)).findAll();
        verify(this.transformationMapper, times(1)).toTransformationList(transformationEntities);

        assertThat(result).isEqualTo(transformations);
    }

    /**
     * Test find all when list is null then throw exception.
     */
    @Test
    void testFindAll_whenListIsNull_thenThrowException() {

        // Given

        // When
        when(this.transformationMyBatisMapper.findAll()).thenReturn(null);

        final var exception = assertThrows(CharacterException.class,
                () -> this.transformationFindRepository.findAll());

        // Then
        verify(this.transformationMyBatisMapper, times(1)).findAll();

        assertThat(exception.getCode()).isEqualTo(ExceptionMessageConstants.TRANSFORMATION_NOT_FOUND_CODE_ERROR);
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessageConstants.TRANSFORMATION_NOT_FOUND_MESSAGE_ERROR);
    }

    /**
     * Test find by id when transformation exists then returns transformation.
     */
    @Test
    void testFindById_whenTransformationExists_thenReturnsTransformation() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var transformationEntity = Instancio.create(TransformationEntity.class);
        final var transformation = Instancio.create(Transformation.class);

        // When
        when(this.transformationMyBatisMapper.findById(id)).thenReturn(transformationEntity);
        when(this.transformationMapper.toTransformation(transformationEntity)).thenReturn(transformation);

        final var result = this.transformationFindRepository.findById(id);

        // Then
        verify(this.transformationMyBatisMapper, times(1)).findById(id);
        verify(this.transformationMapper, times(1)).toTransformation(transformationEntity);

        assertThat(result).isEqualTo(transformation);
    }

    /**
     * Test find by id when transformation not exists then throws exception.
     */
    @Test
    void testFindById_whenTransformationNotExists_thenThrowsException() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        when(this.transformationMyBatisMapper.findById(id)).thenReturn(null);

        final var exception = assertThrows(CharacterException.class,
                () -> this.transformationFindRepository.findById(id));

        // Then
        verify(this.transformationMyBatisMapper, times(1)).findById(id);

        assertThat(exception.getCode()).isEqualTo(ExceptionMessageConstants.TRANSFORMATION_NOT_FOUND_CODE_ERROR);
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessageConstants.TRANSFORMATION_NOT_FOUND_MESSAGE_ERROR);
    }

    /**
     * Test exists when transformation exists then returns true.
     */
    @Test
    void testExists_whenTransformationExists_thenReturnsTrue() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        when(this.transformationMyBatisMapper.exists(id)).thenReturn(true);

        final var result = this.transformationFindRepository.exists(id);

        // Then
        verify(this.transformationMyBatisMapper, times(1)).exists(id);

        assertThat(result).isTrue();
    }

    /**
     * Test exists when transformation not exists then returns false.
     */
    @Test
    void testExists_whenTransformationNotExists_thenReturnsFalse() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        when(this.transformationMyBatisMapper.exists(id)).thenReturn(false);

        final var result = this.transformationFindRepository.exists(id);

        // Then
        verify(this.transformationMyBatisMapper, times(1)).exists(id);

        assertThat(result).isFalse();
    }
}
