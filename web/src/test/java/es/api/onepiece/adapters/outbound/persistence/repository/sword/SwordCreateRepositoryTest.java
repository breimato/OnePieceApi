package es.api.onepiece.adapters.outbound.persistence.repository.sword;

import es.api.onepiece.adapters.outbound.persistence.entities.sword.SwordEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.sword.SwordMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.sword.SwordMyBatisMapper;
import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.internal.vo.sword.CreateSwordVo;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class SwordCreateRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class SwordCreateRepositoryTest {

    /** The sword create repository. */
    @InjectMocks
    SwordCreateRepository swordCreateRepository;

    /** The sword my batis mapper. */
    @Mock
    SwordMyBatisMapper swordMyBatisMapper;

    /** The sword mapper. */
    @Mock
    SwordMapper swordMapper;

    /**
     * Test execute when valid vo then creates sword.
     */
    @Test
    void testExecute_whenValidVo_thenCreatesSword() {

        // Given
        final var createSwordVo = Instancio.create(CreateSwordVo.class);
        final var swordEntity = Instancio.create(SwordEntity.class);
        final var sword = Instancio.create(Sword.class);

        // When
        when(this.swordMapper.toSwordEntity(createSwordVo)).thenReturn(swordEntity);
        when(this.swordMyBatisMapper.findById(swordEntity.getId())).thenReturn(swordEntity);
        when(this.swordMapper.toSword(swordEntity)).thenReturn(sword);

        final var result = this.swordCreateRepository.execute(createSwordVo);

        // Then
        verify(this.swordMapper, times(1)).toSwordEntity(createSwordVo);
        verify(this.swordMyBatisMapper, times(1)).insertSword(swordEntity);
        verify(this.swordMyBatisMapper, times(1)).findById(swordEntity.getId());
        verify(this.swordMapper, times(1)).toSword(swordEntity);

        assertThat(result).isEqualTo(sword);
    }
}
