package br.ufrn.imd.lp.pam.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class ClientRegisterController {

    public TextField clientRegisterName;
    public TextField clientRegisterTelephone1;
    public TextField clientRegisterTelephone2;
    public TextField clientRegisterEmail;
    public TextField clientRegisterCPF;

    public void AddClientLogin(ActionEvent event) throws Exception
    {
        clientRegisterName.getText();
        clientRegisterTelephone1.getText();
        clientRegisterTelephone2.getText();
        clientRegisterEmail.getText();
        clientRegisterCPF.getText();
    }

    public void CloseWindow()
    {

    }

}
