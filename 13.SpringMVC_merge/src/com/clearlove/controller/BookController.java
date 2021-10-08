package com.clearlove.controller;

import com.clearlove.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author promise
 * @date 2021/10/8 - 21:39
 */
@Controller
public class BookController {

  @Autowired private BookService bookService;

  public BookController() {
    System.out.println("BookController...");
  }

  @RequestMapping(value = "/hello")
  public String hello() {
    System.out.println(bookService);
    return "forward:/index.jsp";
  }
}
