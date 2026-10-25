package exception;

import java.util.UUID;

public class FENotFound extends BusinessE {
    public FENotFound(UUID id) {
        super("Файл не найден, id " + id);
    }
}