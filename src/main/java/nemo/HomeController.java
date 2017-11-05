package nemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("/")
    public String home(Model model) {

        model.addAttribute("jobs", jobRepository.findAll());
        return "home";
    }

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser(@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Job n = new Job();
        n.setName(name);
        n.setEmail(email);
        jobRepository.save(n);
        return "Saved";
    }

    @RequestMapping(path = "/add-job", method = RequestMethod.POST)
    public String addEntity(Job job) {
        jobRepository.save(job);
        return "home";
    }

    @RequestMapping(path = "/postJob", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("job", new Job());
        return "form";
    }


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Job> getAllUsers() {
        // This returns a JSON or XML with the users
        return jobRepository.findAll();
    }
}
