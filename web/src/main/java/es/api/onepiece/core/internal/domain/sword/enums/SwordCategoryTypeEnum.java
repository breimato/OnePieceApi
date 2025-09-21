package es.api.onepiece.core.internal.domain.sword.enums;

import es.api.onepiece.core.exceptions.SwordException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * The Enum SwordCategoryTypeEnum.
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum SwordCategoryTypeEnum {

    /** The SAIJ O ô WAZAMONO. */
    SAIJO_Ô_WAZAMONO(1),

    /** The Ô WAZAMONO. */
    Ô_WAZAMONO(2),

    /** The wazamono. */
    WAZAMONO(3);

    /** The id. */
    private final Integer id;

    /**
     * Gets the by name.
     *
     * @param name the name
     * @return the by name
     */
    public static SwordCategoryTypeEnum getByName(final String name) {
        try {
            return SwordCategoryTypeEnum.valueOf(name);
        } catch (final SwordException exception) {
            log.error(ExceptionMessageConstants.SWORD_CATEGORY_MESSAGE_ERROR, exception);
            throw new SwordException(
                ExceptionMessageConstants.SWORD_CATEGORY_CODE_ERROR,
                ExceptionMessageConstants.SWORD_CATEGORY_MESSAGE_ERROR);
        }
    }

    /**
     * Gets the by type.
     *
     * @param swordCategoryType the sword category type
     * @return the by type
     */
    public static String getByType(final SwordCategoryTypeEnum swordCategoryType) {
        try {
            return swordCategoryType.name();
        } catch (final SwordException exception) {
            log.error(ExceptionMessageConstants.SWORD_CATEGORY_MESSAGE_ERROR, exception);
            throw new SwordException(
                ExceptionMessageConstants.SWORD_CATEGORY_CODE_ERROR,
                ExceptionMessageConstants.SWORD_CATEGORY_MESSAGE_ERROR);
        }
    }
}
