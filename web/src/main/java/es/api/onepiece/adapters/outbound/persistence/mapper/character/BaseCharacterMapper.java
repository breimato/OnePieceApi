package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.BaseCharacterEntity;
import es.api.onepiece.core.internal.domain.character.BaseCharacter;
import org.mapstruct.BeanMapping;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface BaseCharacterMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring"
)
public interface BaseCharacterMapper {

    /**
     * To base character.
     *
     * @param entity the entity
     * @return the base character
     */
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id",          source = "id")
    @Mapping(target = "name",        source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "height",      source = "height")
    @Mapping(target = "age",         source = "age")
    @Mapping(target = "bounty",      source = "bounty")
    @Mapping(target = "image",       source = "image")
    BaseCharacter toBaseCharacter(BaseCharacterEntity entity);
}
