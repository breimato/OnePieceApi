package es.api.onepiece.adapters.inbound.rest.controller.character.transformation;

import es.api.onepiece.adapters.inbound.rest.mapper.character.TransformationDtoMapper;
import es.api.onepiece.core.internal.domain.character.Transformation;
import es.api.onepiece.core.internal.usecases.character.transformation.CreateTransformationUseCase;
import es.api.onepiece.core.internal.vo.character.transformation.CreateTransformationVo;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.CreateTransformationRequestDto;
import org.openapitools.model.TransformationDto;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class PostTransformationControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class PostTransformationControllerTest {

    /** The post transformation controller. */
    @InjectMocks
    PostTransformationController postTransformationController;

    /** The create transformation use case. */
    @Mock
    CreateTransformationUseCase createTransformationUseCase;

    /** The transformation dto mapper. */
    @Mock
    TransformationDtoMapper transformationDtoMapper;

    /**
     * Test create transformation v1 when valid request then returns created
     * response.
     */
    @Test
    void testCreateTransformationV1_whenValidRequest_thenReturnsCreatedResponse() {

        // Given
        final var createTransformationRequestDto = Instancio.create(CreateTransformationRequestDto.class);
        final var createTransformationVo = Instancio.create(CreateTransformationVo.class);
        final var transformation = Instancio.create(Transformation.class);
        final var transformationDto = Instancio.create(TransformationDto.class);

        // When
        when(this.transformationDtoMapper.toCreateTransformationVo(createTransformationRequestDto))
                .thenReturn(createTransformationVo);
        when(this.createTransformationUseCase.execute(createTransformationVo)).thenReturn(transformation);
        when(this.transformationDtoMapper.toTransformationDto(transformation)).thenReturn(transformationDto);

        final var response = this.postTransformationController.createTransformationV1(createTransformationRequestDto);

        // Then
        verify(this.transformationDtoMapper, times(1)).toCreateTransformationVo(createTransformationRequestDto);
        verify(this.createTransformationUseCase, times(1)).execute(createTransformationVo);
        verify(this.transformationDtoMapper, times(1)).toTransformationDto(transformation);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getTransformation()).isEqualTo(transformationDto);
    }
}
