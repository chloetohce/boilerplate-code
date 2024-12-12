package boilerplate.code.file_upload;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("api/boardgame")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping()
    public ResponseEntity<String> uploadFile(@RequestParam("file-upload") MultipartFile file) throws IOException {
        return fileService.add(file);
    }
}
