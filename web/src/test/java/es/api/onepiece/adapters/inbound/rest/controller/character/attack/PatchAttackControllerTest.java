package es.api.onepiece.adapters.inbound.rest.controller.character.attack;

import es.api.onepiece.adapters.inbound.rest.mapper.character.AttackDtoMapper;
import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.ports.inbound.character.attack.UpdateAttackPort;
import es.api.onepiece.core.internal.vo.character.attack.UpdateAttackVo;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.AttackDto;
import org.openapitools.model.UpdateAttackRequestDto;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class PatchAttackControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class PatchAttackControllerTest {

    /** The patch attack controller. */
    @InjectMocks
    PatchAttackController patchAttackController;

    /** The update attack port. */
    @Mock
    UpdateAttackPort updateAttackPort;

    /** The attack dto mapper. */
    @Mock
    AttackDtoMapper attackDtoMapper;

    /**
     * Test update attack v1 when valid request then returns updated attack.
     */
    @Test
    void testUpdateAttackV1_whenValidRequest_thenReturnsUpdatedAttack() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var updateAttackRequestDto = Instancio.create(UpdateAttackRequestDto.class);
        final var updateAttackVo = Instancio.create(UpdateAttackVo.class);
        final var attack = Instancio.create(Attack.class);
        final var attackDto = Instancio.create(AttackDto.class);

        // When
        when(this.attackDtoMapper.toUpdateAttackVo(id, updateAttackRequestDto)).thenReturn(updateAttackVo);
        when(this.updateAttackPort.execute(updateAttackVo)).thenReturn(attack);
        when(this.attackDtoMapper.toAttackDto(attack)).thenReturn(attackDto);

        final var response = this.patchAttackController.updateAttackV1(id, updateAttackRequestDto);

        // Then
        verify(this.attackDtoMapper, times(1)).toUpdateAttackVo(id, updateAttackRequestDto);
        verify(this.updateAttackPort, times(1)).execute(updateAttackVo);
        verify(this.attackDtoMapper, times(1)).toAttackDto(attack);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getAttack()).isEqualTo(attackDto);
    }
}
