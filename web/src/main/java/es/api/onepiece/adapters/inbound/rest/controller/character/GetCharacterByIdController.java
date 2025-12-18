package es.api.onepiece.adapters.inbound.rest.controller.character;

import es.api.onepiece.adapters.inbound.rest.mapper.character.CharacterDtoMapper;
import es.api.onepiece.core.internal.usecases.character.GetCharactersUseCase;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.GetCharacterByIdV1Api;
import org.openapitools.model.GetCharacterByIdV1ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class GetCharacterByIdController.
 */
@RestController
@Validated
@RequiredArgsConstructor
public class GetCharacterByIdController implements GetCharacterByIdV1Api {

    /** The get characters use case. */
    private final GetCharactersUseCase getCharactersUseCase;

    /** The character dto mapper. */
    private final CharacterDtoMapper characterDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<GetCharacterByIdV1ResponseDto> getCharacterByIdV1(final Integer id) {

        final var character = this.getCharactersUseCase.findById(id);

        final var characterDto = this.characterDtoMapper.toCharacterDto(character);

        final var getCharacterByIdV1ResponseDto = GetCharacterByIdV1ResponseDto.builder()
                .character(characterDto)
                .build();

        return new ResponseEntity<>(getCharacterByIdV1ResponseDto, HttpStatus.OK);
    }
}
