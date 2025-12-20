package es.api.onepiece.adapters.inbound.rest.controller.character.transformation;

import es.api.onepiece.adapters.inbound.rest.mapper.character.TransformationDtoMapper;
import es.api.onepiece.core.ports.inbound.character.transformation.CreateTransformationPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.CreateTransformationV1Api;
import org.openapitools.model.CreateTransformationRequestDto;
import org.openapitools.model.CreateTransformationV1ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class PostTransformationController.
 */
@Validated
@RestController
@RequiredArgsConstructor
public class PostTransformationController implements CreateTransformationV1Api {

        /** The create transformation use case. */
        private final CreateTransformationPort createTransformationPort;

        /** The transformation dto mapper. */
        private final TransformationDtoMapper transformationDtoMapper;

        /**
         * {@inheritDoc}
         */
        @Override
        public ResponseEntity<CreateTransformationV1ResponseDto> createTransformationV1(
                        @Valid final CreateTransformationRequestDto createTransformationRequestDto) {

                final var createTransformationVo = this.transformationDtoMapper
                                .toCreateTransformationVo(createTransformationRequestDto);

                final var createdTransformation = this.createTransformationPort.execute(createTransformationVo);

                final var transformationDto = this.transformationDtoMapper.toTransformationDto(createdTransformation);

                final var createTransformationV1ResponseDto = CreateTransformationV1ResponseDto.builder()
                                .transformation(transformationDto)
                                .build();

                return new ResponseEntity<>(createTransformationV1ResponseDto, HttpStatus.CREATED);
        }
}
