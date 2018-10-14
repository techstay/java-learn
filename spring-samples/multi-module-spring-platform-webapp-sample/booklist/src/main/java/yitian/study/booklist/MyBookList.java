package yitian.study.booklist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyBookList implements IBookList {

    @Override
    public List<String> getBookList() {
        return List.of("金瓶梅", "少年阿宾", "少妇白洁");
    }
}
