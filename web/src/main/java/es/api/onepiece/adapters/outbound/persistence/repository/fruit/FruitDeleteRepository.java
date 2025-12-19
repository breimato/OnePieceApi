package es.api.onepiece.adapters.outbound.persistence.repository.fruit;

import es.api.onepiece.adapters.outbound.persistence.mybatis.fruit.FruitMyBatisMapper;
import es.api.onepiece.core.ports.outbound.fruit.DeleteFruitPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The Class FruitDeleteRepository.
 */
@Component
@RequiredArgsConstructor
public class FruitDeleteRepository implements DeleteFruitPersistencePort {

    /** The fruit my batis mapper. */
    private final FruitMyBatisMapper fruitMyBatisMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void execute(@NotNull final Integer id) {
        this.fruitMyBatisMapper.deleteCharacterFruitsByFruitId(id);
        this.fruitMyBatisMapper.deleteFruit(id);
    }
}
