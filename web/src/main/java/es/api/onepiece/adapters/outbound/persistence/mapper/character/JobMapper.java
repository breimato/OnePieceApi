package es.api.onepiece.adapters.outbound.persistence.mapper.character;

import es.api.onepiece.adapters.outbound.persistence.entities.character.JobEntity;
import es.api.onepiece.core.internal.domain.character.Job;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * The Interface JobMapper.
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true),
        componentModel = "spring"
)
public interface JobMapper {
    
    /**
     * To job.
     *
     * @param entity the entity
     * @return the job
     */
    Job toJob(JobEntity entity);
}
