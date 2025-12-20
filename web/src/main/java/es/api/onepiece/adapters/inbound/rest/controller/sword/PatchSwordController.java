package es.api.onepiece.adapters.inbound.rest.controller.sword;

import es.api.onepiece.adapters.inbound.rest.mapper.sword.SwordDtoMapper;
import es.api.onepiece.core.internal.usecases.sword.UpdateSwordUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.UpdateSwordV1Api;
import org.openapitools.model.UpdateSwordRequestDto;
import org.openapitools.model.UpdateSwordV1ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class PatchSwordController.
 */
@Validated
@RestController
@RequiredArgsConstructor
public class PatchSwordController implements UpdateSwordV1Api {

    /** The update sword use case. */
    private final UpdateSwordUseCase updateSwordUseCase;

    /** The sword dto mapper. */
    private final SwordDtoMapper swordDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<UpdateSwordV1ResponseDto> updateSwordV1(
            @NotNull final Integer id,
            @Valid final UpdateSwordRequestDto updateSwordRequestDto) {

        final var updateSwordVo = this.swordDtoMapper.toUpdateSwordVo(id, updateSwordRequestDto);

        final var updatedSword = this.updateSwordUseCase.execute(updateSwordVo);

        final var swordDto = this.swordDtoMapper.toSwordDto(updatedSword);

        final var updateSwordV1ResponseDto = UpdateSwordV1ResponseDto.builder()
                .sword(swordDto)
                .build();

        return ResponseEntity.ok(updateSwordV1ResponseDto);
    }
}
