package es.api.onepiece.adapters.outbound.persistence.mybatis.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.*;
import es.api.onepiece.adapters.outbound.persistence.entities.debut.*;
import es.api.onepiece.adapters.outbound.persistence.entities.fruit.*;
import es.api.onepiece.adapters.outbound.persistence.entities.sword.*;
import es.api.onepiece.adapters.outbound.persistence.entities.boat.*;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * The Interface CharacterMyBatisMapper.
 */
@Mapper
public interface CharacterMyBatisMapper {

    /**
     * Find all summary.
     *
     * @return the list
     */
    @Results(value = {
            @Result(property = "id", column = "character_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "height", column = "height_cm"),
            @Result(property = "age", column = "age"),
            @Result(property = "bounty", column = "bounty"),
            @Result(property = "image", column = "image_url"),
            @Result(property = "statusName", column = "status_name"),
            @Result(property = "affiliationName", column = "affiliation_name"),
            @Result(property = "fruitList", column = "character_id", many = @Many(select = "getFruitNamesByCharacterId")),
            @Result(property = "hakiList", column = "character_id", many = @Many(select = "getHakiNamesByCharacterId")),
            @Result(property = "transformationList", column = "character_id", many = @Many(select = "getTransformationNamesByCharacterId"))
    })
    @Select("""
            select
                c.character_id, c.name, c.description, c.height_cm, c.age, c.bounty,
                c.image_url,
                cs.name as status_name,
                (select a.name from character_affiliation ca join affiliation a on a.affiliation_id = ca.affiliation_id where ca.character_id = c.character_id limit 1) as affiliation_name
            from "character" c
            left join character_status cs on cs.id = c.status_id
            order by c.character_id
            """)
    List<BaseCharacterEntity> findAll();

    @Select("select name from character_status where id = #{id}")
    String getStatusNameById(Integer id);

    @Select("""
            select f.name
            from character_fruit cf
            join fruit f on f.fruit_id = cf.fruit_id
            where cf.character_id = #{characterId}
            """)
    List<String> getFruitNamesByCharacterId(Integer characterId);

    @Select("""
            select h.name
            from character_haki ch
            join haki h on h.id = ch.haki_id
            where ch.character_id = #{characterId}
            """)
    List<String> getHakiNamesByCharacterId(Integer characterId);

    @Select("""
            select t.name
            from transformation t
            where t.character_id = #{characterId}
            """)
    List<String> getTransformationNamesByCharacterId(Integer characterId);

    @Select("""
            select a.name
            from character_affiliation ca
            join affiliation a on a.affiliation_id = ca.affiliation_id
            where ca.character_id = #{characterId}
            limit 1
            """)
    String getAffiliationNameByCharacterId(Integer characterId);

    /**
     * Insert character.
     *
     * @param characterEntity the entity
     */
    @Insert("""
                insert into "character" (name, description, height_cm, age, bounty, image_url, status_id, first_appearance_id, race_id)
                values (#{name}, #{description}, #{height}, #{age}, #{bounty}, #{image}, #{status.id}, #{debut.id}, #{race.id})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "character_id")
    void insertCharacter(CharacterEntity characterEntity);

    /**
     * Insert character fruits in batch.
     *
     * @param characterId the character id
     * @param fruitIds    the fruit ids
     */
    @Insert("""
                <script>
                insert into character_fruit (character_id, fruit_id) VALUES
                <foreach collection='fruitIds' item='fruitId' separator=','>
                    (#{characterId}, #{fruitId})
                </foreach>
                </script>
            """)
    void insertFruits(@Param("characterId") Integer characterId,
            @Param("fruitIds") List<Integer> fruitIds);

    /**
     * Insert character hakis in batch.
     *
     * @param characterId the character id
     * @param hakiIds     the haki ids
     */
    @Insert("""
                <script>
                insert into character_haki (character_id, haki_id) VALUES
                <foreach collection='hakiIds' item='hakiId' separator=','>
                    (#{characterId}, #{hakiId})
                </foreach>
                </script>
            """)
    void insertHakis(@Param("characterId") Integer characterId,
            @Param("hakiIds") List<Integer> hakiIds);

    /**
     * Gets the character by id.
     *
     * @param id the id
     * @return the character by id
     */
    @Result(property = "id", column = "character_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Result(property = "height", column = "height_cm")
    @Result(property = "age", column = "age")
    @Result(property = "statusName", column = "status_name")
    @Result(property = "affiliationName", column = "affiliation_name")
    @Result(property = "bounty", column = "bounty")
    @Result(property = "image", column = "image_url")
    @Result(property = "status", column = "status_id", one = @One(select = "getStatusById"))
    @Result(property = "race", javaType = RaceEntity.class, column = "race_id", one = @One(select = "getRaceById"))
    @Result(property = "debut", javaType = DebutEntity.class, column = "first_appearance_id", one = @One(select = "getDebutById"))
    @Result(property = "fruits", javaType = List.class, column = "character_id", many = @Many(select = "getFruitsByCharacterId"))
    @Result(property = "hakis", javaType = List.class, column = "character_id", many = @Many(select = "getHakisByCharacterId"))
    @Result(property = "titles", javaType = List.class, column = "character_id", many = @Many(select = "getTitlesByCharacterId"))
    @Result(property = "jobs", javaType = List.class, column = "character_id", many = @Many(select = "getJobsByCharacterId"))
    @Result(property = "affiliations", javaType = List.class, column = "character_id", many = @Many(select = "getAffiliationsByCharacterId"))
    @Result(property = "swords", javaType = List.class, column = "character_id", many = @Many(select = "getSwordsByCharacterId"))
    @Result(property = "transformations", javaType = List.class, column = "character_id", many = @Many(select = "getTransformationsByCharacterId"))
    @Result(property = "attacks", javaType = List.class, column = "character_id", many = @Many(select = "getAttacksByCharacterId"))
    @Select("""
            select
                c.character_id, c.name, c.description, c.height_cm, c.age, c.bounty,
                c.image_url, c.status_id, c.first_appearance_id, c.race_id,
                cs.name as status_name,
                (select a.name from character_affiliation ca join affiliation a on a.affiliation_id = ca.affiliation_id where ca.character_id = c.character_id limit 1) as affiliation_name
            from "character" c
            left join character_status cs on cs.id = c.status_id
            where c.character_id = #{id}
            """)
    CharacterEntity getCharacterById(Integer id);

    /**
     * Gets the debut by id.
     *
     * @param chapterEpisodeId the chapter episode id
     * @return the debut by id
     */
    @Result(property = "id", column = "chapter_episode_id")
    @Result(property = "chapter", column = "chapter_id", one = @One(select = "getChapterById"))
    @Result(property = "episode", column = "episode_id", one = @One(select = "getEpisodeById"))
    @Result(property = "saga", column = "saga_id", one = @One(select = "getSagaById"))
    @Select("select chapter_episode_id, chapter_id, episode_id, saga_id from chapter_episode " +
            "where chapter_episode_id = #{chapterEpisodeId}")
    DebutEntity getDebutById(Integer chapterEpisodeId);

    /**
     * Gets the chapter by id.
     *
     * @param chapterId the chapter id
     * @return the chapter by id
     */
    @Select("select chapter_id, title, number, description from chapter where chapter_id = #{chapterId}")
    @Results({
            @Result(property = "id", column = "chapter_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "number", column = "number"),
            @Result(property = "description", column = "description")
    })
    ChapterEntity getChapterById(Integer chapterId);

    /**
     * Gets the episode by id.
     *
     * @param episodeId the episode id
     * @return the episode by id
     */
    @Select("select episode_id, title, number, description from episode where episode_id = #{episodeId}")
    @Results({
            @Result(property = "id", column = "episode_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "number", column = "number"),
            @Result(property = "description", column = "description")
    })
    EpisodeEntity getEpisodeById(Integer episodeId);

    /**
     * Gets the saga by id.
     *
     * @param sagaId the saga id
     * @return the saga by id
     */
    @Select("select saga_id, title, number, description from saga where saga_id = #{sagaId}")
    @Results({
            @Result(property = "id", column = "saga_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "number", column = "number"),
            @Result(property = "description", column = "description")
    })
    SagaEntity getSagaById(Integer sagaId);

    /**
     * Gets the race by id.
     *
     * @param raceId the race id
     * @return the race by id
     */
    @Result(property = "id", column = "race_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Select("select race_id, name, description from race where race_id = #{raceId}")
    RaceEntity getRaceById(Integer raceId);

    @Result(property = "id", column = "id")
    @Result(property = "status", column = "status")
    @Select("select id, name as status from character_status where id = #{id}")
    CharacterStatusEntity getStatusById(Integer id);

    /**
     * Gets the fruits by character id.
     *
     * @param characterId the character id
     * @return the fruits by character id
     */
    @Result(property = "id", column = "fruit_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Result(property = "image", column = "image_url")
    @Result(property = "type", column = "type_id", one = @One(select = "getFruitTypeById"))
    @Select("""
            select f.fruit_id, f.name, f.description, f.image_url, f.type_id
            from character_fruit cf
            join fruit f on f.fruit_id = cf.fruit_id
            where cf.character_id = #{characterId}
            """)
    List<FruitEntity> getFruitsByCharacterId(Integer characterId);

    /**
     * Gets the fruit type by id.
     *
     * @param fruitTypeId the fruit type id
     * @return the fruit type by id
     */
    @Result(property = "id", column = "id")
    @Result(property = "type", column = "name")
    @Select("select id, name from fruit_type where id = #{fruitTypeId}")
    FruitTypeEntity getFruitTypeById(Integer fruitTypeId);

    /**
     * Gets the hakis by character id.
     *
     * @param characterId the character id
     * @return the hakis by character id
     */
    @Result(property = "id", column = "haki_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Select("""
                select h.id as haki_id, h.name, h.description
                from character_haki ch
                join haki h on h.id = ch.haki_id
                where ch.character_id = #{characterId}
            """)
    List<HakiEntity> getHakisByCharacterId(Integer characterId);

    /**
     * Gets the titles by character id.
     *
     * @param characterId the character id
     * @return the titles by character id
     */
    @Result(property = "id", column = "title_id")
    @Result(property = "title", column = "title")
    @Result(property = "isActive", column = "is_active")
    @Select("""
                select ct.title_id, t.name as title, ct.is_active
                from character_title ct
                join title t on t.title_id = ct.title_id
                where ct.character_id = #{characterId}
            """)
    List<CharacterTitleEntity> getTitlesByCharacterId(Integer characterId);

    /**
     * Gets the jobs by character id.
     *
     * @param characterId the character id
     * @return the jobs by character id
     */

    @Result(property = "id", column = "job_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")

    @Select("""
            select j.job_id, j.name, j.description
            from character_job cj
            join job j on j.job_id = cj.job_id
            where cj.character_id = #{characterId}
            """)
    List<JobEntity> getJobsByCharacterId(Integer characterId);

    /**
     * Gets the swords by character id.
     *
     * @param characterId the character id
     * @return the swords by character id
     */

    @Result(property = "id", column = "sword_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Result(property = "blackSword", column = "is_black_sword")
    @Result(property = "swordStatus", column = "status_name")
    @Result(property = "category", column = "category_id", one = @One(select = "getSwordCategoryById"))
    @Result(property = "debut", column = "first_appearance_id", one = @One(select = "getDebutById"))

    @Select("""
            select s.sword_id as sword_id, s.name, s.description, s.is_black_sword, ss.name as status_name, s.category_id, s.first_appearance_id
            from character_sword cs
            join sword s on s.sword_id = cs.sword_id
            join sword_status ss on ss.id = s.status_id
            where cs.character_id = #{characterId}
            """)
    List<SwordEntity> getSwordsByCharacterId(Integer characterId);

    /**
     * Gets the sword category by id.
     *
     * @param categoryId the category id
     * @return the sword category by id
     */
    @Select("select id, name from sword_category where id = #{categoryId}")
    @Result(property = "id", column = "id")
    @Result(property = "name", column = "name")
    SwordCategoryEntity getSwordCategoryById(Integer categoryId);

    /**
     * Gets the transformations by character id.
     *
     * @param characterId the character id
     * @return the transformations by character id
     */

    @Result(property = "id", column = "transformation_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Result(property = "debut", column = "first_appearance_id", one = @One(select = "getDebutById"))

    @Select("""
            select t.transformation_id as transformation_id, t.name, t.description, t.first_appearance_id
            from transformation t
            where t.character_id = #{characterId}
            """)
    List<TransformationEntity> getTransformationsByCharacterId(Integer characterId);

    /**
     * Gets the attacks by character id.
     *
     * @param characterId the character id
     * @return the attacks by character id
     */

    @Result(property = "id", column = "attack_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Result(property = "debut", column = "first_appearance_id", one = @One(select = "getDebutById"))
    @Result(property = "character", column = "character_id", one = @One(select = "getAttackOwnerById"))
    @Result(property = "transformation", column = "transformation_id", one = @One(select = "getTransformationById"))

    @Select("""
            select a.attack_id as attack_id, a.name, a.description, a.first_appearance_id, a.transformation_id, a.character_id
            from attack a
            where a.character_id = #{characterId}
            """)
    List<AttackEntity> getAttacksByCharacterId(Integer characterId);

    /**
     * Gets the transformation by id.
     *
     * @param id the id
     * @return the transformation by id
     */
    @Select("select transformation_id as transformation_id, name, description, character_id, first_appearance_id from transformation where transformation_id = #{id}")

    @Result(property = "id", column = "transformation_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Result(property = "debut", column = "first_appearance_id", one = @One(select = "getDebutById"))
    TransformationEntity getTransformationById(Integer id);

    /**
     * Gets the affiliations by character id.
     *
     * @param characterId the character id
     * @return the affiliations by character id
     */

    @Result(property = "id", column = "affiliation_id")
    @Result(property = "name", column = "affiliation_name")
    @Result(property = "description", column = "affiliation_description")
    @Result(property = "totalBounty", column = "affiliation_total_bounty")
    @Result(property = "isActive", column = "affiliation_is_active")
    @Result(property = "leader", column = "leader_id", one = @One(select = "getCharacterLeaderById"))
    @Result(property = "boats", column = "affiliation_id", many = @Many(select = "getBoatsByAffiliationId"))
    @Result(property = "status", column = "status")
    @Result(property = "role", column = "role")
    @Select("""
            select
                ca.affiliation_id,
                cas.name as status,
                r.name as role,
                a.name  as affiliation_name,
                a.description as affiliation_description,
                a.total_bounty as affiliation_total_bounty,
                a.is_active as affiliation_is_active,
                a.leader_id as leader_id
            from character_affiliation ca
            join affiliation a on a.affiliation_id = ca.affiliation_id
            join character_affiliation_status cas on cas.id = ca.status_id
            left join role r on r.id = ca.role_id
            where ca.character_id = #{characterId}
            """)
    List<AffiliationEntity> getAffiliationsByCharacterId(Integer characterId);

    /**
     * Gets the boats by affiliation id.
     *
     * @param affiliationId the affiliation id
     * @return the boats by affiliation id
     */

    @Result(property = "id", column = "boat_id")
    @Result(property = "name", column = "name")
    @Result(property = "isAlive", column = "is_alive")
    @Result(property = "boatType", column = "type_name")
    @Result(property = "debut", column = "first_appearance_id", one = @One(select = "getDebutById"))

    @Select("""
            select b.boat_id as boat_id, b.name, b.is_alive, bt.name as type_name, b.first_appearance_id
            from boat b
            left join boat_type bt on bt.id = b.type_id
            where b.affiliation_id = #{affiliationId}
            """)
    List<BoatEntity> getBoatsByAffiliationId(Integer affiliationId);

    /**
     * Gets the character leader by id.
     *
     * @param id the id
     * @return the character leader by id
     */
    @Select("""
            select
                c.character_id,
                c.name,
                c.description,
                c.height_cm as height,
                c.age,
                c.bounty,
                c.image_url as image
            from character c
            where c.character_id = #{id}
            """)

    @Result(property = "id", column = "character_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Result(property = "height", column = "height")
    @Result(property = "age", column = "age")
    @Result(property = "bounty", column = "bounty")
    @Result(property = "image", column = "image")
    BaseCharacterEntity getCharacterLeaderById(Integer id);

    /**
     * Gets the attack owner by id.
     *
     * @param id the id
     * @return the attack owner by id
     */
    @Result(property = "id", column = "character_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Result(property = "height", column = "height_cm")
    @Result(property = "age", column = "age")
    @Result(property = "bounty", column = "bounty")
    @Result(property = "image", column = "image_url")

    @Select("""
            select
                c.character_id, c.name, c.description, c.height_cm, c.age, c.bounty,
                c.image_url
            from "character" c
            where c.character_id = #{id}
            """)
    List<BaseCharacterEntity> getAttackOwnerById(Integer id);
}
