/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mateusm
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    private final String stmtInserir = "INSERT INTO lpoo.contato(nome, telefone) VALUES(?,?)";
    private final String stmtConsultar = "SELECT * FROM lpoo.contato WHERE id = ?";
    private final String stmtListar = "SELECT * FROM lpoo.contato";
    private final String stmtExcluir = "DELETE FORM SELECT * FROM lpoo.contato WHERE ID = ?";

    public int insereContato(Contato contato) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.executeUpdate();
            contato.setId(lerIdContato(stmt));
            return contato.getId();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um autor no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }

    private int lerIdContato(PreparedStatement stmt) throws SQLException {
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    public void removeContato(long id) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtExcluir);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um autor no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }

    public List<Contato> listarContatos() throws Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Contato> lista = new ArrayList();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtListar);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Contato contato = new Contato(rs.getString("nome"),rs.getString("telefone"));
                contato.setId(rs.getInt("id"));
                lista.add(contato);
            }
            return lista;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar uma lista de autores. Origem=" + ex.getMessage());
        } finally {
            try {
                rs.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar result set. Ex=" + ex.getMessage());
            };
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();;
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }

    }

}
