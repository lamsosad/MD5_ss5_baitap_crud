package lam.ss5_baithuchanh.controller;

import lam.ss5_baithuchanh.model.entity.Music;
import lam.ss5_baithuchanh.model.service.IServiceMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class MusicController {
    @Autowired
    private IServiceMusic serviceMusic;

    @GetMapping("/")
    public ModelAndView listMusic() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("music", serviceMusic.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "createMusic";
    }
    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable("id") String idDel){
        serviceMusic.deleteById(Long.valueOf(idDel));
        return "redirect:/";
    }

    @Value("${file-upload}")
    private String fileUpload;

    @PostMapping("/add")
    public String add(@RequestParam("song") MultipartFile song,
                      @RequestParam("nameSong") String nameSong,
                      @RequestParam("nameSinger") String nameSinger,
                      Model model) throws IOException {
        File file = new File(fileUpload);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = song.getOriginalFilename();
        FileCopyUtils.copy(song.getBytes(), new File(fileUpload +File.separator+ fileName));
        serviceMusic.save(new Music(nameSong,nameSinger,fileName));
        return "redirect:/";
    }

}
