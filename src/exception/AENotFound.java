package exception;

import java.util.UUID;

public class AENotFound extends BusinessE {
    public AENotFound(UUID id) {
        super("Архив не найден, id:" + id);
    }
}