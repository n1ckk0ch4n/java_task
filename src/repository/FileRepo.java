package repository;

import exception.FileExceptionNotFound;
import model.Archive;
import model.File;

import java.util.UUID;

public class FileRepo implements FileRepository{
    @Override
    public File addFile(Archive archive, File file) {
        archive.getFiles().add(file);
        return file;
    }
    @Override
    public File removeFile(Archive archive, UUID fileId) {
        boolean removed = archive.getFiles().removeIf(f -> f.getId().equals(fileId));
        if (!removed) {
            throw new FileExceptionNotFound(fileId);
        }
        return null;
    }
}