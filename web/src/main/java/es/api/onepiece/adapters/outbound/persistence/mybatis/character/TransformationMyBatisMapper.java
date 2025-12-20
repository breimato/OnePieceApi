package es.api.onepiece.adapters.outbound.persistence.mybatis.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.TransformationEntity;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * The Interface TransformationMyBatisMapper.
 */
@Mapper
public interface TransformationMyBatisMapper {

    /**
     * Find all transformations.
     *
     * @return the list
     */
    @Result(property = "id", column = "transformation_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Result(property = "debut", column = "first_appearance_id", one = @One(select = "es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper.getDebutById"))
    @Select("""
            select t.transformation_id, t.name, t.description, t.first_appearance_id
            from transformation t
            order by t.transformation_id
            """)
    List<TransformationEntity> findAll();

    /**
     * Find transformation by id.
     *
     * @param id the id
     * @return the transformation entity
     */
    @Result(property = "id", column = "transformation_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Result(property = "debut", column = "first_appearance_id", one = @One(select = "es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper.getDebutById"))
    @Select("""
            select t.transformation_id, t.name, t.description, t.first_appearance_id
            from transformation t
            where t.transformation_id = #{id}
            """)
    TransformationEntity findById(Integer id);

    /**
     * Exists.
     *
     * @param id the id
     * @return the boolean
     */
    @Select("select count(1) > 0 from transformation where transformation_id = #{id}")
    boolean exists(Integer id);

    /**
     * Insert transformation.
     *
     * @param transformationEntity the transformation entity
     */
    @Insert("""
            insert into transformation (name, description, character_id, first_appearance_id)
            values (#{name}, #{description}, #{character.id}, #{debut.id})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "transformation_id")
    void insertTransformation(TransformationEntity transformationEntity);

    /**
     * Update transformation.
     *
     * @param transformationEntity the transformation entity
     */
    @Update("""
            <script>
            update transformation
            <set>
                <if test="name != null">name = #{name},</if>
                <if test="description != null">description = #{description},</if>
                <if test="character != null and character.id != null">character_id = #{character.id},</if>
                <if test="debut != null and debut.id != null">first_appearance_id = #{debut.id},</if>
            </set>
            where transformation_id = #{id}
            </script>
            """)
    void updateTransformation(TransformationEntity transformationEntity);

    /**
     * Delete transformation.
     *
     * @param id the transformation id
     */
    @Delete("delete from transformation where transformation_id = #{id}")
    void deleteTransformation(Integer id);

    /**
     * Delete attacks by transformation id.
     *
     * @param transformationId the transformation id
     */
    @Delete("delete from attack where transformation_id = #{transformationId}")
    void deleteAttacksByTransformationId(Integer transformationId);
}
