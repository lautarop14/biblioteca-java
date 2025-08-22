package tpFinal;

public class Libro extends Objeto {
private int paginas;
	
	public Libro (String titulo, String autor, String genero, String ISBN, String editorial, int anio, int paginas, String formato) {
		super (titulo, autor, genero, ISBN, editorial, anio, formato);
		
		this.paginas = paginas;
	}

	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public String toString() {
		return super.toString();
	}
}
