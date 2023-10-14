/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import model.Autor;
import model.Livro;

/**
 *
 * @author mateusm
 */

public class LivroAutorGUI {
    private JFrame frame;
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtAssunto;
    private JTextField txtISBN;
    private JTextField txtDataPublicacao;
    private JTable livroTable;
    private JTable autorTable;
    private JButton btnIncluirLivro;
    private JButton btnIncluirAutor;

    private final List<Livro> livros;
    private final List<Autor> autores;

    private final LivroTableModel livroTableModel;
    private final AutorTableModel autorTableModel;

    public LivroAutorGUI() {
        livros = new ArrayList<>();
        autores = new ArrayList<>();

        livroTableModel = new LivroTableModel(livros);
        autorTableModel = new AutorTableModel(autores);

        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        txtTitulo = new JTextField("Titulo");
        txtTitulo.setBounds(10, 10, 150, 20);
        panel.add(txtTitulo);
        txtTitulo.setColumns(10);

        txtAutor = new JTextField("Autor");
        txtAutor.setBounds(170, 10, 150, 20);
        panel.add(txtAutor);
        txtAutor.setColumns(10);

        txtAssunto = new JTextField("Assunto");
        txtAssunto.setBounds(10, 40, 150, 20);
        panel.add(txtAssunto);
        txtAssunto.setColumns(10);

        txtISBN = new JTextField("ISBN");
        txtISBN.setBounds(170, 40, 150, 20);
        panel.add(txtISBN);
        txtISBN.setColumns(10);

        txtDataPublicacao = new JTextField("Data Publicação");
        txtDataPublicacao.setBounds(10, 70, 150, 20);
        panel.add(txtDataPublicacao);
        txtDataPublicacao.setColumns(10);

        livroTable = new JTable(livroTableModel);
        JScrollPane livroScrollPane = new JScrollPane(livroTable);
        livroScrollPane.setBounds(10, 100, 400, 200);
        panel.add(livroScrollPane);

        autorTable = new JTable((TableModel) autorTableModel);
        JScrollPane autorScrollPane = new JScrollPane(autorTable);
        autorScrollPane.setBounds(10, 320, 400, 200);
        panel.add(autorScrollPane);

        btnIncluirLivro = new JButton("Incluir Livro");
        btnIncluirLivro.setBounds(170, 70, 150, 20);
        panel.add(btnIncluirLivro);

        btnIncluirAutor = new JButton("Incluir Autor");
        btnIncluirAutor.setBounds(570, 10, 150, 20);
        panel.add(btnIncluirAutor);

        btnIncluirLivro.addActionListener((ActionEvent e) -> {
            Livro livro = new Livro();
            livro.setTitulo(txtTitulo.getText());
            livro.setAutor(txtAutor.getText());
            livro.setAssunto(txtAssunto.getText());
            livro.setCodigoISBN(txtISBN.getText());
            livro.setDataPublicacao(txtDataPublicacao.getText());
            
            livros.add(livro);
            livroTableModel.fireTableDataChanged();
        });

        btnIncluirAutor.addActionListener((ActionEvent e) -> {
            Autor autor = new Autor();
            autor.setNome(txtAutor.getText());
            autores.add(autor);
            autorTableModel.fireTableDataChanged();
        });
    }

    public void show() {
        frame.setVisible(true);
    }
}



