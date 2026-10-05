import java.util.*;

public class Repo {

    private final Map<UUID, File> storage = new HashMap<>();

    public void create(File archive) {
        if (archive.getId() == null) {
            archive.setId(UUID.randomUUID());
        }
        storage.put(archive.getId(), archive);
    }

    public void update(UUID id, File archive) {
        if (!storage.containsKey(id)) {
            throw new NoSuchElementException("Архив не найден");
        }
        archive.setId(id);
        storage.put(id, archive);
    }

    public void delete(UUID id) {
        if (!storage.containsKey(id)) {
            throw new NoSuchElementException("Архив не найден");
        }
        storage.remove(id);
    }

    public File get(UUID id) {
        File archive = storage.get(id);
        if (archive == null) {
            throw new NoSuchElementException("Архив не найден");
        }
        return archive;
    }

    public List<File> getAll() {
        return new ArrayList<>(storage.values());
    }

    public boolean exists(UUID id) {
        return storage.containsKey(id);
    }
}