package es.api.onepiece.adapters.outbound.persistence.mapper.sword;

import es.api.onepiece.adapters.outbound.persistence.entities.debut.DebutEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.sword.SwordCategoryEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.sword.SwordEntity;
import es.api.onepiece.adapters.outbound.persistence.entities.sword.SwordStatusEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.DebutMapper;
import es.api.onepiece.core.internal.domain.sword.Sword;
import es.api.onepiece.core.internal.vo.sword.CreateSwordVo;
import es.api.onepiece.core.internal.vo.sword.UpdateSwordVo;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Objects;

/**
 * The Interface SwordMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring", uses = {
        SwordCategoryMapper.class, SwordStatusEnumMapper.class,
        DebutMapper.class })
public interface SwordMapper {

    /**
     * To sword.
     *
     * @param swordEntity the sword entity
     * @return the sword
     */
    @Mapping(target = "swordStatus", source = "status.name")
    Sword toSword(SwordEntity swordEntity);

    /**
     * To sword list.
     *
     * @param swordEntities the sword entities
     * @return the list
     */
    List<Sword> toSwordList(List<SwordEntity> swordEntities);

    /**
     * To sword entity.
     *
     * @param createSwordVo the create sword vo
     * @return the sword entity
     */
    @Mapping(target = "status", expression = "java(statusIdToSwordStatusEntity(createSwordVo.getStatusId()))")
    @Mapping(target = "category", expression = "java(categoryIdToSwordCategoryEntity(createSwordVo.getCategoryId()))")
    @Mapping(target = "debut", expression = "java(debutIdToDebutEntity(createSwordVo.getDebutId()))")
    SwordEntity toSwordEntity(CreateSwordVo createSwordVo);

    /**
     * To sword entity.
     *
     * @param updateSwordVo the update sword vo
     * @return the sword entity
     */
    @Mapping(target = "status", expression = "java(statusIdToSwordStatusEntity(updateSwordVo.getStatusId()))")
    @Mapping(target = "category", expression = "java(categoryIdToSwordCategoryEntity(updateSwordVo.getCategoryId()))")
    @Mapping(target = "debut", expression = "java(debutIdToDebutEntity(updateSwordVo.getDebutId()))")
    SwordEntity toSwordEntityFromUpdate(UpdateSwordVo updateSwordVo);

    /**
     * Status id to sword status entity.
     *
     * @param statusId the status id
     * @return the sword status entity
     */
    default SwordStatusEntity statusIdToSwordStatusEntity(
            final Integer statusId) {
        if (Objects.isNull(statusId)) {
            return null;
        }
        final var swordStatusEntity = new SwordStatusEntity();
        swordStatusEntity.setId(statusId);
        return swordStatusEntity;
    }

    /**
     * Category id to sword category entity.
     *
     * @param categoryId the category id
     * @return the sword category entity
     */
    default SwordCategoryEntity categoryIdToSwordCategoryEntity(final Integer categoryId) {
        if (Objects.isNull(categoryId)) {
            return null;
        }
        final var swordCategoryEntity = new SwordCategoryEntity();
        swordCategoryEntity.setId(categoryId);
        return swordCategoryEntity;
    }

    /**
     * Debut id to debut entity.
     *
     * @param debutId the debut id
     * @return the debut entity
     */
    default DebutEntity debutIdToDebutEntity(final Integer debutId) {
        if (Objects.isNull(debutId)) {
            return null;
        }
        final var debutEntity = new DebutEntity();
        debutEntity.setId(debutId);
        return debutEntity;
    }
}
