package es.api.onepiece.adapters.inbound.rest.controller.character;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import es.api.onepiece.adapters.inbound.rest.mapper.character.CharacterDtoMapper;
import es.api.onepiece.core.internal.domain.character.CharacterSummary;
import es.api.onepiece.core.internal.usecases.character.GetCharactersUseCase;
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
import org.instancio.Instancio;

/**
 * The Class GetCharacterControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class GetCharacterControllerTest {

    /** The Constant URL. */
    static final String URL = "/api/v1/characters";

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
    void testGetCharacters_whenValidParams_thenReturnsOk() throws Exception {

        // Given
        final var characterSummaryList = Instancio.ofList(CharacterSummary.class).size(3).create();
        final var characterDtoList = Instancio.ofList(CharacterDto.class).size(3).create();

        // When
        when(this.getCharactersUseCase.findAll()).thenReturn(characterSummaryList);
        when(this.characterDtoMapper.toCharacterDtoList(characterSummaryList))
                .thenReturn(characterDtoList);

        final var response = this.mockMvc.perform(get(URL).accept(MediaType.APPLICATION_JSON));

        // Then
        verify(this.getCharactersUseCase, times(1)).findAll();
        verify(this.characterDtoMapper, times(1)).toCharacterDtoList(characterSummaryList);

        response
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
