package es.api.onepiece.core.internal.domain.boat.enums;

import es.api.onepiece.core.exceptions.BoatException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * The Enum BoatTypeEnum.
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum BoatTypeEnum {
    
    /** The caravel. */
    CARAVEL(1);


    /** The id. */
    private final Integer id;

    /**
     * Gets the by name.
     *
     * @param name the name
     * @return the by name
     */
    public static BoatTypeEnum getByName(final String name) {
        try {
            return BoatTypeEnum.valueOf(name);
        } catch (final BoatException exception) {
            log.error(ExceptionMessageConstants.BOAT_TYPE_MESSAGE_ERROR, exception);
            throw new BoatException(
                ExceptionMessageConstants.BOAT_TYPE_CODE_ERROR,
                ExceptionMessageConstants.BOAT_TYPE_MESSAGE_ERROR);
        }
    }

    /**
     * Gets the by type.
     *
     * @param boatType the boat type
     * @return the by type
     */
    public static String getByType(final BoatTypeEnum boatType) {
        try {
            return boatType.name();
        } catch (final BoatException exception) {
            log.error(ExceptionMessageConstants.BOAT_TYPE_MESSAGE_ERROR, exception);
            throw new BoatException(
                ExceptionMessageConstants.BOAT_TYPE_CODE_ERROR,
                ExceptionMessageConstants.BOAT_TYPE_MESSAGE_ERROR);
        }
    }
}
