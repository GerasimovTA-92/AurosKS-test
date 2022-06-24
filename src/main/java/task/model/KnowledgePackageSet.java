package task.model;

import java.util.List;

public class KnowledgePackageSet {
    private Long id;
    private String title;
    private List<KnowledgePackage> pacs;

    public KnowledgePackageSet() {
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

    public List<KnowledgePackage> getPacs() {
        return pacs;
    }

    public void setPacs(List<KnowledgePackage> pacs) {
        this.pacs = pacs;
    }

    @Override
    public String toString() {
        return "KnowledgePackageSet{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", kPacs=" + pacs
                + '}';
    }
}
