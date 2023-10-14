package A04_jdbc.livroautor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {

    private final String stmtInserir = "INSERT INTO lpoo.autor(nome) VALUES(?)";
    private final String stmtConsultar = "SELECT * FROM lpoo.autor WHERE id = ?";
    private final String stmtListar = "SELECT * FROM lpoo.autor";
    private final String stmtExcluir = "DELETE FORM SELECT * FROM lpoo.autor WHERE ID = ?";


    public int inserirAutor(Autor autor) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, autor.getNome());
            stmt.executeUpdate();
            autor.setId(lerIdAutor(stmt));
            return autor.getId();
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

    private int lerIdAutor(PreparedStatement stmt) throws SQLException {
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    public Autor consultarAutor(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Autor autorLido;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtConsultar);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                autorLido = new Autor(rs.getString("nome"));
                autorLido.setId(rs.getInt("id"));
                return autorLido;
            } else {
                throw new RuntimeException("Não existe autor com este id. Id=" + id);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao consultar um autor no banco de dados. Origem=" + ex.getMessage());
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

    public List<Autor> listarAutores() throws Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Autor> lista = new ArrayList();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtListar);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Autor autor = new Autor(rs.getString("nome"));
                autor.setId(rs.getInt("id"));
                lista.add(autor);
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

    public void excluirAutor(long id) {
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

    private List<Livro> lerLivros(long idAutor, Connection con) throws SQLException {
        //Select para pegar os livros de um autor
        String sql = "SELECT livro.id,livro.titulo"
                + " FROM lpoo.livro"
                + " INNER JOIN lpoo.livro_autor"
                + " 	ON livro.id = livro_autor.idLivro"
                + " WHERE livro_autor.idAutor = ? ";
        PreparedStatement stmt = null;
        List<Livro> livros = null;
        List<Autor> autorlista = new ArrayList<Autor>();
        stmt = con.prepareStatement(sql);
        stmt.setLong(1, idAutor);
        ResultSet resultado = stmt.executeQuery();
        livros = new ArrayList<Livro>();
        Autor autor = consultarAutor((int) idAutor);
        autorlista.add(autor);
        while (resultado.next()) {
            Livro livroLido = new Livro(resultado.getString("titulo"), autorlista);
            livroLido.setId(resultado.getInt("id"));
            livros.add(livroLido);
        }
        return livros;
    }

    List<Livro> listarLivrosDoAutor(int idAutor) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtListar);
            rs = stmt.executeQuery();
            List<Livro> listaLivros = lerLivros(idAutor, con);
            return listaLivros;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar um livro com autores no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                rs.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar rs. Ex=" + ex.getMessage());
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
