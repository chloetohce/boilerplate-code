package boilerplate.code.healthcheck;

import java.io.File;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/health")
public class HealthCheck {
    
    @GetMapping("")
    public ModelAndView getHealthz() {
        ModelAndView mav = new ModelAndView();

        try {
            checkHealth();

            mav.setViewName("healthy");
            mav.setStatus(HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            mav.setViewName("unhealthy");
            mav.setStatus(HttpStatusCode.valueOf(500));
        }

        return mav;
    }

    private ResponseEntity<String> checkHealth() {
        File f = new File("test");
        if (f.exists() && f.isFile()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(400).body("{}");
    }
    
}
