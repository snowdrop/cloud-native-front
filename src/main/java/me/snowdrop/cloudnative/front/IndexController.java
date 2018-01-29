package me.snowdrop.cloudnative.front;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final String hostname;

    public IndexController(
        @Value("#{systemEnvironment['HOSTNAME'] == null ? 'local': systemEnvironment['HOSTNAME']}") String hostname) {

        this.hostname = hostname;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("hostname", hostname);
        return "index";
    }
}
