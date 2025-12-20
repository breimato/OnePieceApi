package es.api.onepiece.adapters.inbound.rest.controller.sword;

import es.api.onepiece.adapters.inbound.rest.mapper.sword.SwordDtoMapper;
import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.ports.inbound.sword.GetSwordsPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.SwordDto;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class GetSwordByIdControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class GetSwordByIdControllerTest {

    /** The get sword by id controller. */
    @InjectMocks
    GetSwordByIdController getSwordByIdController;

    /** The get swords port. */
    @Mock
    GetSwordsPort getSwordsPort;

    /** The sword dto mapper. */
    @Mock
    SwordDtoMapper swordDtoMapper;

    /**
     * Test get sword by id v1 when called then returns ok response.
     */
    @Test
    void testGetSwordByIdV1_whenCalled_thenReturnsOkResponse() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var sword = Instancio.create(Sword.class);
        final var swordDto = Instancio.create(SwordDto.class);

        // When
        when(this.getSwordsPort.findById(id)).thenReturn(sword);
        when(this.swordDtoMapper.toSwordDto(sword)).thenReturn(swordDto);

        final var response = this.getSwordByIdController.getSwordByIdV1(id);

        // Then
        verify(this.getSwordsPort, times(1)).findById(id);
        verify(this.swordDtoMapper, times(1)).toSwordDto(sword);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getSword()).isEqualTo(swordDto);
    }
}
