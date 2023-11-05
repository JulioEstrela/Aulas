package com.example.todolist;

import com.example.todolist.model.Task;
import com.example.todolist.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tornadofx.control.DateTimePicker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private TextField txtTaskName;
    @FXML
    private DateTimePicker taskDateTime;
    @FXML
    private TableView<Task> table;
    @FXML
    private TableColumn<Task, Integer> colId;
    @FXML
    private TableColumn<Task, String> colName;
    @FXML
    private TableColumn<Task, LocalDate> colDate;

    List<Task> taskList = new ArrayList<>();

    /**
     * Exibe as tarefas na tabela
     */
    private void showTasks() {
        table.setItems(FXCollections.observableArrayList(taskList));
        colId.setCellValueFactory(new PropertyValueFactory<Task, Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Task, String>("name"));
        colDate.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("date"));
    }

    /**
     * Este método salva a tarefa na tabela
     * @param actionEvent
     */
    public void salvar(ActionEvent actionEvent) {
        //TODO get hour
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Task t = new Task(txtTaskName.getText(), taskDateTime.getDateTimeValue().truncatedTo(ChronoUnit.MINUTES));
        session.persist(t);
        transaction.commit();

        taskList.add(t);
        showTasks();
    }


}
