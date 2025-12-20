package es.api.onepiece.adapters.inbound.rest.controller.fruit;

import es.api.onepiece.adapters.inbound.rest.mapper.fruit.FruitDtoMapper;
import es.api.onepiece.core.ports.inbound.fruit.UpdateFruitPort;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.UpdateFruitV1Api;
import org.openapitools.model.UpdateFruitRequestDto;
import org.openapitools.model.UpdateFruitV1ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class PatchFruitController.
 */
@Validated
@RestController
@RequiredArgsConstructor
public class PatchFruitController implements UpdateFruitV1Api {

    /** The update fruit port. */
    private final UpdateFruitPort updateFruitPort;

    /** The fruit dto mapper. */
    private final FruitDtoMapper fruitDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<UpdateFruitV1ResponseDto> updateFruitV1(
            @NotNull final Integer id,
            @Valid final UpdateFruitRequestDto updateFruitRequestDto) {

        final var updateFruitVo = this.fruitDtoMapper.toUpdateFruitVo(id, updateFruitRequestDto);

        final var updatedFruit = this.updateFruitPort.execute(updateFruitVo);

        final var fruitDto = this.fruitDtoMapper.toFruitDto(updatedFruit);

        final var updateFruitV1ResponseDto = UpdateFruitV1ResponseDto.builder()
                .fruit(fruitDto)
                .build();

        return ResponseEntity.ok(updateFruitV1ResponseDto);
    }
}
