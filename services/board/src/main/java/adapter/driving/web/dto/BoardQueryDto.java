package adapter.driving.web.dto;

import lombok.Builder;

public final class BoardQueryDto {
    private BoardQueryDto() {}

    @Builder
    public record BoardDetailResponse(
            application.model.BoardQueryModels.BoardDetail board
    ){}
}
