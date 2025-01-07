package Collections.HashSet.exercise1;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    String name;
    private final LocalDateTime date;
    private boolean isDone;

    public Task(String name) {
        this.date = LocalDateTime.now();
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isDone() {
        return isDone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return isDone == task.isDone && Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isDone);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", isDone=" + isDone +
                '}';
    }
}
