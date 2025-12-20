package es.api.onepiece.adapters.outbound.persistence.repository.character.attack;

import es.api.onepiece.adapters.outbound.persistence.entities.character.AttackEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.AttackMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.AttackMyBatisMapper;
import es.api.onepiece.adapters.outbound.persistence.repository.character.attack.AttackUpdateRepository;
import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.internal.vo.character.attack.UpdateAttackVo;
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
 * The Class AttackUpdateRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class AttackUpdateRepositoryTest {

    /** The attack update repository. */
    @InjectMocks
    AttackUpdateRepository attackUpdateRepository;

    /** The attack my batis mapper. */
    @Mock
    AttackMyBatisMapper attackMyBatisMapper;

    /** The attack mapper. */
    @Mock
    AttackMapper attackMapper;

    /**
     * Test execute when attack exists then updates attack.
     */
    @Test
    void testExecute_whenAttackExists_thenUpdatesAttack() {

        // Given
        final var updateAttackVo = Instancio.create(UpdateAttackVo.class);
        final var attackEntity = Instancio.create(AttackEntity.class);
        final var attack = Instancio.create(Attack.class);

        // When
        when(this.attackMyBatisMapper.exists(updateAttackVo.getId())).thenReturn(true);
        when(this.attackMapper.toAttackEntity(updateAttackVo)).thenReturn(attackEntity);
        doNothing().when(this.attackMyBatisMapper).updateAttack(attackEntity);
        when(this.attackMyBatisMapper.findById(updateAttackVo.getId())).thenReturn(attackEntity);
        when(this.attackMapper.toAttack(attackEntity)).thenReturn(attack);

        final var result = this.attackUpdateRepository.execute(updateAttackVo);

        // Then
        verify(this.attackMyBatisMapper, times(1)).exists(updateAttackVo.getId());
        verify(this.attackMapper, times(1)).toAttackEntity(updateAttackVo);
        verify(this.attackMyBatisMapper, times(1)).updateAttack(attackEntity);
        verify(this.attackMyBatisMapper, times(1)).findById(updateAttackVo.getId());
        verify(this.attackMapper, times(1)).toAttack(attackEntity);

        assertThat(result).isEqualTo(attack);
    }

    /**
     * Test execute when attack not exists then throws exception.
     */
    @Test
    void testExecute_whenAttackNotExists_thenThrowsException() {

        // Given
        final var updateAttackVo = Instancio.create(UpdateAttackVo.class);

        // When
        when(this.attackMyBatisMapper.exists(updateAttackVo.getId())).thenReturn(false);

        final var exception = assertThrows(CharacterException.class,
                () -> this.attackUpdateRepository.execute(updateAttackVo));

        // Then
        verify(this.attackMyBatisMapper, times(1)).exists(updateAttackVo.getId());

        assertThat(exception.getCode()).isEqualTo(ExceptionMessageConstants.ATTACK_NOT_FOUND_CODE_ERROR);
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessageConstants.ATTACK_NOT_FOUND_MESSAGE_ERROR);
    }
}
