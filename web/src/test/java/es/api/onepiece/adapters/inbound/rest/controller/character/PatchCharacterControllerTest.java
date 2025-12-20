package es.api.onepiece.adapters.inbound.rest.controller.character;

import es.api.onepiece.adapters.inbound.rest.mapper.character.CharacterDtoMapper;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.ports.inbound.character.UpdateCharacterPort;
import es.api.onepiece.core.internal.vo.character.UpdateCharacterVo;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.CharacterDto;
import org.openapitools.model.UpdateCharacterRequestDto;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class PatchCharacterControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class PatchCharacterControllerTest {

    /** The patch character controller. */
    @InjectMocks
    PatchCharacterController patchCharacterController;

    /** The update character port. */
    @Mock
    UpdateCharacterPort updateCharacterPort;

    /** The character dto mapper. */
    @Mock
    CharacterDtoMapper characterDtoMapper;

    /**
     * Test update character v1 when valid request then returns ok response.
     */
    @Test
    void testUpdateCharacterV1_whenValidRequest_thenReturnsOkResponse() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var updateCharacterRequestDto = Instancio.create(UpdateCharacterRequestDto.class);
        final var updateCharacterVo = Instancio.create(UpdateCharacterVo.class);
        final var character = Instancio.create(Character.class);
        final var characterDto = Instancio.create(CharacterDto.class);

        // When
        when(this.characterDtoMapper.toUpdateCharacterVo(id, updateCharacterRequestDto)).thenReturn(updateCharacterVo);
        when(this.updateCharacterPort.execute(updateCharacterVo)).thenReturn(character);
        when(this.characterDtoMapper.toCharacterDto(character)).thenReturn(characterDto);

        final var response = this.patchCharacterController.updateCharacterV1(id, updateCharacterRequestDto);

        // Then
        verify(this.characterDtoMapper, times(1)).toUpdateCharacterVo(id, updateCharacterRequestDto);
        verify(this.updateCharacterPort, times(1)).execute(updateCharacterVo);
        verify(this.characterDtoMapper, times(1)).toCharacterDto(character);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getCharacter()).isEqualTo(characterDto);
    }
}
