package seu.tracker_system.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectModel {
    private int id;
    private String title;
    private String description;
    private boolean status;
    private String companyName;
}
