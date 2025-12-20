package es.api.onepiece.adapters.outbound.persistence.repository.character.attack;

import es.api.onepiece.adapters.outbound.persistence.entities.character.AttackEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.AttackMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.AttackMyBatisMapper;
import es.api.onepiece.adapters.outbound.persistence.repository.character.attack.AttackFindRepository;
import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.character.Attack;
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
 * The Class AttackFindRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class AttackFindRepositoryTest {

    /** The attack find repository. */
    @InjectMocks
    AttackFindRepository attackFindRepository;

    /** The attack my batis mapper. */
    @Mock
    AttackMyBatisMapper attackMyBatisMapper;

    /** The attack mapper. */
    @Mock
    AttackMapper attackMapper;

    /**
     * Test find all when called then returns all attacks.
     */
    @Test
    void testFindAll_whenCalled_thenReturnsAllAttacks() {

        // Given
        final var attackEntities = Instancio.ofList(AttackEntity.class).size(3).create();
        final var attacks = Instancio.ofList(Attack.class).size(3).create();

        // When
        when(this.attackMyBatisMapper.findAll()).thenReturn(attackEntities);
        when(this.attackMapper.toAttackList(attackEntities)).thenReturn(attacks);

        final var result = this.attackFindRepository.findAll();

        // Then
        verify(this.attackMyBatisMapper, times(1)).findAll();
        verify(this.attackMapper, times(1)).toAttackList(attackEntities);

        assertThat(result).isEqualTo(attacks);
    }

    /**
     * Test find all when list is null then throw exception.
     */
    @Test
    void testFindAll_whenListIsNull_thenThrowException() {

        // Given

        // When
        when(this.attackMyBatisMapper.findAll()).thenReturn(null);

        final var exception = assertThrows(CharacterException.class, () -> this.attackFindRepository.findAll());

        // Then
        verify(this.attackMyBatisMapper, times(1)).findAll();

        assertThat(exception.getCode()).isEqualTo(ExceptionMessageConstants.ATTACK_NOT_FOUND_CODE_ERROR);
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessageConstants.ATTACK_NOT_FOUND_MESSAGE_ERROR);
    }

    /**
     * Test find by id when attack exists then returns attack.
     */
    @Test
    void testFindById_whenAttackExists_thenReturnsAttack() {

        // Given
        final var id = Instancio.create(Integer.class);
        final var attackEntity = Instancio.create(AttackEntity.class);
        final var attack = Instancio.create(Attack.class);

        // When
        when(this.attackMyBatisMapper.findById(id)).thenReturn(attackEntity);
        when(this.attackMapper.toAttack(attackEntity)).thenReturn(attack);

        final var result = this.attackFindRepository.findById(id);

        // Then
        verify(this.attackMyBatisMapper, times(1)).findById(id);
        verify(this.attackMapper, times(1)).toAttack(attackEntity);

        assertThat(result).isEqualTo(attack);
    }

    /**
     * Test find by id when attack not exists then throws exception.
     */
    @Test
    void testFindById_whenAttackNotExists_thenThrowsException() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        when(this.attackMyBatisMapper.findById(id)).thenReturn(null);

        final var exception = assertThrows(CharacterException.class, () -> this.attackFindRepository.findById(id));

        // Then
        verify(this.attackMyBatisMapper, times(1)).findById(id);

        assertThat(exception.getCode()).isEqualTo(ExceptionMessageConstants.ATTACK_NOT_FOUND_CODE_ERROR);
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessageConstants.ATTACK_NOT_FOUND_MESSAGE_ERROR);
    }

    /**
     * Test exists when attack exists then returns true.
     */
    @Test
    void testExists_whenAttackExists_thenReturnsTrue() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        when(this.attackMyBatisMapper.exists(id)).thenReturn(true);

        final var result = this.attackFindRepository.exists(id);

        // Then
        verify(this.attackMyBatisMapper, times(1)).exists(id);

        assertThat(result).isTrue();
    }

    /**
     * Test exists when attack not exists then returns false.
     */
    @Test
    void testExists_whenAttackNotExists_thenReturnsFalse() {

        // Given
        final var id = Instancio.create(Integer.class);

        // When
        when(this.attackMyBatisMapper.exists(id)).thenReturn(false);

        final var result = this.attackFindRepository.exists(id);

        // Then
        verify(this.attackMyBatisMapper, times(1)).exists(id);

        assertThat(result).isFalse();
    }
}
