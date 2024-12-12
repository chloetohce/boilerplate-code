package boilerplate.code.file_upload;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import boilerplate.code.model.DemoObject;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class FileService {
    //  @Autowired
    // private FileRepository fileRepository;

    @SuppressWarnings("unused")
    public ResponseEntity<String> add(MultipartFile file) throws IOException {
        JsonReader reader = Json.createReader(file.getInputStream());
        JsonArray dataArray = reader.readArray();
        
        for (int i = 0; i < dataArray.size(); i++) {
            JsonObject obj = dataArray.get(i).asJsonObject();
            DemoObject demo = new DemoObject(
                obj.getString("name"),
                obj.getString("email"),
                obj.getJsonNumber("num").longValue()
            );

            // fileRepository.add(Constant.REDIS_KEY, demo.toString());
        }
        
        return ResponseEntity.ok().body("MESSAGE");
    }
}
