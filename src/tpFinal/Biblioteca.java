package tpFinal;

import java.util.*;

public class Biblioteca {
	private List<Objeto> objetos;
	private Scanner scanner;

    public Biblioteca() {
        objetos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void addObj(Objeto objeto) {
        objetos.add(objeto);
    }
    
//1
    public void agregarObjeto() {
    	Objeto objeto = pedirDatosLibro();
        if (!existeObjeto(objeto)) {
            addObj(objeto);
            System.out.println("\nEl libro fue agregado exitosamente.");
        } else {
            System.out.println("\nYa existe el libro ingresado en la biblioteca.");
        }
    }
    
    private boolean existeObjeto(Objeto nuevoLibro) {
        for (Objeto objeto : objetos) {
            if (objeto instanceof Libro) {
                Libro libroExistente = (Libro) objeto;
                if (libroExistente.getTitulo().equalsIgnoreCase(nuevoLibro.getTitulo()) &&
                    libroExistente.getAutor().equalsIgnoreCase(nuevoLibro.getAutor())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private Objeto pedirDatosLibro() {
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Genero: ");
        String genero = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Editorial: ");
        String editorial = scanner.nextLine();
        System.out.print("Anio: ");
        int anio = scanner.nextInt();
        System.out.print("Paginas: ");
        int paginas = scanner.nextInt();
        System.out.print("Formato: ");
        String formato = scanner.nextLine();
        
        scanner.nextLine();
                
        return new Libro(titulo, autor, genero, isbn, editorial, anio, paginas, formato);
    }

//2
    public boolean eliminarObjeto(String titulo) {
        List<Objeto> objetosNuevos = new ArrayList<>();
        boolean objetoEliminado = false;
        for (Objeto objeto : objetos) {
            if (!objeto.getTitulo().equals(titulo)) {
                objetosNuevos.add(objeto);
            } else {
                objetoEliminado = true;
            }
        }
        objetos = objetosNuevos;
        return objetoEliminado;
    }
    
//3
    public boolean modificarObjeto(String titulo, Scanner scanner) {
        Objeto objetoAModificar = null;
        for (Objeto objetoActual : objetos) {
            if (objetoActual.getTitulo().equalsIgnoreCase(titulo)) {
                objetoAModificar = objetoActual;
                break;
            }
        }

        if (objetoAModificar != null) {
            System.out.println("\nIngrese los nuevos datos del libro:");
            System.out.print("Nuevo titulo: ");
            objetoAModificar.setTitulo(scanner.nextLine());
            System.out.print("Nuevo autor: ");
            objetoAModificar.setAutor(scanner.nextLine());
            System.out.print("Nuevo genero: ");
            objetoAModificar.setGenero(scanner.nextLine());
            System.out.print("Nuevo ISBN: ");
            objetoAModificar.setIsbn(scanner.nextLine());
            System.out.print("Nueva editorial: ");
            objetoAModificar.setEditorial(scanner.nextLine());
            System.out.print("Nuevo anio: ");
            objetoAModificar.setAnio(scanner.nextInt());
            scanner.nextLine();
            System.out.println("\nEl libro fue modificado con exito.");

        } else {
            System.out.println("\nNo se encontro el libro ingresado.");
        }
        return false;
    }

//4
    public void listarPorTitulo() {
        System.out.print("\nIngrese el titulo del libro: ");
        String titulo = scanner.nextLine();
        boolean encontrado = false;
        for (Objeto objeto : objetos) {
            if (objeto instanceof Libro) {
                Libro libro = (Libro) objeto;
                if (libro.titulo.equalsIgnoreCase(titulo)) {
                    System.out.println(libro); 
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("\nNo se encontraron libros con el titulo solicitado.");
        }
    }
    
//5
    public void buscarPorISBN() {
        System.out.print("\nIngrese el ISBN-13 del libro a buscar: ");
        String isbnBuscar = scanner.nextLine();
        boolean encontrado = false;
        for (Objeto objeto : objetos) {
            if (objeto instanceof Libro) {
                Libro libro = (Libro) objeto;
                if (libro.getIsbn().equalsIgnoreCase(isbnBuscar)) {
                    System.out.println("\nLibro con el ISBN-13 ingresado:");
                    System.out.println(libro);
                    encontrado = true;
                    break; 
                }
            }
        }
        if (!encontrado) {
            System.out.println("\nNo se encontro ningun libro con el ISBN ingresado.");
        }
    }
    
    public void listarTodo() {
    	if (objetos.isEmpty()) {
    		System.out.println("\nLa biblioteca esta vacia.");
    	} else {
    		System.out.println("\nLista de todos los libros");
    		for (Objeto objeto : objetos) {
    			System.out.println(objeto);
    		}
        }
    }
    
//6
    public void listarPorAutor() {
    	System.out.print("\nIngrese el autor del libro: ");
        String autor = scanner.nextLine();
        boolean encontrado = false;
        System.out.println("\nLibros del autor '" + autor + "':");
        for (Objeto objeto : objetos) {
            if (objeto instanceof Libro) {
                Libro libro = (Libro) objeto;
                if (libro.getAutor().equalsIgnoreCase(autor)) {
                    System.out.println(libro);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            System.out.println("\nNo se encontraron libros del autor solicitado.");
        }
    }
    
//7
    public void listarPorGenero() {
    	System.out.print("\nIngrese el genero del libro: ");
        String genero = scanner.nextLine();
        boolean encontrado = false;
        System.out.println("\nLibros del genero '" + genero + "':");
        for (Objeto objeto : objetos) {
            if (objeto instanceof Libro) {
                Libro libro = (Libro) objeto;
                if (libro.getGenero().equalsIgnoreCase(genero)) {
                    System.out.println(libro);
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("\nNo se encontraron libros del genero ingresado.");
        }
    }
    
    public void listarAutores() {
        Set<String> autores = new HashSet<>();
        for (Objeto objeto : objetos) {
            if (objeto instanceof Libro) {
                Libro libro = (Libro) objeto;
                autores.add(libro.getAutor());
            }
        }
        if (!autores.isEmpty()) {
            System.out.println("\nAutores existentes:");
            for (String autor : autores) {
                System.out.println(autor);
            }
        } else {
            System.out.println("\nNo hay autores registrados en la biblioteca.");
        }
    }
    
    public void listarPorEditorial() {
        System.out.print("\nIngrese la editorial de los libros a listar: ");
        String editorial = scanner.nextLine();
        boolean encontrado = false;
        System.out.println("\nLibros de la editorial '" + editorial + "':");
        for (Objeto objeto : objetos) {
            if (objeto instanceof Libro) {
                Libro libro = (Libro) objeto;
                if (libro.getEditorial().equalsIgnoreCase(editorial)) {
                    System.out.println(libro);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            System.out.println("\nNo se encontraron libros de la editorial ingresada.");
        }
    }
    
    public void listarPorEditRango() {
        System.out.print("\nIngrese la editorial de los libros a listar: ");
        String editorial = scanner.nextLine();
        System.out.print("Ingrese el anio de inicio del rango: ");
        int anioInicio = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el anio de fin del rango: ");
        int anioFin = scanner.nextInt();
        scanner.nextLine();
        boolean encontrado = false;
        System.out.println("\nLibros de la editorial '" + editorial + "' publicados entre " + anioInicio + " y " + anioFin + ":");
        for (Objeto objeto : objetos) {
            if (objeto instanceof Libro) {
                Libro libro = (Libro) objeto;
                if (libro.getEditorial().equalsIgnoreCase(editorial) && libro.getAnio() >= anioInicio && libro.getAnio() <= anioFin) {
                    System.out.println(libro);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            System.out.println("\nNo se encontraron libros de la editorial ingresada en tal rango de anios.");
        }
    }
    
    public void listarAutoresPorEditorial() {
        System.out.print("\nIngrese la editorial de la cual desea conocer los autores: ");
        String editorial = scanner.nextLine();
        Set<String> autores = new HashSet<>();
        for (Objeto objeto : objetos) {
            if (objeto instanceof Libro) {
                Libro libro = (Libro) objeto;
                if (libro.getEditorial().equalsIgnoreCase(editorial)) {
                    autores.add(libro.getAutor());
                }
            }
        }
        if (!autores.isEmpty()) {
            System.out.println("\nAutores de la editorial '" + editorial + "':");
            for (String autor : autores) {
                System.out.println(autor);
            }
        } else {
            System.out.println("\nNo se encontraron autores de la editorial ingresada.");
        }
    }
    
    public void listarLibrosPorAnio() {
        System.out.print("\nIngrese el anio de edicion que desea buscar: ");
        int anioBuscado = scanner.nextInt();
        scanner.nextLine();
        boolean encontrado = false;
        System.out.println("\nLibros editados en el anio '" + anioBuscado + "':");
        for (Objeto objeto : objetos) {
            if (objeto instanceof Libro) {
                Libro libro = (Libro) objeto;
                if (libro.getAnio() == anioBuscado) {
                    System.out.println(libro);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            System.out.println("\nNo se encontraron libros editados en el anio ingresado");
        }
    }
    
    public void listarPorInicial() {
    	System.out.print("\nIngrese la letra inicial del apellido del autor a buscar: ");
        char letraApellido = scanner.nextLine().toUpperCase().charAt(0);
        boolean encontrado = false;
        for (Objeto objeto : objetos) {
            if (objeto instanceof Libro) {
                Libro libro = (Libro) objeto;
                String[] apellidosAutores = libro.getAutor().split(" ");
                for (String apellido : apellidosAutores) {
                    if (!apellido.isEmpty() && Character.toUpperCase(apellido.charAt(0)) == letraApellido) {
                    	System.out.println("Libros de autores cuyos apellidos comienzan con la letra '" + letraApellido + "':");
                        System.out.println(libro);
                        encontrado = true;
                        break; 
                    }
                }
            }
        }
        if (!encontrado) {
            System.out.println("\nNo se encontraron libros de autores con apellidos que comiencen con la letra " + letraApellido + ".");
        }
    }
    
    public void listarPorPalabra() {
        System.out.print("\nIngrese la palabra a buscar en los titulos: ");
        String palabraBuscar = scanner.nextLine().toLowerCase();
        boolean encontrado = false;
        for (Objeto objeto : objetos) {
            if (objeto instanceof Libro) {
                Libro libro = (Libro) objeto;
                if (libro.getTitulo().toLowerCase().contains(palabraBuscar)) {
                    if (!encontrado) {
                        System.out.println("\nTitulos que contienen la palabra '" + palabraBuscar + "':");
                        encontrado = true;
                    }
                    System.out.println(libro);
                }
            }
        }

        if (!encontrado) {
            System.out.println("\nNo se encontraron libros con la palabra en el título.");
        }
    }
}