package es.api.onepiece.adapters.outbound.persistence.repository.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.CharacterEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.CharacterMapper;
import es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper;
import es.api.onepiece.core.exceptions.CharacterException;
import es.api.onepiece.core.exceptions.FruitException;
import es.api.onepiece.core.exceptions.HakiException;
import es.api.onepiece.core.exceptions.SwordException;
import es.api.onepiece.core.internal.domain.character.Character;
import es.api.onepiece.core.internal.vo.character.UpdateCharacterVo;
import es.api.onepiece.core.ports.outbound.character.FindCharactersPersistencePort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Collections;

import static es.api.onepiece.core.exceptions.constants.ExceptionMessageConstants.*;
import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The Class CharacterUpdateRepositoryTest.
 */
@ExtendWith(MockitoExtension.class)
class CharacterUpdateRepositoryTest {

        /** The character my batis mapper. */
        @Mock
        CharacterMyBatisMapper characterMyBatisMapper;

        /** The character mapper. */
        @Mock
        CharacterMapper characterMapper;

        /** The find character persistence port. */
        @Mock
        FindCharactersPersistencePort findCharacterPersistencePort;

        /** The character update repository. */
        @InjectMocks
        CharacterUpdateRepository characterUpdateRepository;

        /**
         * Test execute when vo has all fields then updates character and relations.
         */
        @Test
        void testExecute_whenVoHasAllFields_thenUpdatesCharacterAndRelations() {

                // Given
                final var updateCharacterVo = Instancio.create(UpdateCharacterVo.class);
                final var characterEntity = Instancio.create(CharacterEntity.class);
                final var updatedCharacterEntity = Instancio.create(CharacterEntity.class);
                final var character = Instancio.create(Character.class);
                final var characterId = updateCharacterVo.getId();

                // When
                when(this.characterMapper.toCharacterEntityFromUpdateVo(updateCharacterVo)).thenReturn(characterEntity);
                when(this.findCharacterPersistencePort.exists(characterId)).thenReturn(true);
                when(this.characterMyBatisMapper.getCharacterById(characterId)).thenReturn(updatedCharacterEntity);
                when(this.characterMapper.toCharacter(updatedCharacterEntity)).thenReturn(character);

                final var result = this.characterUpdateRepository.execute(updateCharacterVo);

                // Then
                verify(this.findCharacterPersistencePort, times(1)).exists(characterId);
                verify(this.characterMyBatisMapper, times(1)).updateCharacter(characterEntity);

                verify(this.characterMyBatisMapper, times(1)).deleteFruitsByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(1)).insertFruits(characterId,
                                updateCharacterVo.getFruitIds());

                verify(this.characterMyBatisMapper, times(1)).deleteHakisByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(1)).insertHakis(characterId, updateCharacterVo.getHakiIds());

                verify(this.characterMyBatisMapper, times(1)).deleteTitlesByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(1)).insertTitles(characterId,
                                updateCharacterVo.getTitleIds());

                verify(this.characterMyBatisMapper, times(1)).deleteJobsByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(1)).insertJobs(characterId, updateCharacterVo.getJobIds());

                verify(this.characterMyBatisMapper, times(1)).deleteAffiliationsByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(1)).insertAffiliations(characterId,
                                updateCharacterVo.getCharacterAffiliations());

                verify(this.characterMyBatisMapper, times(1)).deleteSwordsByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(1)).insertSwords(characterId,
                                updateCharacterVo.getSwordIds());

                verify(this.characterMyBatisMapper, times(1)).deleteTransformationsByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(1)).insertTransformations(characterId,
                                updateCharacterVo.getTransformationIds());

                verify(this.characterMyBatisMapper, times(1)).deleteAttacksByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(1)).insertAttacks(characterId,
                                updateCharacterVo.getAttackIds());

                assertNotNull(result);
                assertEquals(character, result);
        }

        /**
         * Test execute when partial update then success.
         */
        @Test
        void testExecute_whenPartialUpdate_thenSuccess() {

                // Given
                final var updateCharacterVo = Instancio.of(UpdateCharacterVo.class)
                                .ignore(field(UpdateCharacterVo::getFruitIds))
                                .ignore(field(UpdateCharacterVo::getHakiIds))
                                .ignore(field(UpdateCharacterVo::getTitleIds))
                                .ignore(field(UpdateCharacterVo::getJobIds))
                                .ignore(field(UpdateCharacterVo::getCharacterAffiliations))
                                .ignore(field(UpdateCharacterVo::getSwordIds))
                                .ignore(field(UpdateCharacterVo::getTransformationIds))
                                .ignore(field(UpdateCharacterVo::getAttackIds))
                                .create();

                final var characterEntity = Instancio.create(CharacterEntity.class);
                final var updatedCharacterEntity = Instancio.create(CharacterEntity.class);
                final var character = Instancio.create(Character.class);
                final var characterId = updateCharacterVo.getId();

                // When
                when(this.characterMapper.toCharacterEntityFromUpdateVo(updateCharacterVo)).thenReturn(characterEntity);
                when(this.findCharacterPersistencePort.exists(characterId)).thenReturn(true);
                when(this.characterMyBatisMapper.getCharacterById(characterId)).thenReturn(updatedCharacterEntity);
                when(this.characterMapper.toCharacter(updatedCharacterEntity)).thenReturn(character);

                final var result = this.characterUpdateRepository.execute(updateCharacterVo);

                // Then
                verify(this.findCharacterPersistencePort, times(1)).exists(characterId);
                verify(this.characterMyBatisMapper, times(1)).updateCharacter(characterEntity);

                verify(this.characterMyBatisMapper, times(0)).deleteFruitsByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(0)).insertFruits(characterId,
                                updateCharacterVo.getFruitIds());

                verify(this.characterMyBatisMapper, times(0)).deleteHakisByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(0)).insertHakis(characterId, updateCharacterVo.getHakiIds());

                verify(this.characterMyBatisMapper, times(0)).deleteTitlesByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(0)).insertTitles(characterId,
                                updateCharacterVo.getTitleIds());

                verify(this.characterMyBatisMapper, times(0)).deleteJobsByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(0)).insertJobs(characterId, updateCharacterVo.getJobIds());

                verify(this.characterMyBatisMapper, times(0)).deleteAffiliationsByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(0)).insertAffiliations(characterId,
                                updateCharacterVo.getCharacterAffiliations());

                verify(this.characterMyBatisMapper, times(0)).deleteSwordsByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(0)).insertSwords(characterId,
                                updateCharacterVo.getSwordIds());

                verify(this.characterMyBatisMapper, times(0)).deleteTransformationsByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(0)).insertTransformations(characterId,
                                updateCharacterVo.getTransformationIds());

                verify(this.characterMyBatisMapper, times(0)).deleteAttacksByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(0)).insertAttacks(characterId,
                                updateCharacterVo.getAttackIds());

                assertNotNull(result);
                assertEquals(character, result);
        }

        /**
         * Test execute when update with empty relations then success.
         */
        @Test
        void testExecute_whenUpdateWithEmptyRelations_thenSuccess() {

                // Given
                final var updateCharacterVo = Instancio.create(UpdateCharacterVo.class);
                updateCharacterVo.setFruitIds(Collections.emptyList());
                updateCharacterVo.setHakiIds(Collections.emptyList());
                updateCharacterVo.setTitleIds(Collections.emptyList());
                updateCharacterVo.setJobIds(Collections.emptyList());
                updateCharacterVo.setCharacterAffiliations(Collections.emptyList());
                updateCharacterVo.setSwordIds(Collections.emptyList());
                updateCharacterVo.setTransformationIds(Collections.emptyList());
                updateCharacterVo.setAttackIds(Collections.emptyList());

                final var characterEntity = Instancio.create(CharacterEntity.class);
                final var updatedCharacterEntity = Instancio.create(CharacterEntity.class);
                final var character = Instancio.create(Character.class);
                final var characterId = updateCharacterVo.getId();

                // When
                when(this.characterMapper.toCharacterEntityFromUpdateVo(updateCharacterVo)).thenReturn(characterEntity);
                when(this.findCharacterPersistencePort.exists(characterId)).thenReturn(true);
                when(this.characterMyBatisMapper.getCharacterById(characterId)).thenReturn(updatedCharacterEntity);
                when(this.characterMapper.toCharacter(updatedCharacterEntity)).thenReturn(character);

                final var result = this.characterUpdateRepository.execute(updateCharacterVo);

                // Then
                verify(this.findCharacterPersistencePort, times(1)).exists(characterId);
                verify(this.characterMyBatisMapper, times(1)).updateCharacter(characterEntity);

                verify(this.characterMyBatisMapper, times(1)).deleteFruitsByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(0)).insertFruits(characterId,
                                updateCharacterVo.getFruitIds());

                verify(this.characterMyBatisMapper, times(1)).deleteHakisByCharacterId(characterId);
                verify(this.characterMyBatisMapper, times(0)).insertHakis(characterId, updateCharacterVo.getHakiIds());

                assertNotNull(result);
                assertEquals(character, result);
        }

        /**
         * Test execute when character not found then throw character exception.
         */
        @Test
        void testExecute_whenCharacterNotFound_thenThrowCharacterException() {

                // Given
                final var updateCharacterVo = Instancio.create(UpdateCharacterVo.class);
                final var characterEntity = Instancio.create(CharacterEntity.class);
                final var characterId = updateCharacterVo.getId();

                // When
                when(this.characterMapper.toCharacterEntityFromUpdateVo(updateCharacterVo)).thenReturn(characterEntity);
                when(this.findCharacterPersistencePort.exists(characterId)).thenReturn(false);

                // Then
                final var exception = assertThrows(CharacterException.class,
                                () -> this.characterUpdateRepository.execute(updateCharacterVo));

                verify(this.findCharacterPersistencePort, times(1)).exists(characterId);
                verify(this.characterMyBatisMapper, times(0)).updateCharacter(characterEntity);

                assertEquals(CHARACTER_NOT_FOUND_CODE_ERROR, exception.getCode());
                assertEquals(CHARACTER_NOT_FOUND_MESSAGE_ERROR, exception.getMessage());
        }

        /**
         * Test execute when fruits update fails then throw fruit exception.
         */
        @Test
        void testExecute_whenFruitsUpdateFails_thenThrowFruitException() {

                // Given
                final var updateCharacterVo = Instancio.create(UpdateCharacterVo.class);
                final var characterEntity = Instancio.create(CharacterEntity.class);
                final var characterId = updateCharacterVo.getId();

                // When
                when(this.characterMapper.toCharacterEntityFromUpdateVo(updateCharacterVo)).thenReturn(characterEntity);
                when(this.findCharacterPersistencePort.exists(characterId)).thenReturn(true);
                doThrow(new DataIntegrityViolationException(FRUIT_UPDATE_MESSAGE_ERROR))
                                .when(this.characterMyBatisMapper).deleteFruitsByCharacterId(characterId);

                // Then
                final var exception = assertThrows(FruitException.class,
                                () -> this.characterUpdateRepository.execute(updateCharacterVo));

                assertEquals(FRUIT_UPDATE_CODE_ERROR, exception.getCode());
                assertEquals(FRUIT_UPDATE_MESSAGE_ERROR, exception.getMessage());
        }

        /**
         * Test execute when hakis update fails then throw haki exception.
         */
        @Test
        void testExecute_whenHakisUpdateFails_thenThrowHakiException() {

                // Given
                final var updateCharacterVo = Instancio.of(UpdateCharacterVo.class)
                                .ignore(field(UpdateCharacterVo::getFruitIds))
                                .create();
                final var characterEntity = Instancio.create(CharacterEntity.class);
                final var characterId = updateCharacterVo.getId();

                // When
                when(this.characterMapper.toCharacterEntityFromUpdateVo(updateCharacterVo)).thenReturn(characterEntity);
                when(this.findCharacterPersistencePort.exists(characterId)).thenReturn(true);
                doThrow(new DataIntegrityViolationException(HAKI_UPDATE_MESSAGE_ERROR))
                                .when(this.characterMyBatisMapper).deleteHakisByCharacterId(characterId);

                // Then
                final var exception = assertThrows(HakiException.class,
                                () -> this.characterUpdateRepository.execute(updateCharacterVo));

                assertEquals(HAKI_UPDATE_CODE_ERROR, exception.getCode());
                assertEquals(HAKI_UPDATE_MESSAGE_ERROR, exception.getMessage());
        }

        /**
         * Test execute when titles update fails then throw character exception.
         */
        @Test
        void testExecute_whenTitlesUpdateFails_thenThrowCharacterException() {

                // Given
                final var updateCharacterVo = Instancio.of(UpdateCharacterVo.class)
                                .ignore(field(UpdateCharacterVo::getFruitIds))
                                .ignore(field(UpdateCharacterVo::getHakiIds))
                                .create();
                final var characterEntity = Instancio.create(CharacterEntity.class);
                final var characterId = updateCharacterVo.getId();

                // When
                when(this.characterMapper.toCharacterEntityFromUpdateVo(updateCharacterVo)).thenReturn(characterEntity);
                when(this.findCharacterPersistencePort.exists(characterId)).thenReturn(true);
                doThrow(new DataIntegrityViolationException(TITLE_UPDATE_MESSAGE_ERROR))
                                .when(this.characterMyBatisMapper).deleteTitlesByCharacterId(characterId);

                // Then
                final var exception = assertThrows(CharacterException.class,
                                () -> this.characterUpdateRepository.execute(updateCharacterVo));

                assertEquals(TITLE_UPDATE_CODE_ERROR, exception.getCode());
                assertEquals(TITLE_UPDATE_MESSAGE_ERROR, exception.getMessage());
        }

        /**
         * Test execute when jobs update fails then throw character exception.
         */
        @Test
        void testExecute_whenJobsUpdateFails_thenThrowCharacterException() {

                // Given
                final var updateCharacterVo = Instancio.of(UpdateCharacterVo.class)
                                .ignore(field(UpdateCharacterVo::getFruitIds))
                                .ignore(field(UpdateCharacterVo::getHakiIds))
                                .ignore(field(UpdateCharacterVo::getTitleIds))
                                .create();
                final var characterEntity = Instancio.create(CharacterEntity.class);
                final var characterId = updateCharacterVo.getId();

                // When
                when(this.characterMapper.toCharacterEntityFromUpdateVo(updateCharacterVo)).thenReturn(characterEntity);
                when(this.findCharacterPersistencePort.exists(characterId)).thenReturn(true);
                doThrow(new DataIntegrityViolationException(JOB_UPDATE_MESSAGE_ERROR))
                                .when(this.characterMyBatisMapper).deleteJobsByCharacterId(characterId);

                // Then
                final var exception = assertThrows(CharacterException.class,
                                () -> this.characterUpdateRepository.execute(updateCharacterVo));

                assertEquals(JOB_UPDATE_CODE_ERROR, exception.getCode());
                assertEquals(JOB_UPDATE_MESSAGE_ERROR, exception.getMessage());
        }

        /**
         * Test execute when affiliations update fails then throw character exception.
         */
        @Test
        void testExecute_whenAffiliationsUpdateFails_thenThrowCharacterException() {

                // Given
                final var updateCharacterVo = Instancio.of(UpdateCharacterVo.class)
                                .ignore(field(UpdateCharacterVo::getFruitIds))
                                .ignore(field(UpdateCharacterVo::getHakiIds))
                                .ignore(field(UpdateCharacterVo::getTitleIds))
                                .ignore(field(UpdateCharacterVo::getJobIds))
                                .create();
                final var characterEntity = Instancio.create(CharacterEntity.class);
                final var characterId = updateCharacterVo.getId();

                // When
                when(this.characterMapper.toCharacterEntityFromUpdateVo(updateCharacterVo)).thenReturn(characterEntity);
                when(this.findCharacterPersistencePort.exists(characterId)).thenReturn(true);
                doThrow(new DataIntegrityViolationException(AFFILIATION_UPDATE_MESSAGE_ERROR))
                                .when(this.characterMyBatisMapper).deleteAffiliationsByCharacterId(characterId);

                // Then
                final var exception = assertThrows(CharacterException.class,
                                () -> this.characterUpdateRepository.execute(updateCharacterVo));

                assertEquals(AFFILIATION_UPDATE_CODE_ERROR, exception.getCode());
                assertEquals(AFFILIATION_UPDATE_MESSAGE_ERROR, exception.getMessage());
        }

        /**
         * Test execute when swords update fails then throw sword exception.
         */
        @Test
        void testExecute_whenSwordsUpdateFails_thenThrowSwordException() {

                // Given
                final var updateCharacterVo = Instancio.of(UpdateCharacterVo.class)
                                .ignore(field(UpdateCharacterVo::getFruitIds))
                                .ignore(field(UpdateCharacterVo::getHakiIds))
                                .ignore(field(UpdateCharacterVo::getTitleIds))
                                .ignore(field(UpdateCharacterVo::getJobIds))
                                .ignore(field(UpdateCharacterVo::getCharacterAffiliations))
                                .create();
                final var characterEntity = Instancio.create(CharacterEntity.class);
                final var characterId = updateCharacterVo.getId();

                // When
                when(this.characterMapper.toCharacterEntityFromUpdateVo(updateCharacterVo)).thenReturn(characterEntity);
                when(this.findCharacterPersistencePort.exists(characterId)).thenReturn(true);
                doThrow(new DataIntegrityViolationException(SWORD_UPDATE_MESSAGE_ERROR))
                                .when(this.characterMyBatisMapper).deleteSwordsByCharacterId(characterId);

                // Then
                final var exception = assertThrows(SwordException.class,
                                () -> this.characterUpdateRepository.execute(updateCharacterVo));

                assertEquals(SWORD_UPDATE_CODE_ERROR, exception.getCode());
                assertEquals(SWORD_UPDATE_MESSAGE_ERROR, exception.getMessage());
        }

        /**
         * Test execute when attacks update fails then throw character exception.
         */
        @Test
        void testExecute_whenAttacksUpdateFails_thenThrowCharacterException() {

                // Given
                final var updateCharacterVo = Instancio.of(UpdateCharacterVo.class)
                                .ignore(field(UpdateCharacterVo::getFruitIds))
                                .ignore(field(UpdateCharacterVo::getHakiIds))
                                .ignore(field(UpdateCharacterVo::getTitleIds))
                                .ignore(field(UpdateCharacterVo::getJobIds))
                                .ignore(field(UpdateCharacterVo::getCharacterAffiliations))
                                .ignore(field(UpdateCharacterVo::getSwordIds))
                                .create();
                final var characterEntity = Instancio.create(CharacterEntity.class);
                final var characterId = updateCharacterVo.getId();

                // When
                when(this.characterMapper.toCharacterEntityFromUpdateVo(updateCharacterVo)).thenReturn(characterEntity);
                when(this.findCharacterPersistencePort.exists(characterId)).thenReturn(true);
                doThrow(new DataIntegrityViolationException(ATTACK_UPDATE_MESSAGE_ERROR))
                                .when(this.characterMyBatisMapper).deleteAttacksByCharacterId(characterId);

                // Then
                final var exception = assertThrows(CharacterException.class,
                                () -> this.characterUpdateRepository.execute(updateCharacterVo));

                assertEquals(ATTACK_UPDATE_CODE_ERROR, exception.getCode());
                assertEquals(ATTACK_UPDATE_MESSAGE_ERROR, exception.getMessage());
        }

        /**
         * Test execute when transformations update fails then throw character
         * exception.
         */
        @Test
        void testExecute_whenTransformationsUpdateFails_thenThrowCharacterException() {

                // Given
                final var updateCharacterVo = Instancio.of(UpdateCharacterVo.class)
                                .ignore(field(UpdateCharacterVo::getFruitIds))
                                .ignore(field(UpdateCharacterVo::getHakiIds))
                                .ignore(field(UpdateCharacterVo::getTitleIds))
                                .ignore(field(UpdateCharacterVo::getJobIds))
                                .ignore(field(UpdateCharacterVo::getCharacterAffiliations))
                                .ignore(field(UpdateCharacterVo::getSwordIds))
                                .ignore(field(UpdateCharacterVo::getAttackIds))
                                .create();
                final var characterEntity = Instancio.create(CharacterEntity.class);
                final var characterId = updateCharacterVo.getId();

                // When
                when(this.characterMapper.toCharacterEntityFromUpdateVo(updateCharacterVo)).thenReturn(characterEntity);
                when(this.findCharacterPersistencePort.exists(characterId)).thenReturn(true);
                doThrow(new DataIntegrityViolationException(TRANSFORMATION_UPDATE_MESSAGE_ERROR))
                                .when(this.characterMyBatisMapper).deleteTransformationsByCharacterId(characterId);

                // Then
                final var exception = assertThrows(CharacterException.class,
                                () -> this.characterUpdateRepository.execute(updateCharacterVo));

                assertEquals(TRANSFORMATION_UPDATE_CODE_ERROR, exception.getCode());
                assertEquals(TRANSFORMATION_UPDATE_MESSAGE_ERROR, exception.getMessage());
        }
}
