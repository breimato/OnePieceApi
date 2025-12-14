package es.api.onepiece.adapters.inbound.rest.mapper.character;

import es.api.onepiece.core.internal.domain.character.Job;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.JobDto;
import java.util.List;

/**
 * The Interface JobDtoMapper.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface JobDtoMapper {

    /**
     * To dto.
     *
     * @param job the job
     * @return the job dto
     */
    JobDto toJobDto(Job job);

    /**
     * To dto list.
     *
     * @param jobs the jobs
     * @return the list
     */
    List<JobDto> toJobDtoList(List<Job> jobs);
}
