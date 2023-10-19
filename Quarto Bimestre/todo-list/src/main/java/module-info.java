module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;


    opens com.example.todolist to javafx.fxml;
    opens com.example.todolist.model to org.hibernate.orm.core;
    exports com.example.todolist;
    exports com.example.todolist.model;
}