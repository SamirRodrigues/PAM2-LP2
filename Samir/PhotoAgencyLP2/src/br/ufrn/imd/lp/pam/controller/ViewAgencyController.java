package br.ufrn.imd.lp.pam.controller;

import br.ufrn.imd.lp.pam.dao.Database;
import br.ufrn.imd.lp.pam.domain.*;

import javafx.beans.property.adapter.JavaBeanStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewAgencyController implements Initializable {

    public ListView<String> listPhotoView;
    public ListView<String> listTuorView;
    public ListView<String> listOrderView;

    // DETAIL ORDER
    public Label nameDetailOrder;
    public Label packDetailOrder;
    public Label statusDetailOrder;
    public Label tourDetailOrder;


    // ## Start Register Menu Options ##

    //Esse metodo Inicia a janela de cadastro de uma nova empresa parceira
    public void OpenRegisterNewCompany() throws IOException {
        Parent tripViewParent = FXMLLoader.load(getClass().getResource("companyRegister.fxml")); // Carregando o arquivo fxml

        // Pegando informações da stage
        Stage window = new Stage();
        window.setResizable(false);
        window.setScene(new Scene(tripViewParent));
        window.show();
    }
    //Esse metodo Inicia a janela de cadastro de um(a) novo(a) fotografo(a) parceiro(a)
    public void OpenRegisterNewPhotographer() throws IOException {
        Parent tripViewParent = FXMLLoader.load(getClass().getResource("photographerRegister.fxml")); // Carregando o arquivo fxml

        // Pegando informações da stage
        Stage window = new Stage();
        window.setResizable(false);
        window.setScene(new Scene(tripViewParent));
        window.show();
    }

    // ## End Register Menu Options ##

    // ## Start Agency Body View ##

    private void  initPhotoList() {
        initData();

        for (var p: Database.getInstance().getAgency().getPhotographers())
        {
            listPhotoView.getItems().addAll(p.getName());
        }
        listPhotoView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    //Esse metodo recebe um pedido para inicializar a janela de detalhamento com os dados desse pedido
    public void initData(Order order) {
        tourDetailOrder.setText(order.getTour().getName());
        nameDetailOrder.setText(order.getClient().getName());
        packDetailOrder.setText(order.getPhotoPack().getDescription());
        statusDetailOrder.setText(order.getOrderStatus().getInfo());

    }

    //Esse metodo recebe um pedido para inicializar a janela de detalhamento com os dados desse pedido
    public void initData() {

        listPhotoView = new ListView<>();
        listTuorView = new ListView<>();
        listOrderView = new ListView<>();

        nameDetailOrder = new Label();
        tourDetailOrder = new Label();
        packDetailOrder = new Label();
        statusDetailOrder = new Label();


        nameDetailOrder.setText("-");
        tourDetailOrder.setText("-");
        packDetailOrder.setText("-");
        statusDetailOrder.setText("-");

    }

    // Executa o detalhamento do pedido selecionado
    public void ButtonDetailsOrders()
    {


    }

    // Executa o detalhamento do pedido selecionado
    public void ButtonTuorFilter()
    {
    }

    // Executa o detalhamento do pedido selecionado
    public void ButtonOrderFilter()
    {

    }

    // ## End Agency Body View ##


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initPhotoList(); // TODO: Configurar a lista de inicial de empresas, que servirar de base para as filtragens
    }
}