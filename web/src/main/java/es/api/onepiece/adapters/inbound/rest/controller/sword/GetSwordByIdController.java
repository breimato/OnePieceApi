package es.api.onepiece.adapters.inbound.rest.controller.sword;

import es.api.onepiece.adapters.inbound.rest.mapper.sword.SwordDtoMapper;
import es.api.onepiece.core.ports.inbound.sword.GetSwordsPort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.GetSwordByIdV1Api;
import org.openapitools.model.GetSwordByIdV1ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class GetSwordByIdController.
 */
@RestController
@Validated
@RequiredArgsConstructor
public class GetSwordByIdController implements GetSwordByIdV1Api {

    /** The get swords port. */
    private final GetSwordsPort getSwordsPort;

    /** The sword dto mapper. */
    private final SwordDtoMapper swordDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<GetSwordByIdV1ResponseDto> getSwordByIdV1(@NotNull final Integer id) {

        final var sword = this.getSwordsPort.findById(id);

        final var swordDto = this.swordDtoMapper.toSwordDto(sword);

        final var getSwordByIdV1ResponseDto = GetSwordByIdV1ResponseDto.builder()
                .sword(swordDto)
                .build();

        return new ResponseEntity<>(getSwordByIdV1ResponseDto, HttpStatus.OK);
    }
}
