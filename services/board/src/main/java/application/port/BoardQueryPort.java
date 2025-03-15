package application.port;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import application.model.BoardQueryModels.BoardDetail;
import application.model.BoardQueryModels.BoardSummary;
import application.domain.type.BoardStatus;

public interface BoardQueryPort {

    java.util.Optional<BoardDetail> findById(Long id);

    Page<BoardSummary> findAll(Pageable pageable);

    Page<BoardSummary> findByStatusesList(java.util.Set<BoardStatus> statuses, Pageable pageable);
}
    