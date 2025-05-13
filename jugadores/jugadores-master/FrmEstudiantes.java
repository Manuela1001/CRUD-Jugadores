package com.narvasoft.gui;

import java.util.ArrayList;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FrmEstudiantes extends javax.swing.JFrame {

    private JButton btnSave;
    private static JLabel lblId3;
    private static JLabel lblJuegof;
    private static JLabel lblLevel;
    private static JLabel lblNombre;
    private static JLabel lblScore;
    private static JTextField txtId;
    private static JTextField txtJuego;
    private static JTextField txtLevel;
    private static JTextField txtNombre;
    private static JTextField txtScore;
    private static JTextArea txtArea;
    private static JScrollPane jScrollPane1;
    private static JButton btnBuscar;
    private static JButton btnEliminar;
    private static JButton btnEditar;
    private static JButton btnCargarJugadores;


    static ArrayList<Jugadores> jugadores = CargarJugadores.leerA("jugadores.txt");



   public static void addJugador() {
        Jugadores jugador = new Jugadores(txtNombre.getText(), txtLevel.getText().charAt(0), txtJuego.getText(), Integer.parseInt(txtScore.getText()));
        jugadores.add(jugador);
        listarGuardarJugadores();
    }

    static void listarGuardarJugadores(){
       txtArea.setText("");
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append("************Listado de Jugadores***************\n");
       for(Jugadores jugador: jugadores)
           stringBuilder.append("Id: ").append(jugador.getId())
                   .append(" | Nombre: ").append(jugador.getNombre())
                   .append(" | Nivel: ").append(jugador.getLevel())
                   .append(" | Juego favorito: ").append(jugador.getJuegoFavorito())
                   .append(" | Puntaje: ").append(jugador.getMaxScore())
                   .append("\n");
       txtArea.setText(stringBuilder.toString());


       try (BufferedWriter writer = new BufferedWriter(new FileWriter("jugadores.txt"))) {
           for (Jugadores jugador : jugadores) {
               writer.write(jugador.getId() + " " + jugador.getNombre() + " " + jugador.getLevel() + " "+ jugador.getJuegoFavorito() + " " + jugador.getMaxScore());
               writer.newLine();
           }
           System.out.println();
       } catch (IOException e) {
           System.out.println();
       }

       try (BufferedWriter id = new BufferedWriter(new FileWriter("id.txt"))) {
           for (Jugadores jugador : jugadores) {
               id.write(String.valueOf(jugador.getId()));
               id.newLine();
           }
           System.out.println();
       } catch (IOException e) {
           System.out.println();
       }

   }


    public FrmEstudiantes() {
        initComponents();
    }

    static void buscarJugador() {
        int id = Integer.parseInt(txtId.getText());
        for (Jugadores jugador : jugadores) {
            if (jugador.getId() == id) {
                txtNombre.setText(jugador.getNombre());
                txtJuego.setText(jugador.getJuegoFavorito());
                txtScore.setText(String.valueOf(jugador.getMaxScore()));
                txtLevel.setText(Character.toString(jugador.getLevel()));
                return;
            }
        }
            JOptionPane.showMessageDialog(null,
                    "No se encontró ningún jugador con el ID: " + id,
                    "Jugador no encontrado",
                    JOptionPane.WARNING_MESSAGE);
   }

    static void eliminarJugador() {
        int id = Integer.parseInt(txtId.getText());
        for (Jugadores jugador : jugadores) {
            if (jugador.getId() == id) {

                int opcion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Seguro que quieres eliminar al jugador con ID: " + jugador.getId() + "?",
                        "Eliminar Jugador",
                        JOptionPane.YES_NO_OPTION
                );

                if (opcion == JOptionPane.YES_OPTION) {

                    jugadores.remove(jugador);
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el jugador con ID: "
                                    + jugador.getId(), "Eliminar jugador",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Se ha eliminado el jugador " + jugador.getId());
                    break;
                }
            }
        }

    }

    static void editarJugador() {
        int id = Integer.parseInt(txtId.getText());

        for (Jugadores jugador : jugadores){

            if (jugador.getId() == id) {

                int opcion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Confima que ingresó los nuevos datos para modificar al jugador con ID: " + jugador.getId() + "?",
                        "Editar Jugador",
                        JOptionPane.YES_NO_OPTION
                );

                if (opcion == JOptionPane.YES_OPTION) {

                    jugador.setNombre(txtNombre.getText());
                    jugador.setJuegoFavorito(txtJuego.getText());
                    jugador.setLevel(txtLevel.getText().charAt(0));
                    jugador.setMaxScore(Integer.parseInt(txtScore.getText()));

                    JOptionPane.showMessageDialog(null, "Se ha modificado el jugador con ID: "
                                    + jugador.getId(), "Modificar jugador",
                            JOptionPane.INFORMATION_MESSAGE);

                    break;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        lblJuegof = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lblId3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtLevel = new javax.swing.JTextField();
        txtJuego = new javax.swing.JTextField();
        txtScore = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCargarJugadores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre del jugador:");
        lblNombre.setToolTipText("");

        lblLevel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLevel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLevel.setText("Nivel:");
        lblLevel.setToolTipText("'");

        lblJuegof.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblJuegof.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblJuegof.setText("Juego Favorito:");

        lblScore.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblScore.setText("Score:");

        lblId3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblId3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblId3.setText("ID:");

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtLevel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtLevel.setToolTipText("P' principiante, 'I' Intermedio o 'A' Avanzado");

        txtJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtScore.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("salvar.png")));
        btnSave.setText("Guardar");
        btnSave.setToolTipText("Guardar el Jugador Actual");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("buscar.png")));
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Guardar el Jugador Actual");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("eliminar.png")));
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Guardar el Jugador Actual");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("editar.png")));
        btnEditar.setText("Editar");
        btnEditar.setToolTipText("Editar el Jugador Actual");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCargarJugadores.setText("Cargar Jugadores");
        btnCargarJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarJugadoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(btnSave)
                        .addGap(42, 42, 42)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(btnCargarJugadores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblId3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblLevel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblJuegof, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblScore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtScore, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(btnBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnCargarJugadores))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblId3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJuegof, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave))
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        addJugador();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarJugador();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarJugador();
        listarGuardarJugadores();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
          editarJugador();
          listarGuardarJugadores();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCargarJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarJugadoresActionPerformed
        listarGuardarJugadores();
    }//GEN-LAST:event_btnCargarJugadoresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEstudiantes().setVisible(true);
            }
        });
    }
    /*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargarJugadores;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId3;
    private javax.swing.JLabel lblJuegof;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblScore;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJuego;
    private javax.swing.JTextField txtLevel;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtScore;
    // End of variables declaration//GEN-END:variables
*/
}
