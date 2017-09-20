package com.boris.decompressor.App;

import com.boris.decompressor.Service.FileHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * Created by boris on 15.09.17.
 *
 * Controller class to get requests from the user.
 */

@Controller
@Configuration
@ComponentScan("com.boris.decompressor.Service")
public class AppController {

    @Autowired
    private FileHandlerService fileHandlerService;

    @RequestMapping("/decompress")
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String fileLink) throws IOException {
        model.addAttribute("name", fileLink);
        System.out.println(fileLink);
        fileHandlerService.processFile(fileLink);
        return "page";
    }

}
