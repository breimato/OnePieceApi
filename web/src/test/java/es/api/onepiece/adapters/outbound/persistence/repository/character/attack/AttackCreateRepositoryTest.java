package es.api.onepiece.adapters.outbound.persistence.repository.character.attack;

import es.api.onepiece.adapters.outbound.persistence.entities.character.AttackEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.AttackMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.AttackMyBatisMapper;
import es.api.onepiece.adapters.outbound.persistence.repository.character.attack.AttackCreateRepository;
import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.vo.character.attack.CreateAttackVo;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * The Class AttackCreateRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class AttackCreateRepositoryTest {

    /** The attack create repository. */
    @InjectMocks
    AttackCreateRepository attackCreateRepository;

    /** The attack my batis mapper. */
    @Mock
    AttackMyBatisMapper attackMyBatisMapper;

    /** The attack mapper. */
    @Mock
    AttackMapper attackMapper;

    /**
     * Test execute when valid then creates attack.
     */
    @Test
    void testExecute_whenValid_thenCreatesAttack() {

        // Given
        final var createAttackVo = Instancio.create(CreateAttackVo.class);
        final var attackEntity = Instancio.create(AttackEntity.class);
        final var attack = Instancio.create(Attack.class);

        // When
        when(this.attackMapper.toAttackEntity(createAttackVo)).thenReturn(attackEntity);
        doNothing().when(this.attackMyBatisMapper).insertAttack(attackEntity);
        when(this.attackMyBatisMapper.findById(attackEntity.getId())).thenReturn(attackEntity);
        when(this.attackMapper.toAttack(attackEntity)).thenReturn(attack);

        final var result = this.attackCreateRepository.execute(createAttackVo);

        // Then
        verify(this.attackMapper, times(1)).toAttackEntity(createAttackVo);
        verify(this.attackMyBatisMapper, times(1)).insertAttack(attackEntity);
        verify(this.attackMyBatisMapper, times(1)).findById(attackEntity.getId());
        verify(this.attackMapper, times(1)).toAttack(attackEntity);

        assertThat(result).isEqualTo(attack);
    }
}
