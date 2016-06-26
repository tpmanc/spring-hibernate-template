package controllers;

import models.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.FileService;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    public FileService fileService;

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(
            @RequestParam(value="categoryId", required=false, defaultValue = "0") int categoryId,
            Model model
    ) {
        File file = fileService.getFile(2);

        List<File> list = fileService.getAll();

        File edit = list.get(13);
        edit.setTitle("TEST");
        fileService.save(edit);

        model.addAttribute("title", "Index page");
        return "index/index";
    }
}
