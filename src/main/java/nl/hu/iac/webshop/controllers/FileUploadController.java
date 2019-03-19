package nl.hu.iac.webshop.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import oracle.jdbc.proxy.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

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
        return new RedirectView("/api/"+optie+"/add");
    }

}
