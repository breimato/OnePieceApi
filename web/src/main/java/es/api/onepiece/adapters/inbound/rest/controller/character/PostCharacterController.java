package es.api.onepiece.adapters.inbound.rest.controller.character;

import es.api.onepiece.adapters.inbound.rest.mapper.character.CharacterDtoMapper;
import es.api.onepiece.core.internal.usecases.character.CreateCharacterUseCase;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.CreateCharacterV1Api;
import org.openapitools.model.CreateCharacterRequestDto;
import org.openapitools.model.CreateCharacterV1ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

/**
 * The Class CreateCharacterController.
 */
@Validated
@RestController
@RequiredArgsConstructor
public class PostCharacterController implements CreateCharacterV1Api {

    /** The create character use case. */
    private final CreateCharacterUseCase createCharacterUseCase;

    /** The character dto mapper. */
    private final CharacterDtoMapper characterDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<CreateCharacterV1ResponseDto> createCharacterV1(
            @Valid final CreateCharacterRequestDto createCharacterRequestDto) {

        final var createCharacterVo = this.characterDtoMapper.toCreateCharacterVo(createCharacterRequestDto);

        final var createdCharacter = this.createCharacterUseCase.execute(createCharacterVo);

        final var characterDto = this.characterDtoMapper.toCharacterV1Dto(createdCharacter);

        final var createCharacterV1ResponseDto = CreateCharacterV1ResponseDto.builder()
                .character(characterDto)
                .build();

        return new ResponseEntity<>(createCharacterV1ResponseDto, HttpStatus.CREATED);
    }
}
