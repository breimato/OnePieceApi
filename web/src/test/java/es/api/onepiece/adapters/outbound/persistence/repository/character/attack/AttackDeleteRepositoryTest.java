package es.api.onepiece.adapters.outbound.persistence.repository.character.attack;

import es.api.onepiece.adapters.outbound.persistence.mybatis.character.AttackMyBatisMapper;
import es.api.onepiece.adapters.outbound.persistence.repository.character.attack.AttackDeleteRepository;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

/**
 * The Class AttackDeleteRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class AttackDeleteRepositoryTest {

    /** The attack delete repository. */
    @InjectMocks
    AttackDeleteRepository attackDeleteRepository;

    /** The attack my batis mapper. */
    @Mock
    AttackMyBatisMapper attackMyBatisMapper;

    /**
     * Test execute when called then deletes attack.
     */
    @Test
    void testExecute_whenCalled_thenDeletesAttack() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        doNothing().when(this.attackMyBatisMapper).deleteAttack(id);

        this.attackDeleteRepository.execute(id);

        // Then
        verify(this.attackMyBatisMapper, times(1)).deleteAttack(id);
    }
}
