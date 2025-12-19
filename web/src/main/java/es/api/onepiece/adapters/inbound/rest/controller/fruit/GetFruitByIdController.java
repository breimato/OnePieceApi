package es.api.onepiece.adapters.inbound.rest.controller.fruit;

import es.api.onepiece.adapters.inbound.rest.mapper.fruit.FruitDtoMapper;
import es.api.onepiece.core.internal.usecases.fruit.GetFruitsUseCase;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.GetFruitByIdV1Api;
import org.openapitools.model.GetFruitByIdV1ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class GetFruitByIdController.
 */
@RestController
@Validated
@RequiredArgsConstructor
public class GetFruitByIdController implements GetFruitByIdV1Api {

    /** The get fruits use case. */
    private final GetFruitsUseCase getFruitsUseCase;

    /** The fruit dto mapper. */
    private final FruitDtoMapper fruitDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<GetFruitByIdV1ResponseDto> getFruitByIdV1(@NotNull final Integer id) {

        final var fruit = this.getFruitsUseCase.findById(id);

        final var fruitDto = this.fruitDtoMapper.toFruitDto(fruit);

        final var getFruitByIdV1ResponseDto = GetFruitByIdV1ResponseDto.builder()
                .fruit(fruitDto)
                .build();

        return new ResponseEntity<>(getFruitByIdV1ResponseDto, HttpStatus.OK);
    }
}
