package adapter.driving.web.mapper;

import adapter.driving.web.dto.BoardCommandDto.BoardCreateCommand;
import adapter.driving.web.dto.BoardCommandDto.BoardUpdateCommand;
import adapter.driving.web.dto.BoardQueryDto.BoardDetailResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardDtoMapper {

    application.domain.Board toDomain(BoardCreateCommand command);

    application.domain.Board toDomain(Long id, BoardUpdateCommand command);

    BoardDetailResponse toDtoDetail(application.model.BoardQueryModels.BoardDetail board);
}
