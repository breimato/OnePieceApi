package es.api.onepiece.adapters.inbound.rest.controller.character.attack;

import es.api.onepiece.adapters.inbound.rest.mapper.character.AttackDtoMapper;
import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.ports.inbound.character.attack.CreateAttackPort;
import es.api.onepiece.core.internal.vo.character.attack.CreateAttackVo;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.AttackDto;
import org.openapitools.model.CreateAttackRequestDto;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class PostAttackControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class PostAttackControllerTest {

    /** The post attack controller. */
    @InjectMocks
    PostAttackController postAttackController;

    /** The create attack port. */
    @Mock
    CreateAttackPort createAttackPort;

    /** The attack dto mapper. */
    @Mock
    AttackDtoMapper attackDtoMapper;

    /**
     * Test create attack v1 when valid request then returns created response.
     */
    @Test
    void testCreateAttackV1_whenValidRequest_thenReturnsCreatedResponse() {

        // Given
        final var createAttackRequestDto = Instancio.create(CreateAttackRequestDto.class);
        final var createAttackVo = Instancio.create(CreateAttackVo.class);
        final var attack = Instancio.create(Attack.class);
        final var attackDto = Instancio.create(AttackDto.class);

        // When
        when(this.attackDtoMapper.toCreateAttackVo(createAttackRequestDto)).thenReturn(createAttackVo);
        when(this.createAttackPort.execute(createAttackVo)).thenReturn(attack);
        when(this.attackDtoMapper.toAttackDto(attack)).thenReturn(attackDto);

        final var response = this.postAttackController.createAttackV1(createAttackRequestDto);

        // Then
        verify(this.attackDtoMapper, times(1)).toCreateAttackVo(createAttackRequestDto);
        verify(this.createAttackPort, times(1)).execute(createAttackVo);
        verify(this.attackDtoMapper, times(1)).toAttackDto(attack);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getAttack()).isEqualTo(attackDto);
    }
}
