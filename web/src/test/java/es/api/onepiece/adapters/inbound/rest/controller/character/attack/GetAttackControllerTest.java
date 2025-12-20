package es.api.onepiece.adapters.inbound.rest.controller.character.attack;

import es.api.onepiece.adapters.inbound.rest.mapper.character.AttackDtoMapper;
import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.ports.inbound.character.attack.GetAttacksPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.AttackDto;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class GetAttackControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class GetAttackControllerTest {

    /** The get attack controller. */
    @InjectMocks
    GetAttackController getAttackController;

    /** The get attacks port. */
    @Mock
    GetAttacksPort getAttacksPort;

    /** The attack dto mapper. */
    @Mock
    AttackDtoMapper attackDtoMapper;

    /**
     * Test get attacks v1 when called then returns all attacks.
     */
    @Test
    void testGetAttacksV1_whenCalled_thenReturnsAllAttacks() {

        // Given
        final var attacks = Instancio.ofList(Attack.class).size(3).create();
        final var attacksDto = Instancio.ofList(AttackDto.class).size(3).create();

        // When
        when(this.getAttacksPort.findAll()).thenReturn(attacks);
        when(this.attackDtoMapper.toAttackDtoList(attacks)).thenReturn(attacksDto);

        final var response = this.getAttackController.getAttacksV1();

        // Then
        verify(this.getAttacksPort, times(1)).findAll();
        verify(this.attackDtoMapper, times(1)).toAttackDtoList(attacks);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getAttacks()).isEqualTo(attacksDto);
    }
}
