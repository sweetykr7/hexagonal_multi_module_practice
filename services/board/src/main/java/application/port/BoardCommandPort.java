package application.port;
import application.domain.type.BoardStatus;
import application.domain.Board;


public interface BoardCommandPort {

    java.util.Optional<Board> findById(Long id);

    Board create(Board board);

    Board update(Board board);

    void updateStatus(Long id, BoardStatus status);
}
