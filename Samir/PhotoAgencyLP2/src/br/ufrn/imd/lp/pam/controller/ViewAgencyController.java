package br.ufrn.imd.lp.pam.controller;

import br.ufrn.imd.lp.pam.dao.OrderDao;
import br.ufrn.imd.lp.pam.dao.PhotographerDao;
import br.ufrn.imd.lp.pam.dao.TourDao;
import br.ufrn.imd.lp.pam.domain.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewAgencyController implements Initializable {

    @FXML    private ListView<String> listPhotoView = new ListView<>();
    @FXML    private ListView<String> listTuorView = new ListView<>();
    @FXML    private ListView<String> listOrderView = new ListView<>();

    @FXML    private TableView<Order> tableOrderView = new TableView<>();

    // Selected Items
    ArrayList<Photographer> list = new ArrayList<>();
    Photographer selectedPhotographer;
    Tour selectedTour;
    Order selectedOrder;

    //Order TableView
    private TableColumn<Order, String> clientName = new TableColumn<>("VEJA");




    // DETAIL ORDER
    @FXML    private Label nameDetailOrder = new Label();
    @FXML    private Label packDetailOrder = new Label();
    @FXML    private Label statusDetailOrder = new Label();
    @FXML    private Label tourDetailOrder = new Label();


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

        PhotographerDao listPhotographerDao = new PhotographerDao();
        list = listPhotographerDao.listAgencyPhotographers();
        TourDao listTourDao = new TourDao();

        for (var p: list)
        {
            listPhotoView.getItems().add(p.getName());
        }

        listPhotoView.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>()
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
                    {
                        selectedPhotographer =  listPhotographerDao.findByNameAgency(newValue);

                        listTuorView.getItems().removeAll(listTuorView.getItems()); //Remove todos os itens dele mesmo, ou seja, limpa a lista

                        for (var a: selectedPhotographer.getTours())
                        {
                            listTuorView.getItems().add(a.getName());
                        }
                    }
                });

        listTuorView.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>()
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
                    {
                        selectedTour = listTourDao.findTour(newValue, selectedPhotographer.getName());

                        listOrderView.getItems().removeAll(listOrderView.getItems());

                        ObservableList<Order> orderItems = FXCollections.observableArrayList();

                        for (var a: selectedTour.getOrders())
                        {
                            listOrderView.getItems().add(a.getClientName());
                        }
                    }
                });

        listOrderView.getSelectionModel().selectedItemProperty() //TODO: Criar uma tabela no lugar da lista e armazenar Nome e ID
                .addListener(new ChangeListener<String>()
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
                    {

                    }
                });
    }

         clientName.setCellValueFactory(new PropertyValueFactory<Order, String>("clientName"));
         listOrderView.setItems(items);
         listOrderView.getColumns().add(clientName);


    //Esse metodo recebe um pedido para inicializar a janela de detalhamento com os dados desse pedido
    public void initData(Order order) {
        tourDetailOrder.setText(order.getTour().getName());
        nameDetailOrder.setText(order.getClient().getName());
        packDetailOrder.setText(order.getPhotoPack().getDescription());
        statusDetailOrder.setText(order.getOrderStatus().getInfo());
    }

    //Esse metodo recebe um pedido para inicializar a janela de detalhamento com os dados desse pedido
    public void initData()
    {
        nameDetailOrder.setText("-");
        tourDetailOrder.setText("-");
        packDetailOrder.setText("-");
        statusDetailOrder.setText("-");
    }

    // ## End Agency Body View ##


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initPhotoList(); // TODO: Configurar a lista de inicial de empresas, que servirar de base para as filtragens
    }
}