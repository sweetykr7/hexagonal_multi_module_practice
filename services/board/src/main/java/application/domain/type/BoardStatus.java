package application.domain.type;

public enum BoardStatus {

    PENDING,
    ACTIVE,
    SUSPENDED,
    REMOVED;

    private static final java.util.Set<BoardStatus> GENERAL_QUERY_STATUS = java.util.EnumSet.of(ACTIVE, SUSPENDED);

    public static java.util.Set<BoardStatus> getGeneralQueryStatus() {
       return GENERAL_QUERY_STATUS;
    }

}
