package yitian.study.jacksonspringbootsample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
public class MainController {
    private ObjectMapper jsonMapper;
    private XmlMapper xmlMapper;
    private Person person = new Person("yitian", 10000, LocalDate.of(1994, 1, 1));

//    public MainController( ObjectMapper jsonMapper,XmlMapper xmlMapper) {
//        this.jsonMapper = jsonMapper;
//        this.xmlMapper = xmlMapper;
//    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/xml", produces = "application/xml")
    @ResponseBody
    public Person xml() throws JsonProcessingException {
        return person;
    }

    @RequestMapping(value = "/json", produces = "application/json")
    @ResponseBody
    public Person json() throws JsonProcessingException {
        return person;
    }
}
