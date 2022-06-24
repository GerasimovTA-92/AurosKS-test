package task.dto.request;

import javax.validation.constraints.Size;

public class KnowledgePackageSetRequestDto {
    @Size(max = 200)
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
