package es.api.onepiece.adapters.inbound.rest.controller.character.attack;

import es.api.onepiece.adapters.inbound.rest.mapper.character.AttackDtoMapper;
import es.api.onepiece.core.ports.inbound.character.attack.UpdateAttackPort;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.UpdateAttackV1Api;
import org.openapitools.model.UpdateAttackRequestDto;
import org.openapitools.model.UpdateAttackV1ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class PatchAttackController.
 */
@Validated
@RestController
@RequiredArgsConstructor
public class PatchAttackController implements UpdateAttackV1Api {

    /** The update attack use case. */
    private final UpdateAttackPort updateAttackPort;

    /** The attack dto mapper. */
    private final AttackDtoMapper attackDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<UpdateAttackV1ResponseDto> updateAttackV1(
            @NotNull final Integer id,
            @Valid final UpdateAttackRequestDto updateAttackRequestDto) {

        final var updateAttackVo = this.attackDtoMapper.toUpdateAttackVo(id, updateAttackRequestDto);

        final var updatedAttack = this.updateAttackPort.execute(updateAttackVo);

        final var attackDto = this.attackDtoMapper.toAttackDto(updatedAttack);

        final var updateAttackV1ResponseDto = UpdateAttackV1ResponseDto.builder()
                .attack(attackDto)
                .build();

        return ResponseEntity.ok(updateAttackV1ResponseDto);
    }
}
