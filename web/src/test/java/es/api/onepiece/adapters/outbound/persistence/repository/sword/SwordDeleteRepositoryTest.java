package es.api.onepiece.adapters.outbound.persistence.repository.sword;

import es.api.onepiece.adapters.outbound.persistence.mybatis.sword.SwordMyBatisMapper;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * The Class SwordDeleteRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class SwordDeleteRepositoryTest {

    /** The sword delete repository. */
    @InjectMocks
    SwordDeleteRepository swordDeleteRepository;

    /** The sword my batis mapper. */
    @Mock
    SwordMyBatisMapper swordMyBatisMapper;

    /**
     * Test execute when called then deletes sword.
     */
    @Test
    void testExecute_whenCalled_thenDeletesSword() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        assertThatCode(() -> this.swordDeleteRepository.execute(id))
                .doesNotThrowAnyException();

        // Then
        verify(this.swordMyBatisMapper, times(1)).deleteCharacterSwordsBySwordId(id);
        verify(this.swordMyBatisMapper, times(1)).deleteSword(id);
    }
}
