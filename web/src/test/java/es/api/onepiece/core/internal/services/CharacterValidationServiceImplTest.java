package es.api.onepiece.core.internal.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.FruitException;
import es.api.onepiece.core.exceptions.HakiException;
import es.api.onepiece.core.exceptions.SwordException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;

/**
 * The Class CharacterValidationServiceImplTest.
 */
@ExtendWith(MockitoExtension.class)
class CharacterValidationServiceImplTest {

    /** The Constant MAX_FRUITS_ALLOWED. */
    private static final int MAX_FRUITS_ALLOWED = 2;

    /** The Constant MAX_HAKIS_ALLOWED. */
    private static final int MAX_HAKIS_ALLOWED = 3;

    /** The Constant DUPLICATE_SIZE. */
    private static final int DUPLICATE_SIZE = 2;

    /** The character validation service. */
    @InjectMocks
    CharacterValidationServiceImpl characterValidationService;

    /**
     * Test check creation rules when vo is valid then no exception thrown.
     */
    @Test
    void testCheckCreationRules_whenVoIsValid_thenNoExceptionThrown() {

        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);

        final var validFruitIds = Instancio.of(Integer.class).stream()
                .limit(MAX_FRUITS_ALLOWED).toList();
        final var validHakiIds = Instancio.of(Integer.class).stream()
                .limit(MAX_HAKIS_ALLOWED).toList();

        createCharacterVo.setFruitIds(validFruitIds);
        createCharacterVo.setHakiIds(validHakiIds);
        createCharacterVo.setTitleIds(Collections.emptyList());
        createCharacterVo.setJobIds(Collections.emptyList());
        createCharacterVo.setSwordIds(Collections.emptyList());
        createCharacterVo.setTransformationIds(Collections.emptyList());
        createCharacterVo.setAttackIds(Collections.emptyList());

        // When // Then
        assertDoesNotThrow(() -> this.characterValidationService.checkCreationRules(createCharacterVo));

    }

    /**
     * Test check creation rules when fruits exceed limit then throw fruit exception.
     */
    @Test
    void testCheckCreationRules_whenFruitsExceedLimit_thenThrowFruitException() {
        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);

        final var limitExceeded = MAX_FRUITS_ALLOWED + 1;
        final var excessiveFruitIds = Instancio.of(Integer.class).stream()
                .limit(limitExceeded).toList();

        createCharacterVo.setFruitIds(excessiveFruitIds);

        // When // Then
        final var exception = assertThrows(FruitException.class,
                () -> this.characterValidationService.checkCreationRules(createCharacterVo));

        assertEquals(ExceptionMessageConstants.FRUITS_LIMIT_EXCEEDED_CODE_ERROR, exception.getCode());
        assertEquals(ExceptionMessageConstants.FRUITS_LIMIT_EXCEEDED_MESSAGE_ERROR, exception.getMessage());
    }

    /**
     * Test check creation rules when fruits duplicated then throw fruit exception.
     */
    @Test
    void testCheckCreationRules_whenFruitsDuplicated_thenThrowFruitException() {

        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);

        final var duplicateId = Instancio.create(Integer.class);
        final var duplicatedFruitIds = Stream.generate(() -> duplicateId)
                .limit(DUPLICATE_SIZE).toList();

        createCharacterVo.setFruitIds(duplicatedFruitIds);

        // When // Then
        final var exception = assertThrows(FruitException.class,
                () -> this.characterValidationService.checkCreationRules(createCharacterVo));

        assertEquals(ExceptionMessageConstants.FRUIT_CANNOT_BE_DUPLICATED_CODE_ERROR, exception.getCode());
        assertEquals(ExceptionMessageConstants.FRUIT_CANNOT_BE_DUPLICATED_MESSAGE_ERROR, exception.getMessage());
    }

    /**
     * Test check creation rules when hakis exceed limit then throw haki exception.
     */
    @Test
    void testCheckCreationRules_whenHakisExceedLimit_thenThrowHakiException() {

        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);

        final var limitExceeded = MAX_HAKIS_ALLOWED + 1;
        final var excessiveHakiIds = Instancio.of(Integer.class).stream()
                .limit(limitExceeded).toList();
        createCharacterVo.setFruitIds(Collections.emptyList());
        createCharacterVo.setHakiIds(excessiveHakiIds);

        // When // Then
        final var exception = assertThrows(HakiException.class,
                () -> this.characterValidationService.checkCreationRules(createCharacterVo));

        assertEquals(ExceptionMessageConstants.HAKIS_LIMIT_EXCEEDED_CODE_ERROR, exception.getCode());
        assertEquals(ExceptionMessageConstants.HAKIS_LIMIT_EXCEEDED_MESSAGE_ERROR, exception.getMessage());
    }

    /**
     * Test check creation rules when hakis duplicated then throw haki exception.
     */
    @Test
    void testCheckCreationRules_whenHakisDuplicated_thenThrowHakiException() {

        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);

        final var duplicateId = Instancio.create(Integer.class);
        final var duplicatedHakiIds = Stream.generate(() -> duplicateId)
                .limit(DUPLICATE_SIZE).toList();

        createCharacterVo.setFruitIds(Collections.emptyList());
        createCharacterVo.setHakiIds(duplicatedHakiIds);

        // When // Then
        final var exception = assertThrows(HakiException.class,
                () -> this.characterValidationService.checkCreationRules(createCharacterVo));

        assertEquals(ExceptionMessageConstants.HAKI_CANNOT_BE_DUPLICATED_CODE_ERROR, exception.getCode());
        assertEquals(ExceptionMessageConstants.HAKI_CANNOT_BE_DUPLICATED_MESSAGE_ERROR, exception.getMessage());
    }

    /**
     * Test check creation rules when swords duplicated then throw sword exception.
     */
    @Test
    void testCheckCreationRules_whenSwordsDuplicated_thenThrowSwordException() {

        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);

        final var duplicateId = Instancio.create(Integer.class);
        final var duplicatedSwordIds = Stream.generate(() -> duplicateId)
                .limit(DUPLICATE_SIZE).toList();

        createCharacterVo.setFruitIds(Collections.emptyList());
        createCharacterVo.setHakiIds(Collections.emptyList());
        createCharacterVo.setSwordIds(duplicatedSwordIds);

        // When // Then
        final var exception = assertThrows(SwordException.class,
                () -> this.characterValidationService.checkCreationRules(createCharacterVo));

        assertEquals(ExceptionMessageConstants.SWORD_CANNOT_BE_DUPLICATED_CODE_ERROR, exception.getCode());
        assertEquals(ExceptionMessageConstants.SWORD_CANNOT_BE_DUPLICATED_MESSAGE_ERROR, exception.getMessage());
    }

    /**
     * Test check creation rules when titles duplicated then throw character exception.
     */
    @Test
    void testCheckCreationRules_whenTitlesDuplicated_thenThrowCharacterException() {
        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);

        final var duplicateId = Instancio.create(Integer.class);
        final var duplicatedTitleIds = Stream.generate(() -> duplicateId)
                .limit(DUPLICATE_SIZE).toList();

        createCharacterVo.setFruitIds(Collections.emptyList());
        createCharacterVo.setHakiIds(Collections.emptyList());
        createCharacterVo.setTitleIds(duplicatedTitleIds);

        // When // Then
        final var exception = assertThrows(CharacterException.class,
                () -> this.characterValidationService.checkCreationRules(createCharacterVo));

        assertEquals(ExceptionMessageConstants.TITLE_CANNOT_BE_DUPLICATED_CODE_ERROR, exception.getCode());
        assertEquals(ExceptionMessageConstants.TITLE_CANNOT_BE_DUPLICATED_MESSAGE_ERROR, exception.getMessage());
    }
}