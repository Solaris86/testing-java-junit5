package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTests {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test proper view name is returned for index page")
    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "Wrong View Returned");

        assertEquals("index", indexController.index(), () -> "Another expensive message, make me only if you have to");

        assertThat(indexController.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            indexController.oupsHandler();
        });
    }

    @Test
    @Disabled("Demo of timeout")
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
                Thread.sleep(5000);
                System.out.println("I got here");
        });
    }

    @Test
    @Disabled("Demo of timeout")
    void testTimeoutPreempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
                Thread.sleep(5000);
                System.out.println("I got here preempt");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testMeOnMacOS() {
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testMeOnWindows() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testMeOnJava8() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testMeOnJava11() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "SYSTEM")
    void testIfUserProfileNikola() {
    }
}
