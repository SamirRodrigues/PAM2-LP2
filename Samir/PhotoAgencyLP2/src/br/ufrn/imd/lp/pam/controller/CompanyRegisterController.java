package br.ufrn.imd.lp.pam.controller;

import br.ufrn.imd.lp.pam.domain.Person;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CompanyRegisterController {


    public TextField companyRegisterName;
    public TextField companyRegisterTelephone1;
    public TextField companyRegisterTelephone2;
    public TextField companyRegisterEmail;
    public TextField companyRegisterCNPJ;

    public void AddClientLogin(ActionEvent event) throws Exception
    {
        if(companyRegisterName.getText().trim().equals("")          ||  companyRegisterName.getText() == null       ||
            clientRegisterTelephone1.getText().trim().equals("")    ||  clientRegisterTelephone1.getText() == null  ||
            clientRegisterEmail.getText().trim().equals("")         ||  clientRegisterEmail.getText() == null       ||
            clientRegisterCPF.getText().trim().equals("")           ||  clientRegisterCPF.getText() == null)
        {

            Alert alert = new Alert(Alert.AlertType.NONE);

            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("FAVOR PREENCHER TODOS OS CAMPOS");
            alert.show();
        }
        else
        {
            Person newCLient = new Person(clientRegisterName.getText(),clientRegisterTelephone1.getText(),clientRegisterEmail.getText());
            newCLient.setCpf(clientRegisterCPF.getText());

            Alert alert = new Alert(Alert.AlertType.NONE);

            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText("CADASTRADO COM SUCESSO");
            alert.show();

            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        }
    }

    public void CloseWindow(ActionEvent event) throws IOException {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

}
