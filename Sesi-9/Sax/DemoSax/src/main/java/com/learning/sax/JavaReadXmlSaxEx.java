package com.learning.sax;

import java.util.List;

public class JavaReadXmlSaxEx {
    public static void main(String[] args) {
        MyRunner runner = new MyRunner();
        List<User> lines = runner.parseUsers();

        lines.forEach(System.out::println);
        // lines.forEach(System.out.println());
    }
}
