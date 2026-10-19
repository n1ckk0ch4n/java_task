package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Archive {
    private UUID id;
    private String name;
    private LocalDateTime createdAt;
    private List<File> files = new ArrayList<>();

    public Archive() {
    }

    public Archive(UUID id, String name, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<File> getFiles() { return files; }
    public void setFiles(List<File> files) { this.files = files; }
}