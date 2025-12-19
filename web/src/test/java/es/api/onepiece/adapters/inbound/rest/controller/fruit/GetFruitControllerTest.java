package es.api.onepiece.adapters.inbound.rest.controller.fruit;

import es.api.onepiece.adapters.inbound.rest.mapper.fruit.FruitDtoMapper;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.usecases.fruit.GetFruitsUseCase;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.FruitDto;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class GetFruitControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class GetFruitControllerTest {

    /** The get fruit controller. */
    @InjectMocks
    GetFruitController getFruitController;

    /** The get fruits use case. */
    @Mock
    GetFruitsUseCase getFruitsUseCase;

    /** The fruit dto mapper. */
    @Mock
    FruitDtoMapper fruitDtoMapper;

    /**
     * Test get fruits v1 when called then returns ok response.
     */
    @Test
    void testGetFruitsV1_whenCalled_thenReturnsOkResponse() {

        // Given
        final var fruits = Instancio.ofList(Fruit.class).size(3).create();
        final var fruitsDto = Instancio.ofList(FruitDto.class).size(3).create();

        // When
        when(this.getFruitsUseCase.findAll()).thenReturn(fruits);
        when(this.fruitDtoMapper.toFruitDtoList(fruits)).thenReturn(fruitsDto);

        final var response = this.getFruitController.getFruitsV1();

        // Then
        verify(this.getFruitsUseCase, times(1)).findAll();
        verify(this.fruitDtoMapper, times(1)).toFruitDtoList(fruits);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getFruits()).isEqualTo(fruitsDto);
    }
}
