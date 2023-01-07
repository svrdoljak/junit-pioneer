package junit;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junitpioneer.jupiter.json.JsonClasspathSource;

@MicronautTest
public class PioneerTest {

    private static final Logger log = LogManager.getLogger();

    @Inject
    ObjectMapper mapper;

    @Test
    void readingWorks() {
        try {
            var myDto = mapper.readValue(this.getClass().getResourceAsStream("/test-files/test-file.json"), MyDto.class);
            log.info("MY DTO: {}", myDto);
        } catch (Exception e) {
            log.error("could not read test file ", e);
        }
    }

    @ParameterizedTest
    @JsonClasspathSource(value = "test-files/test-file.json")
    void jacksonJavaTimeModuleIsNotRecognised(MyDto myDto) {
        log.info("MY DTO: {}", myDto);
	}
}
