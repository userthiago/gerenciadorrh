package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private static final String SQL_AUTENTICAR_USUARIO = "select * from usuarios where login = ? and senha = MD5(?)";

    private Connection connection;
    
    public Usuario autenticar(String login, String senha) throws SQLException {
        Usuario u = null;
        try {
            connection = ConnectionFactory.getConnection();
            try{
                PreparedStatement stmt = connection.prepareStatement(SQL_AUTENTICAR_USUARIO);
                stmt.setString(1, login);
                stmt.setString(2, senha);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()) {
                    u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setRg(rs.getString("rg"));
                    u.setNome(rs.getString("nome"));
                    u.setCargo(rs.getString("cargo"));
                    u.setLogin(rs.getString("login"));
                    u.setSenha(rs.getString("senha"));
                    u.setTipo(TipoUsuario.valueOf(rs.getString("tipo")));
                }
                stmt.close();
                rs.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
        return u;
    }
}
