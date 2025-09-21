package es.api.onepiece.adapters.outbound.persistence.mapper.sword;

import es.api.onepiece.core.internal.domain.sword.enums.SwordStatusEnum;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface SwordStatusEnumMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring",
        implementationName = "SwordStatusEnumMapperFromPersistence")
public interface SwordStatusEnumMapper {

    /**
     * To enum.
     *
     * @param status the status
     * @return the sword status enum
     */
    default SwordStatusEnum toEnum(String status) {
        return SwordStatusEnum.getByName(status);
    }
}
