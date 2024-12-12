package boilerplate.code;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;

public class CLArgs {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CLArgs.class);
        String port = "8080";
        ApplicationArguments argsOptions = new DefaultApplicationArguments(args);

        if (argsOptions.containsOption("port")) {
            port = argsOptions.getOptionValues("port").get(0);
        }

        app.setDefaultProperties(Collections.singletonMap("server.port", port));
        System.out.println("Application running on port " + port);

        String f = "";
        if (argsOptions.containsOption("file")) {
            f = argsOptions.getOptionValues("file").get(0);
        }

        app.run(args);
    }
}
