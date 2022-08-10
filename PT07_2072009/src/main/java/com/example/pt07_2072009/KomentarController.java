package com.example.pt07_2072009;

import com.example.pt07_2072009.model.Komentar;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class KomentarController {
    @FXML
    private ListView listkomen;
    @FXML
    private TextField txtuser;
    @FXML
    private TextArea txtkomen;
    private ObservableList<Komentar>komentarlist;

    public void initialize() throws IOException {
        komentarlist = FXCollections.observableArrayList();
        showData();
    }
    public void showData() {
        listkomen.setItems(komentarlist);
    }
    public void addcom(){
        komentarlist.add(new Komentar(txtuser.getText(),txtkomen.getText()));
    }
    public void savecom(){
        BufferedWriter writer;
        String filename = "data/komen.txt";
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            Gson g = new Gson();
            String jsonGson = g.toJson(listkomen.getItems());
            writer.write(jsonGson);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadcom(){
        BufferedReader reader;
        String filename = "data/komen.txt";
        try {
            reader = new BufferedReader(new FileReader(filename));

            String json = reader.readLine();
            Gson gson = new Gson();
            Komentar[]KomentarList = gson.fromJson(json,Komentar[].class);
            listkomen.getItems().addAll(KomentarList);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void savecom2() throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(txtuser.getScene().getWindow());
        Path path = Paths.get(file.toURI());
        Gson gson = new Gson();
        String json = gson.toJson(listkomen.getItems());
        Files.write(path,json.getBytes());
    }
    public void loadcom2() throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(txtuser.getScene().getWindow());
        Path path = Paths.get(file.toURI());
        if(file != null){
            Gson gson = new Gson();
            String json = Files.readString(path);
            Komentar[]komentarlist = gson.fromJson(json,Komentar[].class);
            listkomen.getItems().addAll(komentarlist);
        }
    }
}