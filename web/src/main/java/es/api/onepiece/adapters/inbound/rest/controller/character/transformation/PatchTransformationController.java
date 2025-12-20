package es.api.onepiece.adapters.inbound.rest.controller.character.transformation;

import es.api.onepiece.adapters.inbound.rest.mapper.character.TransformationDtoMapper;
import es.api.onepiece.core.internal.usecases.character.transformation.UpdateTransformationUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.UpdateTransformationV1Api;
import org.openapitools.model.UpdateTransformationRequestDto;
import org.openapitools.model.UpdateTransformationV1ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class PatchTransformationController.
 */
@Validated
@RestController
@RequiredArgsConstructor
public class PatchTransformationController implements UpdateTransformationV1Api {

        /** The update transformation use case. */
        private final UpdateTransformationUseCase updateTransformationUseCase;

        /** The transformation dto mapper. */
        private final TransformationDtoMapper transformationDtoMapper;

        /**
         * {@inheritDoc}
         */
        @Override
        public ResponseEntity<UpdateTransformationV1ResponseDto> updateTransformationV1(
                        @NotNull final Integer id,
                        @Valid final UpdateTransformationRequestDto updateTransformationRequestDto) {

                final var updateTransformationVo = this.transformationDtoMapper.toUpdateTransformationVo(id,
                                updateTransformationRequestDto);

                final var updatedTransformation = this.updateTransformationUseCase.execute(updateTransformationVo);

                final var transformationDto = this.transformationDtoMapper.toTransformationDto(updatedTransformation);

                final var updateTransformationV1ResponseDto = UpdateTransformationV1ResponseDto.builder()
                                .transformation(transformationDto)
                                .build();

                return ResponseEntity.ok(updateTransformationV1ResponseDto);
        }
}
