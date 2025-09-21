package es.api.onepiece.adapters.outbound.persistence.mapper.character.enums;

import es.api.onepiece.core.internal.domain.character.enums.HakiTypeEnum;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface HakiTypeEnumMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        implementationName = "HakiTypeEnumMapperFromPersistence")
public interface HakiTypeEnumMapper {

    /**
     * To enum.
     *
     * @param type the type
     * @return the haki type enum
     */
    default HakiTypeEnum toEnum(String type) {
        return HakiTypeEnum.getByName(type);
    }
}
