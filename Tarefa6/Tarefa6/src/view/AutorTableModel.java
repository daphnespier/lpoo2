/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Autor;


/**
 *
 * @author mateusm
 */

class AutorTableModel extends AbstractTableModel {
    private List<Autor> autores;
    private final String[] colunas = { "Nome", "Livros"};

    public AutorTableModel(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public int getRowCount() {
        return autores.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autor autor = autores.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return autor.getNome();
            case 1:
                return autor.getLivros();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}

