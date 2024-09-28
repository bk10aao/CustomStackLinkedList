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
        assertTrue(new CustomStackLinkedList<>().isEmpty());
    }

    @Test
    public void pushInteger_10_toDefaultStack_returnSizeOf_1_and_elementsValueOf_10() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        int pushedItem = customStackLinkedList.push(10);
        assertFalse(customStackLinkedList.isEmpty());
        assertEquals(pushedItem, 10);
        assertEquals(1, customStackLinkedList.getSize());
    }

    @Test
    public void pushInteger_10_toCustomStackLinkedListSizeOf_32_returnSizeOf_1_and_elementsValueOf_10() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        assertEquals(customStackLinkedList.push(10), 10);
        assertFalse(customStackLinkedList.isEmpty());
    }

    @Test
    public void pushThreeIntegers__toCustomStackLinkedListSizeOf_2_returnSizeOf_3_andStackSizeOf_4() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 3; i++)
            customStackLinkedList.push(10);
        assertFalse(customStackLinkedList.isEmpty());
        assertEquals(3, customStackLinkedList.getSize());
    }

    @Test
    public void pushFiveIntegers__toCustomStackLinkedListSizeOf_2_return_size_of_5_andStackSizeOf_8() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 5; i++)
            customStackLinkedList.push(10);
        assertFalse(customStackLinkedList.isEmpty());
        assertEquals(5, customStackLinkedList.getSize());
    }

    @Test
    public void popElement_fromEmptyStack_returns_EmptyStackException() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        assertThrows(EmptyStackException.class, customStackLinkedList::pop);
    }

    @Test
    public void popElement_fromStack_returns_10() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        customStackLinkedList.push(10);
        assertEquals(1, customStackLinkedList.getSize());
        assertFalse(customStackLinkedList.isEmpty());
        assertEquals(customStackLinkedList.pop(), 10);
        assertEquals(0, customStackLinkedList.getSize());
        assertTrue(customStackLinkedList.isEmpty());
    }

    @Test
    public void peek_onEmptyStack_returns_EmptyStackException() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        assertThrows(EmptyStackException.class, customStackLinkedList::peek);
    }

    @Test
    public void peek_onStackOfTreeItems_10_20_30_returns_3() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 3; i++)
            customStackLinkedList.push((i + 1) * 10);
        assertEquals(30, customStackLinkedList.peek());
    }

    @Test
    public void pop_onEmptyStack_returns_EmptyStackException() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        assertThrows(EmptyStackException.class, customStackLinkedList::pop);
    }

    @Test
    public void popOnDefaultStack_of_10_returns_10_and_sizeOf_0() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        customStackLinkedList.push(30);
        assertEquals(30, customStackLinkedList.pop());
        assertTrue(customStackLinkedList.isEmpty());
        assertEquals(0, customStackLinkedList.getSize());
    }

    @Test
    public void popOnDefaultStack_of_10_20_30_returns_30() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 3; i++)
            customStackLinkedList.push((i + 1) * 10);
        assertEquals(30, customStackLinkedList.pop());
        assertFalse(customStackLinkedList.isEmpty());
        assertEquals(2, customStackLinkedList.getSize());
    }

    @Test
    public void createStackOfSize_8_with_eightItems_whenPopCalled_6_times_returns_stack_size_of_2() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 8; i++)
            customStackLinkedList.push((i + 1) * 10);
        for(int i = 0; i < 6; i++)
            customStackLinkedList.pop();
        assertFalse(customStackLinkedList.isEmpty());
        assertEquals(20, customStackLinkedList.peek());
        assertEquals(2, customStackLinkedList.getSize());
    }

    @Test
    public void searchEmptyDefaultStack_returns_negative_1() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        assertEquals(-1, customStackLinkedList.search(10));
    }

    @Test
    public void searchStackOfSize_10_with_no_values_returns_negative_1() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        assertEquals(-1, customStackLinkedList.search(10));
    }

    @Test
    public void searchDefaultStack_with_10_items_with_value_thatDoesNotExist_returns_negative_1() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 10; i++)
            customStackLinkedList.push((i + 1) * 10);
        assertEquals(-1, customStackLinkedList.search(1_000));
    }

    @Test
    public void searchStackOfSize_10_with_10_items_with_value_thatDoesNotExist_returns_negative_1() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 10; i++)
            customStackLinkedList.push((i + 1) * 10);
        assertEquals(-1, customStackLinkedList.search(1_000));
    }

    @Test
    public void searchDefaultStack_10_with_values_10_20_30_40_50_for_30_returns_indexOf_2() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 10; i++)
            customStackLinkedList.push((i + 1) * 10);
        assertEquals(2, customStackLinkedList.search(30));
    }

    @Test
    public void searchStackOfSize_10_with_values_10_20_30_40_50_for_30_returns_indexOf_2() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i < 10; i++)
            customStackLinkedList.push((i + 1) * 10);
        assertEquals(2, customStackLinkedList.search(30));
    }

    @Test
    public void givenSetOf_0_1_2_3_4_5_returnsCorrectStringRepresentation_on_toString() {
        CustomStackLinkedList<Integer> customStackLinkedList = new CustomStackLinkedList<>();
        for(int i = 0; i <= 5; i++)
            customStackLinkedList.push(i);
        assertEquals("{ 5, 4, 3, 2, 1, 0 }", customStackLinkedList.toString());
    }

    @Test
    public void givenEmptySet_CorrectStringRepresentation_on_toString() {
        assertEquals("{ }", new CustomStackLinkedList<>().toString());
    }
}
