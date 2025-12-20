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
 * The Class GetSwordControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class GetSwordControllerTest {

    /** The get sword controller. */
    @InjectMocks
    GetSwordController getSwordController;

    /** The get swords port. */
    @Mock
    GetSwordsPort getSwordsPort;

    /** The sword dto mapper. */
    @Mock
    SwordDtoMapper swordDtoMapper;

    /**
     * Test get swords v1 when called then returns ok response.
     */
    @Test
    void testGetSwordsV1_whenCalled_thenReturnsOkResponse() {

        // Given
        final var swords = Instancio.ofList(Sword.class).size(3).create();
        final var swordsDto = Instancio.ofList(SwordDto.class).size(3).create();

        // When
        when(this.getSwordsPort.findAll()).thenReturn(swords);
        when(this.swordDtoMapper.toSwordDtoList(swords)).thenReturn(swordsDto);

        final var response = this.getSwordController.getSwordsV1();

        // Then
        verify(this.getSwordsPort, times(1)).findAll();
        verify(this.swordDtoMapper, times(1)).toSwordDtoList(swords);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getSwords()).isEqualTo(swordsDto);
    }
}
