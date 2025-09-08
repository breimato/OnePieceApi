package es.api.onepiece.core.internal.domain.character.enums;

import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * The Enum CharacterTitleEnum.
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum CharacterTitleEnum {

    /** The shichibukai. */
    SHICHIBUKAI(1),
    
    /** The yonkou. */
    YONKOU(2),
    
    /** The supernova. */
    SUPERNOVA(3);

    /** The id. */
    private final Integer id;

    /**
     * Gets the by name.
     *
     * @param name the name
     * @return the by name
     */
    public static CharacterTitleEnum getByName(final String name) {
        try {
            return CharacterTitleEnum.valueOf(name);
        } catch (final Exception exception) {
            throw new CharacterException(
                ExceptionMessageConstants.CHARACTER_STATUS_CODE_ERROR,
                ExceptionMessageConstants.CHARACTER_STATUS_MESSAGE_ERROR);
        }
    }

    /**
     * Gets the by type.
     *
     * @param type the type
     * @return the by type
     */
    public static String getByType(final CharacterTitleEnum type) {
        try {
            return type.name();
        } catch (final RuntimeException exception) {
            throw new CharacterException(
                ExceptionMessageConstants.CHARACTER_STATUS_CODE_ERROR,
                ExceptionMessageConstants.CHARACTER_STATUS_MESSAGE_ERROR);
        }
    }
}
