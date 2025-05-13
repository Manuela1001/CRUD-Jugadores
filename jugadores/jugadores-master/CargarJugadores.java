package com.narvasoft.gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

    public class CargarJugadores {

        public static ArrayList<Jugadores> leerA(String nTxt) {
            ArrayList<Jugadores> lista = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(nTxt))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    String[] espacio = linea.split(" ");

                    if (espacio.length == 5) {
                        int id = Integer.parseInt(espacio[0]);
                        String nombre = espacio[1];
                        char level = espacio[2].charAt(0);
                        String juegoFavorito = espacio[3];
                        int maxScore = Integer.parseInt(espacio[4]);

                        Jugadores jugador = new Jugadores(id, nombre, level, juegoFavorito, maxScore);
                        lista.add(jugador);
                    }
                }
            } catch (IOException e) {
                System.out.println();
            }

            return lista;
        }
    }
