package es.api.onepiece.core.internal.usecases.character.attack;

import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.usecases.character.attack.GetAttacksUseCase;
import es.api.onepiece.core.ports.outbound.character.attack.FindAttacksPersistencePort;
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
 * The Class GetAttacksUseCaseTest.
 */
@ExtendWith(MockitoExtension.class)
class GetAttacksUseCaseTest {

    /** The get attacks use case. */
    @InjectMocks
    GetAttacksUseCase getAttacksUseCase;

    /** The find attacks persistence port. */
    @Mock
    FindAttacksPersistencePort findAttacksPersistencePort;

    /**
     * Test find all when called then returns all attacks.
     */
    @Test
    void testFindAll_whenCalled_thenReturnsAllAttacks() {

        // Given
        final var attacks = Instancio.ofList(Attack.class).size(3).create();

        // When
        when(this.findAttacksPersistencePort.findAll()).thenReturn(attacks);

        final var result = this.getAttacksUseCase.findAll();

        // Then
        verify(this.findAttacksPersistencePort, times(1)).findAll();

        assertThat(result).isEqualTo(attacks);
    }

    /**
     * Test find by id when attack exists then returns attack.
     */
    @Test
    void testFindById_whenAttackExists_thenReturnsAttack() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var attack = Instancio.create(Attack.class);

        // When
        when(this.findAttacksPersistencePort.findById(id)).thenReturn(attack);

        final var result = this.getAttacksUseCase.findById(id);

        // Then
        verify(this.findAttacksPersistencePort, times(1)).findById(id);

        assertThat(result).isEqualTo(attack);
    }
}
