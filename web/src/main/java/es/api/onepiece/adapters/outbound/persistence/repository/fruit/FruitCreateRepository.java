package es.api.onepiece.adapters.outbound.persistence.repository.fruit;

import es.api.onepiece.adapters.outbound.persistence.mapper.fruit.FruitMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.fruit.FruitMyBatisMapper;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.vo.fruit.CreateFruitVo;
import es.api.onepiece.core.ports.outbound.fruit.CreateFruitPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The Class FruitCreateRepository.
 */
@Component
@RequiredArgsConstructor
public class FruitCreateRepository implements CreateFruitPersistencePort {

    /** The fruit my batis mapper. */
    private final FruitMyBatisMapper fruitMyBatisMapper;

    /** The fruit mapper. */
    private final FruitMapper fruitMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Fruit execute(@Valid final CreateFruitVo createFruitVo) {

        final var fruitEntity = this.fruitMapper.toFruitEntity(createFruitVo);

        this.fruitMyBatisMapper.insertFruit(fruitEntity);

        final var createdFruitEntity = this.fruitMyBatisMapper.findById(fruitEntity.getId());

        return this.fruitMapper.toFruit(createdFruitEntity);
    }
}
