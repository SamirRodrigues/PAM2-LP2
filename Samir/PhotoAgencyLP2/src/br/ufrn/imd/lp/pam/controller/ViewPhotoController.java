package br.ufrn.imd.lp.pam.controller;

import br.ufrn.imd.lp.pam.dao.OrderDao;
import br.ufrn.imd.lp.pam.dao.PhotographerDao;
import br.ufrn.imd.lp.pam.dao.TourDao;
import br.ufrn.imd.lp.pam.domain.Order;
import br.ufrn.imd.lp.pam.domain.OrderStatus;
import br.ufrn.imd.lp.pam.domain.Tour;
import br.ufrn.imd.lp.pam.exception.DataNotFoundException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class ViewPhotoController implements Initializable {

    private String photographer = "Samir";
    private boolean changeValue;

    //Choice box
    @FXML private ChoiceBox choiceBox;


    @FXML    private ListView<String> listTuorView = new ListView<>();
    @FXML    private ListView<Order> listOrderView = new ListView<>();

    // Selected Items
    ArrayList<Tour> list = new ArrayList<>();
    Tour selectedTour;
    Order selectedOrder;

    // DETAIL ORDER
    @FXML    private Label nameDetailOrder = new Label();
    @FXML    private Label packDetailOrder = new Label();
    @FXML    private Label statusDetailOrder = new Label();
    @FXML    private Label tourDetailOrder = new Label();


    // ## Start Register Menu Options ##

    public void OpenRegisterNewClient() throws IOException {
        Parent tripViewParent = FXMLLoader.load(getClass().getResource("clientRegister.fxml")); // Carregando o arquivo fxml

        // Pegando informações da stage
        Stage window = new Stage();
        window.setResizable(false);
        window.setScene(new Scene(tripViewParent));
        window.show();
    }

    public void OpenRegisterNewTrip() throws IOException {
        Parent tripViewParent = FXMLLoader.load(getClass().getResource("tripRegister.fxml")); // Carregando o arquivo fxml

        // Pegando informações da stage
        Stage window = new Stage();
        window.setResizable(false);
        window.setScene(new Scene(tripViewParent));
        window.show();
    }

    //Esse metodo retorna a janela de Login
    public void OpenLoginScreen(ActionEvent event) throws IOException {
        Parent tripViewParent = FXMLLoader.load(getClass().getResource("login.fxml")); // Carregando o arquivo fxml

        Stage window = new Stage();
        window.setResizable(false);
        window.setScene(new Scene(tripViewParent));
        window.show();

        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    // ## End Register Menu Options ##

    // ## Start Agency Body View ##
    private void  initPhotoList() throws DataNotFoundException {
        initData();

        TourDao listTourDao = new TourDao();
        PhotographerDao listPhotographerDao = new PhotographerDao();

        list = listPhotographerDao.findByNameAgency(photographer).getTours();

        OrderDao listOrderDao = new OrderDao();

        for (var p: list)
        {
            listTuorView.getItems().add(p.getName());
        }


        listTuorView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    try {
                        selectedTour = listTourDao.findTour(newValue, "Samir");
                    } catch (DataNotFoundException e) {
                        e.printStackTrace();
                    }

                    if(!listOrderView.getItems().isEmpty())
                    {
                        listOrderView.getItems().removeAll(listOrderView.getItems());
                    }

                    for (var a: selectedTour.getOrders())
                    {
                        listOrderView.getItems().add(a);
                    }

                    if(listOrderView.getItems().isEmpty())
                    {
                        initData();
                    }
                });

        listOrderView.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<Order>()
                {
                    ObservableList<Order> items = FXCollections.observableArrayList();
                    @Override
                    public void changed(ObservableValue<? extends Order> observable, Order oldValue, Order newValue)
                    {
                        try {
                            selectedOrder = listOrderDao.findOrder(selectedTour.getName(),photographer,newValue.getOrderId());
                        } catch (DataNotFoundException e) {
                            e.printStackTrace();
                        }
                        changeValue = true;
                        initData(selectedOrder);
                    }
                });
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
        nameDetailOrder.setText("-");
        tourDetailOrder.setText("-");
        packDetailOrder.setText("-");
        statusDetailOrder.setText("-");
    }

    private void initChoiceBox()
    {
        choiceBox.getItems().addAll(OrderStatus.CUSTOMER_CHOOSING_PHOTOS,OrderStatus.SELECTED_PHOTOS,OrderStatus.DELIVERED,OrderStatus.EDITED,OrderStatus.PAID);
    }

    public void EditOrder(ActionEvent event) throws IOException {

            System.out.println("!");
            selectedOrder.setOrderStatus((OrderStatus) choiceBox.getValue());
            initData(selectedOrder);

    }

    // ## End Agency Body View ##


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initPhotoList();
            initChoiceBox();
        } catch (DataNotFoundException e) {
            e.printStackTrace();
        }
    }



}
