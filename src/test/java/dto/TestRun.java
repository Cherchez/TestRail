package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestRun {

    String references;
    String assignTo;
    String description;

}
