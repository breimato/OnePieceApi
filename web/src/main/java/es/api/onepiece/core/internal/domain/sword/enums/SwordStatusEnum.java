package es.api.onepiece.core.internal.domain.sword.enums;

import es.api.onepiece.core.exceptions.SwordException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * The Enum SwordStatusEnum.
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum SwordStatusEnum {
    
    /** The destroyed. */
    DESTROYED(1),

    /** The lost. */
    LOST(2),

    /** The existing. */
    EXISTING(3);

    /** The id. */
    private final Integer id;

    /**
     * Gets the by name.
     *
     * @param name the name
     * @return the by name
     */
    public static SwordStatusEnum getByName(final String name) {
        try {
            return SwordStatusEnum.valueOf(name);
        } catch (final Exception exception) {
            log.error(ExceptionMessageConstants.SWORD_STATUS_MESSAGE_ERROR, exception);
            throw new SwordException(
                ExceptionMessageConstants.SWORD_STATUS_CODE_ERROR,
                ExceptionMessageConstants.SWORD_STATUS_MESSAGE_ERROR);
        }
    }

    /**
     * Gets the by type.
     *
     * @param swordStatus the sword status
     * @return the by type
     */
    public static String getByType(final SwordStatusEnum swordStatus) {
        try {
            return swordStatus.name();
        } catch (final RuntimeException exception) {
            log.error(ExceptionMessageConstants.SWORD_STATUS_MESSAGE_ERROR, exception);
            throw new SwordException(
                ExceptionMessageConstants.SWORD_STATUS_CODE_ERROR,
                ExceptionMessageConstants.SWORD_STATUS_MESSAGE_ERROR);
        }
    }
}
