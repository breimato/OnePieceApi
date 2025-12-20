package es.api.onepiece.adapters.outbound.persistence.repository.fruit;

import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.fruit.FruitMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.fruit.FruitMyBatisMapper;
import es.api.onepiece.core.exceptions.FruitException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
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
 * The Class FruitFindRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class FruitFindRepositoryTest {

    /** The fruit my batis mapper. */
    @Mock
    FruitMyBatisMapper fruitMyBatisMapper;

    /** The fruit find repository. */
    @InjectMocks
    FruitFindRepository fruitFindRepository;

    /** The fruit mapper. */
    @Mock
    FruitMapper fruitMapper;

    /**
     * Test find all when called then returns all fruits.
     */
    @Test
    void testFindAll_whenCalled_thenReturnsAllFruits() {

        // Given
        final var fruitEntities = Instancio.ofList(FruitEntity.class).size(3).create();
        final var fruits = Instancio.ofList(Fruit.class).size(3).create();

        // When
        when(this.fruitMyBatisMapper.findAll()).thenReturn(fruitEntities);
        when(this.fruitMapper.toFruitList(fruitEntities)).thenReturn(fruits);

        final var result = this.fruitFindRepository.findAll();

        // Then
        verify(this.fruitMyBatisMapper, times(1)).findAll();
        verify(this.fruitMapper, times(1)).toFruitList(fruitEntities);

        assertThat(result).isEqualTo(fruits);
    }

    /**
     * Test find all when list is null then throw exception.
     */
    @Test
    void testFindAll_whenListIsNull_thenThrowException() {

        // Given

        // When
        when(this.fruitMyBatisMapper.findAll()).thenReturn(null);

        final var exception = assertThrows(FruitException.class, () -> this.fruitFindRepository.findAll());

        // Then
        verify(this.fruitMyBatisMapper, times(1)).findAll();

        assertThat(exception.getCode()).isEqualTo(ExceptionMessageConstants.FRUIT_NOT_FOUND_CODE_ERROR);
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessageConstants.FRUIT_NOT_FOUND_MESSAGE_ERROR);
    }

    /**
     * Test find by id when fruit exists then returns fruit.
     */
    @Test
    void testFindById_whenFruitExists_thenReturnsFruit() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var fruitEntity = Instancio.create(FruitEntity.class);
        final var fruit = Instancio.create(Fruit.class);

        // When
        when(this.fruitMyBatisMapper.findById(id)).thenReturn(fruitEntity);
        when(this.fruitMapper.toFruit(fruitEntity)).thenReturn(fruit);

        final var result = this.fruitFindRepository.findById(id);

        // Then
        verify(this.fruitMyBatisMapper, times(1)).findById(id);
        verify(this.fruitMapper, times(1)).toFruit(fruitEntity);

        assertThat(result).isEqualTo(fruit);
    }

    /**
     * Test find by id when fruit not exists then throws exception.
     */
    @Test
    void testFindById_whenFruitNotExists_thenThrowsException() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        when(this.fruitMyBatisMapper.findById(id)).thenReturn(null);

        final var exception = assertThrows(FruitException.class, () -> this.fruitFindRepository.findById(id));

        // Then
        verify(this.fruitMyBatisMapper, times(1)).findById(id);

        assertThat(exception.getCode()).isEqualTo(ExceptionMessageConstants.FRUIT_NOT_FOUND_CODE_ERROR);
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessageConstants.FRUIT_NOT_FOUND_MESSAGE_ERROR);
    }

    /**
     * Test exists when fruit exists then returns true.
     */
    @Test
    void testExists_whenFruitExists_thenReturnsTrue() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        when(this.fruitMyBatisMapper.exists(id)).thenReturn(true);

        final var result = this.fruitFindRepository.exists(id);

        // Then
        verify(this.fruitMyBatisMapper, times(1)).exists(id);

        assertThat(result).isTrue();
    }

    /**
     * Test exists when fruit not exists then returns false.
     */
    @Test
    void testExists_whenFruitNotExists_thenReturnsFalse() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        when(this.fruitMyBatisMapper.exists(id)).thenReturn(false);

        final var result = this.fruitFindRepository.exists(id);

        // Then
        verify(this.fruitMyBatisMapper, times(1)).exists(id);

        assertThat(result).isFalse();
    }
}
