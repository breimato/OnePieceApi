package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.AttackEntity;
import es.api.onepiece.adapters.outbound.persistence.mapper.debut.DebutMapper;
import es.api.onepiece.adapters.outbound.persistence.mapper.character.TransformationMapper;
import es.api.onepiece.core.internal.domain.character.Attack;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface AttackMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        uses = {DebutMapper.class, TransformationMapper.class}
)
public interface AttackMapper {

    /**
     * To attack.
     *
     * @param entity the entity
     * @return the attack
     */
    @Mapping(target = "character", ignore = true)
    Attack toAttack(AttackEntity entity);
}
