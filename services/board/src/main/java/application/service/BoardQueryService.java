package application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import application.port.BoardQueryPort;
import application.model.BoardQueryModels;
import application.model.BoardQueryModels.BoardDetail;
import application.model.BoardQueryModels.BoardSummary;
import application.domain.type.BoardStatus;
import application.usecase.BoardReadUseCase;
import application.usecase.BoardReadByStatusesUseCase;

import static application.exception.BoardQueryErrorCode.BOARD_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class BoardQueryService implements BoardReadUseCase, BoardReadByStatusesUseCase {

    private final BoardQueryPort boardQueryPort;

    @Override
    public BoardDetail getBoard(Long id) {
        return boardQueryPort.findById(id)
                .orElseThrow(BOARD_NOT_FOUND::exception);
    }

    @Override
    public Page<BoardSummary> findByStatuses(java.util.Set<BoardStatus> statuses, Pageable pageable) {
        return boardQueryPort.findByStatusesList(statuses, pageable);
    }
}
