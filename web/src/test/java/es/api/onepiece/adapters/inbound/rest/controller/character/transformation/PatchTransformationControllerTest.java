package es.api.onepiece.adapters.inbound.rest.controller.character.transformation;

import es.api.onepiece.adapters.inbound.rest.mapper.character.TransformationDtoMapper;
import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.internal.usecases.character.transformation.UpdateTransformationUseCase;
import es.api.onepiece.core.internal.vo.character.transformation.UpdateTransformationVo;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.TransformationDto;
import org.openapitools.model.UpdateTransformationRequestDto;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class PatchTransformationControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class PatchTransformationControllerTest {

    /** The patch transformation controller. */
    @InjectMocks
    PatchTransformationController patchTransformationController;

    /** The update transformation use case. */
    @Mock
    UpdateTransformationUseCase updateTransformationUseCase;

    /** The transformation dto mapper. */
    @Mock
    TransformationDtoMapper transformationDtoMapper;

    /**
     * Test update transformation v1 when valid request then returns ok response.
     */
    @Test
    void testUpdateTransformationV1_whenValidRequest_thenReturnsOkResponse() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var updateTransformationRequestDto = Instancio.create(UpdateTransformationRequestDto.class);
        final var updateTransformationVo = Instancio.create(UpdateTransformationVo.class);
        final var transformation = Instancio.create(Transformation.class);
        final var transformationDto = Instancio.create(TransformationDto.class);

        // When
        when(this.transformationDtoMapper.toUpdateTransformationVo(id, updateTransformationRequestDto))
                .thenReturn(updateTransformationVo);
        when(this.updateTransformationUseCase.execute(updateTransformationVo)).thenReturn(transformation);
        when(this.transformationDtoMapper.toTransformationDto(transformation)).thenReturn(transformationDto);

        final var response = this.patchTransformationController.updateTransformationV1(id,
                updateTransformationRequestDto);

        // Then
        verify(this.transformationDtoMapper, times(1)).toUpdateTransformationVo(id, updateTransformationRequestDto);
        verify(this.updateTransformationUseCase, times(1)).execute(updateTransformationVo);
        verify(this.transformationDtoMapper, times(1)).toTransformationDto(transformation);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTransformation()).isEqualTo(transformationDto);
    }
}
