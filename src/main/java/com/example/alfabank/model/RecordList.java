package com.example.alfabank.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Date;

public class RecordList {
    //globales
    ObservableList<Record> records = FXCollections.observableArrayList();

    //constructor privado
    private RecordList(){}

    private static RecordList instance = null;

    public static RecordList getInstance() {
        if(instance == null){
            instance = new RecordList();
        }
        return instance;
    }
    public boolean delete(Date date, String type, double value, String desc) {
        for (int i = 0; i < records.size(); i++){
            if(date.compareTo(records.get(i).getDate()) == 0){
                if(value == records.get(i).getValue()){
                    if(type.equalsIgnoreCase(records.get(i).getType())){
                        if (desc.equalsIgnoreCase(records.get(i).getDesc())){
                            records.remove(i);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public ObservableList<Record> getRecords() {
        return records;
    }
    public ObservableList<Record> getIncomes(){
        ObservableList<Record> incomes = FXCollections.observableArrayList();;
        for (int i = 0; i < records.size(); i++){
            if(records.get(i).getValue() > 0){
                incomes.add(records.get(i));
            }
        }
        return incomes;
    }
    public ObservableList<Record> getCosts(){
        ObservableList<Record> costs = FXCollections.observableArrayList();;
        for (int i = 0; i < records.size(); i++){
            if(records.get(i).getValue() < 0){
                costs.add(records.get(i));
            }
        }
        return costs;
    }
    public String getBalance(){
        double counter = 0;
        for (int i = 0; i < records.size(); i++){
            counter += records.get(i).getValue();
        }
        String balance = String.valueOf(counter);
        return balance;
    }

    public void setRecords(ObservableList<Record> records) {
        this.records = records;
    }
}
