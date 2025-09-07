package es.api.onepiece.adapters.outbound.persistence.mybatis.character;

import es.api.onepiece.adapters.outbound.persistence.entities.CharacterEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.ChapterEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.DebutEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.EpisodeEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.FruitEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.FruitTypeEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.SagaEntity;
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
            )
        }
    )
    @Select(
        """
        select
            c.character_id, c.name, c.description, c.height_cm, c.age, c.bounty, c.image_url, c.status_id, c.fruit_id, c.first_appearance_id
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
    @Select("select chapter_episode_id, chapter_id, episode_id, saga_id from chapter_episode where chapter_episode_id = #{chapterEpisodeId}")
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
}
