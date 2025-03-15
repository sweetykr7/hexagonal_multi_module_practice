package adapter.driven.persistence;

import lombok.RequiredArgsConstructor;
import adapter.driven.persistence.entity.type.BoardEntityStatus;
import adapter.driven.persistence.mapper.BoardEntityMapper;
import application.domain.Board;
import application.domain.type.BoardStatus;
import application.port.BoardCommandPort;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import static application.exception.BoardCommandErrorCode.BOARD_NOT_FOUND;
import static application.exception.BoardCommandErrorCode.DEFAULT;

@Repository
@RequiredArgsConstructor
public class BoardCommandAdapter implements BoardCommandPort {

    private final BoardJpaRepository boardJpaRepository;
    private final BoardEntityMapper boardEntityMapper;

    @Override
    public java.util.Optional<Board> findById(Long id) {
        var board = boardJpaRepository.findById(id)
                .orElseThrow(BOARD_NOT_FOUND::exception);

        return boardEntityMapper.toOptionalDomain(board);
    }

    @Override
    public Board create(Board board) {
        var boardEntity = boardEntityMapper.toEntity(board);
        try {
            var newBoard = boardJpaRepository.save(boardEntity);
            boardJpaRepository.flush();
            return boardEntityMapper.toDomain(newBoard);
        } catch (DataAccessException e) {
            throw DEFAULT.exception(e);
        }
    }

    @Override
    public Board update(Board board) {
        var existBoard = boardJpaRepository.findById(board.getId())
                .orElseThrow(BOARD_NOT_FOUND::exception);

        existBoard.prepareUpdate()
                .title(board.getTitle())
                .content(board.getContent())
                .status(BoardEntityStatus.valueOf(board.getStatus()))
                .update();

        return boardEntityMapper.toDomain(boardJpaRepository.save(existBoard));
    }

    @Override
    public void updateStatus(Long id, BoardStatus status) {
        var board = boardJpaRepository.findById(id)
                .orElseThrow(BOARD_NOT_FOUND::exception);

        board.prepareUpdateStatus()
                .status(BoardEntityStatus.valueOf(status))
                .updateStatus();

        boardJpaRepository.save(board);
    }
}
