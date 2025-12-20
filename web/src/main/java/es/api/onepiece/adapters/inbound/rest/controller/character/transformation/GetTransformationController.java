package es.api.onepiece.adapters.inbound.rest.controller.character.transformation;

import es.api.onepiece.adapters.inbound.rest.mapper.character.TransformationDtoMapper;
import es.api.onepiece.core.internal.usecases.character.transformation.GetTransformationsUseCase;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.GetTransformationsV1Api;
import org.openapitools.model.GetTransformationsV1ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class GetTransformationController.
 */
@RestController
@Validated
@RequiredArgsConstructor
public class GetTransformationController implements GetTransformationsV1Api {

    /** The get transformations use case. */
    private final GetTransformationsUseCase getTransformationsUseCase;

    /** The transformation dto mapper. */
    private final TransformationDtoMapper transformationDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<GetTransformationsV1ResponseDto> getTransformationsV1() {

        final var transformations = this.getTransformationsUseCase.findAll();

        final var transformationsDto = this.transformationDtoMapper.toTransformationDtoList(transformations);

        final var getTransformationsV1ResponseDto = GetTransformationsV1ResponseDto.builder()
                .transformations(transformationsDto)
                .build();

        return new ResponseEntity<>(getTransformationsV1ResponseDto, HttpStatus.OK);
    }
}
