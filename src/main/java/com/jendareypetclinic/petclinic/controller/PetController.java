package com.jendareypetclinic.petclinic.controller;


import com.jendareypetclinic.petclinic.model.Pet;
import com.jendareypetclinic.petclinic.service.FileService;
import com.jendareypetclinic.petclinic.service.PetService;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@AllArgsConstructor
public class PetController {

    private final PetService petService;

    private final FileService fileService;

    @PostMapping("/save")
    public String savePet(@ModelAttribute Pet pet, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        petService.savePet(multipartFile,pet);
        return "redirect:/";
    }

    @GetMapping("/table")
    public String table(Model model){

        model.addAttribute("pets",petService.petList());

        String url="http://localhost:8080/image";

        model.addAttribute("img",url);

        return "table";
    }



    @GetMapping(value = "/image/{imgName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadFile(@PathVariable String imgName, HttpServletResponse response) throws IOException {

        InputStream resource = fileService.getResource("images", imgName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource, response.getOutputStream());

    }


    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("ip",petService.getIpAddress());
        model.addAttribute("hostName",petService.getHostName());
        return "index";
    }
    @GetMapping("/get")
    public String getPet( Pet pet) throws IOException {

        return "redirect:/";
    }
}
