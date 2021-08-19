package com.eneselibol.projectlibrary.Controller;

import com.eneselibol.projectlibrary.Model.Author;
import com.eneselibol.projectlibrary.Model.Book;
import com.eneselibol.projectlibrary.Model.Publisher;
import com.eneselibol.projectlibrary.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/all")
    public String viewHomePage(Model model){
        model.addAttribute("listAuthor",authorService.getAllAuthor());
        return "allAuthor";
    }
    @GetMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable(value = "id") long id) {
        this.authorService.deleteAuthorById(id);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdateAuthor/{id}")
    public String showFormForUpdateAuthor(@PathVariable(value = "id") long id, Model model) {
        Author author=authorService.getAuthorById(id);
        model.addAttribute("author",author);
        return "update_author";
    }

    @PostMapping("/updateAuthor/{id}")
    public String updateAuthor(@PathVariable(value = "id") long id,@ModelAttribute("author") Author author) {
        Author objauthor=authorService.getAuthorById(id);
        objauthor.setAuthorName(author.getAuthorName());
        objauthor.setAuthorExplanation(author.getAuthorExplanation());
        authorService.saveAuthor(objauthor);
        return "redirect:/";
    }
    @GetMapping("/showNewAuthorForm")
    public String showNewAuthorForm(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "new_author";
    }
    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("author") Author author) {
        authorService.saveAuthor(author);
        return "redirect:/";
    }

}
