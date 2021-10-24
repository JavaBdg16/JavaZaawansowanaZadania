package stack;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("A stack")
public class StackTests {

    private Stack<Object> stack;

    @DisplayName("when new")
    @Nested
    public class WhenNew {

        @BeforeEach
        public void createNewStack() {
            stack = new Stack<>();
        }

        @Test
        @DisplayName("should be empty")
        public void shouldBeEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        public void shouldThrowEmptyStackExceptionWhenPopped() {
            assertThrows(EmptyStackException.class, stack::pop);
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        public void shoudThrowEpmtyStackExceptionWhenPeeked() {
            assertThrows(EmptyStackException.class, stack::peek);
        }

        @Nested
        @DisplayName("after adding")
        public class AfterAdding {

            String element = "an element";

            @BeforeEach
            public void pushAnElement() {
                try {
                    stack.add(element);
                } catch (StackMaxSizeException e) {
                    fail(e.getMessage());
                } catch (StackDuplicateElementException e) {
                    fail(e.getMessage());
                }
            }

            @Test
            @DisplayName("should return element when popped")
            public void shouldReturnElementWhenPopped() {
                try {
                    assertEquals(element, stack.pop());
                } catch (EmptyStackException e) {
                    fail(e.getMessage());
                }
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("should return element when peeked")
            public void shouldReturnElementWhenPeeked() {
                try {
                    assertEquals(element, stack.peek());
                } catch (EmptyStackException e) {
                    fail(e.getMessage());
                }
                assertFalse(stack.isEmpty());
            }
        }
    }

    @Nested
    @DisplayName("when new and bounded")
    public class WhenNewAndBounded {

        private String element = "an element";

        @BeforeEach
        public void createNewStack() {
            stack = new Stack<>(0);
        }

        @Test
        @DisplayName("should throw StackMaxSizeException when adding")
        public void shouldThrowStackMaxSizeExceptionWhenAdding() {
            assertThrows(StackMaxSizeException.class, () -> stack.add(element));
        }
    }

}
