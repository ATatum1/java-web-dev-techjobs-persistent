package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    @Autowired
    private EmployerRepository employerRepository;


    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }
    @GetMapping ("")
    public String index(Model model){
        model.addAttribute("employers",employerRepository.findAll());
        return "employers/index";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title","Add Employer"); //needed?
            model.addAttribute("employers",employerRepository.findAll()); //needed?
            return "employers/add";
        }
        //employerRepository.save(newEmployer);

        employerRepository.save(newEmployer);
        //model.addAttribute(new Employer());
        // model.addAttribute("newEmployer",newEmployer);
        return "redirect:";
    }




    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {
            //public String displayViewEmployer(Model model, @PathVariable )
        //Optional optEmployer = null;
        Optional optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer",employer);

            return "employers/view";
        } else {


            return "redirect:../";

        }

    }
}
