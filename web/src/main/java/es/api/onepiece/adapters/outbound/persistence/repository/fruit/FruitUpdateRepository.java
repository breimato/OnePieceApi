package es.api.onepiece.adapters.outbound.persistence.repository.fruit;

import es.api.onepiece.adapters.outbound.persistence.mapper.fruit.FruitMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.fruit.FruitMyBatisMapper;
import es.api.onepiece.core.exceptions.FruitException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.domain.fruit.Fruit;
import es.api.onepiece.core.internal.vo.fruit.UpdateFruitVo;
import es.api.onepiece.core.ports.outbound.fruit.UpdateFruitPersistencePort;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class FruitUpdateRepository.
 */
@Component
@RequiredArgsConstructor
public class FruitUpdateRepository implements UpdateFruitPersistencePort {

    /** The fruit my batis mapper. */
    private final FruitMyBatisMapper fruitMyBatisMapper;

    /** The fruit mapper. */
    private final FruitMapper fruitMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Fruit execute(@Valid final UpdateFruitVo updateFruitVo) {

        if (BooleanUtils.isFalse(this.fruitMyBatisMapper.exists(updateFruitVo.getId()))) {
            throw new FruitException(ExceptionMessageConstants.FRUIT_NOT_FOUND_CODE_ERROR, ExceptionMessageConstants.FRUIT_NOT_FOUND_MESSAGE_ERROR);
        }

        final var fruitEntity = this.fruitMapper.toFruitEntity(updateFruitVo);

        this.fruitMyBatisMapper.updateFruit(fruitEntity);

        final var updatedFruitEntity = this.fruitMyBatisMapper.findById(updateFruitVo.getId());

        return this.fruitMapper.toFruit(updatedFruitEntity);
    }
}
