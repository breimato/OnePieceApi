package es.api.onepiece.adapters.inbound.rest.controller.character.transformation;

import es.api.onepiece.adapters.inbound.rest.mapper.character.TransformationDtoMapper;
import es.api.onepiece.core.internal.usecases.character.transformation.GetTransformationsUseCase;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.GetTransformationByIdV1Api;
import org.openapitools.model.GetTransformationByIdV1ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class GetTransformationByIdController.
 */
@RestController
@Validated
@RequiredArgsConstructor
public class GetTransformationByIdController implements GetTransformationByIdV1Api {

    /** The get transformations use case. */
    private final GetTransformationsUseCase getTransformationsUseCase;

    /** The transformation dto mapper. */
    private final TransformationDtoMapper transformationDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<GetTransformationByIdV1ResponseDto> getTransformationByIdV1(@NotNull final Integer id) {

        final var transformation = this.getTransformationsUseCase.findById(id);

        final var transformationDto = this.transformationDtoMapper.toTransformationDto(transformation);

        final var getTransformationByIdV1ResponseDto = GetTransformationByIdV1ResponseDto.builder()
                .transformation(transformationDto)
                .build();

        return new ResponseEntity<>(getTransformationByIdV1ResponseDto, HttpStatus.OK);
    }
}
