package service;

import exception.AppException;
import model.Archive;
import model.File;
import repository.Repo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ArchiveService {
    private final Repo repo;

    public ArchiveService(Repo repo) {
        this.repo = repo;
    }

    public List<Archive> getAll() {
        return repo.getAll();
    }

    public Archive getById(UUID id) {
        return repo.get(id);
    }

    public Archive create(String name) {
        if (name == null || name.isBlank()) {
            throw new AppException("Наименование архива не может быть пустым");
        }
        Archive archive = new Archive(UUID.randomUUID(), name, LocalDateTime.now());
        repo.create(archive);
        return archive;
    }

    public Archive update(UUID id, String newName) {
        if (newName == null || newName.isBlank()) {
            throw new AppException("Наименование архива не может быть пустым");
        }
        Archive archive = repo.get(id);
        archive.setName(newName);
        repo.update(archive);
        return archive;
    }

    public boolean deleteById(UUID id) {
        repo.delete(id);
        return true;
    }

    public void addFile(UUID archiveId, String fileName, String content) {
        Archive archive = repo.get(archiveId);
        File newFile = new File(UUID.randomUUID(), fileName, content, LocalDateTime.now());
        archive.getFiles().add(newFile);
        repo.update(archive);
    }
    public void removeFile(UUID archiveId, UUID fileId) {
        Archive archive = repo.get(archiveId);
        boolean removed = archive.getFiles().removeIf(f -> f.getId().equals(fileId));
        if (!removed) {
            throw new AppException("Файл с таким ID не найден");
        }
        repo.update(archive);
    }
}