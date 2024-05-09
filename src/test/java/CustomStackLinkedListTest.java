import org.CustomStackLinkedList.CustomStackLinkedList;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomStackLinkedListTest {

    @Test
    public void instantiateDefaultCustomStackLinkedList_returns_emptyStack() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        assertTrue(CustomStackLinkedList.isEmpty());
    }

    @Test
    public void instantiateCustomStackLinkedListWithSizeOf_64_returns_emptyStack() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        assertTrue(CustomStackLinkedList.isEmpty());
    }

    @Test
    public void pushInteger_10_toDefaultStack_returnSizeOf_1_and_elementsValueOf_10() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        Object item = 10;
        Object pushedItem =  CustomStackLinkedList.push(item);
        assertFalse(CustomStackLinkedList.isEmpty());
        assertEquals(pushedItem, item);
        assertEquals(1, CustomStackLinkedList.getSize());
    }

    @Test
    public void pushInteger_10_toCustomStackLinkedListSizeOf_32_returnSizeOf_1_and_elementsValueOf_10() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        Object item = 10;
        Object pushedItem =  CustomStackLinkedList.push(item);
        assertFalse(CustomStackLinkedList.isEmpty());
        assertEquals(pushedItem, item);
    }

    @Test
    public void pushThreeIntegers__toCustomStackLinkedListSizeOf_2_returnSizeOf_3_andStackSizeOf_4() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        Object item = 10;
        for(int i = 0; i < 3; i++) {
            CustomStackLinkedList.push(item);
        }
        assertFalse(CustomStackLinkedList.isEmpty());
        assertEquals(3, CustomStackLinkedList.getSize());
    }

    @Test
    public void pushFiveIntegers__toCustomStackLinkedListSizeOf_2_return_size_of_5_andStackSizeOf_8() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        Object item = 10;
        for(int i = 0; i < 5; i++) {
            CustomStackLinkedList.push(item);
        }
        assertFalse(CustomStackLinkedList.isEmpty());
        assertEquals(5, CustomStackLinkedList.getSize());
    }

    @Test
    public void popElement_fromEmptyStack_returns_EmptyStackException() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        assertThrows(EmptyStackException.class, CustomStackLinkedList::pop);
    }

    @Test
    public void popElement_fromStack_returns_10() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        Object item = 10;
        CustomStackLinkedList.push(item);
        assertEquals(1, CustomStackLinkedList.getSize());
        assertFalse(CustomStackLinkedList.isEmpty());
        Object result = CustomStackLinkedList.pop();
        assertEquals(result, item);
        assertEquals(0, CustomStackLinkedList.getSize());
        assertTrue(CustomStackLinkedList.isEmpty());
    }

    @Test
    public void peek_onEmptyStack_returns_EmptyStackException() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        assertThrows(EmptyStackException.class, CustomStackLinkedList::peek);
    }

    @Test
    public void peek_onStackOfTreeItems_10_20_30_returns_3() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 3; i++) {
            Object item = (i + 1) * 10;
            CustomStackLinkedList.push(item);
        }
        Object expected = 30;
        assertEquals(expected, CustomStackLinkedList.peek());
    }

    @Test
    public void pop_onEmptyStack_returns_EmptyStackException() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        assertThrows(EmptyStackException.class, CustomStackLinkedList::pop);
    }

    @Test
    public void popOnDefaultStack_of_10_returns_10_and_sizeOf_0() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        Object item = 30;
        CustomStackLinkedList.push(item);
        assertEquals(item, CustomStackLinkedList.pop());
        assertTrue(CustomStackLinkedList.isEmpty());
        assertEquals(0, CustomStackLinkedList.getSize());
    }

    @Test
    public void popOnDefaultStack_of_10_20_30_returns_30() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 3; i++) {
            Object item = (i + 1) * 10;
            CustomStackLinkedList.push(item);
        }
        Object expected = 30;
        assertEquals(expected, CustomStackLinkedList.pop());
        assertFalse(CustomStackLinkedList.isEmpty());
        assertEquals(2, CustomStackLinkedList.getSize());
    }

    @Test
    public void createStackOfSize_8_with_eightItems_whenPopCalled_6_times_returns_stack_size_of_2() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 8; i++) {
            Object item = (i + 1) * 10;
            CustomStackLinkedList.push(item);
        }
        for(int i = 0; i < 6; i++) {
            CustomStackLinkedList.pop();
        }
        Object expected = 20;
        assertFalse(CustomStackLinkedList.isEmpty());
        assertEquals(expected, CustomStackLinkedList.peek());
        assertEquals(2, CustomStackLinkedList.getSize());
    }

    @Test
    public void searchEmptyDefaultStack_returns_negative_1() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        Object doesNotExist = 10;
        assertEquals(-1, CustomStackLinkedList.search(doesNotExist));
    }

    @Test
    public void searchStackOfSize_10_with_no_values_returns_negative_1() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        Object doesNotExist = 10;
        assertEquals(-1, CustomStackLinkedList.search(doesNotExist));
    }

    @Test
    public void searchDefaultStack_with_10_items_with_value_thatDoesNotExist_returns_negative_1() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 10; i++) {
            Object item = (i + 1) * 10;
            CustomStackLinkedList.push(item);
        }
        Object doesNotExist = 1_000;
        assertEquals(-1, CustomStackLinkedList.search(doesNotExist));
    }

    @Test
    public void searchStackOfSize_10_with_10_items_with_value_thatDoesNotExist_returns_negative_1() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 10; i++) {
            Object item = (i + 1) * 10;
            CustomStackLinkedList.push(item);
        }
        Object doesNotExist = 1_000;
        assertEquals(-1, CustomStackLinkedList.search(doesNotExist));
    }

    @Test
    public void searchDefaultStack_10_with_values_10_20_30_40_50_for_30_returns_indexOf_2() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 10; i++) {
            Object item = (i + 1) * 10;
            CustomStackLinkedList.push(item);
        }
        Object expected = 30;
        assertEquals(2, CustomStackLinkedList.search(expected));
    }

    @Test
    public void searchStackOfSize_10_with_values_10_20_30_40_50_for_30_returns_indexOf_2() {
        CustomStackLinkedList<Object> CustomStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 10; i++) {
            Object item = (i + 1) * 10;
            CustomStackLinkedList.push(item);
        }
        Object expected = 30;
        assertEquals(2, CustomStackLinkedList.search(expected));
    }
}
