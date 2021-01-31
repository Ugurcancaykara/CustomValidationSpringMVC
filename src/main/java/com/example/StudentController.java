package com.example;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @RequestMapping("/showForm")
    public String showForm(Model theModel){

        Student theStudent = new Student();
        theModel.addAttribute("student",theStudent);

        theModel.addAttribute("theCountryOptions",countryOptions);

        return "student-form";

    }


    @RequestMapping("/processForm")
    public String processStudent(@ModelAttribute("student") Student theStudent){

        System.out.println("theStudent name: "+theStudent.getFirstName()+
                "\n theStudent lastname: "+theStudent.getLastName()+
                "\n theStudent country: "+theStudent.getCountry()
        );

        return "student-result";
    }


}
