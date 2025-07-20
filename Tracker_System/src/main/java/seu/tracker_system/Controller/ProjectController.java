package seu.tracker_system.Controller;


import org.springframework.web.bind.annotation.*;
import seu.tracker_system.Api.ApiReturn;
import seu.tracker_system.Model.ProjectModel;

import java.util.ArrayList;

@RestController
public class ProjectController {

    ArrayList<ProjectModel> projectList = new ArrayList<>();


    @PostMapping("/add")
    public ApiReturn addProject(@RequestBody ProjectModel projectModel){
        projectList.add(projectModel);
        return new ApiReturn("project added successfully");
    }

    @GetMapping("/get")
    public ArrayList<ProjectModel> getProjectList(){
        return projectList;
    }


    @PutMapping("/update/{id}")
    public ApiReturn updateProject(@PathVariable int id, @RequestBody ProjectModel projectModel){
        for(int i = 0 ; i < projectList.size() ; i++){
            if(projectList.get(i).getId() == id){
                projectList.set(i, projectModel);
                return new ApiReturn("project updated successfully");
            }
        }
        return new ApiReturn("project not found");
    }


    @DeleteMapping("/delete/{id}")
    public ApiReturn deleteProject(@PathVariable int id){
        for(int i = 0 ; i < projectList.size() ; i++){
            if(projectList.get(i).getId() == id){
                projectList.remove(i);
                return new ApiReturn("project deleted successfully");
            }
        }
        return new ApiReturn("project not found");
    }


    @PutMapping("change-project-status/{id}")
    public ApiReturn changeProjectStatus(@PathVariable int id){
        for (ProjectModel p : projectList) {
            if(p.getId() == id){
                p.setStatus(!p.isStatus());
                return new ApiReturn("project status changed successfully");
            }
        }
        return new ApiReturn("project not found");
    }


    @GetMapping("/search/{title}")
    public ArrayList<ProjectModel> searchProject(@PathVariable String title){
        ArrayList<ProjectModel> searchList = new ArrayList<>();
        for (ProjectModel p : projectList) {
            if(p.getTitle().contains(title)){
                searchList.add(p);
            }
        }
        return searchList;
    }



    @GetMapping("/search-by-company-name/{companyName}")
    public ArrayList<ProjectModel> searchProjectByCompanyName(@PathVariable String companyName){
        ArrayList<ProjectModel> searchList = new ArrayList<>();
        for (ProjectModel p : projectList) {
            if(p.getCompanyName().contains(companyName)){
                searchList.add(p);
            }
        }
        return searchList;
    }
}
