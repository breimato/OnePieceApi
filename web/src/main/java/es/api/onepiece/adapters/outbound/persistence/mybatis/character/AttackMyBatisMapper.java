package es.api.onepiece.adapters.outbound.persistence.mybatis.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.AttackEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * The Interface AttackMyBatisMapper.
 */
@Mapper
public interface AttackMyBatisMapper {

    /**
     * Find all attacks.
     *
     * @return the list
     */
    @Result(property = "id", column = "attack_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Result(property = "debut", column = "first_appearance_id", one = @One(select = "es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper.getDebutById"))
    @Result(property = "character", column = "character_id", one = @One(select = "es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper.getCharacterSummaryById"))
    @Result(property = "transformation", column = "transformation_id", one = @One(select = "es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper.getTransformationById"))
    @Select("""
            select a.attack_id, a.name, a.description, a.first_appearance_id, a.character_id, a.transformation_id
            from attack a
            order by a.attack_id
            """)
    List<AttackEntity> findAll();

    /**
     * Find attack by id.
     *
     * @param id the id
     * @return the attack entity
     */
    @Result(property = "id", column = "attack_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Result(property = "debut", column = "first_appearance_id", one = @One(select = "es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper.getDebutById"))
    @Result(property = "character", column = "character_id", one = @One(select = "es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper.getCharacterSummaryById"))
    @Result(property = "transformation", column = "transformation_id", one = @One(select = "es.api.onepiece.adapters.outbound.persistence.mybatis.character.CharacterMyBatisMapper.getTransformationById"))
    @Select("""
            select a.attack_id, a.name, a.description, a.first_appearance_id, a.character_id, a.transformation_id
            from attack a
            where a.attack_id = #{id}
            """)
    AttackEntity findById(Integer id);

    /**
     * Exists.
     *
     * @param id the id
     * @return the boolean
     */
    @Select("select count(1) > 0 from attack where attack_id = #{id}")
    boolean exists(Integer id);

    /**
     * Insert attack.
     *
     * @param attackEntity the attack entity
     */
    @Insert("""
            insert into attack (name, description, first_appearance_id, character_id, transformation_id)
            values (#{name}, #{description}, #{debut.id}, #{character.id}, #{transformation.id})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "attack_id")
    void insertAttack(AttackEntity attackEntity);

    /**
     * Update attack.
     *
     * @param attackEntity the attack entity
     */
    @Update("""
            <script>
            update attack
            <set>
                <if test="name != null">name = #{name},</if>
                <if test="description != null">description = #{description},</if>
                <if test="debut != null">first_appearance_id = #{debut.id},</if>
                <if test="character != null">character_id = #{character.id},</if>
                <if test="transformation != null">transformation_id = #{transformation.id},</if>
            </set>
            where attack_id = #{id}
            </script>
            """)
    void updateAttack(AttackEntity attackEntity);

    /**
     * Delete attack.
     *
     * @param id the attack id
     */
    @Delete("delete from attack where attack_id = #{id}")
    void deleteAttack(Integer id);
}
