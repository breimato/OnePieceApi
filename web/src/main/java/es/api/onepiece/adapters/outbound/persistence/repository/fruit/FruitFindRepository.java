package es.api.onepiece.adapters.outbound.persistence.repository.fruit;

import es.api.onepiece.adapters.outbound.persistence.mapper.fruit.FruitMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.fruit.FruitMyBatisMapper;
import es.api.onepiece.core.exceptions.FruitException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.ports.outbound.fruit.FindFruitsPersistencePort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * The Class FruitFindRepository.
 */
@Component
@RequiredArgsConstructor
public class FruitFindRepository implements FindFruitsPersistencePort {

    /** The fruit my batis mapper. */
    private final FruitMyBatisMapper fruitMyBatisMapper;

    /** The fruit mapper. */
    private final FruitMapper fruitMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Fruit> findAll() {

        final var fruitEntities = this.fruitMyBatisMapper.findAll();

        if (Objects.isNull(fruitEntities)) {
            throw new FruitException(
                    ExceptionMessageConstants.FRUIT_NOT_FOUND_CODE_ERROR,
                    ExceptionMessageConstants.FRUIT_NOT_FOUND_MESSAGE_ERROR);
        }
        return this.fruitMapper.toFruitList(fruitEntities);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Fruit findById(@NotNull final Integer id) {

        final var fruitEntity = this.fruitMyBatisMapper.findById(id);

        if (Objects.isNull(fruitEntity)) {
            throw new FruitException(
                    ExceptionMessageConstants.FRUIT_NOT_FOUND_CODE_ERROR,
                    ExceptionMessageConstants.FRUIT_NOT_FOUND_MESSAGE_ERROR);
        }
        return this.fruitMapper.toFruit(fruitEntity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean exists(@NotNull final Integer id) {
        return this.fruitMyBatisMapper.exists(id);
    }
}
