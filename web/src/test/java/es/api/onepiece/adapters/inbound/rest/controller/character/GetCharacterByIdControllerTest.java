package es.api.onepiece.adapters.inbound.rest.controller.character;

import es.api.onepiece.adapters.inbound.rest.mapper.character.CharacterDtoMapper;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.usecases.character.GetCharactersUseCase;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.CharacterDto;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The Class GetCharacterControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class GetCharacterByIdControllerTest {

    /** The Constant URL. */
    static final String URL = "/api/v1/characters/{id}";

    /** The mock mvc. */
    MockMvc mockMvc;

    /** The get character controller. */
    @InjectMocks
    GetCharacterController getCharacterController;

    /** The get characters use case. */
    @Mock
    GetCharactersUseCase getCharactersUseCase;

    /** The character dto mapper. */
    @Mock
    CharacterDtoMapper characterDtoMapper;

    /**
     * Sets the up.
     */
    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.getCharacterController).build();
    }

    /**
     * Test get characters when valid params then returns ok.
     *
     * @throws Exception the exception
     */
    @Test
    void testGetCharactersById_whenValidParams_thenReturnsOk() throws Exception {

        // Given
        final var characterId = Instancio.create(Integer.class);
        final var character = Instancio.create(Character.class);
        final var characterDto = Instancio.create(CharacterDto.class);

        // When
        when(this.getCharactersUseCase.findById(characterId)).thenReturn(character);
        when(this.characterDtoMapper.toCharacterV1Dto(character))
                .thenReturn(characterDto);

        final var response = this.mockMvc.perform(get(URL).accept(MediaType.APPLICATION_JSON));

        // Then
        verify(this.getCharactersUseCase, times(1)).findById(characterId);
        verify(this.characterDtoMapper, times(1)).toCharacterV1Dto(character);

        response
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
