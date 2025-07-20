package seu.lab5.Controller;

import org.springframework.web.bind.annotation.*;
import seu.lab5.Api.ApiReturn;
import seu.lab5.Model.StudentModel;

import java.util.ArrayList;

@RestController
public class StudentController {

    ArrayList<StudentModel> students = new ArrayList<>();

    @PostMapping("/add")
    public ApiReturn addStudent(@RequestBody StudentModel student) {
        students.add(student);
        return new ApiReturn("Student added successfully");
    }

    @GetMapping("/get")
    public ArrayList<StudentModel> getStudents() {
        return students;
    }


    @PutMapping("/update/{id}")
    public ApiReturn updateStudent(@PathVariable("id") int id, @RequestBody StudentModel student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, student);
                return new ApiReturn("Student updated successfully");
            }
        }
        return new ApiReturn("Student not found");
    }


    @DeleteMapping("/delete/{id}")
    public ApiReturn deleteStudent(@PathVariable("id") int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return new ApiReturn("Student deleted successfully");
            }
        }
        return new ApiReturn("Student not found");
    }

    @GetMapping("/get-student-honors-categories/{id}")
    public ApiReturn honorsCategories(@PathVariable int id) {
        for (StudentModel student : students) {
            if (student.getId() == id) {
                if (student.getGpa() >= 4.7 && student.getGpa() <= 5) {
                    return new ApiReturn("First Honer ");
                } else if (student.getGpa() >= 4.5 && student.getGpa() < 4.7) {
                    return new ApiReturn("Second Honer ");
                } else if (student.getGpa() >= 4 && student.getGpa() < 4.5) {
                    return new ApiReturn("Third Honer ");
                } else if (student.getGpa() >= 3.5 && student.getGpa() < 4) {
                    return new ApiReturn("Fourth Honer ");
                } else if (student.getGpa() < 3.5) {
                    return new ApiReturn("Under Honer ");
                }


            }
        }
        return new ApiReturn("Student not found");
    }


    @GetMapping("/get-average-gpa")
    public ArrayList<StudentModel> averageGpa() {
        ArrayList<StudentModel> averageGpa = new ArrayList<>();
        double sum = 0;
        for (int i = 0; i < students.size(); i++) {
            students.get(i).getGpa();
            sum += students.get(i).getGpa();
        }
        double average = sum / students.size();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getGpa() > average) {
                averageGpa.add(students.get(i));
            }
        }
        return averageGpa;
    }


    //Not requierd but this is list to get all excellent-students
    @GetMapping("/get/excellent-students")
    public ArrayList<StudentModel> excellentStudents() {
        ArrayList<StudentModel> excellentStudents = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getGpa() >= 4.5) {
                excellentStudents.add(students.get(i));
            }
        }
        return excellentStudents;
    }


    //Not requierd but this is list to get all very-good-students
    @GetMapping("/get/very-good-students")
    public ArrayList<StudentModel> veryGoodStudents() {
        ArrayList<StudentModel> veryGoodStudents = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getGpa() >= 3.5 && students.get(i).getGpa() < 4.5) {
                veryGoodStudents.add(students.get(i));
            }
        }
        return veryGoodStudents;
    }


    //Not requierd but this is list to get all good-students
    @GetMapping("/get/good-students")
    public ArrayList<StudentModel> goodStudents() {
        ArrayList<StudentModel> goodStudents = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getGpa() >= 2.5 && students.get(i).getGpa() < 3.5) {
                goodStudents.add(students.get(i));
            }
        }
        return goodStudents;
    }


}

