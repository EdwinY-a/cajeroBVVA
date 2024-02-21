/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVVM;

/**
 *
 * @author pasit
 */
public class LibroPublic {
     int bookid;
    String bookNombre;
    String bookgenero;
    String bookDescripcion;
    String bookAutor;
    String bookArchivo;
    String bookPortada;

    public LibroPublic() {
    }

    public LibroPublic(int bookid, String bookNombre, String bookgenero, String bookDescripcion, String bookAutor, String bookArchivo, String bookPortada) {
        this.bookid = bookid;
        this.bookNombre = bookNombre;
        this.bookgenero = bookgenero;
        this.bookDescripcion = bookDescripcion;
        this.bookAutor = bookAutor;
        this.bookArchivo = bookArchivo;
        this.bookPortada = bookPortada;
    }
    
    
}
