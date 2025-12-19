package es.api.onepiece.adapters.outbound.persistence.repository.fruit;

import es.api.onepiece.adapters.outbound.persistence.mybatis.fruit.FruitMyBatisMapper;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * The Class FruitDeleteRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class FruitDeleteRepositoryTest {

    /** The fruit delete repository. */
    @InjectMocks
    FruitDeleteRepository fruitDeleteRepository;

    /** The fruit my batis mapper. */
    @Mock
    FruitMyBatisMapper fruitMyBatisMapper;


    /**
     * Test execute when called then deletes fruit and character fruit relations.
     */
    @Test
    void testExecute_whenCalled_thenDeletesFruitAndCharacterFruitRelations() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        this.fruitDeleteRepository.execute(id);

        // Then
        verify(this.fruitMyBatisMapper, times(1)).deleteCharacterFruitsByFruitId(id);
        verify(this.fruitMyBatisMapper, times(1)).deleteFruit(id);
    }
}
