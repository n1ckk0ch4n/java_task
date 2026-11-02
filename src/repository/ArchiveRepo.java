package repository;

import exception.ArchiveExceptionNotFound;
import model.Archive;

import java.util.*;

public class ArchiveRepo implements  ArchiveRepository{
    private final Map<UUID, Archive> storage = new HashMap<>();

    @Override
    public Archive create(Archive archive) {
        if (archive.getId() == null) {
            archive.setId(UUID.randomUUID());
        }
        storage.put(archive.getId(), archive);
        return archive;
    }

    @Override
    public Archive update(Archive archive) {
        if (!storage.containsKey(archive.getId())) {
            throw new ArchiveExceptionNotFound(archive.getId());
        }
        storage.put(archive.getId(), archive);
        return archive;
    }

    @Override
    public Archive delete(UUID id) {
        if (!storage.containsKey(id)) {
            throw new ArchiveExceptionNotFound(id);
        }
        storage.remove(id);
        return null;
    }

    public Optional<Archive> get(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Archive> getAll() {
        return new ArrayList<>(storage.values());
    }
}