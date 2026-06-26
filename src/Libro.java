public class Libro<T> {
    private final T codice;
    private String nome;
    private int costo;

    public Libro(T codice, String nome, int costo){
        this.codice = codice;
        this.nome = nome;
        this.costo = costo;
    }

    //getter
    public String getNome() {
        return nome;
    }

    public T getCodice() {
        return codice;
    }

    public int getCosto() {
        return costo;
    }

    //setter

    public void setNome(String nome) {
        if(!nome.isEmpty()) {
            this.nome = nome;
        }else {
            System.out.println("Il nome non può essere vuoto");
        }
    }

    public void setCosto(int costo) {
        if(costo>=0) {
            this.costo = costo;
        } else {
            System.out.println("Il costo del libro non può essere negativo");
        }
        }
}

