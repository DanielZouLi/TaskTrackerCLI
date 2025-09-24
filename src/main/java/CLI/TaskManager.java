package CLI;

import model.Task;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class TaskManager {

    private List<Task> tasks = new ArrayList<Task>();

    public void addTask(int id, String description) {
        Task newTask = new Task(id, description);
        tasks.add(newTask);
        System.out.println("Task added succesfully " + "\n"  +newTask);
    }

    public void listTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public void updateTask(int id, String description) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to update");
        } else {
            for (Task task : tasks) {
                if (task.getId() == id) {
                    task.setDescription(description);
                    break;
                }
            }
        }
    }
    public void deleteTask ( int id){
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if(task.getId() == id) {
                iterator.remove();
                System.out.println("Task deleted succesfully ");
                break;
            }
        }
    }
    public void markTaskAsDone(int id) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found");
        } else {
            for(Task task : tasks) {
                if(task.getId() == id) {
                    task.setStatus("done");
                    System.out.println("Task marked successfully as done");
                    break;
                }
            }
        }
    }
    public void markTaskInProgress(int id) {
        if(tasks.isEmpty()) {
            System.out.println("No tasks found");
        } else {
            for(Task task : tasks) {
                if(task.getId() == id) {
                    task.setStatus("Task in progress");
                    System.out.println("Task marked sucessfully as in-progress");
                    break;
                }
            }
        }
    }
}
