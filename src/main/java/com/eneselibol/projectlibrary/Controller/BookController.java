package com.eneselibol.projectlibrary.Controller;

import com.eneselibol.projectlibrary.Model.Author;
import com.eneselibol.projectlibrary.Model.Book;
import com.eneselibol.projectlibrary.Model.Publisher;
import com.eneselibol.projectlibrary.RandomLong;
import com.eneselibol.projectlibrary.Repository.AuthorRepository;
import com.eneselibol.projectlibrary.Repository.PublisherRepository;
import com.eneselibol.projectlibrary.Service.AuthorService;
import com.eneselibol.projectlibrary.Service.BookService;
import com.eneselibol.projectlibrary.Service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorRepository authorRepository;

    RandomLong aLong = new RandomLong();


    @GetMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {

        List<Book> bookList = bookService.getKeywordBooks(keyword);
        model.addAttribute("listBooks", bookList);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") long id) {
        this.bookService.deleteBookById(id);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdateBook/{id}")
    public String showFormForUpdateBook(@PathVariable(value = "id") long id, Model model) {
        Book book = bookService.getBookById(id);
        List<Publisher> publisherList = publisherService.getAllPublisher();
        model.addAttribute("publisherList", publisherList);
        List<Author> authorList = authorService.getAllAuthor();
        model.addAttribute("authorList", authorList);
        model.addAttribute("book", book);
        return "update_book";
    }


    @PostMapping("/updateBook/{id}")
    public String updateBook(@PathVariable(value = "id") long id, @ModelAttribute("book") Book book) {
        book.setBookId(id);

        Author author = authorRepository.getAuthorByAuthorName(book.getAuthor().getAuthorName());
        book.getAuthor().setAuthorId(author.getAuthorId());
        book.getAuthor().setAuthorExplanation(author.getAuthorExplanation());

        Publisher publisher = publisherRepository.getPublisherByPublisherName(book.getPublisher().getPublisherName());
        book.getPublisher().setPublisherId(publisher.getPublisherId());
        book.getPublisher().setPublisherExplanation(publisher.getPublisherExplanation());

        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        List<Publisher> publisherList = publisherService.getAllPublisher();
        model.addAttribute("publisherList", publisherList);
        List<Author> authorList = authorService.getAllAuthor();
        model.addAttribute("authorList", authorList);
        return "new_book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {

        Author author2 = authorRepository.getAuthorByAuthorName(book.getAuthor().getAuthorName());
        book.getAuthor().setAuthorId(author2.getAuthorId());
        book.getAuthor().setAuthorExplanation(author2.getAuthorExplanation());

        Publisher publisher = publisherRepository.getPublisherByPublisherName(book.getPublisher().getPublisherName());
        book.getPublisher().setPublisherId(publisher.getPublisherId());
        book.getPublisher().setPublisherExplanation(publisher.getPublisherExplanation());


        book.setBookIsbn(aLong.numberRandom());


        bookService.saveBook(book);
        return "redirect:/";
    }
}
