package es.api.onepiece.adapters.outbound.persistence.mapper;

import es.api.onepiece.adapters.outbound.persistence.entities.debut.SagaEntity;
import es.api.onepiece.core.internal.domain.debut.Saga;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface SagaMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface SagaMapper {

    /**
     * To saga.
     *
     * @param entity the entity
     * @return the saga
     */
    Saga toSaga(SagaEntity entity);

    /**
     * To saga entity.
     *
     * @param saga the saga
     * @return the saga entity
     */
    SagaEntity toSagaEntity(Saga saga);
}
