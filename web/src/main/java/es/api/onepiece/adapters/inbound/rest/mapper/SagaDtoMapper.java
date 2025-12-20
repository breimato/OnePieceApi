package es.api.onepiece.adapters.inbound.rest.mapper;

import es.api.onepiece.core.internal.domain.debut.Saga;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.SagaDto;
import java.util.List;

/**
 * The Interface SagaDtoMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface SagaDtoMapper {

    /**
     * To dto.
     *
     * @param saga the saga
     * @return the saga dto
     */
    SagaDto toSagaDto(Saga saga);

    /**
     * To dto list.
     *
     * @param sagas the sagas
     * @return the list
     */
    List<SagaDto> toSagaDtoList(List<Saga> sagas);
}
