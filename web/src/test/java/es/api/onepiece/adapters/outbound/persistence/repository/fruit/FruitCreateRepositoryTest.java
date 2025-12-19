package es.api.onepiece.adapters.outbound.persistence.repository.fruit;

import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.fruit.FruitMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.fruit.FruitMyBatisMapper;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.vo.fruit.CreateFruitVo;
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
 * The Class FruitCreateRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class FruitCreateRepositoryTest {

    /** The fruit create repository. */
    @InjectMocks
    FruitCreateRepository fruitCreateRepository;

    /** The fruit my batis mapper. */
    @Mock
    FruitMyBatisMapper fruitMyBatisMapper;

    /** The fruit mapper. */
    @Mock
    FruitMapper fruitMapper;


    /**
     * Test execute when valid vo then creates fruit.
     */
    @Test
    void testExecute_whenValidVo_thenCreatesFruit() {

        // Given
        final var createFruitVo = Instancio.create(CreateFruitVo.class);
        final var fruitEntity = Instancio.create(FruitEntity.class);
        final var fruit = Instancio.create(Fruit.class);

        // When
        when(this.fruitMapper.toFruitEntity(createFruitVo)).thenReturn(fruitEntity);
        when(this.fruitMyBatisMapper.findById(fruitEntity.getId())).thenReturn(fruitEntity);
        when(this.fruitMapper.toFruit(fruitEntity)).thenReturn(fruit);

        final var result = this.fruitCreateRepository.execute(createFruitVo);

        // Then
        verify(this.fruitMapper, times(1)).toFruitEntity(createFruitVo);
        verify(this.fruitMyBatisMapper, times(1)).insertFruit(fruitEntity);
        verify(this.fruitMyBatisMapper, times(1)).findById(fruitEntity.getId());
        verify(this.fruitMapper, times(1)).toFruit(fruitEntity);

        assertThat(result).isEqualTo(fruit);
    }
}
