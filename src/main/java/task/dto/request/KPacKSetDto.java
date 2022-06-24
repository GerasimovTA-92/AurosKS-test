package task.dto.request;

import javax.validation.constraints.NotNull;

public class KPacKSetDto {
    @NotNull
    private Long setId;
    @NotNull
    private Long pacId;

    public Long getSetId() {
        return setId;
    }

    public void setSetId(Long setId) {
        this.setId = setId;
    }

    public Long getPacId() {
        return pacId;
    }

    public void setPacId(Long pacId) {
        this.pacId = pacId;
    }
}
