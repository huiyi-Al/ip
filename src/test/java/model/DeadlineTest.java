package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    void toStringTest(){
        Deadline deadline = new Deadline("read book", "Sunday");
        assertEquals("[D][ ] read book (by: Sunday)", deadline.toString());
    }
}
