package es.api.onepiece.adapters.inbound.rest.controller.fruit;

import es.api.onepiece.adapters.inbound.rest.mapper.fruit.FruitDtoMapper;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.usecases.fruit.UpdateFruitUseCase;
import es.api.onepiece.core.internal.vo.fruit.UpdateFruitVo;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.FruitDto;
import org.openapitools.model.UpdateFruitRequestDto;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class PatchFruitControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class PatchFruitControllerTest {

    /** The patch fruit controller. */
    @InjectMocks
    PatchFruitController patchFruitController;

    /** The update fruit use case. */
    @Mock
    UpdateFruitUseCase updateFruitUseCase;

    /** The fruit dto mapper. */
    @Mock
    FruitDtoMapper fruitDtoMapper;

    /**
     * Test update fruit v1 when valid request then returns ok response.
     */
    @Test
    void testUpdateFruitV1_whenValidRequest_thenReturnsOkResponse() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var updateFruitRequestDto = Instancio.create(UpdateFruitRequestDto.class);
        final var updateFruitVo = Instancio.create(UpdateFruitVo.class);
        final var fruit = Instancio.create(Fruit.class);
        final var fruitDto = Instancio.create(FruitDto.class);

        // When
        when(this.fruitDtoMapper.toUpdateFruitVo(id, updateFruitRequestDto)).thenReturn(updateFruitVo);
        when(this.updateFruitUseCase.execute(updateFruitVo)).thenReturn(fruit);
        when(this.fruitDtoMapper.toFruitDto(fruit)).thenReturn(fruitDto);

        final var response = this.patchFruitController.updateFruitV1(id, updateFruitRequestDto);

        // Then
        verify(this.fruitDtoMapper, times(1)).toUpdateFruitVo(id, updateFruitRequestDto);
        verify(this.updateFruitUseCase, times(1)).execute(updateFruitVo);
        verify(this.fruitDtoMapper, times(1)).toFruitDto(fruit);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getFruit()).isEqualTo(fruitDto);
    }
}
