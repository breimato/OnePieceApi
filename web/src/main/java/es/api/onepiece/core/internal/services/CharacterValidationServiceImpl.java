package es.api.onepiece.core.internal.services;

import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.FruitException;
import es.api.onepiece.core.exceptions.HakiException;
import es.api.onepiece.core.exceptions.SwordException;
import es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants;
import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.HashSet;
import java.util.List;

/**
 * The Class CharacterValidationServiceImpl.
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Validated
public class CharacterValidationServiceImpl implements CharacterValidationService {

    /**
     * The Constant MAX_FRUITS_PER_CHARACTER.
     */
    private static final int MAX_FRUITS_PER_CHARACTER = 2;

    /**
     * The Constant MAX_HAKIS_PER_CHARACTER.
     */
    private static final int MAX_HAKIS_PER_CHARACTER = 3;

    /**
     * {@inheritDoc}
     */
    @Override
    public void checkCreationRules(@Valid final CreateCharacterVo createCharacterVo) {
        this.validateFruits(createCharacterVo.getFruitIds());
        this.validateHakis(createCharacterVo.getHakiIds());
        this.validateTitles(createCharacterVo.getTitleIds());
        this.validateJobs(createCharacterVo.getJobIds());
        this.validateSwords(createCharacterVo.getSwordIds());
        this.validateTransformations(createCharacterVo.getTransformationIds());
        this.validateAttacks(createCharacterVo.getAttackIds());
    }

    /**
     * Validate fruits.
     *
     * @param fruitIds the fruit ids
     */
    private void validateFruits(final List<Integer> fruitIds) {

        if (fruitIds.size() > MAX_FRUITS_PER_CHARACTER) {
            log.error(ExceptionMessageConstants.FRUITS_LIMIT_EXCEEDED_MESSAGE_ERROR);
            throw new FruitException(
                    ExceptionMessageConstants.FRUITS_LIMIT_EXCEEDED_CODE_ERROR,
                    ExceptionMessageConstants.FRUITS_LIMIT_EXCEEDED_MESSAGE_ERROR);
        }
        if (this.hasDuplicates(fruitIds)) {
            log.error(ExceptionMessageConstants.FRUIT_CANNOT_BE_DUPLICATED_MESSAGE_ERROR);
            throw new FruitException(
                    ExceptionMessageConstants.FRUIT_CANNOT_BE_DUPLICATED_CODE_ERROR,
                    ExceptionMessageConstants.FRUIT_CANNOT_BE_DUPLICATED_MESSAGE_ERROR);
        }

    }

    /**
     * Validate hakis.
     *
     * @param hakiIds the haki ids
     */
    private void validateHakis(final List<Integer> hakiIds) {

        if (CollectionUtils.isEmpty(hakiIds)) {
            return;
        }

        if (hakiIds.size() > MAX_HAKIS_PER_CHARACTER) {
            log.error(ExceptionMessageConstants.HAKIS_LIMIT_EXCEEDED_MESSAGE_ERROR);
            throw new HakiException(
                    ExceptionMessageConstants.HAKIS_LIMIT_EXCEEDED_CODE_ERROR,
                    ExceptionMessageConstants.HAKIS_LIMIT_EXCEEDED_MESSAGE_ERROR);
        }

        if (this.hasDuplicates(hakiIds)) {
            log.error(ExceptionMessageConstants.HAKI_CANNOT_BE_DUPLICATED_MESSAGE_ERROR);
            throw new HakiException(
                    ExceptionMessageConstants.HAKI_CANNOT_BE_DUPLICATED_CODE_ERROR,
                    ExceptionMessageConstants.HAKI_CANNOT_BE_DUPLICATED_MESSAGE_ERROR);
        }

    }

    /**
     * Validate titles.
     *
     * @param titleIds the title ids
     */
    private void validateTitles(final List<Integer> titleIds) {
        if (CollectionUtils.isNotEmpty(titleIds) && this.hasDuplicates(titleIds)) {
            log.error(ExceptionMessageConstants.TITLE_CANNOT_BE_DUPLICATED_MESSAGE_ERROR);
            throw new CharacterException(
                    ExceptionMessageConstants.TITLE_CANNOT_BE_DUPLICATED_CODE_ERROR,
                    ExceptionMessageConstants.TITLE_CANNOT_BE_DUPLICATED_MESSAGE_ERROR);
        }
    }

    /**
     * Validate jobs.
     *
     * @param jobIds the job ids
     */
    private void validateJobs(final List<Integer> jobIds) {
        if (CollectionUtils.isNotEmpty(jobIds) && this.hasDuplicates(jobIds)) {
            log.error(ExceptionMessageConstants.JOB_CANNOT_BE_DUPLICATED_MESSAGE_ERROR);
            throw new CharacterException(
                    ExceptionMessageConstants.JOB_CANNOT_BE_DUPLICATED_CODE_ERROR,
                    ExceptionMessageConstants.JOB_CANNOT_BE_DUPLICATED_MESSAGE_ERROR);
        }
    }

    /**
     * Validate swords.
     *
     * @param swordIds the sword ids
     */
    private void validateSwords(final List<Integer> swordIds) {
        if (CollectionUtils.isNotEmpty(swordIds) && this.hasDuplicates(swordIds)) {
            log.error(ExceptionMessageConstants.SWORD_CANNOT_BE_DUPLICATED_MESSAGE_ERROR);
            throw new SwordException(
                    ExceptionMessageConstants.SWORD_CANNOT_BE_DUPLICATED_CODE_ERROR,
                    ExceptionMessageConstants.SWORD_CANNOT_BE_DUPLICATED_MESSAGE_ERROR);
        }
    }

    /**
     * Validate transformations.
     *
     * @param transformationIds the transformation ids
     */
    private void validateTransformations(final List<Integer> transformationIds) {
        if (CollectionUtils.isNotEmpty(transformationIds) && this.hasDuplicates(transformationIds)) {
            log.error(ExceptionMessageConstants.TRANSFORMATION_CANNOT_BE_DUPLICATED_MESSAGE_ERROR);
            throw new CharacterException(
                    ExceptionMessageConstants.TRANSFORMATION_CANNOT_BE_DUPLICATED_CODE_ERROR,
                    ExceptionMessageConstants.TRANSFORMATION_CANNOT_BE_DUPLICATED_MESSAGE_ERROR);
        }
    }

    /**
     * Validate attacks.
     *
     * @param attackIds the attack ids
     */
    private void validateAttacks(final List<Integer> attackIds) {
        if (CollectionUtils.isNotEmpty(attackIds) && this.hasDuplicates(attackIds)) {
            log.error(ExceptionMessageConstants.ATTACK_CANNOT_BE_DUPLICATED_MESSAGE_ERROR);
            throw new CharacterException(
                    ExceptionMessageConstants.ATTACK_CANNOT_BE_DUPLICATED_CODE_ERROR,
                    ExceptionMessageConstants.ATTACK_CANNOT_BE_DUPLICATED_MESSAGE_ERROR);
        }
    }

    /**
     * Has duplicates.
     *
     * @param idList the idList
     * @return the boolean
     */
    private boolean hasDuplicates(final List<Integer> idList) {
        return new HashSet<>(idList).size() != idList.size();
    }
}
