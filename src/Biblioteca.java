import java.util.*;

public class Biblioteca {

    private List<Libro<?>> listaLibri = new ArrayList<>();
    private Set<String> utentiRegistrati = new HashSet<>();
    private Map<String, Stack<Libro<?>>> listaUtentiPrestiti = new HashMap<>();
    private Queue<Libro<?>> resi = new LinkedList<>();

    public void aggiungiLibro(Libro<?> libro){
       if(!this.listaLibri.contains(libro)) {
           listaLibri.add(libro);
       } else {
           System.out.println("Il libro è già presente.");
       }
    }

    public void rimuoviLibro(Libro<?> libro){
        if(this.listaLibri.contains(libro)){
            listaLibri.remove(libro);
        } else {
            System.out.println("Il libro non è presente.");
        }
    }

    public void registraUtente(String utente){
        if(!utente.isEmpty()){
            utentiRegistrati.add(utente);
            listaUtentiPrestiti.put(utente, new Stack<>());
        } else {
            throw new IllegalArgumentException("L'utente deve per forza avere un nome");
        }
    }

    public void prestaLibro(String utente, Libro<?> libro){
        if (!utentiRegistrati.contains(utente)){
            System.out.println("L'utente selezionato non è registarto");
            return;
        }
        if (!listaLibri.contains(libro)){
            System.out.println("Il libro non è disponibile");
            return;
        }

        listaUtentiPrestiti.get(utente).push(libro);
        listaLibri.remove(libro);
    }

    public void restauraLibro(String utente){
        Stack<Libro<?>> pila = listaUtentiPrestiti.get(utente);
        if (pila == null || pila.isEmpty()){
            System.out.println("L'utente non ha libri da restituire");
            return;
        }
        Libro<?> libro = pila.pop();
        resi.offer(libro);
        System.out.println("L'utente " +  utente +  " ha restituito il libro");

    }
}
