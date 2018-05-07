public class Musica implements Comparable<Musica> {

    private int id;
    private String nome;
    private int idArtista;
    private int idGenero;
    private long vezesTocada;

    public Musica() {
    }

    public Musica(int id, String nome, int idArtista, int idGenero) {
        this.id = id;
        this.nome = nome;
        this.idArtista = idArtista;
        this.idGenero = idGenero;
        this.vezesTocada = 0;
    }

    public void reproduzir() {
        this.vezesTocada++;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public long getVezesTocada() {
        return vezesTocada;
    }

    public int compareTo(Musica o) {
        if (this.vezesTocada > o.vezesTocada) {
            return -1;
        } else if (this.vezesTocada < o.vezesTocada) {
            return 1;
        } else {
            return 0;
        }
    }
}
