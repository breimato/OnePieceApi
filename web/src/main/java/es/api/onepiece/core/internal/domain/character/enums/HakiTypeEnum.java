package es.api.onepiece.core.internal.domain.character.enums;

import es.api.onepiece.core.exceptions.HakiException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * The Enum HakiTypeEnum.
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum HakiTypeEnum {

    /** The haoshoku. */
    HAOSHOKU(1),

    /** The busoshoku. */
    BUSOSHOKU(2),

    /** The kenbunshoku. */
    KENBUNSHOKU(3);

    /** The id. */
    private final Integer id;

    /**
     * Gets the by name.
     *
     * @param name the name
     * @return the by name
     */
    public static HakiTypeEnum getByName(final String name) {
        try {
            return HakiTypeEnum.valueOf(name);
        } catch (final HakiException exception) {
            log.error(ExceptionMessageConstants.HAKI_TYPE_MESSAGE_ERROR, exception);
            throw new HakiException(
                ExceptionMessageConstants.HAKI_TYPE_CODE_ERROR,
                ExceptionMessageConstants.HAKI_TYPE_MESSAGE_ERROR);
        }
    }

    /**
     * Gets the by type.
     *
     * @param hakiType the haki type
     * @return the by type
     */
    public static String getByType(final HakiTypeEnum hakiType) {
        try {
            return hakiType.name();
        } catch (final HakiException exception) {
            log.error(ExceptionMessageConstants.HAKI_TYPE_MESSAGE_ERROR, exception);
            throw new HakiException(
                ExceptionMessageConstants.HAKI_TYPE_CODE_ERROR,
                ExceptionMessageConstants.HAKI_TYPE_MESSAGE_ERROR);
        }
    }
}
