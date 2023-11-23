package assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Hauptstruktur")
class ObjectTests {
    @Nested
    @DisplayName("Null Tests")
    class NullTests {
        @Test
        void shouldBeNull() {
            assertNull(null);
        }

    }

    @Nested
    @DisplayName("Not Null Tests")
    class NotNullTests {
        @Test
        void shouldNotBeNull() {
            assertNotNull(new Object());
        }
    }

    @Nested
    @DisplayName("Identity Tests")
    class IdentityTests {

        @Test
        void shouldBeSame() {
            Object one = new Object();
            Object two = one;

            assertSame(one, two);
        }

        @Test
        void shouldNotBeSame() {
            Object one = new Object();
            Object two = new Object();

            assertNotSame(one, two);
        }

    }
}
