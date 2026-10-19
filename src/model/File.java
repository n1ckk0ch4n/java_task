package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class File {
    private UUID id;
    private String name;
    private String content;
    private LocalDateTime createdAt;

    public File(UUID id, String name, String content, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}