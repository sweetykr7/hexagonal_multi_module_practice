package adapter.driven.persistence.mapper;

import adapter.driven.persistence.entity.BoardEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardEntityMapper {

    application.domain.Board toDomain(BoardEntity boardEntity);

    BoardEntity toEntity(application.domain.Board board);

    application.model.BoardQueryModels.BoardDetail toBoardDetail(BoardEntity boardEntity);

    application.model.BoardQueryModels.BoardSummary toBoardSummary(BoardEntity boardEntity);

    default java.util.Optional<application.domain.Board> toOptionalDomain(BoardEntity boardEntity) {
        return java.util.Optional.ofNullable(toDomain(boardEntity));
    }

    default java.util.Optional<application.model.BoardQueryModels.BoardDetail> toOptionalBoardDetail(BoardEntity boardEntity) {
        return java.util.Optional.ofNullable(toBoardDetail(boardEntity));
    }
}
