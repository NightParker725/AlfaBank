package com.example.alfabank.model;

import com.example.alfabank.HelloApplication;
import com.example.alfabank.model.Record;
import com.example.alfabank.model.RecordList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class RegisterController implements Initializable {
    @FXML
    private TextField dateTF;

    @FXML
    private Button deleteBTN;

    @FXML
    private TextField descTF;

    @FXML
    private ImageView logoIMG;

    @FXML
    private Button recViewBTN;

    @FXML
    private Button registerBTN;

    @FXML
    private TextField typeTF;

    @FXML
    private TextField valueTF;
    @FXML
    void viewRecords(ActionEvent event){
        Stage stage = (Stage) this.recViewBTN.getScene().getWindow();
        stage.close();
        HelloApplication.openWindow("hello-view.fxml");
    }
    @FXML
    void record(ActionEvent event) {
        try {
            double value = parseInt(valueTF.getText());
            String type = typeTF.getText();
            String desc = descTF.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dstr  = dateTF.getText();
            Date date = sdf.parse(dstr);
            System.out.println(date);
            if (date != null) {
                Record record = new Record(value, type, desc, date);
                if (record != null) {
                    RecordList.getInstance().getRecords().add(record);
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Exito");
                alert.setContentText("El registro ha sido realizado");
                alert.showAndWait();
                valueTF.setText(null);
                typeTF.setText(null);
                descTF.setText(null);
                dateTF.setText(null);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("La fecha es incorrecta");
                alert.showAndWait();
            }

        } catch (ParseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("La fecha es incorrecta");
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    void delete(ActionEvent event){
        try {
            double value = parseInt(valueTF.getText());
            String type = typeTF.getText();
            String desc = descTF.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dstr  = dateTF.getText();
            Date date = sdf.parse(dstr);
            if (date != null) {
                if (RecordList.getInstance().delete(date, type, value, desc)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Exito");
                    alert.setContentText("El registro ha sido removido");
                    alert.showAndWait();
                    valueTF.setText(null);
                    typeTF.setText(null);
                    descTF.setText(null);
                    dateTF.setText(null);
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("La el registro no existe");
                    alert.showAndWait();
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("La fecha es incorrecta");
                alert.showAndWait();
            }

        } catch (ParseException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("La fecha es incorrecta");
            alert.showAndWait();
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
