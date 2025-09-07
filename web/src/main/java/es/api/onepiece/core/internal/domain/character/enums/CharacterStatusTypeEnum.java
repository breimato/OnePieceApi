package es.api.onepiece.core.internal.domain.character.enums;

import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


/**
 * The Enum CharacterStatusTypeEnum.
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum CharacterStatusTypeEnum {

    /** The alive. */
    ALIVE(1),

    /** The dead. */
    DEAD(2),

    /** The unknown. */
    UNKNOWN(3);

    /** The id. */
    private final Integer id;


    /**
     * Gets the by name.
     *
     * @param name the name
     * @return the by name
     */
    public static CharacterStatusTypeEnum getByName(final String name) {

        try {
            return CharacterStatusTypeEnum.valueOf(name);
        } catch (final Exception exception) {
            log.error(ExceptionMessageConstants.CHARACTER_STATUS_MESSAGE_ERROR, exception);
            throw new CharacterException(
                    ExceptionMessageConstants.CHARACTER_STATUS_CODE_ERROR,
                    ExceptionMessageConstants.CHARACTER_STATUS_MESSAGE_ERROR);
        }
    }

    /**
     * Gets the by type.
     *
     * @param characterStatusTypeEnum the character status type enum
     * @return the by type
     */
    public static String getByType(final CharacterStatusTypeEnum characterStatusTypeEnum) {

        try {
            return characterStatusTypeEnum.name();
        } catch (final RuntimeException exception) {
            log.error(ExceptionMessageConstants.CHARACTER_STATUS_MESSAGE_ERROR, exception);
            throw new CharacterException(
                    ExceptionMessageConstants.CHARACTER_STATUS_CODE_ERROR,
                    ExceptionMessageConstants.CHARACTER_STATUS_MESSAGE_ERROR);
        }
    }
}
