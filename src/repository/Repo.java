package repository;

import exception.AppException;
import model.Archive;

import java.util.*;

public class Repo {

    private final Map<UUID, Archive> storage = new HashMap<>();

    public void create(Archive archive) {
        if (archive.getId() == null) {
            archive.setId(UUID.randomUUID());
        }
        storage.put(archive.getId(), archive);
    }

    public void update(Archive archive) {
        if (!storage.containsKey(archive.getId())) {
            throw new AppException("Архив не найден");
        }
        storage.put(archive.getId(), archive);
    }

    public void delete(UUID id) {
        if (!storage.containsKey(id)) {
            throw new AppException("Архив не найден");
        }
        storage.remove(id);
    }

    public Archive get(UUID id) {
        Archive archive = storage.get(id);
        if (archive == null) {
            throw new AppException("Архив не найден");
        }
        return archive;
    }

    public List<Archive> getAll() {
        return new ArrayList<>(storage.values());
    }

    public boolean exists(UUID id) {
        return storage.containsKey(id);
    }
}