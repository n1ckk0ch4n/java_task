package repository;

import exception.FENotFound;
import model.Archive;
import model.File;

import java.util.UUID;

public class FileRepo {
    public void addFile(Archive archive, File file) {
        archive.getFiles().add(file);
    }
    public void removeFile(Archive archive, UUID fileId) {
        boolean removed = archive.getFiles().removeIf(f -> f.getId().equals(fileId));
        if (!removed) {
            throw new FENotFound(fileId);
        }
    }
}