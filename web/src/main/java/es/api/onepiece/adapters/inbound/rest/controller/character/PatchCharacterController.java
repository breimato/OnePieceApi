package es.api.onepiece.adapters.inbound.rest.controller.character;

import es.api.onepiece.adapters.inbound.rest.mapper.character.CharacterDtoMapper;
import es.api.onepiece.core.internal.usecases.character.UpdateCharacterUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.UpdateCharacterV1Api;
import org.openapitools.model.UpdateCharacterRequestDto;
import org.openapitools.model.UpdateCharacterV1ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class PatchCharacterController.
 */
@Validated
@RestController
@RequiredArgsConstructor
public class PatchCharacterController implements UpdateCharacterV1Api {

    /** The update character use case. */
    private final UpdateCharacterUseCase updateCharacterUseCase;

    /** The character dto mapper. */
    private final CharacterDtoMapper characterDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<UpdateCharacterV1ResponseDto> updateCharacterV1(
            @NotNull final Integer id,
            @Valid final UpdateCharacterRequestDto updateCharacterRequestDto) {

        final var updateCharacterVo = this.characterDtoMapper.toUpdateCharacterVo(id, updateCharacterRequestDto);

        final var updatedCharacter = this.updateCharacterUseCase.execute(updateCharacterVo);

        final var characterDto = this.characterDtoMapper.toCharacterDto(updatedCharacter);

        final var updateCharacterV1ResponseDto = UpdateCharacterV1ResponseDto.builder()
                .character(characterDto)
                .build();

        return ResponseEntity.ok(updateCharacterV1ResponseDto);
    }
}
