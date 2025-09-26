package CLI;

import model.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class TaskManager {
    private List<Task> tasks = new ArrayList<Task>();
    private static final String FILE_NAME = "tasks.json";

    public TaskManager() {
        loadTaskFromFile();
    }
    public void addTask(String description) {
        int newId = tasks.isEmpty() ? 1 : tasks.get(tasks.size() -1).getId() +1;
        Task newTask = new Task(newId, description);
        tasks.add(newTask);
        saveTaskToFile();
        System.out.println("Task added succesfully " + "\n"  +newTask);
    }
    public void saveTaskToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bw.write("[ ");
            for(int i = 0;i<tasks.size();i++){
                Task task = tasks.get(i);
                bw.write(String.format(
                        "{\"idTask\":%d,\"description\":\"%s\",\"status\":\"%s\",\"createdAt\":\"%s\",\"updateAt\":\"%s\"}",
                        task.getId(), task.getDescription(), task.getStatus(), task.getCreateAt(),task.getUpdateAt()
                ));
                if(i<tasks.size()-1){
                    bw.write(",");
                }
            }
            bw.write(" ]");
        } catch (IOException ex) {
            System.out.println("Error saving tasks to file" + ex.getMessage());
        }
    }
    private void loadTaskFromFile() {
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String json = br.lines().collect(Collectors.joining());
            if(!json.isEmpty() && !json.equals("[]")) {
                json = json.substring(1, json.length() - 1);
                String[] taskArray = json.split("},\\{");
                for(String task : taskArray) {
                    task = task.replace("{", "").replace("}", "");
                    String[] taskSplit = task.split(" , ");
                    Map<String, String> taskMap = new HashMap<>();
                    for(String s : taskSplit) {
                        int firstColonIndex = s.indexOf(":");
                        if(firstColonIndex != -1) {
                            String key = s.substring(0, firstColonIndex).replace("\"", "").trim();
                            String value = s.substring(firstColonIndex + 1).replace("\"", "").trim();
                            taskMap.put(key,value);
                        }
                    }
                    Task objTask = new Task(
                            Integer.parseInt(taskMap.get("idTask")),
                            taskMap.get("description")
                    );
                    objTask.setStatus(taskMap.get("status"));
                    objTask.setCreateAt(LocalDateTime.parse(taskMap.get("createAt")));
                    tasks.add(objTask);

                    }
                }
        }catch(IOException e) {
            System.out.println("Error loading tasks from file" + e.getMessage());
        }
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
