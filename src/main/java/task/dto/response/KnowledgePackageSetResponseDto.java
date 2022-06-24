package task.dto.response;

import java.util.List;

public class KnowledgePackageSetResponseDto {
    private Long id;
    private String title;
    private List<KnowledgePackageResponseDto> pacs;

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

    public List<KnowledgePackageResponseDto> getPacs() {
        return pacs;
    }

    public void setPacs(List<KnowledgePackageResponseDto> pacs) {
        this.pacs = pacs;
    }
}
