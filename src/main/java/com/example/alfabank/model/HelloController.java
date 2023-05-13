package com.example.alfabank.model;

import com.example.alfabank.HelloApplication;
import com.example.alfabank.model.Record;
import com.example.alfabank.model.RecordList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button costViewBTN;

    @FXML
    private TableColumn<Record, String> dateTC;

    @FXML
    private TableColumn<Record, String> descTC;
    @FXML
    private TableColumn<Record, String> typeTC;
    @FXML
    private Button homeBTN;

    @FXML
    private Button incViewBTN;

    @FXML
    private TableColumn<Record, Double> recordTC;

    @FXML
    private TableView<Record> recordsTV;

    @FXML
    private Button viewBTN;
    @FXML
    private Label balanceLB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        recordTC.setCellValueFactory(new PropertyValueFactory<>("value"));
        typeTC.setCellValueFactory(new PropertyValueFactory<>("type"));
        descTC.setCellValueFactory(new PropertyValueFactory<>("desc"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        recordsTV.setItems(RecordList.getInstance().getRecords());
        recordsTV.getSortOrder().add(dateTC);
        balanceLB.setText(RecordList.getInstance().getBalance());


        viewBTN.setOnAction(action->{
            recordsTV.setItems(RecordList.getInstance().getRecords());
            recordsTV.getSortOrder().add(dateTC);
            dateTC.setSortType(TableColumn.SortType.DESCENDING);
        } );

        costViewBTN.setOnAction(action ->{
            recordsTV.setItems(RecordList.getInstance().getCosts());
            recordsTV.getSortOrder().add(dateTC);
        });

        incViewBTN.setOnAction(action ->{
            recordsTV.setItems(RecordList.getInstance().getIncomes());
            recordsTV.getSortOrder().add(dateTC);
        });

        homeBTN.setOnAction(action->{
            Stage stage = (Stage) this.homeBTN.getScene().getWindow();
            stage.close();
            HelloApplication.openWindow("register-view.fxml");
        });
    }
}
