package es.api.onepiece.adapters.inbound.rest.mapper.sword;

import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.internal.vo.sword.CreateSwordVo;
import es.api.onepiece.core.internal.vo.sword.UpdateSwordVo;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.CreateSwordRequestDto;
import org.openapitools.model.SwordDto;
import org.openapitools.model.UpdateSwordRequestDto;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The Class SwordDtoMapperTest.
 */
class SwordDtoMapperTest {

    /** The mapper. */
    private final SwordDtoMapper mapper = Mappers.getMapper(SwordDtoMapper.class);

    /**
     * Test to sword dto when called then returns sword dto.
     */
    @Test
    void testToSwordDto_whenCalled_thenReturnsSwordDto() {

        // Given
        final var sword = Instancio.create(Sword.class);

        // When
        final var result = this.mapper.toSwordDto(sword);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(sword.getId());
        assertThat(result.getSwordStatus()).isEqualTo(sword.getSwordStatus().name());
        assertThat(result.getDescription()).isEqualTo(sword.getDescription());
        assertThat(result.getBlackSword()).isEqualTo(sword.getBlackSword());
        assertThat(result.getSwordStatus()).isEqualTo(sword.getSwordStatus().name());
        assertThat(result.getCategory()).isEqualTo(sword.getCategory().getType().name());
        assertThat(result.getDebut().getId()).isEqualTo(sword.getDebut().getId());
    }

    /**
     * Test to sword dto list when called then returns sword dto list.
     */
    @Test
    void testToSwordDtoList_whenCalled_thenReturnsSwordDtoList() {
        // Given
        final var swords = Instancio.ofList(Sword.class).size(3).create();

        // When
        final var result = this.mapper.toSwordDtoList(swords);

        // Then
        assertThat(result).isNotNull().hasSize(3);
    }

    /**
     * Test to create sword vo when called then returns create sword vo.
     */
    @Test
    void testToCreateSwordVo_whenCalled_thenReturnsCreateSwordVo() {
        // Given
        final var createSwordRequestDto = Instancio.create(CreateSwordRequestDto.class);

        // When
        final var result = this.mapper.toCreateSwordVo(createSwordRequestDto);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(createSwordRequestDto.getName());
        assertThat(result.getDescription()).isEqualTo(createSwordRequestDto.getDescription());
        assertThat(result.getBlackSword()).isEqualTo(createSwordRequestDto.getBlackSword());
        assertThat(result.getStatusId()).isEqualTo(createSwordRequestDto.getStatusId());
        assertThat(result.getCategoryId()).isEqualTo(createSwordRequestDto.getCategoryId());
        assertThat(result.getDebutId()).isEqualTo(createSwordRequestDto.getDebutId());
    }

    /**
     * Test to update sword vo when called then returns update sword vo.
     */
    @Test
    void testToUpdateSwordVo_whenCalled_thenReturnsUpdateSwordVo() {
        // Given
        final var id = Instancio.create(Integer.class);
        final var updateSwordRequestDto = Instancio.create(UpdateSwordRequestDto.class);

        // When
        final var result = this.mapper.toUpdateSwordVo(id, updateSwordRequestDto);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
        assertThat(result.getName()).isEqualTo(updateSwordRequestDto.getName());
        assertThat(result.getDescription()).isEqualTo(updateSwordRequestDto.getDescription());
        assertThat(result.getBlackSword()).isEqualTo(updateSwordRequestDto.getBlackSword());
        assertThat(result.getStatusId()).isEqualTo(updateSwordRequestDto.getStatusId());
        assertThat(result.getCategoryId()).isEqualTo(updateSwordRequestDto.getCategoryId());
        assertThat(result.getDebutId()).isEqualTo(updateSwordRequestDto.getDebutId());
    }
}
