package es.api.onepiece.core.internal.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.stream.Stream;

import org.instancio.Instancio;
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
import es.api.onepiece.core.internal.vo.character.UpdateCharacterVo;

/**
 * The Class CharacterValidationServiceImplTest.
 */
@ExtendWith(MockitoExtension.class)
class CharacterValidationServiceImplTest {

    /**
     * The Constant MAX_FRUITS_ALLOWED.
     */
    private static final int MAX_FRUITS_ALLOWED = 2;

    /**
     * The Constant MAX_HAKIS_ALLOWED.
     */
    private static final int MAX_HAKIS_ALLOWED = 3;

    /**
     * The Constant DUPLICATE_SIZE.
     */
    private static final int DUPLICATE_SIZE = 2;

    /**
     * The character validation service.
     */
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
     * Test check creation rules when fruits exceed limit then throw fruit
     * exception.
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
        assertEquals(ExceptionMessageConstants.FRUIT_CANNOT_BE_DUPLICATED_MESSAGE_ERROR,
                exception.getMessage());
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
        assertEquals(ExceptionMessageConstants.SWORD_CANNOT_BE_DUPLICATED_MESSAGE_ERROR,
                exception.getMessage());
    }

    /**
     * Test check creation rules when titles duplicated then throw character
     * exception.
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
        assertEquals(ExceptionMessageConstants.TITLE_CANNOT_BE_DUPLICATED_MESSAGE_ERROR,
                exception.getMessage());
    }

    /**
     * Test check creation rules when jobs duplicated then throw character
     * exception.
     */
    @Test
    void testCheckCreationRules_whenJobsDuplicated_thenThrowCharacterException() {
        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);

        final var duplicateId = Instancio.create(Integer.class);
        final var duplicatedJobIds = Stream.generate(() -> duplicateId)
                .limit(DUPLICATE_SIZE).toList();

        createCharacterVo.setFruitIds(Collections.emptyList());
        createCharacterVo.setHakiIds(Collections.emptyList());
        createCharacterVo.setJobIds(duplicatedJobIds);

        // When // Then
        final var exception = assertThrows(CharacterException.class,
                () -> this.characterValidationService.checkCreationRules(createCharacterVo));

        assertEquals(ExceptionMessageConstants.JOB_CANNOT_BE_DUPLICATED_CODE_ERROR, exception.getCode());
        assertEquals(ExceptionMessageConstants.JOB_CANNOT_BE_DUPLICATED_MESSAGE_ERROR, exception.getMessage());
    }

    /**
     * Test check creation rules when transformations duplicated then throw
     * character exception.
     */
    @Test
    void testCheckCreationRules_whenTransformationsDuplicated_thenThrowCharacterException() {
        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);

        final var duplicateId = Instancio.create(Integer.class);
        final var duplicatedTransformationIds = Stream.generate(() -> duplicateId)
                .limit(DUPLICATE_SIZE).toList();

        createCharacterVo.setFruitIds(Collections.emptyList());
        createCharacterVo.setHakiIds(Collections.emptyList());
        createCharacterVo.setTransformationIds(duplicatedTransformationIds);

        // When // Then
        final var exception = assertThrows(CharacterException.class,
                () -> this.characterValidationService.checkCreationRules(createCharacterVo));

        assertEquals(ExceptionMessageConstants.TRANSFORMATION_CANNOT_BE_DUPLICATED_CODE_ERROR,
                exception.getCode());
        assertEquals(ExceptionMessageConstants.TRANSFORMATION_CANNOT_BE_DUPLICATED_MESSAGE_ERROR,
                exception.getMessage());
    }

    /**
     * Test check creation rules when attacks duplicated then throw character
     * exception.
     */
    @Test
    void testCheckCreationRules_whenAttacksDuplicated_thenThrowCharacterException() {
        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);

        final var duplicateId = Instancio.create(Integer.class);
        final var duplicatedAttackIds = Stream.generate(() -> duplicateId)
                .limit(DUPLICATE_SIZE).toList();

        createCharacterVo.setFruitIds(Collections.emptyList());
        createCharacterVo.setHakiIds(Collections.emptyList());
        createCharacterVo.setAttackIds(duplicatedAttackIds);

        // When // Then
        final var exception = assertThrows(CharacterException.class,
                () -> this.characterValidationService.checkCreationRules(createCharacterVo));

        assertEquals(ExceptionMessageConstants.ATTACK_CANNOT_BE_DUPLICATED_CODE_ERROR, exception.getCode());
        assertEquals(ExceptionMessageConstants.ATTACK_CANNOT_BE_DUPLICATED_MESSAGE_ERROR,
                exception.getMessage());
    }

    /**
     * Test check creation rules when vo has all lists populated without duplicates
     * then no exception thrown.
     */
    @Test
    void testCheckCreationRules_whenVoHasAllListsPopulatedWithoutDuplicates_thenNoExceptionThrown() {

        // Given
        final var createCharacterVo = Instancio.create(CreateCharacterVo.class);

        final var fruitIds = Instancio.ofList(Integer.class).size(MAX_FRUITS_ALLOWED).create();
        final var hakiIds = Instancio.ofList(Integer.class).size(MAX_HAKIS_ALLOWED).create();
        final var titleIds = Instancio.ofList(Integer.class).size(2).create();
        final var jobIds = Instancio.ofList(Integer.class).size(2).create();
        final var swordIds = Instancio.ofList(Integer.class).size(2).create();
        final var transformationIds = Instancio.ofList(Integer.class).size(2).create();
        final var attackIds = Instancio.ofList(Integer.class).size(2).create();

        createCharacterVo.setFruitIds(fruitIds);
        createCharacterVo.setHakiIds(hakiIds);
        createCharacterVo.setTitleIds(titleIds);
        createCharacterVo.setJobIds(jobIds);
        createCharacterVo.setSwordIds(swordIds);
        createCharacterVo.setTransformationIds(transformationIds);
        createCharacterVo.setAttackIds(attackIds);

        // When // Then
        assertDoesNotThrow(() -> this.characterValidationService.checkCreationRules(createCharacterVo));

    }

    // ==================== checkUpdateRules tests ====================

    /**
     * Test check update rules when vo is valid then no exception thrown.
     */
    @Test
    void testCheckUpdateRules_whenVoIsValid_thenNoExceptionThrown() {

        // Given
        final var updateCharacterVo = Instancio.create(UpdateCharacterVo.class);

        final var validFruitIds = Instancio.of(Integer.class).stream()
                .limit(MAX_FRUITS_ALLOWED).toList();
        final var validHakiIds = Instancio.of(Integer.class).stream()
                .limit(MAX_HAKIS_ALLOWED).toList();

        updateCharacterVo.setFruitIds(validFruitIds);
        updateCharacterVo.setHakiIds(validHakiIds);
        updateCharacterVo.setTitleIds(Collections.emptyList());
        updateCharacterVo.setJobIds(Collections.emptyList());
        updateCharacterVo.setSwordIds(Collections.emptyList());
        updateCharacterVo.setTransformationIds(Collections.emptyList());
        updateCharacterVo.setAttackIds(Collections.emptyList());

        // When // Then
        assertDoesNotThrow(() -> this.characterValidationService.checkUpdateRules(updateCharacterVo));
    }

    /**
     * Test check update rules when fruits exceed limit then throw fruit exception.
     */
    @Test
    void testCheckUpdateRules_whenFruitsExceedLimit_thenThrowFruitException() {

        // Given
        final var updateCharacterVo = Instancio.create(UpdateCharacterVo.class);

        final var limitExceeded = MAX_FRUITS_ALLOWED + 1;
        final var excessiveFruitIds = Instancio.of(Integer.class).stream()
                .limit(limitExceeded).toList();

        updateCharacterVo.setFruitIds(excessiveFruitIds);

        // When // Then
        final var exception = assertThrows(FruitException.class,
                () -> this.characterValidationService.checkUpdateRules(updateCharacterVo));

        assertEquals(ExceptionMessageConstants.FRUITS_LIMIT_EXCEEDED_CODE_ERROR, exception.getCode());
        assertEquals(ExceptionMessageConstants.FRUITS_LIMIT_EXCEEDED_MESSAGE_ERROR, exception.getMessage());
    }

    /**
     * Test check update rules when fruits duplicated then throw fruit exception.
     */
    @Test
    void testCheckUpdateRules_whenFruitsDuplicated_thenThrowFruitException() {

        // Given
        final var updateCharacterVo = Instancio.create(UpdateCharacterVo.class);

        final var duplicateId = Instancio.create(Integer.class);
        final var duplicatedFruitIds = Stream.generate(() -> duplicateId)
                .limit(DUPLICATE_SIZE).toList();

        updateCharacterVo.setFruitIds(duplicatedFruitIds);

        // When // Then
        final var exception = assertThrows(FruitException.class,
                () -> this.characterValidationService.checkUpdateRules(updateCharacterVo));

        assertEquals(ExceptionMessageConstants.FRUIT_CANNOT_BE_DUPLICATED_CODE_ERROR, exception.getCode());
        assertEquals(ExceptionMessageConstants.FRUIT_CANNOT_BE_DUPLICATED_MESSAGE_ERROR,
                exception.getMessage());
    }

    /**
     * Test check update rules when hakis exceed limit then throw haki exception.
     */
    @Test
    void testCheckUpdateRules_whenHakisExceedLimit_thenThrowHakiException() {

        // Given
        final var updateCharacterVo = Instancio.create(UpdateCharacterVo.class);

        final var limitExceeded = MAX_HAKIS_ALLOWED + 1;
        final var excessiveHakiIds = Instancio.of(Integer.class).stream()
                .limit(limitExceeded).toList();
        updateCharacterVo.setFruitIds(Collections.emptyList());
        updateCharacterVo.setHakiIds(excessiveHakiIds);

        // When // Then
        final var exception = assertThrows(HakiException.class,
                () -> this.characterValidationService.checkUpdateRules(updateCharacterVo));

        assertEquals(ExceptionMessageConstants.HAKIS_LIMIT_EXCEEDED_CODE_ERROR, exception.getCode());
        assertEquals(ExceptionMessageConstants.HAKIS_LIMIT_EXCEEDED_MESSAGE_ERROR, exception.getMessage());
    }

    /**
     * Test check update rules when hakis duplicated then throw haki exception.
     */
    @Test
    void testCheckUpdateRules_whenHakisDuplicated_thenThrowHakiException() {

        // Given
        final var updateCharacterVo = Instancio.create(UpdateCharacterVo.class);

        final var duplicateId = Instancio.create(Integer.class);
        final var duplicatedHakiIds = Stream.generate(() -> duplicateId)
                .limit(DUPLICATE_SIZE).toList();

        updateCharacterVo.setFruitIds(Collections.emptyList());
        updateCharacterVo.setHakiIds(duplicatedHakiIds);

        // When // Then
        final var exception = assertThrows(HakiException.class,
                () -> this.characterValidationService.checkUpdateRules(updateCharacterVo));

        assertEquals(ExceptionMessageConstants.HAKI_CANNOT_BE_DUPLICATED_CODE_ERROR, exception.getCode());
        assertEquals(ExceptionMessageConstants.HAKI_CANNOT_BE_DUPLICATED_MESSAGE_ERROR, exception.getMessage());
    }
}
