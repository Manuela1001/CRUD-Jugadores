package com.narvasoft.gui;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Jugadores {
   private static final AtomicInteger idGen = new AtomicInteger(ultimoId("id.txt"));
   private int id;
   private String nombre;
   private String juegoFavorito;
   private char level;
   private int maxScore;


    public static int ultimoId(String txtId) {
        int ultimo = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(txtId))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
                    ultimo = Integer.parseInt(linea);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println();
        }

        return ultimo;
    }


    public static int getNextID() {
        return idGen.incrementAndGet();
    }

    public Jugadores(String nombre, char level, String juegoFavorito , int maxScore) {
        this.nombre =nombre;
        this.juegoFavorito = juegoFavorito;
        this.level = level;
        this.maxScore = maxScore;
        this.id=getNextID();
    }

    public Jugadores(int id, String nombre, char level, String juegoFavorito , int maxScore) {
        this.id = id;
        this.nombre = nombre;
        this.juegoFavorito = juegoFavorito;
        this.level = level;
        this.maxScore = maxScore;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getJuegoFavorito() {
        return juegoFavorito;
    }

    public void setJuegoFavorito(String juegoFavorito) {
        this.juegoFavorito = juegoFavorito;
    }

    public char getLevel() {
        return level;
    }

    public void setLevel(char level) {
        this.level = level;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

}
