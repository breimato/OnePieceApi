package es.api.onepiece.core.internal.domain.fruit.enums;

import es.api.onepiece.core.exceptions.FruitException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;



/**
 * The Enum FruitTypeEnum.
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum FruitTypeEnum {

    /** The paramecia. */
    PARAMECIA(1),

    /** The logia. */
    LOGIA(2),

    /** The zoan. */
    ZOAN(3),

    /** The mythical zoan. */
    MYTHICAL_ZOAN(4),

    /** The ancient zoan. */
    ANCIENT_ZOAN(5),

    /** The artificial zoan. */
    ARTIFICIAL_ZOAN(6);

    /** The id. */
    private final Integer id;


    /**
     * Gets the by name.
     *
     * @param name the name
     * @return the by name
     */
    public static FruitTypeEnum getByName(final String name) {

        try {
            return FruitTypeEnum.valueOf(name);
        } catch (final FruitException exception) {
            log.error(ExceptionMessageConstants.FRUIT_TYPE_MESSAGE_ERROR, exception);
            throw new FruitException(
                    ExceptionMessageConstants.FRUIT_TYPE_CODE_ERROR,
                    ExceptionMessageConstants.FRUIT_TYPE_MESSAGE_ERROR);
        }
    }

    /**
     * Gets the by type.
     *
     * @param fruitType the fruit type
     * @return the by type
     */
    public static String getByType(final FruitTypeEnum fruitType) {

        try {
            return fruitType.name();
        } catch (final FruitException exception) {
            log.error(ExceptionMessageConstants.FRUIT_TYPE_MESSAGE_ERROR, exception);
            throw new FruitException(
                    ExceptionMessageConstants.FRUIT_TYPE_CODE_ERROR,
                    ExceptionMessageConstants.FRUIT_TYPE_MESSAGE_ERROR);
        }
    }
}
