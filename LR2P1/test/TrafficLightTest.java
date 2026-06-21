import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrafficLightTest {
    private TrafficLight trafficLight;
    private int changesInTest;
    private int initialTotal;

    @BeforeAll
    static void initAll() {
        TrafficLight.totalChanges = 0;
    }

    @BeforeEach
    void setUp() {
        trafficLight = new TrafficLight();
        initialTotal = TrafficLight.totalChanges;
        changesInTest = 0;
    }

    @AfterEach
    void tearDown() {
        assertEquals(changesInTest, TrafficLight.totalChanges - initialTotal);
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Total changes: " + TrafficLight.totalChanges);
    }

    @Test
    @DisplayName("Initial state is RED")
    void testInitialState() {
        assertEquals("RED", trafficLight.getCurrentColor());
        assertTrue(trafficLight.isRed());
    }

    @Test
    @DisplayName("One change: RED -> GREEN")
    void testChangeFromRedToGreen() {
        trafficLight.changeColor();
        changesInTest = 1;
        assertEquals("GREEN", trafficLight.getCurrentColor());
        assertTrue(trafficLight.isGreen());
    }

    @Test
    @DisplayName("Two changes: RED -> GREEN -> YELLOW")
    void testChangeFromGreenToYellow() {
        trafficLight.changeColor();
        trafficLight.changeColor();
        changesInTest = 2;
        assertEquals("YELLOW", trafficLight.getCurrentColor());
        assertTrue(trafficLight.isYellow());
    }

    @Test
    @DisplayName("Three changes return to RED")
    void testThreeChangesReturnRed() {
        trafficLight.changeColor();
        trafficLight.changeColor();
        trafficLight.changeColor();
        changesInTest = 3;
        assertEquals("RED", trafficLight.getCurrentColor());
        assertTrue(trafficLight.isRed());
    }
}