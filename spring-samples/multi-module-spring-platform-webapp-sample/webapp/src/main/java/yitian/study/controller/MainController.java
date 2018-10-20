package yitian.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yitian.study.booklist.IBookList;
import yitian.study.entity.ISpringVersion;
import yitian.study.entity.SpringVersion;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private IBookList myBookList;

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @CrossOrigin
    @RequestMapping(value = "/booklist", produces = "application/json")
    @ResponseBody
    List<String> bookList() {
        return myBookList.getBookList();
    }

    @RequestMapping(value = "/springversion", produces = "application/json")
    @ResponseBody
    ISpringVersion springVersion() {
        return new SpringVersion();
    }
}
