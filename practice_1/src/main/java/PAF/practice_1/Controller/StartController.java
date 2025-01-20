package PAF.practice_1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/", "index.html" })
public class StartController {

    @GetMapping()
    public String start() {
        return "redirect:/loginpage";
    }

    // Show the Loginpage
    @GetMapping("/loginpage")
    public String loginpage() {
        return "loginpage";
    }
}
