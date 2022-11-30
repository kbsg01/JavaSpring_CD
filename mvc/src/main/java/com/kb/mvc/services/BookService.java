package com.kb.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kb.mvc.models.Book;
import com.kb.mvc.repositories.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepo;

    public BookService(BookRepository bookRepo){
        this.bookRepo=bookRepo;
    }
    public List<Book> allBooks(){
        return bookRepo.findAll();
    }
    public Book createBook(Book book){
        return bookRepo.save(book);
    }
    public Book findBook(Long id){
        Optional<Book> optionalBook = bookRepo.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        }else{
            return null;
        }
    }
    public Book updateBook(Long id, String title, String description, String language, int numberOfPages){
        Book toUpdate= bookRepo.findById(id).orElse(null);
        if (toUpdate == null) {
            return null;
        }
        toUpdate.setTitle(title);
        toUpdate.setDescription(description);
        toUpdate.setLanguage(language);
        toUpdate.setNumberOfPages(numberOfPages);
        return bookRepo.save(toUpdate);
    }
    public Book updateBook(Book book){
        return bookRepo.save(book);
    }
    public void deleteBook(Long id){
        bookRepo.deleteById(id);
    }
}
