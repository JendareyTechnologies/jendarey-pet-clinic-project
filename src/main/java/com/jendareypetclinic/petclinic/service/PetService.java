package com.jendareypetclinic.petclinic.service;


import com.jendareypetclinic.petclinic.model.Pet;
import com.jendareypetclinic.petclinic.repository.PetRepository;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@Service
@AllArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final FileService fileService;
    private final Path root = Paths.get("./uploads");

    public void savePet(MultipartFile file, Pet pet) throws IOException {

        if (!file.isEmpty()) {
            pet.setImageName(file.getOriginalFilename());

        } else {
            pet.setImageName("default.jpg");
        }

        Pet pet1 = petRepository.save(pet);

        if (pet1!=null) {
            try {
                String imageName = fileService.uploadImage("images", file);
            } catch (IOException exception) {
                exception.printStackTrace();
            }

        }

    }

    public String getIpAddress() {
        InetAddress ip ;

        try {
            ip = InetAddress.getLocalHost();
            System.out.println(ip);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return ip.getHostAddress();
    }


    public String getHostName() {
        InetAddress address;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }


        return address.getHostName();
    }



    public List<Pet> petList(){
        return petRepository.findAll();
    }
}
