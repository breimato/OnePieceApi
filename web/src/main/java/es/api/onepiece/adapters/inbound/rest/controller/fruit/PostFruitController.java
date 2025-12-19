package es.api.onepiece.adapters.inbound.rest.controller.fruit;

import es.api.onepiece.adapters.inbound.rest.mapper.fruit.FruitDtoMapper;
import es.api.onepiece.core.internal.usecases.fruit.CreateFruitUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.CreateFruitV1Api;
import org.openapitools.model.CreateFruitRequestDto;
import org.openapitools.model.CreateFruitV1ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class PostFruitController.
 */
@Validated
@RestController
@RequiredArgsConstructor
public class PostFruitController implements CreateFruitV1Api {

    /** The create fruit use case. */
    private final CreateFruitUseCase createFruitUseCase;

    /** The fruit dto mapper. */
    private final FruitDtoMapper fruitDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<CreateFruitV1ResponseDto> createFruitV1(
            @Valid final CreateFruitRequestDto createFruitRequestDto) {

        final var createFruitVo = this.fruitDtoMapper.toCreateFruitVo(createFruitRequestDto);

        final var createdFruit = this.createFruitUseCase.execute(createFruitVo);

        final var fruitDto = this.fruitDtoMapper.toFruitDto(createdFruit);

        final var createFruitV1ResponseDto = CreateFruitV1ResponseDto.builder()
                .fruit(fruitDto)
                .build();

        return new ResponseEntity<>(createFruitV1ResponseDto, HttpStatus.CREATED);
    }
}
