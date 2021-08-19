package com.eneselibol.projectlibrary.Controller;

import com.eneselibol.projectlibrary.Model.Publisher;
import com.eneselibol.projectlibrary.Service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/all")
    public String viewHomePage(Model model) {
        model.addAttribute("listPublisher", publisherService.getAllPublisher());
        return "allPublisher";
    }

    @GetMapping("/deletePublisher/{id}")
    public String deletePublisher(@PathVariable(value = "id") long id) {
        this.publisherService.deletePublisherById(id);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdatePublisher/{id}")
    public String showFormForUpdatePublisher(@PathVariable(value = "id") long id, Model model) {
        Publisher publisher = publisherService.getPublisherById(id);
        model.addAttribute("publisher", publisher);
        return "update_publisher";
    }

    @PostMapping("/updatePublisher/{id}")
    public String updatePublisher(@PathVariable(value = "id") long id, @ModelAttribute("publisher") Publisher publisher) {
        Publisher objpublisher = publisherService.getPublisherById(id);
        objpublisher.setPublisherName(publisher.getPublisherName());
        objpublisher.setPublisherExplanation(publisher.getPublisherExplanation());
        publisherService.savePublisher(objpublisher);

        return "redirect:/";
    }
    @GetMapping("/showNewPublisherForm")
    public String showNewPublisherForm(Model model) {
        Publisher publisher=new Publisher();
        model.addAttribute("publisher", publisher);
        return "new_publisher";
    }
    @PostMapping("/savePublisher")
    public String savePublisher(@ModelAttribute("publisher") Publisher publisher) {
        publisherService.savePublisher(publisher);
        return "redirect:/";
    }
}
