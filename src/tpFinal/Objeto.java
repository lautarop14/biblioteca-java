package tpFinal;

public abstract class Objeto {
	protected String titulo;
	protected String autor;
	protected String genero;
	protected String isbn;
	protected String editorial;
	protected int anio;
	protected String formato;
	
	public Objeto(String titulo, String autor, String genero, String isbn, String editorial, int anio, String formato) {
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.isbn = isbn;
		this.editorial = editorial;
		this.anio = anio;
		this.formato = formato;		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public String getFormato() {
		return formato;
	}
	
	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String toString() {
		return "\nTitulo: " + titulo + "\nAutor: " + autor + "\nGenero: " + genero + "\nISBN: " + isbn +
                 "\nEditorial: " + editorial + "\nAnio: " + anio + "\nFormato: " + formato + "\n";
	}
}