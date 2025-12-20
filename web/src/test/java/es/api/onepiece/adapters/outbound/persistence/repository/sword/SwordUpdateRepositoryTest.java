package es.api.onepiece.adapters.outbound.persistence.repository.sword;

import es.api.onepiece.adapters.outbound.persistence.entities.sword.SwordEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.sword.SwordMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.sword.SwordMyBatisMapper;
import es.api.onepiece.core.exceptions.SwordException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.internal.vo.sword.UpdateSwordVo;
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
 * The Class SwordUpdateRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class SwordUpdateRepositoryTest {

    /** The sword update repository. */
    @InjectMocks
    SwordUpdateRepository swordUpdateRepository;

    /** The sword my batis mapper. */
    @Mock
    SwordMyBatisMapper swordMyBatisMapper;

    /** The sword mapper. */
    @Mock
    SwordMapper swordMapper;

    /**
     * Test execute when valid vo then updates sword.
     */
    @Test
    void testExecute_whenValidVo_thenUpdatesSword() {

        // Given
        final var updateSwordVo = Instancio.create(UpdateSwordVo.class);
        final var swordEntity = Instancio.create(SwordEntity.class);
        final var sword = Instancio.create(Sword.class);

        // When
        when(this.swordMyBatisMapper.exists(updateSwordVo.getId())).thenReturn(true);
        when(this.swordMapper.toSwordEntityFromUpdate(updateSwordVo)).thenReturn(swordEntity);
        when(this.swordMyBatisMapper.findById(updateSwordVo.getId())).thenReturn(swordEntity);
        when(this.swordMapper.toSword(swordEntity)).thenReturn(sword);

        final var result = this.swordUpdateRepository.execute(updateSwordVo);

        // Then
        verify(this.swordMyBatisMapper, times(1)).exists(updateSwordVo.getId());
        verify(this.swordMapper, times(1)).toSwordEntityFromUpdate(updateSwordVo);
        verify(this.swordMyBatisMapper, times(1)).updateSword(swordEntity);
        verify(this.swordMyBatisMapper, times(1)).findById(updateSwordVo.getId());
        verify(this.swordMapper, times(1)).toSword(swordEntity);

        assertThat(result).isEqualTo(sword);
    }

    /**
     * Test execute when sword not found then throws sword exception.
     */
    @Test
    void testExecute_whenSwordNotFound_thenThrowsSwordException() {

        // Given
        final var updateSwordVo = Instancio.create(UpdateSwordVo.class);

        // When
        when(this.swordMyBatisMapper.exists(updateSwordVo.getId())).thenReturn(false);

        final var exception = assertThrows(SwordException.class,
                () -> this.swordUpdateRepository.execute(updateSwordVo));

        // Then
        verify(this.swordMyBatisMapper, times(1)).exists(updateSwordVo.getId());
        verify(this.swordMapper, never()).toSwordEntityFromUpdate(any());

        assertThat(exception.getCode()).isEqualTo(ExceptionMessageConstants.SWORD_NOT_FOUND_CODE_ERROR);
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessageConstants.SWORD_NOT_FOUND_MESSAGE_ERROR);
    }
}
