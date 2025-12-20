package es.api.onepiece.adapters.inbound.rest.controller.sword;

import es.api.onepiece.adapters.inbound.rest.mapper.sword.SwordDtoMapper;
import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.ports.inbound.sword.CreateSwordPort;
import es.api.onepiece.core.internal.vo.sword.CreateSwordVo;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.CreateSwordRequestDto;
import org.openapitools.model.SwordDto;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class PostSwordControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class PostSwordControllerTest {

    /** The post sword controller. */
    @InjectMocks
    PostSwordController postSwordController;

    /** The create sword port. */
    @Mock
    CreateSwordPort createSwordPort;

    /** The sword dto mapper. */
    @Mock
    SwordDtoMapper swordDtoMapper;

    /**
     * Test create sword v1 when valid request then returns created response.
     */
    @Test
    void testCreateSwordV1_whenValidRequest_thenReturnsCreatedResponse() {

        // Given
        final var createSwordRequestDto = Instancio.create(CreateSwordRequestDto.class);
        final var createSwordVo = Instancio.create(CreateSwordVo.class);
        final var sword = Instancio.create(Sword.class);
        final var swordDto = Instancio.create(SwordDto.class);

        // When
        when(this.swordDtoMapper.toCreateSwordVo(createSwordRequestDto)).thenReturn(createSwordVo);
        when(this.createSwordPort.execute(createSwordVo)).thenReturn(sword);
        when(this.swordDtoMapper.toSwordDto(sword)).thenReturn(swordDto);

        final var response = this.postSwordController.createSwordV1(createSwordRequestDto);

        // Then
        verify(this.swordDtoMapper, times(1)).toCreateSwordVo(createSwordRequestDto);
        verify(this.createSwordPort, times(1)).execute(createSwordVo);
        verify(this.swordDtoMapper, times(1)).toSwordDto(sword);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getSword()).isEqualTo(swordDto);
    }
}
