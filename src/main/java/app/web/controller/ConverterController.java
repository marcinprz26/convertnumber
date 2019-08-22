package app.web.controller;

import app.web.service.Conversion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ConverterController {

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @PostMapping("/convert")
    public String convertNumber(@RequestParam("decimal") String decimal, @RequestParam("system") String system, Model model) {
        model.addAttribute("result", new Conversion().conversion(decimal, system));
        model.addAttribute("decimal", decimal);
        model.addAttribute("system", system);
        return "index";
    }
}
