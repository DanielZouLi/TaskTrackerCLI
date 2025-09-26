import CLI.TaskManager;
import model.Task;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

//        Task Task1 = new Task(1, "First CLI Tracker");
//        Task Task2 = new Task(2, "Second CLI Tracker");
//        System.out.println(Task1);
////        System.out.println(Task2);
//        manager.addTask("First Task");
//        manager.addTask("Second Task");

        System.out.println("\nAll Tasks: ");
        manager.listTask();
//
//        System.out.println("\nUpdating task: ");
//        manager.updateTask(1, "Learning Java");
//
//        System.out.println("\nChanging task status: ");
//        manager.markTaskAsDone(2);
//
//        System.out.println("\nDeleting task: ");
//        manager.deleteTask(1);
//
//        System.out.println("\nAll Tasks: ");
//        manager.listTask();
    }
}
