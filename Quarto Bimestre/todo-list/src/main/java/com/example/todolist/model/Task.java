package com.example.todolist.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


/**
 * Objeto com os atributos da tarefa
 */
@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private boolean isDone; //Task is done?
    @Column
    private String name;
    @Column
    private LocalDate date;
    @Column
    private LocalTime time;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "task-category", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    public Task(String name, LocalDate date) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.isDone = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", isDone=" + isDone +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", categories=" + categories +
                '}';
    }
}
