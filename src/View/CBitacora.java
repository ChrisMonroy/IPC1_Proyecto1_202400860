/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author Christopher
 */
import javax.swing.*;
import Model.Bitacora;

public class CBitacora {
    private JFrame frame;
    private Bitacora bitacora;

    public CBitacora(Bitacora bitacora) {
        this.bitacora = bitacora;
        crearVista();
    }

    private void crearVista() {
        frame = new JFrame("Bitácora");
        JTextArea textArea = new JTextArea(20, 40);
        textArea.setEditable(false);
        String[] registros = bitacora.obtenerRegistros();
        for (String registro : registros) {
            textArea.append(registro + "\n");
        }
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
