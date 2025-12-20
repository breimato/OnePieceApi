package es.api.onepiece.adapters.inbound.rest.controller.character.attack;

import es.api.onepiece.adapters.inbound.rest.mapper.character.AttackDtoMapper;
import es.api.onepiece.core.ports.inbound.character.attack.GetAttacksPort;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.GetAttackByIdV1Api;
import org.openapitools.model.GetAttackByIdV1ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class GetAttackByIdController.
 */
@RestController
@Validated
@RequiredArgsConstructor
public class GetAttackByIdController implements GetAttackByIdV1Api {

    /** The get attacks use case. */
    private final GetAttacksPort getAttacksPort;

    /** The attack dto mapper. */
    private final AttackDtoMapper attackDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<GetAttackByIdV1ResponseDto> getAttackByIdV1(@NotNull final Integer id) {

        final var attack = this.getAttacksPort.findById(id);

        final var attackDto = this.attackDtoMapper.toAttackDto(attack);

        final var getAttackByIdV1ResponseDto = GetAttackByIdV1ResponseDto.builder()
                .attack(attackDto)
                .build();

        return new ResponseEntity<>(getAttackByIdV1ResponseDto, HttpStatus.OK);
    }
}
