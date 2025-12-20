package es.api.onepiece.adapters.outbound.persistence.mybatis.sword;

import es.api.onepiece.adapters.outbound.persistence.entities.sword.SwordEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * The Interface SwordMyBatisMapper.
 */
@Mapper
public interface SwordMyBatisMapper {

        /**
         * Find all.
         *
         * @return the list
         */
        @Results(id = "SwordResultMap", value = {
                        @Result(property = "id", column = "sword_id"),
                        @Result(property = "name", column = "name"),
                        @Result(property = "description", column = "description"),
                        @Result(property = "blackSword", column = "is_black_sword"),
                        @Result(property = "status.id", column = "status_id"),
                        @Result(property = "status.name", column = "status_name"),
                        @Result(property = "category.id", column = "category_id"),
                        @Result(property = "category.name", column = "category_name"),
                        @Result(property = "debut.id", column = "first_appearance_id"),
                        @Result(property = "debut.chapter.id", column = "chapter_id"),
                        @Result(property = "debut.chapter.title", column = "chapter_title"),
                        @Result(property = "debut.chapter.number", column = "chapter_number"),
                        @Result(property = "debut.episode.id", column = "episode_id"),
                        @Result(property = "debut.episode.title", column = "episode_title"),
                        @Result(property = "debut.episode.number", column = "episode_number"),
                        @Result(property = "debut.saga.id", column = "saga_id"),
                        @Result(property = "debut.saga.title", column = "saga_title"),
                        @Result(property = "debut.saga.number", column = "saga_number")
        })
        @Select("""
                        SELECT s.sword_id, s.name, s.description, s.is_black_sword,
                               ss.id AS status_id, ss.name AS status_name,
                               sc.id AS category_id, sc.name AS category_name,
                               ce.chapter_episode_id AS first_appearance_id,
                               c.chapter_id, c.title AS chapter_title, c.number AS chapter_number,
                               e.episode_id, e.title AS episode_title, e.number AS episode_number,
                               sa.saga_id, sa.title AS saga_title, sa.number AS saga_number
                        FROM sword s
                        JOIN sword_status ss ON s.status_id = ss.id
                        LEFT JOIN sword_category sc ON s.category_id = sc.id
                        LEFT JOIN chapter_episode ce ON s.first_appearance_id = ce.chapter_episode_id
                        LEFT JOIN chapter c ON ce.chapter_id = c.chapter_id
                        LEFT JOIN episode e ON ce.episode_id = e.episode_id
                        LEFT JOIN saga sa ON ce.saga_id = sa.saga_id
                        ORDER BY s.sword_id
                        """)
        List<SwordEntity> findAll();

        /**
         * Find by id.
         *
         * @param id the id
         * @return the sword entity
         */
        @ResultMap("SwordResultMap")
        @Select("""
                        SELECT s.sword_id, s.name, s.description, s.is_black_sword,
                               ss.id AS status_id, ss.name AS status_name,
                               sc.id AS category_id, sc.name AS category_name,
                               ce.chapter_episode_id AS first_appearance_id,
                               c.chapter_id, c.title AS chapter_title, c.number AS chapter_number,
                               e.episode_id, e.title AS episode_title, e.number AS episode_number,
                               sa.saga_id, sa.title AS saga_title, sa.number AS saga_number
                        FROM sword s
                        JOIN sword_status ss ON s.status_id = ss.id
                        LEFT JOIN sword_category sc ON s.category_id = sc.id
                        LEFT JOIN chapter_episode ce ON s.first_appearance_id = ce.chapter_episode_id
                        LEFT JOIN chapter c ON ce.chapter_id = c.chapter_id
                        LEFT JOIN episode e ON ce.episode_id = e.episode_id
                        LEFT JOIN saga sa ON ce.saga_id = sa.saga_id
                        WHERE s.sword_id = #{id}
                        """)
        SwordEntity findById(@Param("id") Integer id);

        /**
         * Exists.
         *
         * @param id the id
         * @return true, if successful
         */
        @Select("SELECT EXISTS(SELECT 1 FROM sword WHERE sword_id = #{id})")
        boolean exists(@Param("id") Integer id);

        /**
         * Insert sword.
         *
         * @param swordEntity the sword entity
         */
        @Insert("""
                        INSERT INTO sword (name, description, is_black_sword, status_id, category_id, first_appearance_id)
                        VALUES (#{name}, #{description}, #{blackSword}, #{status.id}, #{category.id}, #{debut.id})
                                """)
        @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "sword_id")
        void insertSword(SwordEntity swordEntity);

        /**
         * Update sword.
         *
         * @param swordEntity the sword entity
         */
        @Update("""
                        UPDATE sword SET
                            name = COALESCE(#{name}, name),
                            description = COALESCE(#{description}, description),
                            is_black_sword = COALESCE(#{blackSword}, is_black_sword),
                            status_id = COALESCE(#{status.id}, status_id),
                            category_id = COALESCE(#{category.id}, category_id),
                            first_appearance_id = COALESCE(#{debut.id}, first_appearance_id)
                        WHERE sword_id = #{id}
                        """)
        void updateSword(SwordEntity swordEntity);

        /**
         * Delete sword.
         *
         * @param id the id
         */
        @Delete("DELETE FROM sword WHERE sword_id = #{id}")
        void deleteSword(@Param("id") Integer id);

        /**
         * Delete character swords by sword id.
         *
         * @param swordId the sword id
         */
        @Delete("DELETE FROM character_sword WHERE sword_id = #{swordId}")
        void deleteCharacterSwordsBySwordId(@Param("swordId") Integer swordId);
}
