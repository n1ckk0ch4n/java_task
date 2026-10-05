import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<Catalog> archives = new ArrayList<>();
    private LocalDateTime lastModified;

    public Catalog() {
    }

    public Catalog(List<Catalog> archives, LocalDateTime lastModified) {
        this.archives = archives != null ? archives : new ArrayList<>();
        this.lastModified = lastModified;
    }

    public List<Catalog> getArchives() {
        return archives;
    }

    public void setArchives(List<Catalog> archives) {
        this.archives = archives;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }
}