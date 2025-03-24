package me.nettee.mapper;

import javax.annotation.processing.Generated;
import me.nettee.Board;
import me.nettee.BoardQueryModels;
import me.nettee.entity.BoardEntity;
import me.nettee.entity.type.BoardEntityStatus;
import me.nettee.type.BoardStatus;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-24T14:16:23+0900",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class BoardEntityMapperImpl implements BoardEntityMapper {

    @Override
    public Board toDomain(BoardEntity boardEntity) {
        if ( boardEntity == null ) {
            return null;
        }

        Board.BoardBuilder board = Board.builder();

        board.id( boardEntity.getId() );
        board.title( boardEntity.getTitle() );
        board.content( boardEntity.getContent() );
        board.status( boardEntityStatusToBoardStatus( boardEntity.getStatus() ) );
        board.createdAt( boardEntity.getCreatedAt() );
        board.updatedAt( boardEntity.getUpdatedAt() );

        return board.build();
    }

    @Override
    public BoardEntity toEntity(Board board) {
        if ( board == null ) {
            return null;
        }

        BoardEntity.BoardEntityBuilder boardEntity = BoardEntity.builder();

        boardEntity.title( board.getTitle() );
        boardEntity.content( board.getContent() );
        boardEntity.status( boardStatusToBoardEntityStatus( board.getStatus() ) );

        return boardEntity.build();
    }

    @Override
    public BoardQueryModels.BoardDetail toBoardDetail(BoardEntity boardEntity) {
        if ( boardEntity == null ) {
            return null;
        }

        BoardQueryModels.BoardDetail.BoardDetailBuilder boardDetail = BoardQueryModels.BoardDetail.builder();

        boardDetail.id( boardEntity.getId() );
        boardDetail.title( boardEntity.getTitle() );
        boardDetail.content( boardEntity.getContent() );
        boardDetail.status( boardEntityStatusToBoardStatus( boardEntity.getStatus() ) );
        boardDetail.createdAt( boardEntity.getCreatedAt() );
        boardDetail.updatedAt( boardEntity.getUpdatedAt() );

        return boardDetail.build();
    }

    @Override
    public BoardQueryModels.BoardSummary toBoardSummary(BoardEntity boardEntity) {
        if ( boardEntity == null ) {
            return null;
        }

        BoardQueryModels.BoardSummary.BoardSummaryBuilder boardSummary = BoardQueryModels.BoardSummary.builder();

        boardSummary.id( boardEntity.getId() );
        boardSummary.title( boardEntity.getTitle() );
        boardSummary.status( boardEntityStatusToBoardStatus( boardEntity.getStatus() ) );
        boardSummary.createdAt( boardEntity.getCreatedAt() );
        boardSummary.updatedAt( boardEntity.getUpdatedAt() );

        return boardSummary.build();
    }

    protected BoardStatus boardEntityStatusToBoardStatus(BoardEntityStatus boardEntityStatus) {
        if ( boardEntityStatus == null ) {
            return null;
        }

        BoardStatus boardStatus;

        switch ( boardEntityStatus ) {
            case REMOVED: boardStatus = BoardStatus.REMOVED;
            break;
            case PENDING: boardStatus = BoardStatus.PENDING;
            break;
            case ACTIVE: boardStatus = BoardStatus.ACTIVE;
            break;
            case SUSPENDED: boardStatus = BoardStatus.SUSPENDED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + boardEntityStatus );
        }

        return boardStatus;
    }

    protected BoardEntityStatus boardStatusToBoardEntityStatus(BoardStatus boardStatus) {
        if ( boardStatus == null ) {
            return null;
        }

        BoardEntityStatus boardEntityStatus;

        switch ( boardStatus ) {
            case PENDING: boardEntityStatus = BoardEntityStatus.PENDING;
            break;
            case ACTIVE: boardEntityStatus = BoardEntityStatus.ACTIVE;
            break;
            case SUSPENDED: boardEntityStatus = BoardEntityStatus.SUSPENDED;
            break;
            case REMOVED: boardEntityStatus = BoardEntityStatus.REMOVED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + boardStatus );
        }

        return boardEntityStatus;
    }
}
