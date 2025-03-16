package adapter.driving.web;

import lombok.RequiredArgsConstructor;
import adapter.driving.web.dto.BoardQueryDto.BoardDetailResponse;
import adapter.driving.web.mapper.BoardDtoMapper;
import application.domain.type.BoardStatus;
import application.usecase.BoardReadByStatusesUseCase;
import application.usecase.BoardReadUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/boards")
@RequiredArgsConstructor
public class BoardQueryApi {

    private final BoardReadUseCase boardReadUseCase;
    private final BoardReadByStatusesUseCase boardReadByStatusesUseCase;

    private final BoardDtoMapper mapper;

    @GetMapping("/{boardId}")
    public BoardDetailResponse getBoard(@PathVariable("boardId") long boardId) {
        var board = boardReadUseCase.getBoard(boardId);

        return mapper.toDtoDetail(board);
    }

    @GetMapping
    public Page<application.model.BoardQueryModels.BoardSummary> getBoardsByStatuses(@RequestParam(defaultValue = "ACTIVE,SUSPENDED") Set<BoardStatus> statuses, Pageable pageable) {
        return boardReadByStatusesUseCase.findByStatuses(statuses, pageable);
    }
}
