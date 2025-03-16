package application.exception;

import exeption.CustomException;

public class BoardQueryException extends CustomException {
    public BoardQueryException(BoardQueryErrorCode errorCode) {
        super(errorCode);
    }

    public BoardQueryException(BoardQueryErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public BoardQueryException(BoardQueryErrorCode errorCode, Runnable runnable) {
        super(errorCode, runnable);
    }

    public BoardQueryException(BoardQueryErrorCode errorCode, Runnable runnable, Throwable cause) {
        super(errorCode, runnable, cause);
    }

    public BoardQueryException(BoardQueryErrorCode errorCode, java.util.function.Supplier<java.util.Map<String, Object>> payload) {
        super(errorCode, payload);
    }

    public BoardQueryException(BoardQueryErrorCode errorCode, java.util.function.Supplier<java.util.Map<String, Object>> payload, Throwable cause) {
        super(errorCode, payload, cause);
    }
}
