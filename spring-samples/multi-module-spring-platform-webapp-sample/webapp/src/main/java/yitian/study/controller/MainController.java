package yitian.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yitian.study.booklist.IBookList;

@Controller
public class MainController {
    @Autowired
    private IBookList myBookList;

    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("booklist",myBookList.getBookList());
        return "index";
    }
}
