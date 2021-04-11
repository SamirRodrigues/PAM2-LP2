package br.ufrn.imd.lp.pam.controller;

import br.ufrn.imd.lp.pam.domain.Photographer;
import br.ufrn.imd.lp.pam.exception.IncompleteDataException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class PhotographerRegisterController {

    public TextField photographerRegisterName;
    public TextField photographerRegisterTelephone;
    public TextField photographerRegisterEmail;
    public TextField photographerRegisterCNPJ;

    public void AddPhotographer(ActionEvent event) throws IncompleteDataException {
        if(photographerRegisterName.getText().trim().equals("")              ||  photographerRegisterName.getText()               == null     ||
            photographerRegisterTelephone.getText().trim().equals("")        ||  photographerRegisterTelephone.getText()          == null     ||
            photographerRegisterEmail.getText().trim().equals("")            ||  photographerRegisterEmail.getText()              == null     ||
            photographerRegisterCNPJ.getText().trim().equals("")             ||  photographerRegisterCNPJ.getText()               == null)
        {

            Alert alert = new Alert(Alert.AlertType.NONE);

            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("FAVOR PREENCHER TODOS OS CAMPOS");
            alert.show();

            throw new IncompleteDataException("FAVOR PREENCHER TODOS OS CAMPOS");
        }
        else
        {
            Photographer photographer = new Photographer(photographerRegisterName.getText(),photographerRegisterTelephone.getText());
            photographer.setCpf(photographerRegisterCNPJ.getText());

            Alert alert = new Alert(Alert.AlertType.NONE);

            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText("CADASTRADO COM SUCESSO");
            alert.show();

            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        }
    }

    public void CloseWindow(ActionEvent event){
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}
