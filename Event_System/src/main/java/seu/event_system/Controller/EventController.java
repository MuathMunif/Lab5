package seu.event_system.Controller;

import org.springframework.web.bind.annotation.*;
import seu.event_system.Api.ApiReturn;
import seu.event_system.Model.EventModel;

import java.util.ArrayList;

@RestController
public class EventController {

    ArrayList<EventModel> eventList = new ArrayList<>();


    @PostMapping("/add")
    public ApiReturn addEvent(@RequestBody EventModel eventModel){
        eventList.add(eventModel);
        return new ApiReturn("event added successfully");
    }


    @GetMapping("/get")
    public ArrayList<EventModel> getEvent(){
        return eventList;
    }


    @PutMapping("/update/{id}")
    public ApiReturn updateEvent(@PathVariable int id, @RequestBody EventModel eventModel){
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getId() == id){
                eventList.set(i, eventModel);
                return new ApiReturn("event updated successfully");
            }
        }
        return new ApiReturn("event not found");
    }


    @DeleteMapping("/delete/{id}")
    public ApiReturn deleteEvent(@PathVariable int id){
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getId() == id){
                eventList.remove(i);
                return new ApiReturn("event deleted successfully");
            }
        }
        return new ApiReturn("event not found");
    }

    @PutMapping("/change-capacity/{id}/{capacity}")
    public ApiReturn changeEventCapacity(@PathVariable int id, @PathVariable int capacity){
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getId() == id){
                eventList.get(i).setCapacity(capacity);
                return new ApiReturn("event capacity updated successfully");
            }
        }
        return new ApiReturn("event not found");
    }


    @GetMapping("/search-by-id/{id}")
    public ArrayList<EventModel> searchEventById(@PathVariable int id){
        ArrayList<EventModel> eventSearch = new ArrayList<>();
        for (int i = 0; i < eventList.size(); i++) {
            if(eventList.get(i).getId() == id){
                eventSearch.add(eventList.get(i));
            }
        }
        return eventSearch;
    }
}
