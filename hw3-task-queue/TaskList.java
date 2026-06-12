//Samantha Bryan
// I pledge my honor that I have abided by the Stevens Honor System

package HW3;

import java.util.Iterator;

//Class to create a list of tasks to be completed
public class TaskList<E> {
    private ListQueue<E> all; //The queue of all tasks both completed and not
    private ListQueue<E> completed; //The queue of only completed tasks
    private ListQueue<E> active; //The queue of only non-complete active tasks
    private int LOW_PRIORITY = Integer.MAX_VALUE; //Establishes the lowest priority as the highest value
    private int HIGH_PRIORITY = 1; //Establishes the highest priority as the lowest value

    //Creates the queues for all, completed, and active
    public TaskList(){
        all = new ListQueue<>();
        completed = new ListQueue<>();
        active = new ListQueue<>();
    }
    //Creates a new task to enter the queue at the lowest priority
    public boolean createTask(E item) {
        if (item == null) {
            return false;
        }
        all.offer(item, LOW_PRIORITY);
        active.offer(item, LOW_PRIORITY);
        return true;
    }

    //Creates a new task to enter the queue at a given priority
    public boolean createTask(E item, int priority) {
        if (item == null) {
            return false;
        }
        all.offer(item, priority);
        active.offer(item, priority);
        return true;
    }

    //Returns the all queue
    public ListQueue<E> getAll() {
        return all;
    }

    //Returns the completed queue
    public ListQueue<E> getCompleted() {
        return completed;
    }

    //Returns the active queue
    public ListQueue<E> getActive() {
        return active;
    }

    //Prints the top three tasks in the active queue
    public String getTopThreeTasks() {
        ListQueue<E> temp = new ListQueue<>();
        StringBuilder result = new StringBuilder();
        int counter = 0;
        while (counter < 3 && active.getSize() > 0) {
            E task = active.poll();
            result.append((counter++) + ", " + task + "\n");
            temp.offer(task, counter);
        }
        while (temp.getSize() != 0) {
            active.offer(temp.poll(), counter);
        }
        return result.toString();
    }

    //Prints the active queue
    public void showActiveTasks() {
        printTasks(active);
    }

    //Prints the completed queue
    public void showCompletedTasks() {
        printTasks(completed);
    }

    //Prints the all queue
    public void showAllTasks() {
        printTasks(all);
    }

    //Prints a given queue
    private void printTasks(ListQueue<E> queue) {
        Iterator<E> i = queue.iterator();
        int counter = 1;
        while (i.hasNext()) {
            E task = i.next();
            System.out.println(counter + ". " + task);
            counter++;
        }
    }

    //Removes the highest priority task from the active queue
    public boolean crossOffMostUrgent() {
        E task = active.poll();
        if (task == null) {
            System.out.println("There are no active tasks.");
            return false;
        }
        completed.offer(task, 1);
        return true;
    }

    //Crosses off the task at a given spot in the active queue order
    public boolean crossOffTask(int taskNumber) {
        if (taskNumber < 1 || taskNumber > active.getSize()) {
            System.out.println("Task number is not in active tasks.");
            return false;
        }
        ListQueue<E> temp = new ListQueue<>();
        int counter = 1;
        while (counter < taskNumber) {
            E task = active.poll();
            temp.offer(task, counter);
            counter++;
        }
        E crossOff = active.poll();
        if (crossOff == null) {
            System.out.println("Task is not in active tasks.");
            while (temp.getSize() > 0) {
                active.offer(temp.poll(), counter);
            }
            return false;
        }
        completed.offer(crossOff, counter);
        while (temp.getSize() != 0) {
            active.offer(temp.poll(), counter);
        }
        return true;
    }
}