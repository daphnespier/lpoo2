/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Livro;

/**
 *
 * @author mateusm
 */
public class LivroTableModel extends AbstractTableModel {
    private final List<Livro> livros;
    private String[] colunas = { "Título", "Autores", "Assunto", "Código ISBN", "Data de Publicação" };

    public LivroTableModel(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public int getRowCount() {
        return livros.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Livro livro = livros.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return livro.getTitulo();
            case 1:
                return livro.getAutor();
            case 2:
                return livro.getAssunto();
            case 3:
                return livro.getCodigoISBN();
            case 4:
                return livro.getDataPublicacao();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}
