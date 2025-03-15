package adapter.driven.persistence.entity;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import adapter.driven.persistence.entity.type.BoardEntityStatus;
import jpa.support.LongBaseTimeEntity;
import org.hibernate.annotations.DynamicUpdate;
@Getter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "board")
public class BoardEntity extends LongBaseTimeEntity {
    private String title;
    private String content;

    @Convert(converter = adapter.driven.persistence.entity.type.BoardEntityStatusConverter.class)
    private BoardEntityStatus status;

    @Builder
    public BoardEntity(String title, String content, BoardEntityStatus status) {
        this.title = title;
        this.content = content;
        this.status = status;
    }

    @Builder(
            builderClassName = "UpdateBoardBuilder",
            builderMethodName = "prepareUpdate",
            buildMethodName = "update"
    )
    public void updateBoard(String title, String content, BoardEntityStatus status) {
        java.util.Objects.requireNonNull(title, "title cannot be null");
        java.util.Objects.requireNonNull(content, "content cannot be null");
        java.util.Objects.requireNonNull(status, "status cannot be null");

        this.title = title;
        this.content = content;
        this.status = status;
    }
    
    @Builder(
            builderClassName = "UpdateStatusBoardBuilder",
            builderMethodName = "prepareUpdateStatus",
            buildMethodName = "updateStatus"
    )
    public void updateStatus(BoardEntityStatus status) {
        java.util.Objects.requireNonNull(status, "status cannot be null");
        this.status = status;
    }
}