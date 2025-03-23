package me.nettee;

import lombok.Builder;
import me.nettee.type.BoardStatus;


import java.time.Instant;

public final class BoardQueryModels {

    private BoardQueryModels() {
    }

    @Builder
    public record BoardDetail(
            Long id,
            String title,
            String content,
            BoardStatus status,
            Instant createdAt,
            Instant updatedAt
    ) {
    }

    @Builder
    public record BoardSummary(
            Long id,
            String title,
            BoardStatus status,
            Instant createdAt,
            Instant updatedAt
    ) {
    }
}
