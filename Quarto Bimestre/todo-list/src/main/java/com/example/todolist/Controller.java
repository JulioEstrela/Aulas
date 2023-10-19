package com.example.todolist;

import com.example.todolist.model.Task;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private TextField txtTaskName;
    @FXML
    private DatePicker dateTaskDate;
    @FXML
    private TextField txtTaskTime;
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
        Task t = new Task(txtTaskName.getText(), dateTaskDate.getValue());
        taskList.add(t);
        showTasks();
    }


}
