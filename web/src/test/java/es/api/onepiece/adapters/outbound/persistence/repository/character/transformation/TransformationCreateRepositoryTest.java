package es.api.onepiece.adapters.outbound.persistence.repository.character.transformation;

import es.api.onepiece.adapters.outbound.persistence.entities.character.TransformationEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.TransformationMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.TransformationMyBatisMapper;
import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.internal.vo.character.transformation.CreateTransformationVo;
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
 * The Class TransformationCreateRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class TransformationCreateRepositoryTest {

    /** The transformation create repository. */
    @InjectMocks
    TransformationCreateRepository transformationCreateRepository;

    /** The transformation my batis mapper. */
    @Mock
    TransformationMyBatisMapper transformationMyBatisMapper;

    /** The transformation mapper. */
    @Mock
    TransformationMapper transformationMapper;

    /**
     * Test execute when valid vo then creates transformation.
     */
    @Test
    void testExecute_whenValidVo_thenCreatesTransformation() {

        // Given
        final var createTransformationVo = Instancio.create(CreateTransformationVo.class);
        final var transformationEntity = Instancio.create(TransformationEntity.class);
        final var transformation = Instancio.create(Transformation.class);

        // When
        when(this.transformationMapper.toTransformationEntity(createTransformationVo)).thenReturn(transformationEntity);
        when(this.transformationMyBatisMapper.findById(transformationEntity.getId())).thenReturn(transformationEntity);
        when(this.transformationMapper.toTransformation(transformationEntity)).thenReturn(transformation);

        final var result = this.transformationCreateRepository.execute(createTransformationVo);

        // Then
        verify(this.transformationMapper, times(1)).toTransformationEntity(createTransformationVo);
        verify(this.transformationMyBatisMapper, times(1)).insertTransformation(transformationEntity);
        verify(this.transformationMyBatisMapper, times(1)).findById(transformationEntity.getId());
        verify(this.transformationMapper, times(1)).toTransformation(transformationEntity);

        assertThat(result).isEqualTo(transformation);
    }
}
