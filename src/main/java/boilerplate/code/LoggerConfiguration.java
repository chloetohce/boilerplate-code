package boilerplate.code;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class LoggerConfiguration {
    @Bean
    public CommonsRequestLoggingFilter log() {
        CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
        logger.setIncludeClientInfo(true);
        logger.setIncludeQueryString(true);

        return logger;
    }
}