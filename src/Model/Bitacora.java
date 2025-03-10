/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Christopher
 */
public class Bitacora {
      private ArrayList<String> registros;

    public Bitacora() {
        registros = new ArrayList<>();
    }

    public void agregarRegistro(String registro) {
        registros.add(registro);
    }
    
    public String[] obtenerRegistros() {
        return registros.toArray(new String[0]);
    }

    public void generarPDF(String nombreArchivo) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();

            for (String registro : registros) {
                document.add(new Paragraph(registro));
            }

            System.out.println("Bitácora generada: " + nombreArchivo);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
