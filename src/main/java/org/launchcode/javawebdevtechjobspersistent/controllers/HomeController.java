package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */




@Controller
public class HomeController {


    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Jobs");
        model.addAttribute("jobs", jobRepository.findAll());

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers",employerRepository.findAll()); //added
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam int employerId,@RequestParam List<Integer> skills) {
        //Optional optJob = employerRepository.findById(employerId); //added
        Optional optEmployer = employerRepository.findById(employerId);
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }//else  {

        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            //model.addAttribute("employer",employer);

            newJob.setEmployer(employer);
//            Job job = (Job) optJob.get();
//            model.addAttribute("employerId", employerId);

            //select the employer object that has been chosen to be affiliated with the new job

            //jobRepository.save(employerId);
            //model.addAttribute("employerId",employerId);
            //employerRepository.findById(employerId);

            //model.addAttribute("employerId",jobRepository.save(Employer) Employer employerId));
            //optEmployer = employerRepository.findById(employerId);
            //newJob = employerRepository.findById(employerId);


        }
        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        return "view";
    }




}
