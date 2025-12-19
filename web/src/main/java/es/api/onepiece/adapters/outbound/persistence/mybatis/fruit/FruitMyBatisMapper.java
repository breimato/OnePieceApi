package es.api.onepiece.adapters.outbound.persistence.mybatis.fruit;

import es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * The Interface FruitMyBatisMapper.
 */
@Mapper
public interface FruitMyBatisMapper {

    /**
     * Find all fruits.
     *
     * @return the list
     */
    @Result(property = "id", column = "fruit_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Result(property = "image", column = "image_url")
    @Result(property = "type", column = "type_id", one = @One(select = "getFruitTypeById"))
    @Select("""
            select f.fruit_id, f.name, f.description, f.image_url, f.type_id
            from fruit f
            order by f.fruit_id
            """)
    List<FruitEntity> findAll();

    /**
     * Find fruit by id.
     *
     * @param id the id
     * @return the fruit entity
     */
    @Result(property = "id", column = "fruit_id")
    @Result(property = "name", column = "name")
    @Result(property = "description", column = "description")
    @Result(property = "image", column = "image_url")
    @Result(property = "type", column = "type_id", one = @One(select = "getFruitTypeById"))
    @Select("""
            select f.fruit_id, f.name, f.description, f.image_url, f.type_id
            from fruit f
            where f.fruit_id = #{id}
            """)
    FruitEntity findById(Integer id);

    /**
     * Exists.
     *
     * @param id the id
     * @return the boolean
     */
    @Select("select count(1) > 0 from fruit where fruit_id = #{id}")
    boolean exists(Integer id);

    /**
     * Gets the fruit type by id.
     *
     * @param fruitTypeId the fruit type id
     * @return the fruit type entity
     */
    @Result(property = "id", column = "id")
    @Result(property = "type", column = "name")
    @Select("select id, name from fruit_type where id = #{fruitTypeId}")
    es.api.onepiece.adapters.outbound.persistence.entities.fruit.FruitTypeEntity getFruitTypeById(Integer fruitTypeId);

    /**
     * Insert fruit.
     *
     * @param fruitEntity the fruit entity
     */
    @Insert("""
            insert into fruit (name, description, image_url, type_id)
            values (#{name}, #{description}, #{image}, #{type.id})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "fruit_id")
    void insertFruit(FruitEntity fruitEntity);

    /**
     * Update fruit.
     *
     * @param fruitEntity the fruit entity
     */
    @Update("""
            <script>
            update fruit
            <set>
                <if test="name != null">name = #{name},</if>
                <if test="description != null">description = #{description},</if>
                <if test="image != null">image_url = #{image},</if>
                <if test="type != null">type_id = #{type.id},</if>
            </set>
            where fruit_id = #{id}
            </script>
            """)
    void updateFruit(FruitEntity fruitEntity);

    /**
     * Delete fruit.
     *
     * @param id the fruit id
     */
    @Delete("delete from fruit where fruit_id = #{id}")
    void deleteFruit(Integer id);

    /**
     * Delete character fruits by fruit id.
     *
     * @param fruitId the fruit id
     */
    @Delete("delete from character_fruit where fruit_id = #{fruitId}")
    void deleteCharacterFruitsByFruitId(Integer fruitId);
}
