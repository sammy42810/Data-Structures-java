//Samantha Bryan
// I pledge my honor that I have abided by the Stevens Honor System

package HW3;

//Class to create a list of tasks to be completed
import java.util.Iterator;

public class MainTest {
    public static void main(String[] args) {
        testListQueue();
        testTaskList();
    }

    private static void testListQueue() {
        System.out.println("Testing ListQueue:");

        ListQueue<String> listQueue = new ListQueue<>();
        listQueue.offer("tast 2", 2);
        listQueue.offer("Task 2", 1);
        listQueue.addRear("Task 3");

        System.out.println("Peek: " + listQueue.peek());
        System.out.println("Poll: " + listQueue.poll());

        System.out.println("Size after polls: " + listQueue.getSize());

        System.out.println("Iterating through remaining elements:");
        Iterator<String> iterator = listQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Testing remove method
        ListQueue.Node nodeToRemove = listQueue.getFront().getNext();
        System.out.println("Removing node: " + nodeToRemove.getData());
        boolean removed = listQueue.remove(null);
        System.out.println("Node removed: " + removed);

        System.out.println("List after removal:");
        iterator = listQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Adding task to rear: Task 3");

        // Iterating through the list after adding rear
        System.out.println("Iterating through list after adding rear:");
        Iterator<String> it = listQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Null case
        try {
            listQueue.addRear(null);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException for null item.");
        }
    }

    private static void testTaskList() {
        System.out.println("\nTesting TaskList:");

        // Normal cases
        TaskList<String> taskList = new TaskList<>();
        taskList.createTask("Task 1");
        taskList.createTask(null, 0);

        System.out.println("Top Three Tasks:");
        System.out.println(taskList.getTopThreeTasks());

        System.out.println("Active Tasks:");
        taskList.showActiveTasks();

        System.out.println("Crossing off most urgent task:");
        taskList.crossOffMostUrgent();

        System.out.println("Completed Tasks:");
        taskList.showCompletedTasks();

        // Error case (crossing off task with invalid task number)
        System.out.println("Crossing off task with invalid task number:");
        System.out.println("Cross off result: " + taskList.crossOffTask(0));

        // Null case
        try {
            taskList.createTask(null);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException for null item.");
        }
    }
}
