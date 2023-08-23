package com.example;


public record Carro (String proprietario, Double valor, String marca, String modelo, String categoria) {

    @Override
    public String toString() {
        return proprietario + " | "  + valor + " | "  + marca + " | "  + modelo + " | "  + categoria;
    }
}
