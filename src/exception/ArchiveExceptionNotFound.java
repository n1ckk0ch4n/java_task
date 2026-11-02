package exception;

import java.util.UUID;

public class ArchiveExceptionNotFound extends BusinessException {
    public ArchiveExceptionNotFound(UUID id) {
        super("Архив не найден, id:" + id);
    }
}