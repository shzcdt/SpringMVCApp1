package org.idubinov.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class firstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
         model.addAttribute("message", "Hello, " + name + " " + surname);

//        System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam("a") int firstNum,
                                 @RequestParam("b") int secondNum,
                                 @RequestParam("action") String action,
                                 Model model) {
        model.addAttribute("firstNum", firstNum);
        model.addAttribute("secondNum", secondNum);
        model.addAttribute("action", action);
        model.addAttribute("message", "DA TI MOLODECH PRAM");

        double result;

        switch (action){
            case "multiplication":
                result = firstNum * secondNum;
                break;
            case "division":
                result = firstNum / (double) secondNum;
                break;
            case "subtraction":
                result = firstNum - secondNum;
                break;
            case "additional":
                result = firstNum + secondNum;
                break;
            default:
                model.addAttribute("message", "POSHEL BI TI NAHUI");
                result = 0;
        }

        model.addAttribute("result", result);
        return "first/calculator";
    }
}
