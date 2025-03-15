package adapter.driving.web.mapper;

import me.nettee.board.adapter.driving.web.dto.BoardCommandDto.BoardCreateCommand;
import me.nettee.board.adapter.driving.web.dto.BoardCommandDto.BoardUpdateCommand;
import me.nettee.board.adapter.driving.web.dto.BoardQueryDto.BoardDetailResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardDtoMapper {

    me.nettee.board.application.domain.Board toDomain(BoardCreateCommand command);

    me.nettee.board.application.domain.Board toDomain(Long id, BoardUpdateCommand command);

    BoardDetailResponse toDtoDetail(me.nettee.board.application.model.BoardQueryModels.BoardDetail board);
}
