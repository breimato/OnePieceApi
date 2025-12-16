package es.api.onepiece.adapters.inbound.rest.controller.character;

import es.api.onepiece.adapters.inbound.rest.mapper.character.CharacterDtoMapper;
import es.api.onepiece.core.internal.usecases.character.GetCharactersUseCase;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.GetCharactersV1Api;
import org.openapitools.model.GetCharactersV1ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class GetCharacterController.
 */
@RestController
@Validated
@RequiredArgsConstructor
public class GetCharacterController implements GetCharactersV1Api {

    /** The get characters use case. */
    private final GetCharactersUseCase getCharactersUseCase;

    /** The character dto mapper. */
    private final CharacterDtoMapper characterDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<GetCharactersV1ResponseDto> getCharactersV1() {

        final var characters = this.getCharactersUseCase.findAll();

        final var charactersDto = this.characterDtoMapper.toCharacterDtoList(characters);

        final var getCharactersV1ResponseDto = GetCharactersV1ResponseDto.builder().characters(charactersDto).build();

        return new ResponseEntity<>(getCharactersV1ResponseDto, HttpStatus.OK);
    }
}
