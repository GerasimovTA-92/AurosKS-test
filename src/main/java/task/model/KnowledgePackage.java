package task.model;

public class KnowledgePackage {
    private Long id;
    private String title;
    private String description;
    private String creationDate;

    public KnowledgePackage() {
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "KPac{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", description='" + description + '\''
                + ", creationDate='" + creationDate + '\''
                + '}';
    }
}
