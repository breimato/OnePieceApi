package es.api.onepiece.adapters.inbound.rest.controller.sword;

import es.api.onepiece.adapters.inbound.rest.mapper.sword.SwordDtoMapper;
import es.api.onepiece.core.ports.inbound.sword.CreateSwordPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.CreateSwordV1Api;
import org.openapitools.model.CreateSwordRequestDto;
import org.openapitools.model.CreateSwordV1ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class PostSwordController.
 */
@Validated
@RestController
@RequiredArgsConstructor
public class PostSwordController implements CreateSwordV1Api {

    /** The create sword port. */
    private final CreateSwordPort createSwordPort;

    /** The sword dto mapper. */
    private final SwordDtoMapper swordDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<CreateSwordV1ResponseDto> createSwordV1(
            @Valid final CreateSwordRequestDto createSwordRequestDto) {

        final var createSwordVo = this.swordDtoMapper.toCreateSwordVo(createSwordRequestDto);

        final var createdSword = this.createSwordPort.execute(createSwordVo);

        final var swordDto = this.swordDtoMapper.toSwordDto(createdSword);

        final var createSwordV1ResponseDto = CreateSwordV1ResponseDto.builder()
                .sword(swordDto)
                .build();

        return new ResponseEntity<>(createSwordV1ResponseDto, HttpStatus.CREATED);
    }
}
