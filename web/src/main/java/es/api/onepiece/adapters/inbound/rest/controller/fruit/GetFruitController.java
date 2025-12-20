package es.api.onepiece.adapters.inbound.rest.controller.fruit;

import es.api.onepiece.adapters.inbound.rest.mapper.fruit.FruitDtoMapper;
import es.api.onepiece.core.ports.inbound.fruit.GetFruitsPort;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.GetFruitsV1Api;
import org.openapitools.model.GetFruitsV1ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class GetFruitController.
 */
@RestController
@Validated
@RequiredArgsConstructor
public class GetFruitController implements GetFruitsV1Api {

    /** The get fruits port. */
    private final GetFruitsPort getFruitsPort;

    /** The fruit dto mapper. */
    private final FruitDtoMapper fruitDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<GetFruitsV1ResponseDto> getFruitsV1() {

        final var fruits = this.getFruitsPort.findAll();

        final var fruitsDto = this.fruitDtoMapper.toFruitDtoList(fruits);

        final var getFruitsV1ResponseDto = GetFruitsV1ResponseDto.builder()
                .fruits(fruitsDto)
                .build();

        return new ResponseEntity<>(getFruitsV1ResponseDto, HttpStatus.OK);
    }
}
