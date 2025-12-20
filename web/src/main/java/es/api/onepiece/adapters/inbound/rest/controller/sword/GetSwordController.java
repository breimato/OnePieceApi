package es.api.onepiece.adapters.inbound.rest.controller.sword;

import es.api.onepiece.adapters.inbound.rest.mapper.sword.SwordDtoMapper;
import es.api.onepiece.core.ports.inbound.sword.GetSwordsPort;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.GetSwordsV1Api;
import org.openapitools.model.GetSwordsV1ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class GetSwordController.
 */
@RestController
@Validated
@RequiredArgsConstructor
public class GetSwordController implements GetSwordsV1Api {

    /** The get swords port. */
    private final GetSwordsPort getSwordsPort;

    /** The sword dto mapper. */
    private final SwordDtoMapper swordDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<GetSwordsV1ResponseDto> getSwordsV1() {

        final var swords = this.getSwordsPort.findAll();

        final var swordsDto = this.swordDtoMapper.toSwordDtoList(swords);

        final var getSwordsV1ResponseDto = GetSwordsV1ResponseDto.builder()
                .swords(swordsDto)
                .build();

        return new ResponseEntity<>(getSwordsV1ResponseDto, HttpStatus.OK);
    }
}
