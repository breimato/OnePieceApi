package es.api.onepiece.adapters.inbound.rest.controller.character.transformation;

import es.api.onepiece.adapters.inbound.rest.mapper.character.TransformationDtoMapper;
import es.api.onepiece.adapters.inbound.rest.controller.character.transformation.GetTransformationController;
import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.ports.inbound.character.transformation.GetTransformationsPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.TransformationDto;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class GetTransformationControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class GetTransformationControllerTest {

    /** The get transformation controller. */
    @InjectMocks
    GetTransformationController getTransformationController;

    /** The get transformations port. */
    @Mock
    GetTransformationsPort getTransformationsPort;

    /** The transformation dto mapper. */
    @Mock
    TransformationDtoMapper transformationDtoMapper;

    /**
     * Test get transformations v1 when called then returns ok response.
     */
    @Test
    void testGetTransformationsV1_whenCalled_thenReturnsOkResponse() {

        // Given
        final var transformations = Instancio.ofList(Transformation.class).size(3).create();
        final var transformationsDto = Instancio.ofList(TransformationDto.class).size(3).create();

        // When
        when(this.getTransformationsPort.findAll()).thenReturn(transformations);
        when(this.transformationDtoMapper.toTransformationDtoList(transformations)).thenReturn(transformationsDto);

        final var response = this.getTransformationController.getTransformationsV1();

        // Then
        verify(this.getTransformationsPort, times(1)).findAll();
        verify(this.transformationDtoMapper, times(1)).toTransformationDtoList(transformations);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTransformations()).isEqualTo(transformationsDto);
    }
}
