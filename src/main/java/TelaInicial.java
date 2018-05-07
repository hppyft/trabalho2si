import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class TelaInicial {
    private JFrame frame;
    private JPanel panel1;
    private JTextField textField1;
    private JButton button1;
    private JTable table1;
    private JButton button2;

    public TelaInicial() {
        createUIComponents();
    }

    private void createUIComponents() {
        frame = new JFrame("Simple GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println("createUI");
        button1.setText("Ouvir");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer integer = Integer.parseInt(textField1.getText());
                    Musica musica = FakeBD.getMusica(integer);
                    musica.reproduzir();
                    createTable();
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
                JOptionPane.showMessageDialog(panel1, FakeBD.getRecomendacao());
            }
        });

        textField1.setText("Digite aqui o id da musica que voce quer escutar");


        frame.getContentPane().add(textField1, BorderLayout.NORTH);
        frame.getContentPane().add(button1, BorderLayout.WEST);
        frame.getContentPane().add(button2, BorderLayout.EAST);
        createTable();
    }

    private void createTable() {
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
            row.add(FakeBD.getArtista(musica.getIdArtista()).getNome());
            row.add(FakeBD.getGen(musica.getIdGenero()).getNome());
            row.add(musica.getVezesTocada());
            rows.add(row);
        }

        DefaultTableModel dtm = new DefaultTableModel(rows, titulos);
        table1 = new JTable(dtm);
        frame.getContentPane().add(table1, BorderLayout.CENTER);
        frame.pack();
    }

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }

    public void refreshTable() {
//        ((DefaultTableModel) table1.getModel()).fireTableDataChanged();
        table1.repaint(); //TODO Verificar como dar refresh na table
    }
}
