package com.codegym.controller;

import com.codegym.handler.BookException;
import com.codegym.handler.BorrowCodeException;
import com.codegym.model.bean.Book;
import com.codegym.model.bean.BorrowCode;
import com.codegym.model.service.IBookService;
import com.codegym.model.service.IBorrowCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LibraryController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IBorrowCodeService borrowCodeService;

    @GetMapping("")
    public String showBook(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "home";
    }

    @GetMapping("{id}/detail")
    public String showDetail(@PathVariable int id, Model model) throws BookException {
        Book book = bookService.findById(id);
        if (book.getAmount() == 0) {
            throw new BookException();
        }
        model.addAttribute("book", book);
        return "view";
    }

    @PostMapping("/borrow")
    public String doBorrow(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        book.setAmount(book.getAmount()-1);
        Long code = Math.round(Math.random() * 89999 + 10000);
        BorrowCode borrowCode = new BorrowCode(code, book);
        bookService.save(book);
        borrowCodeService.save(borrowCode);
        redirectAttributes.addFlashAttribute("msg", "you have successfully borrowed the book, " +
                "Your borrow code is: "+code);
        return "redirect:/";
    }

    @PostMapping("/payBack")
    public String doPayBack(@RequestParam Long code,RedirectAttributes redirectAttributes) throws BorrowCodeException {
        System.out.println(borrowCodeService.findById(code));
        BorrowCode borrowCode = borrowCodeService.findById(code);
        if (borrowCode == null){
            throw new BorrowCodeException();
        }
        Book book = borrowCode.getBook();
        book.setAmount(book.getAmount()+1);
        bookService.save(book);
        borrowCodeService.remove(code);
        redirectAttributes.addFlashAttribute("msg","you have successfully returned the book");
        return "redirect:/";
    }

    @ExceptionHandler(BookException.class)
    public String outOfLoan(){
        return "amount-error";
    }

    @ExceptionHandler(BorrowCodeException.class)
    public String codeError(){
        return "code-error";
    }

}
