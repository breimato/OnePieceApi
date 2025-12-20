package es.api.onepiece.adapters.inbound.rest.controller.character.attack;

import es.api.onepiece.adapters.inbound.rest.mapper.character.AttackDtoMapper;
import es.api.onepiece.core.ports.inbound.character.attack.GetAttacksPort;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.GetAttacksV1Api;
import org.openapitools.model.GetAttacksV1ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class GetAttackController.
 */
@RestController
@Validated
@RequiredArgsConstructor
public class GetAttackController implements GetAttacksV1Api {

    /** The get attacks use case. */
    private final GetAttacksPort getAttacksPort;

    /** The attack dto mapper. */
    private final AttackDtoMapper attackDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<GetAttacksV1ResponseDto> getAttacksV1() {

        final var attacks = this.getAttacksPort.findAll();

        final var attacksDto = this.attackDtoMapper.toAttackDtoList(attacks);

        final var getAttacksV1ResponseDto = GetAttacksV1ResponseDto.builder()
                .attacks(attacksDto)
                .build();

        return new ResponseEntity<>(getAttacksV1ResponseDto, HttpStatus.OK);
    }
}
