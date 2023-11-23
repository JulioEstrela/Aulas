package com.example.todolist;

import com.example.todolist.model.Task;
import com.example.todolist.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.tool.schema.Action;
import tornadofx.control.DateTimePicker;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerPrincipal implements Initializable {
    @FXML
    private ComboBox<String> comboBoxCategories;
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
    @FXML
    private TableColumn<Task, String> colCategory;
    @FXML
    private Button removeBtn;
    @FXML
    private Button editBtn;


    private List<String> categories = new ArrayList<>();
    private ObservableList<String> obsCategories;
    public void loadCategories() {
        String string1 = "Ciências Humanas";
        String string2 = "Ciências da Natureza";
        String string3 = "Matemática";
        String string4 = "Linguagens";
        String string5 = "Disciplinas técnicas";

        categories.add(string5);
        categories.add(string4);
        categories.add(string3);
        categories.add(string2);
        categories.add(string1);

        obsCategories = FXCollections.observableArrayList(categories);

        comboBoxCategories.setItems(obsCategories);
    }

    public void selected(javafx.scene.input.MouseEvent mouseEvent) {
        Task clickedTask = table.getSelectionModel().getSelectedItem();
        txtTaskName.setText(clickedTask.getName());
        taskDateTime.setDateTimeValue(clickedTask.getDate());
        comboBoxCategories.setPromptText(clickedTask.getCategory());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showTasks();
        toggleDisabledButton(removeBtn);
        toggleDisabledButton(editBtn);
        loadCategories();
    }

    public void edit(ActionEvent actionevent) {

        Task task = table.getSelectionModel().getSelectedItem();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.createQuery("update Task set name = :name, category = :category, date = :date where id = :taskId")
                .setParameter("name", txtTaskName.getText())
                .setParameter("date", taskDateTime.getDateTimeValue().truncatedTo(ChronoUnit.MINUTES))
                .setParameter("taskId", task.getId())
                .setParameter("category", comboBoxCategories.getSelectionModel().getSelectedItem())
                .executeUpdate();

        transaction.commit();
        session.close();

        showTasks();
    }


    private void toggleDisabledButton(Button button){
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                button.getStyleClass().remove("disabled-button");
            }
            else{
                button.getStyleClass().add("disabled-button");
            }
        });
    }

    protected List<Task> getTaskList(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Task> taskList = session.createQuery("from Task", Task.class).getResultStream().toList();
        session.close();

        return taskList;
    }

    /**
     * Exibe as tarefas na tabela
     */
    private void showTasks() {
        List<Task> taskList = getTaskList();

        table.setItems(FXCollections.observableArrayList(taskList));
        colId.setCellValueFactory(new PropertyValueFactory<Task, Integer>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<Task, String>("name"));
        colDate.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("date"));
        colCategory.setCellValueFactory(new PropertyValueFactory<Task, String>("category"));
    }

    /**
     * Este método salva a tarefa na tabela
     * @param actionEvent
     */
    public void saveTask(ActionEvent actionEvent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Task t = new Task(txtTaskName.getText(), taskDateTime.getDateTimeValue().truncatedTo(ChronoUnit.MINUTES), comboBoxCategories.getSelectionModel().getSelectedItem());
        session.persist(t);
        transaction.commit();
        session.close();

        showTasks();
    }

    public void removeTask(ActionEvent actionEvent) {
        Task task = table.getSelectionModel().getSelectedItem();

        if (task != null) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.createQuery("delete Task where id = :taskId")
                    .setParameter("taskId", task.getId()).executeUpdate();


            transaction.commit();
            session.close();

            showTasks();
        }
    }

}
