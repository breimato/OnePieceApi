package es.api.onepiece.adapters.inbound.rest.controller.fruit;

import es.api.onepiece.adapters.inbound.rest.mapper.fruit.FruitDtoMapper;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.ports.inbound.fruit.CreateFruitPort;
import es.api.onepiece.core.internal.vo.fruit.CreateFruitVo;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.CreateFruitRequestDto;
import org.openapitools.model.FruitDto;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class PostFruitControllerTest.
 */
@ExtendWith(MockitoExtension.class)
class PostFruitControllerTest {

    /** The post fruit controller. */
    @InjectMocks
    PostFruitController postFruitController;

    /** The create fruit port. */
    @Mock
    CreateFruitPort createFruitPort;

    /** The fruit dto mapper. */
    @Mock
    FruitDtoMapper fruitDtoMapper;

    /**
     * Test create fruit v1 when valid request then returns created response.
     */
    @Test
    void testCreateFruitV1_whenValidRequest_thenReturnsCreatedResponse() {

        // Given
        final var createFruitRequestDto = Instancio.create(CreateFruitRequestDto.class);
        final var createFruitVo = Instancio.create(CreateFruitVo.class);
        final var fruit = Instancio.create(Fruit.class);
        final var fruitDto = Instancio.create(FruitDto.class);

        // When
        when(this.fruitDtoMapper.toCreateFruitVo(createFruitRequestDto)).thenReturn(createFruitVo);
        when(this.createFruitPort.execute(createFruitVo)).thenReturn(fruit);
        when(this.fruitDtoMapper.toFruitDto(fruit)).thenReturn(fruitDto);

        final var response = this.postFruitController.createFruitV1(createFruitRequestDto);

        // Then
        verify(this.fruitDtoMapper, times(1)).toCreateFruitVo(createFruitRequestDto);
        verify(this.createFruitPort, times(1)).execute(createFruitVo);
        verify(this.fruitDtoMapper, times(1)).toFruitDto(fruit);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getFruit()).isEqualTo(fruitDto);
    }
}
