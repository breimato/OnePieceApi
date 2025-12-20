package es.api.onepiece.core.internal.usecases.character.attack;

import es.api.onepiece.core.internal.domain.character.Attack;
import es.api.onepiece.core.ports.inbound.character.attack.GetAttacksPort;
import es.api.onepiece.core.ports.outbound.character.attack.FindAttacksPersistencePort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The Class GetAttacksUseCase.
 */
@Component
@RequiredArgsConstructor
public class GetAttacksUseCase implements GetAttacksPort {

    /** The find attacks persistence port. */
    private final FindAttacksPersistencePort findAttacksPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Attack> findAll() {
        return this.findAttacksPersistencePort.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Attack findById(@NotNull final Integer id) {
        return this.findAttacksPersistencePort.findById(id);
    }
}
