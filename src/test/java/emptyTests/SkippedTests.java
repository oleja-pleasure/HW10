package emptyTests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class SkippedTests {
    @Test
    void test1() {
        assertTrue(true);
    }
    @Test
    void test2() {
        assertTrue(true);
    }
    @Test
    void test3() {
        assertTrue(true);
    }
    @Test
    void test4() {
        assertTrue(true);
    }
}
