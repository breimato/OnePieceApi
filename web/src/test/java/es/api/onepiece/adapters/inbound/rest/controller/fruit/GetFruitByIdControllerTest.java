package es.api.onepiece.adapters.inbound.rest.controller.fruit;

import es.api.onepiece.adapters.inbound.rest.mapper.fruit.FruitDtoMapper;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.ports.inbound.fruit.GetFruitsPort;
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
 * The Class GetFruitByIdControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class GetFruitByIdControllerTest {

    /** The get fruit by id controller. */
    @InjectMocks
    GetFruitByIdController getFruitByIdController;

    /** The get fruits port. */
    @Mock
    GetFruitsPort getFruitsPort;

    /** The fruit dto mapper. */
    @Mock
    FruitDtoMapper fruitDtoMapper;

    /**
     * Test get fruit by id v1 when valid id then returns ok response.
     */
    @Test
    void testGetFruitByIdV1_whenValidId_thenReturnsOkResponse() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var fruit = Instancio.create(Fruit.class);
        final var fruitDto = Instancio.create(FruitDto.class);

        // When
        when(this.getFruitsPort.findById(id)).thenReturn(fruit);
        when(this.fruitDtoMapper.toFruitDto(fruit)).thenReturn(fruitDto);

        final var response = this.getFruitByIdController.getFruitByIdV1(id);

        // Then
        verify(this.getFruitsPort, times(1)).findById(id);
        verify(this.fruitDtoMapper, times(1)).toFruitDto(fruit);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getFruit()).isEqualTo(fruitDto);
    }
}
