package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping(method = {RequestMethod.POST}, value = "hello")
public class HelloController {

    //handle request at path //http://localhost:8080/hello/goodbye
//    @GetMapping("goodbye")
//    public String goodbye(){
//        return "Goodbye, Spring!";
//    }

    //handle requests of the form http://localhost:8080/hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
//    }

    @GetMapping()
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name.isEmpty()) {
            name = "World";
        }

        return createMessage(name, language);
    }


    //handle requests of the form http://localhost:8080/hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //handles requests for http://localhost:8080/hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name='language' id='language-select'>" +
                    "<option value='english'>English</option>" +
                    "<option value='french'>French</option>" +
                    "<option value='spanish'>Spanish</option>" +
                    "<option value='german'>German</option>" +
                    "<option value='italian'>Italian</option>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }


    public static String createMessage(String name, String language) {
        String greeting = "";

        if (language.equals("english")) {
            greeting = "Hello";
        } else if (language.equals("french")) {
            greeting = "Bonjour";
        } else if (language.equals("spanish")) {
            greeting = "Hola";
        } else if (language.equals("german")) {
            greeting = "hallo";
        } else if (language.equals("italian")) {
            greeting = "Bonjourno";
        }

        //return greeting + " " + name + "!";
        return "<html>" +
                "<body>" +
                "<center><div>" +
                "<center><h2>" + greeting + " " + name + "!" +
                "<br><br>Have a wonderful day!</h2></center>" +
                "</body>" +
                "<html>";
    }

}
