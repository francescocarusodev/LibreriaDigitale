import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String...args) {

        //CREAZIONE LIBRI
        Libro<Integer> libro1 = new Libro<>(1234, "Harry Potter", 15);
        Libro<String> libro2 = new Libro<>("isb32", "Aladin", 13);
        Libro<Integer> libro3 = new Libro<>(1235, "Zorro", 16);

        //creazione di una biblioteca a e popolamento della listaLibri
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.aggiungiLibro(libro1);
        biblioteca.aggiungiLibro(libro2);
        biblioteca.aggiungiLibro(libro3);

        //STAMPA LIBRI
        biblioteca.stampaLibri();
        System.out.println();

        //CREAZIONE DI UNA CLASSE ANONIMA PER L'ORDINAMENTO
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

        //USO DELLA CLASSE ANONIMA PER L'ORDINAMENTO
        listaOrdinata.ordinaPerTitolo(biblioteca.getListaLibri());
        biblioteca.stampaLibri();
        System.out.println();

        //RIMOZIONE LIBRO
        biblioteca.rimuoviLibro(libro1);
        biblioteca.stampaLibri();
        System.out.println();

        //REGISTRAZIONE UTENTI
        biblioteca.registraUtente("Mario");
        biblioteca.registraUtente("Giovanni");

        biblioteca.stampaUtenti();
        System.out.println();

        //PRESTITI
        biblioteca.prestaLibro("Mario", libro2);
        biblioteca.prestaLibro("Mario", libro3);
        biblioteca.stampaLibri(); //vuota

        biblioteca.stampaPrestiti();
        System.out.println();

        //RESI
        biblioteca.restauraLibro("Mario");
        biblioteca.stampaPrestiti();
        System.out.println();
        biblioteca.stampaResi();



    }}