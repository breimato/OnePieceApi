package es.api.onepiece.adapters.outbound.persistence.repository.sword;

import es.api.onepiece.adapters.outbound.persistence.entities.sword.SwordEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.sword.SwordMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.sword.SwordMyBatisMapper;
import es.api.onepiece.core.exceptions.SwordException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.sword.Sword;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * The Class SwordFindRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class SwordFindRepositoryTest {

    /** The sword find repository. */
    @InjectMocks
    SwordFindRepository swordFindRepository;

    /** The sword my batis mapper. */
    @Mock
    SwordMyBatisMapper swordMyBatisMapper;

    /** The sword mapper. */
    @Mock
    SwordMapper swordMapper;

    /**
     * Test find all when called then returns list of swords.
     */
    @Test
    void testFindAll_whenCalled_thenReturnsListOfSwords() {

        // Given
        final var swordEntities = Instancio.ofList(SwordEntity.class).size(3).create();
        final var swords = Instancio.ofList(Sword.class).size(3).create();

        // When
        when(this.swordMyBatisMapper.findAll()).thenReturn(swordEntities);
        when(this.swordMapper.toSwordList(swordEntities)).thenReturn(swords);

        final var result = this.swordFindRepository.findAll();

        // Then
        verify(this.swordMyBatisMapper, times(1)).findAll();
        verify(this.swordMapper, times(1)).toSwordList(swordEntities);

        assertThat(result).isEqualTo(swords);
    }

    /**
     * Test find all when list is null then throw exception.
     */
    @Test
    void testFindAll_whenListIsNull_thenThrowException() {

        // Given

        // When
        when(this.swordMyBatisMapper.findAll()).thenReturn(null);

        final var exception = assertThrows(SwordException.class, () -> this.swordFindRepository.findAll());

        // Then
        verify(this.swordMyBatisMapper, times(1)).findAll();

        assertThat(exception.getCode()).isEqualTo(ExceptionMessageConstants.SWORD_NOT_FOUND_CODE_ERROR);
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessageConstants.SWORD_NOT_FOUND_MESSAGE_ERROR);
    }

    /**
     * Test find by id when sword exists then returns sword.
     */
    @Test
    void testFindById_whenSwordExists_thenReturnsSword() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var swordEntity = Instancio.create(SwordEntity.class);
        final var sword = Instancio.create(Sword.class);

        // When
        when(this.swordMyBatisMapper.findById(id)).thenReturn(swordEntity);
        when(this.swordMapper.toSword(swordEntity)).thenReturn(sword);

        final var result = this.swordFindRepository.findById(id);

        // Then
        verify(this.swordMyBatisMapper, times(1)).findById(id);
        verify(this.swordMapper, times(1)).toSword(swordEntity);

        assertThat(result).isEqualTo(sword);
    }

    /**
     * Test find by id when sword not found then throws sword exception.
     */
    @Test
    void testFindById_whenSwordNotFound_thenThrowsSwordException() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        when(this.swordMyBatisMapper.findById(id)).thenReturn(null);

        final var exception = assertThrows(SwordException.class, () -> this.swordFindRepository.findById(id));

        // Then
        verify(this.swordMyBatisMapper, times(1)).findById(id);

        assertThat(exception.getCode()).isEqualTo(ExceptionMessageConstants.SWORD_NOT_FOUND_CODE_ERROR);
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessageConstants.SWORD_NOT_FOUND_MESSAGE_ERROR);
    }

    /**
     * Test exists when called then returns boolean.
     */
    @Test
    void testExists_whenCalled_thenReturnsBoolean() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var exists = Instancio.create(Boolean.class);

        // When
        when(this.swordMyBatisMapper.exists(id)).thenReturn(exists);

        final var result = this.swordFindRepository.exists(id);

        // Then
        verify(this.swordMyBatisMapper, times(1)).exists(id);

        assertThat(result).isEqualTo(exists);
    }
}
