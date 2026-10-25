package repository;

import exception.AENotFound;
import model.Archive;

import java.util.*;

public class ARepo {
    private final Map<UUID, Archive> storage = new HashMap<>();

    public void create(Archive archive) {
        if (archive.getId() == null) {
            archive.setId(UUID.randomUUID());
        }
        storage.put(archive.getId(), archive);
    }

    public void update(Archive archive) {
        if (!storage.containsKey(archive.getId())) {
            throw new AENotFound(archive.getId());
        }
        storage.put(archive.getId(), archive);
    }

    public void delete(UUID id) {
        if (!storage.containsKey(id)) {
            throw new AENotFound(id);
        }
        storage.remove(id);
    }

    public Optional<Archive> get(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Archive> getAll() {
        return new ArrayList<>(storage.values());
    }
}