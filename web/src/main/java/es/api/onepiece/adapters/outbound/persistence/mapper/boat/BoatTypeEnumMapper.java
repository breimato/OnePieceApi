package es.api.onepiece.adapters.outbound.persistence.mapper.boat;

import es.api.onepiece.core.internal.domain.boat.enums.BoatTypeEnum;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface BoatTypeEnumMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        implementationName = "BoatTypeEnumMapperFromPersistence")
public interface BoatTypeEnumMapper {

    /**
     * To enum.
     *
     * @param type the type
     * @return the boat type enum
     */
    default BoatTypeEnum toEnum(String type) {
        return BoatTypeEnum.getByName(type);
    }
}
