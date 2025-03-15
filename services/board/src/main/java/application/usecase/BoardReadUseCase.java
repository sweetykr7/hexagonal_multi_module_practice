package application.usecase;

import application.model.BoardQueryModels.BoardDetail;
public interface BoardReadUseCase {

    BoardDetail getBoard(Long id);
}