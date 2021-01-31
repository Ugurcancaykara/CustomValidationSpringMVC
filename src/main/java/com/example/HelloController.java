package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printHelloWorld(ModelMap modelMap){

        // add attribute to load modelMap
        modelMap.addAttribute("message",
                "Hello World and Welcome to Spring MVC!");

        // return the name of the file to be loaded "hello_world.jsp"
        return "main-team";
    }

    @RequestMapping("showMeMore")
    public String showEverything(){

        return "helloworld-form";
    }

    @RequestMapping("showEverything")
    public String showEveryEverything(HttpServletRequest request, Model model){
        String theName = request.getParameter("studentName");

        theName = theName.toUpperCase();
        theName = "Yo Bitch! "+theName;
        model.addAttribute("message",theName);

        return "submitform";
    }

    @RequestMapping("processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName,Model model){

        theName = theName.toUpperCase();

        String result = "Hey Friend v3! "+theName;
        model.addAttribute("message",result);

        return "submitform";
    }

}