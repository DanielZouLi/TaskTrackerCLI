package model;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String description;
    private String status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "Todo";
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }
     public int getId() {
        return id;
     }
     public void setId() {
        this.id = id;
     }
     public String getDescription() {
        return description;
     }
     public void setDescription(String description) {
        this.description = description;
        this.updateAt = LocalDateTime.now();
     }
     public String getStatus() {
        return status;
     }
     public void setStatus(String done) {
        this.status = status;
        this.updateAt = LocalDateTime.now();
     }
     public LocalDateTime getCreateAt() {
        return createAt;
     }
     public void setCreateAt() {
        this.createAt = createAt;
     }
     public LocalDateTime getUpdateAt() {
        return updateAt;
     }
     public void setUpdateAt() {
        this.updateAt = updateAt;
     }
     public String toString() {
        return "ID: " + getId() + "\n" +
                " | Description: " + getDescription() + "\n" +
                " | Status: " + getStatus() + "\n" +
                " | Created At: " +getCreateAt() + "\n" +
                " | Updated At: " + getUpdateAt() + "\n";
     }
}
