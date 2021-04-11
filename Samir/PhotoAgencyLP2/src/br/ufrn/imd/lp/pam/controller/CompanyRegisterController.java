package br.ufrn.imd.lp.pam.controller;

import br.ufrn.imd.lp.pam.domain.Company;
import br.ufrn.imd.lp.pam.domain.Person;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CompanyRegisterController {


    public TextField companyRegisterName;
    public TextField ownerCompanyRegisterName;
    public TextField companyRegisterTelephone;
    public TextField ownerCompanyRegisterTelephone;
    public TextField companyRegisterEmail;
    public TextField companyRegisterCNPJ;

    public void AddCompany(ActionEvent event) throws Exception
    {
        if(companyRegisterName.getText().trim().equals("")              ||  companyRegisterName.getText()               == null     ||
            ownerCompanyRegisterName.getText().trim().equals("")        ||  ownerCompanyRegisterName.getText()          == null     ||
            companyRegisterTelephone.getText().trim().equals("")        ||  companyRegisterTelephone.getText()          == null     ||
            ownerCompanyRegisterTelephone.getText().trim().equals("")   ||  ownerCompanyRegisterTelephone.getText()     == null     ||
            companyRegisterEmail.getText().trim().equals("")            ||  companyRegisterEmail.getText()              == null     ||
            companyRegisterCNPJ.getText().trim().equals("")             ||  companyRegisterCNPJ.getText()               == null)
        {

            Alert alert = new Alert(Alert.AlertType.NONE);

            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("FAVOR PREENCHER TODOS OS CAMPOS");
            alert.show();
        }
        else
        {
            Person owner = new Person(ownerCompanyRegisterName.getText(), ownerCompanyRegisterTelephone.getText());

            Company company = new Company(companyRegisterName.getText(),companyRegisterTelephone.getText(),companyRegisterEmail.getText(), owner);
            company.setCnpj(companyRegisterCNPJ.getText());

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
