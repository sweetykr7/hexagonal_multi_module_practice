package application.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import application.model.BoardQueryModels.BoardSummary;
import application.domain.type.BoardStatus;

public interface BoardReadByStatusesUseCase {

    Page<BoardSummary> findByStatuses(java.util.Set<BoardStatus> statuses, Pageable pageable);
}

