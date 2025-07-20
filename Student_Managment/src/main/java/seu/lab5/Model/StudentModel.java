package seu.lab5.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {
    private int id;
    private String name;
    private int age;
    private String degree;
    private double gpa;

}
