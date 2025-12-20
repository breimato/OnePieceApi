package es.api.onepiece.adapters.inbound.rest.controller.sword;

import es.api.onepiece.adapters.inbound.rest.mapper.sword.SwordDtoMapper;
import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.ports.inbound.sword.UpdateSwordPort;
import es.api.onepiece.core.internal.vo.sword.UpdateSwordVo;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.UpdateSwordRequestDto;
import org.openapitools.model.SwordDto;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class PatchSwordControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class PatchSwordControllerTest {

    /** The patch sword controller. */
    @InjectMocks
    PatchSwordController patchSwordController;

    /** The update sword port. */
    @Mock
    UpdateSwordPort updateSwordPort;

    /** The sword dto mapper. */
    @Mock
    SwordDtoMapper swordDtoMapper;

    /**
     * Test update sword v1 when valid request then returns ok response.
     */
    @Test
    void testUpdateSwordV1_whenValidRequest_thenReturnsOkResponse() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var updateSwordRequestDto = Instancio.create(UpdateSwordRequestDto.class);
        final var updateSwordVo = Instancio.create(UpdateSwordVo.class);
        final var sword = Instancio.create(Sword.class);
        final var swordDto = Instancio.create(SwordDto.class);

        // When
        when(this.swordDtoMapper.toUpdateSwordVo(id, updateSwordRequestDto)).thenReturn(updateSwordVo);
        when(this.updateSwordPort.execute(updateSwordVo)).thenReturn(sword);
        when(this.swordDtoMapper.toSwordDto(sword)).thenReturn(swordDto);

        final var response = this.patchSwordController.updateSwordV1(id, updateSwordRequestDto);

        // Then
        verify(this.swordDtoMapper, times(1)).toUpdateSwordVo(id, updateSwordRequestDto);
        verify(this.updateSwordPort, times(1)).execute(updateSwordVo);
        verify(this.swordDtoMapper, times(1)).toSwordDto(sword);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getSword()).isEqualTo(swordDto);
    }
}
