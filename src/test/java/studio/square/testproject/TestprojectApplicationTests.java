package studio.square.testproject;

import com.ulisesbocchio.jasyptspringboot.configuration.EnableEncryptablePropertiesConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(EnableEncryptablePropertiesConfiguration.class)
@SpringBootTest
class TestprojectApplicationTests {

    @Test
    void contextLoads() {
    }

}
