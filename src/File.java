import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class File {

    private UUID id;
    private String name;
    private LocalDateTime createdAt;
    private List<Archive> files = new ArrayList<>();

    public File() {
    }

    public File(UUID id, String name, LocalDateTime createdAt, List<Archive> files) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.files = files != null ? files : new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Archive> getFiles() {
        return files;
    }

    public void setFiles(List<Archive> files) {
        this.files = files;
    }
}