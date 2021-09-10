package serenb.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FormRequestDto {
    @NotNull
    @Size(min = 3, max = 20)
    private String name;
    @Min(value = 8)
    private int age;
    @NotNull
    @Size(min = 3, max = 40)
    private String mood;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getMood() {
        return mood;
    }
}
