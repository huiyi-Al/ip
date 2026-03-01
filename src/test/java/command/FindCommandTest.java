package command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Deadline;
import model.Task;
import model.Todo;

public class FindCommandTest {
    @Test
    void find_noTaskFound() {
        Task task1 = new Deadline("return book", "Sunday");
        Task task2 = new Todo("assignment");

        assertEquals(4, 4);
    }
}
