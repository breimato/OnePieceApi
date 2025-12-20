package es.api.onepiece.adapters.inbound.rest.controller.character.attack;

import es.api.onepiece.adapters.inbound.rest.mapper.character.AttackDtoMapper;
import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.usecases.character.attack.GetAttacksUseCase;
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
 * The Class GetAttackByIdControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class GetAttackByIdControllerTest {

    /** The get attack by id controller. */
    @InjectMocks
    GetAttackByIdController getAttackByIdController;

    /** The get attacks use case. */
    @Mock
    GetAttacksUseCase getAttacksUseCase;

    /** The attack dto mapper. */
    @Mock
    AttackDtoMapper attackDtoMapper;

    /**
     * Test get attack by id v1 when attack exists then returns attack.
     */
    @Test
    void testGetAttackByIdV1_whenAttackExists_thenReturnsAttack() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var attack = Instancio.create(Attack.class);
        final var attackDto = Instancio.create(AttackDto.class);

        // When
        when(this.getAttacksUseCase.findById(id)).thenReturn(attack);
        when(this.attackDtoMapper.toAttackDto(attack)).thenReturn(attackDto);

        final var response = this.getAttackByIdController.getAttackByIdV1(id);

        // Then
        verify(this.getAttacksUseCase, times(1)).findById(id);
        verify(this.attackDtoMapper, times(1)).toAttackDto(attack);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getAttack()).isEqualTo(attackDto);
    }
}
