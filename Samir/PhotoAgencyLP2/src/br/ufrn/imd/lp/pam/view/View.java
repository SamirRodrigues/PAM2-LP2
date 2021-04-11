package br.ufrn.imd.lp.pam.view;

import br.ufrn.imd.lp.pam.dao.Database;
import br.ufrn.imd.lp.pam.utils.InitData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View extends Application {

    private Database databese;

    @Override
    public void start(Stage primaryStage) throws Exception {

        databese = Database.getInstance();
        populate();

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        primaryStage.setTitle("Test");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public void populate()
    {
        databese.setAgency(InitData.createAgency());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
