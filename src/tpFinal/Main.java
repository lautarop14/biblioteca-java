package tpFinal;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();
		Libro libro1 = new Libro("La isla prometida", "Amanda Helsing", "Romance", "9788466653688", "LB", 2013, 439, "Físico");
		Libro libro2 = new Libro("Antologia del Studio Ghibli - Vol 2", "Manuel Robles", "Antologia", "9788415296935" , "Asociacion Cultural del Comic", 2013, 216, "Digital");
		Libro libro3 = new Libro("Normal People", "Sally Rooney", "Novela", "9780571334643", "Faber & Faber", 2018, 266, "Físico");
		biblioteca.addObj(libro1);
		biblioteca.addObj(libro2);
		biblioteca.addObj(libro3);
		
        int opcion;
        do {
            System.out.println("\n----- MENU PRINCIPAL -----");
            System.out.println("1. Agregar un libro nuevo");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Modificar un libro");
            System.out.println("4. Buscar libro por titulo");
            System.out.println("5. Buscar libro por ISBN");
            System.out.println("6. Ver biblioteca completa");
            System.out.println("7. Listar libros por autor");
            System.out.println("8. Listar libros por genero");
            System.out.println("9. Listar todos los autores");
            System.out.println("10. Listar libros por editorial");    
            System.out.println("11. Listar libros por editorial en un rango de anios");
            System.out.println("12. Listar autores por editorial");
            System.out.println("13. Listar libros por anio de edicion");
            System.out.println("14. Listar libros por inicial de apellido del autor");
            System.out.println("15. Listar libros por una palabra determinada");
            System.out.println("16. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    biblioteca.agregarObjeto();
                    break;
                case 2:
                    System.out.print("\nIngrese el titulo del libro a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    if (biblioteca.eliminarObjeto(tituloEliminar)) {
                        System.out.println("\nEl libro fue eliminado exitosamente.");
                    } else {
                        System.out.println("\nNo se encontro el libro ingresado.");
                    }
                    break;
                case 3:
                	System.out.print("\nIngrese el titulo del libro que desea modificar: ");
                	String tituloModificar = scanner.nextLine();
                	if (biblioteca.modificarObjeto(tituloModificar, scanner)) {
                	} else {
                	}
                	break;
                case 4:
                    biblioteca.listarPorTitulo();
                    break;
                case 5:
                	biblioteca.buscarPorISBN();
                	break;
                case 6:
                	biblioteca.listarTodo();
                	break;
                case 7:
                	biblioteca.listarPorAutor();	
                	break;
                case 8:
                	biblioteca.listarPorGenero();	
                	break;
                case 9:
                	biblioteca.listarAutores();
                	break;
                case 10:
                	biblioteca.listarPorEditorial();
                	break;
                case 11:
                	biblioteca.listarPorEditRango();
                	break;
                case 12:
                	biblioteca.listarAutoresPorEditorial();
                	break;
                case 13:
                	biblioteca.listarLibrosPorAnio();
                	break;
                case 14:
                	biblioteca.listarPorInicial();
                	break;
                case 15:
                	biblioteca.listarPorPalabra();
                	break;
                case 16:
                    System.out.println("\nHasta luego!");
                    break;
                default:
                    System.out.println("\nOpcion invalida.");
                    break;
            }
        } while (opcion != 16);
        scanner.close();
    }
}