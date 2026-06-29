import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String...args) {

        Libro<Integer> libro1 = new Libro<>(1234, "Harry Potter", 15);
        Libro<String> libro2 = new Libro<>("isb32", "Aladin", 13);
        Libro<Integer> libro3 = new Libro<>(1235, "Zorro", 16);

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.aggiungiLibro(libro1);
        biblioteca.aggiungiLibro(libro2);
        biblioteca.aggiungiLibro(libro3);

        biblioteca.stampaLibri();

        ordinabile listaOrdinata = new ordinabile() {
            @Override
            public void ordinaPerTitolo(List<Libro<?>> listaLibri) {
                boolean scambiato;

                for (int i = 0; i < listaLibri.size() - 1; i++) {
                    scambiato = false;
                    for (int j = 0; j < listaLibri.size() - i - 1; j++) {
                        if (listaLibri.get(j).getNome().compareTo(listaLibri.get(j + 1).getNome()) > 0) {
                            Collections.swap(listaLibri, j, j + 1);
                            scambiato = true;
                        }
                    }
                    if (!scambiato) {
                        break;
                    }
                }
            }
        };

        listaOrdinata.ordinaPerTitolo(biblioteca.getListaLibri());
        biblioteca.stampaLibri();
    }}