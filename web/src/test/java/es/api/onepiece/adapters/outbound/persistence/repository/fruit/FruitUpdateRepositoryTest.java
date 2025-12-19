package es.api.onepiece.adapters.outbound.persistence.repository.fruit;

import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.fruit.FruitMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.fruit.FruitMyBatisMapper;
import es.api.onepiece.core.exceptions.FruitException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.vo.fruit.UpdateFruitVo;
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
 * The Class FruitUpdateRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class FruitUpdateRepositoryTest {

    /** The fruit update repository. */
    @InjectMocks
    FruitUpdateRepository fruitUpdateRepository;

    /** The fruit my batis mapper. */
    @Mock
    FruitMyBatisMapper fruitMyBatisMapper;

    /** The fruit mapper. */
    @Mock
    FruitMapper fruitMapper;


    /**
     * Test execute when fruit exists then updates fruit.
     */
    @Test
    void testExecute_whenFruitExists_thenUpdatesFruit() {

        // Given
        final var updateFruitVo = Instancio.create(UpdateFruitVo.class);
        final var fruitEntity = Instancio.create(FruitEntity.class);
        final var fruit = Instancio.create(Fruit.class);

        // When
        when(this.fruitMyBatisMapper.exists(updateFruitVo.getId())).thenReturn(true);
        when(this.fruitMapper.toFruitEntity(updateFruitVo)).thenReturn(fruitEntity);
        when(this.fruitMyBatisMapper.findById(updateFruitVo.getId())).thenReturn(fruitEntity);
        when(this.fruitMapper.toFruit(fruitEntity)).thenReturn(fruit);

        final var result = this.fruitUpdateRepository.execute(updateFruitVo);

        // Then
        verify(this.fruitMyBatisMapper, times(1)).exists(updateFruitVo.getId());
        verify(this.fruitMapper, times(1)).toFruitEntity(updateFruitVo);
        verify(this.fruitMyBatisMapper, times(1)).updateFruit(fruitEntity);
        verify(this.fruitMyBatisMapper, times(1)).findById(updateFruitVo.getId());
        verify(this.fruitMapper, times(1)).toFruit(fruitEntity);

        assertThat(result).isEqualTo(fruit);
    }

    /**
     * Test execute when fruit not exists then throws exception.
     */
    @Test
    void testExecute_whenFruitNotExists_thenThrowsException() {

        // Given
        final var updateFruitVo = Instancio.create(UpdateFruitVo.class);

        // When
        when(this.fruitMyBatisMapper.exists(updateFruitVo.getId())).thenReturn(false);

        final var exception = assertThrows(FruitException.class,
                () -> this.fruitUpdateRepository.execute(updateFruitVo));

        // Then
        verify(this.fruitMyBatisMapper, times(1)).exists(updateFruitVo.getId());

        assertThat(exception.getCode()).isEqualTo(ExceptionMessageConstants.FRUIT_NOT_FOUND_CODE_ERROR);
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessageConstants.FRUIT_NOT_FOUND_MESSAGE_ERROR);
    }
}
