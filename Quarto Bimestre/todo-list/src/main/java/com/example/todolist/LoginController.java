package com.example.todolist;

import com.example.todolist.model.User;
import com.example.todolist.util.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginController {
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserRegister;
    @FXML
    private Label userRegisterErrorLbl;
    @FXML
    private PasswordField txtPasswordRegister;
    @FXML
    private Label userSuccessfullyRegisteredLbl;

    @FXML
    private void loginUser(ActionEvent event) {
        //if user exists in db -> go to tasks screen
        //else, tells user: incorrect login/password

        if (isUserRegistered()){
            HelloApplication.changeScreen("tasks");
        }
    }

    protected boolean isUserRegistered(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Transaction transaction = session.beginTransaction();

        User user = session.createQuery("from User where login = :login and password = :password", User.class)
                .setParameter("login", txtUser.getText())
                .setParameter("password", txtPassword.getText())
                .uniqueResult();

        session.close();

        return user != null;
    }

    @FXML
    private void registerUser(ActionEvent event){
        userRegisterErrorLbl.setText("");
        userSuccessfullyRegisteredLbl.setText("");

        if(txtUserRegister.getText().equals("") || txtPasswordRegister.getText().equals("")) {
            userRegisterErrorLbl.setText("Usuário em branco");
            return;
        }

        User user = new User(txtUserRegister.getText(), txtPasswordRegister.getText());

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.persist(user);
            transaction.commit();
            session.close();
            userSuccessfullyRegisteredLbl.setText("User successfully registered!");
        }catch (Exception e){
            userRegisterErrorLbl.setText("User already exists");
            transaction.rollback();
        }
    }

}
