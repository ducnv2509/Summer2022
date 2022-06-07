package com.example.crud_staff.controller;

import com.example.crud_staff.model.Information;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Locale;

@Controller
public class InforController {
    @RequestMapping("/")
    public String register() {
        return "infor";
    }

    @PostMapping("/save")
    public String save(@RequestParam("name") String name, @RequestParam("photo") MultipartFile photo, @RequestParam("filecv") MultipartFile filecv, ModelMap modelMap) {
        Information infor = new Information();
        infor.setName(name);
        if (photo.isEmpty() || filecv.isEmpty()) {
            return "infor";
        }
        Path path = Paths.get("uploads/");
        try {
            InputStream inputStream = photo.getInputStream();
            Files.copy(inputStream, path.resolve(photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            infor.setPhoto(photo.getOriginalFilename().toLowerCase());
            inputStream = filecv.getInputStream();
            Files.copy(inputStream, path.resolve(filecv.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            modelMap.addAttribute("INFOR", infor);
            modelMap.addAttribute("FILE_NAME", filecv.getOriginalFilename());
            modelMap.addAttribute("FILE_TYPE", filecv.getContentType());
            modelMap.addAttribute("FILE_SIZE", filecv.getSize());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "view-infor";
    }
}
