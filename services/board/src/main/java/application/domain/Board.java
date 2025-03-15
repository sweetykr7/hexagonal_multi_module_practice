package application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import application.domain.type.BoardStatus;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    private Long id;

    private String title;

    private String content;

    private BoardStatus status;

    private java.time.Instant createdAt;

    private java.time.Instant updatedAt;

    @Builder(
        builderClassName = "updateBoardBuilder",
        builderMethodName = "prepareUpdate",
        buildMethodName = "update"
    )
    public void update(String title, String content) {
        java.util.Objects.requireNonNull(title, "Title cannot be null");
        java.util.Objects.requireNonNull(content, "content cannot be null");

        this.title = title;
        this.content = content;
        this.updatedAt = java.time.Instant.now();
    }

    public void softDelete() {
        this.status = BoardStatus.REMOVED;
    }

}
