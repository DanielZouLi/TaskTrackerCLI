package CLI;
import java.util.Scanner;

public class TaskCli {
    private final TaskManager taskManager;
    private final Scanner scanner;
    public TaskCli(TaskManager taskManager) {
        this.taskManager = taskManager;
        scanner = new Scanner(System.in);
        }

        private void HandleAddTask(String [] commandArgs) {
            if(commandArgs.length > 1) {

            }
        }
    }