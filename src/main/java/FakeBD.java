import javax.swing.*;
import java.util.*;

public class FakeBD {

    private static Genero gen1;
    private static Genero gen2;
    private static Artista artista1;
    private static Artista artista2;
    private static Artista artista3;
    private static Artista artista4;
    private static Musica mus1;
    private static Musica mus2;
    private static Musica mus3;
    private static Musica mus4;
    private static Musica mus5;
    private static Musica mus6;
    private static Musica mus7;
    private static Musica mus8;
    private static Musica mus9;

    public static Genero getGen(int id) {
        switch (id) {
            case 1:
                if (gen1 == null) {
                    gen1 = new Genero(1, "Funk");
                }
                return gen1;
            case 2:
                if (gen2 == null) {
                    gen2 = new Genero(2, "Sertanejo");
                }
                return gen2;
            default:
                return null;
        }
    }

    public static Artista getArtista(int id) {
        switch (id) {
            case 1:
                if (artista1 == null) {
                    artista1 = new Artista(1, "Anitta");
                }
                return artista1;
            case 2:
                if (artista2 == null) {
                    artista2 = new Artista(2, "McKevinho");
                }
                return artista2;
            case 3:
                if (artista3 == null) {
                    artista3 = new Artista(3, "Simone e Simaria");
                }
                return artista3;
            case 4:
                if (artista4 == null) {
                    artista4 = new Artista(4, "Maraia e Maraisa");
                }
                return artista4;
            default:
                return null;
        }
    }

    public static Musica getMusica(int id) {
        switch (id) {
            case 1:
                if (mus1 == null) {
                    mus1 = new Musica(1, "Sim ou Nao", 1, 1);
                }
                return mus1;
            case 2:
                if (mus2 == null) {
                    mus2 = new Musica(2, "Vai Malandra", 1, 1);
                }
                return mus2;
            case 3:
                if (mus3 == null) {
                    mus3 = new Musica(3, "Show das Poderosas", 1, 1);
                }
                return mus3;
            case 4:
                if (mus4 == null) {
                    mus4 = new Musica(4, "Rabiola", 2, 1);
                }
                return mus4;
            case 5:
                if (mus5 == null) {
                    mus5 = new Musica(5, "Deixa ela beijar", 2, 1);
                }
                return mus5;
            case 6:
                if (mus6 == null) {
                    mus6 = new Musica(6, "Regime Fechado", 3, 2);
                }
                return mus6;
            case 7:
                if (mus7 == null) {
                    mus7 = new Musica(7, "Loka", 3, 2);
                }
                return mus7;
            case 8:
                if (mus8 == null) {
                    mus8 = new Musica(8, "Medo bobo", 4, 2);
                }
                return mus8;
            case 9:
                if (mus9 == null) {
                    mus9 = new Musica(9, "Quem ensinou fui eu", 4, 2);
                }
                return mus9;
            default:
                return null;
        }
    }

    public static Musica[] getAllMusicas() {
        Musica[] musicas = new Musica[9];
        musicas[0] = getMusica(1);
        musicas[1] = getMusica(2);
        musicas[2] = getMusica(3);
        musicas[3] = getMusica(4);
        musicas[4] = getMusica(5);
        musicas[5] = getMusica(6);
        musicas[6] = getMusica(7);
        musicas[7] = getMusica(8);
        musicas[8] = getMusica(9);
        return musicas;
    }

    public static String getRecomendacao() {
        List<Musica> allMusicas = new LinkedList<Musica>(Arrays.asList(FakeBD.getAllMusicas()));
        List<Musica> musicasNaoEscutadas = new ArrayList<Musica>();
        List<Musica> musicasEscutadas = new ArrayList<Musica>();
        for (Musica musicaEscutada : allMusicas) {
            if (musicaEscutada.getVezesTocada() == 0) {
                musicasNaoEscutadas.add(musicaEscutada);
            } else {
                musicasEscutadas.add(musicaEscutada);
            }
        }
        if (musicasEscutadas.isEmpty()) {
            return "Você não escutou nenhuma música, por favor escute alguma para que possamos recomendar algo";
        }
        if (musicasNaoEscutadas.isEmpty()) {
            return "Você já escutou todas as músicas, não há nenhuma para recomendar";
        }
        Collections.sort(musicasEscutadas, new Comparator<Musica>() {
            public int compare(Musica musica, Musica t1) {
                return musica.compareTo(t1);
            }
        });
        for (Musica musica : musicasEscutadas) {
            for (Musica musica2 : musicasNaoEscutadas) {
                if (musica.getIdArtista() == musica2.getIdArtista()) {
                    return "Recomendamos que você escute a música " + musica2.getNome() + " baseado no artista que você escutou anteriormente";
                }
            }
            for (Musica musica3 : musicasNaoEscutadas) {
                if (musica.getIdGenero() == musica3.getIdGenero()) {
                    return "Recomendamos que você escute a música " + musica3.getNome() + " baseado no gênero que você escutou anteriormente";
                }
            }
        }
        return "Não possuimos nenhuma recomendação";
    }
}
