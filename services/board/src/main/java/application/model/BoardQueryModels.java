package application.model;

import lombok.Builder;
import application.domain.type.BoardStatus;

public final class BoardQueryModels {

    private BoardQueryModels() {
    }

    @Builder
    public record BoardDetail(
            Long id,
            String title,
            String content,
            BoardStatus status,
            java.time.Instant createdAt,
            java.time.Instant updatedAt
    ) {
    }

    @Builder
    public record BoardSummary(
            Long id,
            String title,
            BoardStatus status,
            java.time.Instant createdAt,
            java.time.Instant updatedAt
    ) {
    }
}
