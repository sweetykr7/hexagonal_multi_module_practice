package me.nettee.mapper;

import javax.annotation.processing.Generated;
import me.nettee.Board;
import me.nettee.BoardQueryModels;
import me.nettee.dto.BoardCommandDto;
import me.nettee.dto.BoardQueryDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-24T14:16:24+0900",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class BoardDtoMapperImpl implements BoardDtoMapper {

    @Override
    public Board toDomain(BoardCommandDto.BoardCreateCommand command) {
        if ( command == null ) {
            return null;
        }

        Board.BoardBuilder board = Board.builder();

        board.title( command.title() );
        board.content( command.content() );
        board.status( command.status() );

        return board.build();
    }

    @Override
    public Board toDomain(Long id, BoardCommandDto.BoardUpdateCommand command) {
        if ( id == null && command == null ) {
            return null;
        }

        Board.BoardBuilder board = Board.builder();

        if ( command != null ) {
            board.title( command.title() );
            board.content( command.content() );
        }
        board.id( id );

        return board.build();
    }

    @Override
    public BoardQueryDto.BoardDetailResponse toDtoDetail(BoardQueryModels.BoardDetail board) {
        if ( board == null ) {
            return null;
        }

        BoardQueryDto.BoardDetailResponse.BoardDetailResponseBuilder boardDetailResponse = BoardQueryDto.BoardDetailResponse.builder();

        boardDetailResponse.board( board );

        return boardDetailResponse.build();
    }
}
