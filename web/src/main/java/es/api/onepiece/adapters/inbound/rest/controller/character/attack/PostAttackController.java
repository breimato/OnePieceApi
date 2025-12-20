package es.api.onepiece.adapters.inbound.rest.controller.character.attack;

import es.api.onepiece.adapters.inbound.rest.mapper.character.AttackDtoMapper;
import es.api.onepiece.core.internal.usecases.character.attack.CreateAttackUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.CreateAttackV1Api;
import org.openapitools.model.CreateAttackRequestDto;
import org.openapitools.model.CreateAttackV1ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class PostAttackController.
 */
@Validated
@RestController
@RequiredArgsConstructor
public class PostAttackController implements CreateAttackV1Api {

    /** The create attack use case. */
    private final CreateAttackUseCase createAttackUseCase;

    /** The attack dto mapper. */
    private final AttackDtoMapper attackDtoMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<CreateAttackV1ResponseDto> createAttackV1(
            @Valid final CreateAttackRequestDto createAttackRequestDto) {

        final var createAttackVo = this.attackDtoMapper.toCreateAttackVo(createAttackRequestDto);

        final var createdAttack = this.createAttackUseCase.execute(createAttackVo);

        final var attackDto = this.attackDtoMapper.toAttackDto(createdAttack);

        final var createAttackV1ResponseDto = CreateAttackV1ResponseDto.builder()
                .attack(attackDto)
                .build();

        return new ResponseEntity<>(createAttackV1ResponseDto, HttpStatus.CREATED);
    }
}
