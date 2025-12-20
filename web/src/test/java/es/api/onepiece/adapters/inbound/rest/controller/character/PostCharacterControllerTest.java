package es.api.onepiece.adapters.inbound.rest.controller.character;

import es.api.onepiece.adapters.inbound.rest.mapper.character.CharacterDtoMapper;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.usecases.character.CreateCharacterUseCase;
import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.CharacterDto;
import org.openapitools.model.CreateCharacterRequestDto;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class PostCharacterControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class PostCharacterControllerTest {

    /** The post character controller. */
    @InjectMocks
    PostCharacterController postCharacterController;

    /** The create character use case. */
    @Mock
    CreateCharacterUseCase createCharacterUseCase;

    /** The character dto mapper. */
    @Mock
    CharacterDtoMapper characterDtoMapper;

    /**
     * Test create character v1 when valid request then returns created response.
     */
    @Test
    void testCreateCharacterV1_whenValidRequest_thenReturnsCreatedResponse() {

        // Given
        final var createCharacterRequestDto = Instancio.create(CreateCharacterRequestDto.class);
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);
        final var character = Instancio.create(Character.class);
        final var characterDto = Instancio.create(CharacterDto.class);

        // When
        when(this.characterDtoMapper.toCreateCharacterVo(createCharacterRequestDto)).thenReturn(createCharacterVo);
        when(this.createCharacterUseCase.execute(createCharacterVo)).thenReturn(character);
        when(this.characterDtoMapper.toCharacterDto(character)).thenReturn(characterDto);

        final var response = this.postCharacterController.createCharacterV1(createCharacterRequestDto);

        // Then
        verify(this.characterDtoMapper, times(1)).toCreateCharacterVo(createCharacterRequestDto);
        verify(this.createCharacterUseCase, times(1)).execute(createCharacterVo);
        verify(this.characterDtoMapper, times(1)).toCharacterDto(character);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getCharacter()).isEqualTo(characterDto);

    }
}
