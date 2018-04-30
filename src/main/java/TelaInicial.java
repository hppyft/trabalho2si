import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class TelaInicial {
    private JPanel panel1;
    private JTextField textField1;
    private JButton button1;
    private JTable table1;
    private JButton button2;

    public TelaInicial() {
        createUIComponents();
    }

    private void createUIComponents() {
        System.out.println("createUI");
        button1.setText("Ouvir");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Musica musica = FakeBD.getMusica(Integer.getInteger(textField1.getText()));
                    musica.reproduzir();
                } catch (NullPointerException n) {
                    JOptionPane.showMessageDialog(panel1, "Por favor, digite um numero dentre os das musicas disponiveis");
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(panel1, "Por favor, digite um numero inteiro valido");
                }
            }
        });

        button2.setText("Recomendar música");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO abrir uma dialog recomendando a musica
            }
        });

        textField1.setText("Digite aqui o id da musica que voce quer escutar");

        Vector<String> titulos = new Vector<String>();
        titulos.add("Id");
        titulos.add("Nome");
        titulos.add("Artista");
        titulos.add("Genero");
        titulos.add("Vezes Tocadas");

        Musica[] musicas = FakeBD.getAllMusicas();
        Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
        for (Musica musica : musicas) {
            Vector<Object> row = new Vector<Object>();
            row.add(musica.getId());
            row.add(musica.getNome());
            row.add(FakeBD.getArtista(musica.getIdArtista()));
            row.add(FakeBD.getGen(musica.getIdGenero()));
            row.add(musica.getVezesTocada());
            rows.add(row);
        }

        table1 = new JTable(new DefaultTableModel(rows, titulos));
    }

    public void show() {
        panel1.setVisible(true);
    }

    public void hide() {
        panel1.setVisible(false);
    }
}
