package me.whiteship;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author whiteship
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/signup"}, method = GET)
    public String home() {
        return "forward:/index.html";
    }

}
