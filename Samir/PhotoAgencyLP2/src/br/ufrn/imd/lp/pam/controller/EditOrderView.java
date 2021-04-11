package br.ufrn.imd.lp.pam.controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class EditOrderView implements Initializable {

    private int id;

    public EditOrderView(int id) {
        this.id = id;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(id);
    }
}
