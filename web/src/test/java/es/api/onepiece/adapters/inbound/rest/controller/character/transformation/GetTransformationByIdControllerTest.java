package es.api.onepiece.adapters.inbound.rest.controller.character.transformation;

import es.api.onepiece.adapters.inbound.rest.mapper.character.TransformationDtoMapper;
import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.ports.inbound.character.transformation.GetTransformationsPort;
import es.api.onepiece.adapters.inbound.rest.controller.character.transformation.GetTransformationByIdController;
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
 * The Class GetTransformationByIdControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class GetTransformationByIdControllerTest {

    /** The get transformation by id controller. */
    @InjectMocks
    GetTransformationByIdController getTransformationByIdController;

    /** The get transformations port. */
    @Mock
    GetTransformationsPort getTransformationsPort;

    /** The transformation dto mapper. */
    @Mock
    TransformationDtoMapper transformationDtoMapper;

    /**
     * Test get transformation by id v1 when valid id then returns ok response.
     */
    @Test
    void testGetTransformationByIdV1_whenValidId_thenReturnsOkResponse() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var transformation = Instancio.create(Transformation.class);
        final var transformationDto = Instancio.create(TransformationDto.class);

        // When
        when(this.getTransformationsPort.findById(id)).thenReturn(transformation);
        when(this.transformationDtoMapper.toTransformationDto(transformation)).thenReturn(transformationDto);

        final var response = this.getTransformationByIdController.getTransformationByIdV1(id);

        // Then
        verify(this.getTransformationsPort, times(1)).findById(id);
        verify(this.transformationDtoMapper, times(1)).toTransformationDto(transformation);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTransformation()).isEqualTo(transformationDto);
    }
}
