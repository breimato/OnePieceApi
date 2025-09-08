package es.api.onepiece.adapters.outbound.persistence.mybatis.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.*;
import es.api.onepiece.adapters.outbound.persistence.entities.debut.ChapterEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.debut.EpisodeEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitTypeEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.debut.SagaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * The Interface CharacterMyBatisMapper.
 */
@Mapper
public interface CharacterMyBatisMapper {


    /**
     * Find all.
     *
     * @return the list
     */
    @Results(
        value = {
            @Result(property = "id",          column = "character_id"),
            @Result(property = "name",        column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "height",      column = "height_cm"),
            @Result(property = "age",         column = "age"),
            @Result(property = "bounty",      column = "bounty"),
            @Result(property = "image",       column = "image_url"),
            @Result(
                property = "race",
                javaType = RaceEntity.class,
                column = "race_id",
                one = @One(select = "getRaceById")
            ),
            @Result(
                property = "debut",
                javaType = DebutEntity.class,
                column = "first_appearance_id",
                one = @One(select = "getDebutById")
            ),
            @Result(
                property = "fruits",
                javaType = List.class,
                column = "character_id",
                many = @Many(select = "getFruitsByCharacterId")
            ),
            @Result(
                property = "hakis",
                javaType = List.class,
                column = "character_id",
                many = @Many(select = "getHakisByCharacterId")
            ),
            @Result(
                property = "titles",
                javaType = List.class,
                column = "character_id",
                many = @Many(select = "getTitlesByCharacterId")
            ),
            @Result(
                property = "jobs",
                javaType = List.class,
                column = "character_id",
                many = @Many(select = "getJobsByCharacterId")
            ),
            @Result(
                property = "affiliations",
                javaType = List.class,
                column = "character_id",
                many = @Many(select = "getAffiliationsByCharacterId")
            )
        }
    )
    @Select(
        """
        select
            c.character_id, c.name, c.description, c.height_cm, c.age, c.bounty,
            c.image_url, c.status_id, c.fruit_id, c.first_appearance_id, c.race_id
        from "character" c
        order by c.character_id
        """
    )
    List<CharacterEntity> findAll();


    /**
     * Gets the debut by id.
     *
     * @param chapterEpisodeId the chapter episode id
     * @return the debut by id
     */
    @Results(
        value = {
            @Result(property = "id",      column = "chapter_episode_id"),
            @Result(property = "chapter", column = "chapter_id", one = @One(select = "getChapterById")),
            @Result(property = "episode", column = "episode_id", one = @One(select = "getEpisodeById")),
            @Result(property = "saga",    column = "saga_id",    one = @One(select = "getSagaById"))
        }
    )
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
        @Result(property = "id",          column = "chapter_id"),
        @Result(property = "title",       column = "title"),
        @Result(property = "number",      column = "number"),
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
        @Result(property = "id",          column = "episode_id"),
        @Result(property = "title",       column = "title"),
        @Result(property = "number",      column = "number"),
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
        @Result(property = "id",          column = "saga_id"),
        @Result(property = "title",       column = "title"),
        @Result(property = "number",      column = "number"),
        @Result(property = "description", column = "description")
    })
    SagaEntity getSagaById(Integer sagaId);

    /**
     * Gets the race by id.
     *
     * @param raceId the race id
     * @return the race by id
     */
    @Select("select race_id, name, description from race where race_id = #{raceId}")
    @Results({
        @Result(property = "id",          column = "race_id"),
        @Result(property = "name",        column = "name"),
        @Result(property = "description", column = "description")
    })
    RaceEntity getRaceById(Integer raceId);


    /**
     * Gets the fruits by character id.
     *
     * @param characterId the character id
     * @return the fruits by character id
     */
    @Results(
        value = {
            @Result(property = "id",          column = "fruit_id"),
            @Result(property = "name",        column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "image",       column = "image_url"),
            @Result(property = "type",        column = "type_id", one = @One(select = "getFruitTypeById"))
        }
    )
    @Select(
        """
        select f.fruit_id, f.name, f.description, f.image_url, f.type_id
        from "character" c
        join fruit f on f.fruit_id = c.fruit_id
        where c.character_id = #{characterId}
        """
    )
    List<FruitEntity> getFruitsByCharacterId(Integer characterId);

    /**
     * Gets the fruit type by id.
     *
     * @param fruitTypeId the fruit type id
     * @return the fruit type by id
     */
    @Select("select id, name from fruit_type where id = #{fruitTypeId}")
    @Results({
        @Result(property = "id",   column = "id"),
        @Result(property = "type", column = "name")
    })
    FruitTypeEntity getFruitTypeById(Integer fruitTypeId);

    /**
     * Gets the hakis by character id.
     *
     * @param characterId the character id
     * @return the hakis by character id
     */
    @Results(
        value = {
            @Result(property = "id",          column = "haki_id"),
            @Result(property = "name",        column = "name"),
            @Result(property = "description", column = "description")
        }
    )
    @Select(
        """
        select h.id as haki_id, h.name, ''::text as description
        from character_haki ch
        join haki h on h.id = ch.haki_id
        where ch.character_id = #{characterId}
        """
    )
    List<HakiEntity> getHakisByCharacterId(Integer characterId);

    /**
     * Gets the titles by character id.
     *
     * @param characterId the character id
     * @return the titles by character id
     */
    @Results(
        value = {
            @Result(property = "id",        column = "title_id"),
            @Result(property = "title",     column = "title"),
            @Result(property = "isActive",  column = "is_active")
        }
    )
    @Select(
        """
        select ct.title_id, t.name as title, ct.is_active
        from character_title ct
        join title t on t.title_id = ct.title_id
        where ct.character_id = #{characterId}
        """
    )
    List<CharacterTitleEntity> getTitlesByCharacterId(Integer characterId);

    /**
     * Gets the jobs by character id.
     *
     * @param characterId the character id
     * @return the jobs by character id
     */
    @Results(
        value = {
            @Result(property = "id",          column = "job_id"),
            @Result(property = "name",        column = "name"),
            @Result(property = "description", column = "description")
        }
    )
    @Select(
        """
        select j.job_id, j.name, j.description
        from character_job cj
        join job j on j.job_id = cj.job_id
        where cj.character_id = #{characterId}
        """
    )
    List<JobEntity> getJobsByCharacterId(Integer characterId);

    /**
     * Gets the affiliations by character id.
     *
     * @param characterId the character id
     * @return the affiliations by character id
     */
    @Results(
        value = {
            @Result(property = "affiliation.id",          column = "affiliation_id"),
            @Result(property = "affiliation.name",        column = "affiliation_name"),
            @Result(property = "affiliation.description", column = "affiliation_description"),
            @Result(property = "affiliation.totalBounty", column = "affiliation_total_bounty"),
            @Result(property = "affiliation.isActive",    column = "affiliation_is_active"),
            @Result(property = "affiliation.leader",
                    column = "leader_id",
                    one = @One(select = "getCharacterLeaderById")),
            @Result(property = "status", column = "status"),
            @Result(property = "role",   column = "role")
        }
    )
    @Select(
        """
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
        """
    )
    List<CharacterAffiliationEntity> getAffiliationsByCharacterId(Integer characterId);

    /**
     * Gets the character leader by id.
     *
     * @param id the id
     * @return the character leader by id
     */
    @Select(
        """
        select
            c.character_id,
            c.name,
            c.description,
            c.height_cm as height,
            c.age,
            c.bounty,
            c.image_url as image
        from "character" c
        where c.character_id = #{id}
        """
    )
    @Results(value = {
        @Result(property = "id",          column = "character_id"),
        @Result(property = "name",        column = "name"),
        @Result(property = "description", column = "description"),
        @Result(property = "height",      column = "height"),
        @Result(property = "age",         column = "age"),
        @Result(property = "bounty",      column = "bounty"),
        @Result(property = "image",       column = "image")
    })
    BaseCharacterEntity getCharacterLeaderById(Integer id);
}
