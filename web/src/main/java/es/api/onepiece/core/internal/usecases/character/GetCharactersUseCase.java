package es.api.onepiece.core.internal.usecases.character;

import es.api.onepiece.core.internal.domain.character.CharacterSummary;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.ports.inbound.character.GetCharactersPort;
import es.api.onepiece.core.ports.outbound.character.FindCharactersPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The Class GetCharactersUseCase.
 */
@Component
@RequiredArgsConstructor
public class GetCharactersUseCase implements GetCharactersPort {

    /** The find characters persistence port. */
    private final FindCharactersPersistencePort findCharactersPersistencePort;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CharacterSummary> findAll() {
        return this.findCharactersPersistencePort.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Character findById(final Integer id) {
        return this.findCharactersPersistencePort.findById(id);
    }
}
