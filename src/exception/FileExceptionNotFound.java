package exception;

import java.util.UUID;

public class FileExceptionNotFound extends BusinessException {
    public FileExceptionNotFound(UUID id) {
        super("Файл не найден, id " + id);
    }
}