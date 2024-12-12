package boilerplate.code.file_reading;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceReading {

    @Value("classpath:data/resource-data.txt")
    Resource resourceFile;
    
    //File name does not need to start with "/"
    public void readFile(String fileName) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(fileName);
        byte [] bytes = classPathResource.getContentAsByteArray();
        String rawData = new String(bytes, StandardCharsets.UTF_8);

        System.out.println(rawData);
    }
}
