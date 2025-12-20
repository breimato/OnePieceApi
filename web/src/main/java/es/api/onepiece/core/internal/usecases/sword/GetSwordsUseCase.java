package es.api.onepiece.core.internal.usecases.sword;

import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.ports.inbound.sword.GetSwordsPort;
import es.api.onepiece.core.ports.outbound.sword.FindSwordsPersistencePort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The Class GetSwordsUseCase.
 */
@Component
@RequiredArgsConstructor
public class GetSwordsUseCase implements GetSwordsPort {

    /** The find swords persistence port. */
    private final FindSwordsPersistencePort findSwordsPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Sword> findAll() {
        return this.findSwordsPersistencePort.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sword findById(@NotNull final Integer id) {
        return this.findSwordsPersistencePort.findById(id);
    }
}
