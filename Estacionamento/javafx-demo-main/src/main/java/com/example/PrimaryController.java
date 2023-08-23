package com.example;

import java.util.ArrayList;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML TextField txtProprietario;

    @FXML TextField txtValor;

    @FXML TextField txtMarca;

    @FXML TextField txtModelo;

    @FXML RadioButton btnCarro;

    @FXML RadioButton btnMoto;
    
    @FXML RadioButton btnOutro;

    @FXML ListView<Carro> listaCarros;

    ArrayList<Carro> carros = new ArrayList<>();

    @FXML
    public void adicionar(){
        String prop = txtProprietario.getText();
        Double valor = Double.parseDouble(txtValor.getText());
        String marca = txtMarca.getText();
        String modelo = txtModelo.getText();
        String categ;

        if (btnCarro.isSelected()){
            categ = "Carro";
        }
        else if (btnMoto.isSelected()){
            categ = "Moto";
        }
        else if (btnOutro.isSelected()) {
            categ = "Outro";
        }
        else {
            categ = "Não selecionado";
        }
        
        var carro = new Carro(prop, valor, marca, modelo, categ);
        carros.add(carro);
        mostrarCarros();

        deixarEmBranco();
        deselecionar();
    }

    public void mostrarCarros() {
        listaCarros.getItems().clear();
        for (var carro : carros) {
            listaCarros.getItems().add(carro);
        }
    }

    public void apagar() {
        var carro = listaCarros.getSelectionModel().getSelectedItem();
        carros.remove(carro);
        mostrarCarros();
    }

    public void editar() {
        var carro = listaCarros.getSelectionModel().getSelectedItem();
        txtProprietario.setText(carro.proprietario());
        txtValor.setText(carro.valor().toString());
        txtMarca.setText(carro.marca());
        txtModelo.setText(carro.modelo());

        if (carro.categoria() == "Carro"){
            btnCarro.setSelected(true);
        }
        else if (carro.categoria() == "Moto"){
            btnMoto.setSelected(true);
        }
        else if (carro.categoria() == "Outro") {
            btnOutro.setSelected(true);
        }
        else {
            deselecionar();
        }
        
        carros.remove(carro);
        mostrarCarros();
    }
    

    public void deixarEmBranco(){
        txtProprietario.clear();
        txtValor.clear();
        txtMarca.clear();
        txtModelo.clear();
    }

    public void deselecionar() {
        btnCarro.setSelected(false);
        btnMoto.setSelected(false);
        btnOutro.setSelected(false);
    }
}
