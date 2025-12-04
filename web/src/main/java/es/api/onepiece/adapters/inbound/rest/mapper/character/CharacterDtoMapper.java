package es.api.onepiece.adapters.inbound.rest.mapper.character;

import org.openapitools.model.CharacterDto;
import es.api.onepiece.core.internal.domain.character.Character;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import es.api.onepiece.adapters.inbound.rest.mapper.boat.BoatDtoMapper;
import es.api.onepiece.adapters.inbound.rest.mapper.fruit.FruitDtoMapper;
import es.api.onepiece.adapters.inbound.rest.mapper.sword.SwordDtoMapper;
import es.api.onepiece.adapters.inbound.rest.mapper.debut.DebutDtoMapper;

import java.util.List;
import es.api.onepiece.core.internal.vo.character.CreateCharacterVo;
import org.openapitools.model.CreateCharacterRequestDto;
import es.api.onepiece.core.internal.domain.character.enums.CharacterStatusTypeEnum;
import org.mapstruct.Mapping;

/**
 * The Interface CharacterDtoMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring", uses = {
                HakiDtoMapper.class,
                SwordDtoMapper.class,
                TransformationDtoMapper.class,
                AttackDtoMapper.class,
                AffiliationDtoMapper.class,
                CharacterAffiliationDtoMapper.class,
                BoatDtoMapper.class,
                CharacterBasicDtoMapper.class,
                FruitDtoMapper.class,
                JobDtoMapper.class,
                RaceDtoMapper.class,
                CharacterTitleDtoMapper.class,
                DebutDtoMapper.class
})
public interface CharacterDtoMapper {

        /**
         * To character V 1 dto.
         *
         * @param character the character
         * @return the character dto
         */
        CharacterDto toCharacterV1Dto(Character character);

        /**
         * To character V 1 dto list.
         *
         * @param characters the characters
         * @return the list
         */
        List<CharacterDto> toCharacterV1DtoList(List<Character> characters);

        /**
         * To create character vo.
         *
         * @param createCharacterRequestDto the create character request dto
         * @return the create character vo
         */
        @Mapping(target = "status", source = "statusId")
        @Mapping(target = "debutId", source = "firstAppearanceId")
        CreateCharacterVo toCreateCharacterVo(CreateCharacterRequestDto createCharacterRequestDto);

        default CharacterStatusTypeEnum mapStatusId(final Integer statusId) {
                return CharacterStatusTypeEnum.getById(statusId);
        }
}
