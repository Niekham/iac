package nl.hu.iac.webshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {
    /**
     * Upload single file using Spring Controller
     */
    @PostMapping("/api/uploadFile")
    public @ResponseBody
    RedirectView uploadFileHandler(@RequestParam("name") String name,
                                    @RequestParam("file") MultipartFile file,
                                   @RequestParam("optie") String optie) throws IOException {

        byte[] bytes = file.getBytes();

        // Creating the directory to store file
        String rootPath = "C:\\Users\\Luuk\\IdeaProjects\\iac\\src\\main\\resources";
        File dir = new File(rootPath + File.separator + "afbeeldingen");
        if (!dir.exists())
            dir.mkdirs();

        // Create the file on server
        File serverFile = new File(dir.getAbsolutePath()
                + File.separator + name);
        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();
        return new RedirectView(optie);
    }

}
