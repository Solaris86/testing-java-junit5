package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.*;

@Tag("model")
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public interface ModelTests {

    @BeforeEach
    default void beforeEach(TestInfo testInfo) {
        System.out.println("Running Test - " + testInfo.getDisplayName());
    }

}
