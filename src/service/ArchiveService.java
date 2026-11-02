package service;

import exception.ArchiveExceptionNotFound;
import exception.ValidationException;
import model.Archive;
import model.File;
import repository.ArchiveRepo;
import repository.FileRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ArchiveService {
    private final ArchiveRepo archiveRepo;
    private final FileRepo fileRepo;

    public ArchiveService(ArchiveRepo archiveRepo, FileRepo fileRepo) {
        this.archiveRepo = archiveRepo;
        this.fileRepo = fileRepo;
    }

    public List<Archive> getAll() {
        return archiveRepo.getAll();
    }

    public Archive getById(UUID id) {
        return archiveRepo.get(id)
                .orElseThrow(() -> new ArchiveExceptionNotFound(id));
    }

    public Archive create(String name) {
        if (name == null || name.isBlank()) {
            throw new ValidationException("Наименование архива не может быть пустым");
        }
        Archive archive = new Archive(UUID.randomUUID(), name, LocalDateTime.now());
        archiveRepo.create(archive);
        return archive;
    }

    public Archive update(UUID id, String newName) {
        if (newName == null || newName.isBlank()) {
            throw new ValidationException("Наименование архива не может быть пустым");
        }
        Archive archive = getById(id);
        archive.setName(newName);
        archiveRepo.update(archive);
        return archive;
    }

    public void deleteById(UUID id) {
        archiveRepo.delete(id);
    }

    public void addFile(UUID archiveId, String fileName, String content) {
        if (fileName == null || fileName.isBlank()) {
            throw new ValidationException("Имя файла не может быть пустым");
        }
        Archive archive = getById(archiveId);
        File newFile = new File(UUID.randomUUID(), fileName, content, LocalDateTime.now());

        fileRepo.addFile(archive, newFile);
        archiveRepo.update(archive);
    }

    public void removeFile(UUID archiveId, UUID fileId) {
        Archive archive = getById(archiveId);
        fileRepo.removeFile(archive, fileId);
        archiveRepo.update(archive);
    }
}