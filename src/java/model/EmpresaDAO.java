package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

public class EmpresaDAO {
    private static final String SQL_PROCURA_EMPRESA = "SELECT * FROM empresas WHERE cnpj = ?";
    private static final String SQL_PROCURA_EMPRESA_CNPJ = "SELECT * FROM empresas WHERE cnpj LIKE ?";
    private static final String SQL_PROCURA_EMPRESA_RAZAO_SOCIAL = "SELECT * FROM empresas WHERE razao_social LIKE ?";
    private static final String SQL_LISTAR_SUAS_EMPRESAS = "SELECT * FROM empresas WHERE id_criador = ?";
    private static final String SQL_LISTAR_EMPRESAS = "SELECT * FROM empresas";
    private static final String SQL_REGISTRA_EMPRESA = "INSERT INTO empresas (cnpj, razao_social, nome_fantasia, cep, endereco, endereco_numero, endereco_complemento, bairro, cidade, estado, telefone, proprietario, email, id_criador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_ALTERAR_EMPRESA = "UPDATE empresas set razao_social=?, nome_fantasia=?, cep=?, endereco=?, endereco_numero=?, endereco_complemento=?, bairro=?, cidade=?, estado=?, telefone=?, proprietario=?, email=? where cnpj=?";
    private static final String SQL_EXCLUIR_EMPRESA = "DELETE FROM empresas WHERE cnpj=?";

    private Connection connection;
    
    public boolean autenticar(String cnpj) throws SQLException {
        boolean achou_empresa = false;
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_PROCURA_EMPRESA);
            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                achou_empresa = true;
            }
            stmt.close();
            rs.close();
        } catch(SQLException e) {
            throw e;
        }
        return achou_empresa;
    }
    
    public boolean cadastraEmpresa(Empresa _empresa) throws SQLException {
        try {
            connection = ConnectionFactory.getConnection();
            try {
                if(!autenticar(_empresa.getCnpj())) {
                    PreparedStatement stmt = connection.prepareStatement(SQL_REGISTRA_EMPRESA);
                    System.out.println(_empresa.getId_empresa());
                    stmt.setString(1, _empresa.getCnpj());
                    stmt.setString(2, _empresa.getRazao_social());
                    stmt.setString(3, _empresa.getNome_fantasia());
                    stmt.setString(4, _empresa.getCep());
                    stmt.setString(5, _empresa.getEndereco());
                    stmt.setString(6, _empresa.getEndereco_numero());
                    stmt.setString(7, _empresa.getEndereco_complemento());
                    stmt.setString(8, _empresa.getBairro());
                    stmt.setString(9, _empresa.getCidade());
                    stmt.setString(10, _empresa.getEstado());
                    stmt.setString(11, _empresa.getTelefone());
                    stmt.setString(12, _empresa.getProprietario());
                    stmt.setString(13, _empresa.getEmail());
                    stmt.setInt(14, _empresa.getId_criador());
                    stmt.executeUpdate();
                } else {
                    return false;
                }
            } finally {
                connection.close();
            }
        } catch(SQLException ex) {
            throw ex;
        }
        return true;
    }
    
    public List<Empresa> listar() throws SQLException {
        List<Empresa> empresas = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(SQL_LISTAR_EMPRESAS);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                    Empresa _empresa = new Empresa();
                    _empresa.setCnpj(rs.getString("cnpj"));
                    _empresa.setRazao_social(rs.getString("razao_social"));
                    _empresa.setNome_fantasia(rs.getString("nome_fantasia"));
                    _empresa.setCep(rs.getString("cep"));
                    _empresa.setEndereco(rs.getString("endereco"));
                    _empresa.setEndereco_numero(rs.getString("endereco_numero"));
                    _empresa.setEndereco_complemento(rs.getString("endereco_complemento"));
                    _empresa.setBairro(rs.getString("bairro"));
                    _empresa.setCidade(rs.getString("cidade"));
                    _empresa.setEstado(rs.getString("estado"));
                    _empresa.setTelefone(rs.getString("telefone"));
                    _empresa.setProprietario(rs.getString("proprietario"));
                    _empresa.setEmail(rs.getString("email"));
                    _empresa.setId_criador(rs.getInt("id_criador"));
                    empresas.add(_empresa);
                }
                stmt.close();
                rs.close();
            } finally {
                connection.close();
            }
        } catch(SQLException e) {
            throw e;
        }
        return empresas;
    }
    
    public List<SelectItem> getEmpresas() throws SQLException {
        List<SelectItem> empresas = new ArrayList<>();
        empresas.add(new SelectItem(null, "Selecione a empresa"));
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_LISTAR_EMPRESAS);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                empresas.add(new SelectItem(rs.getInt("id_empresa"), rs.getString("razao_social")));
            }
            stmt.close();
            rs.close();
        } catch(SQLException ex) {
            throw ex;
        }
        return empresas;
    }
    
    public boolean isANumber(String strNum) {
        return strNum.matches("\\d+");    
    }
    
    public List<Empresa> consultar(String _conteudo_busca) throws SQLException {
        List<Empresa> empresas = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt;
                if(isANumber(_conteudo_busca)) {
                    stmt = connection.
                            prepareStatement(SQL_PROCURA_EMPRESA_CNPJ);
                } else if(_conteudo_busca.equals("getSuasEmpresas")) {
                    stmt = connection.
                            prepareStatement(SQL_LISTAR_SUAS_EMPRESAS);
                }
                else {
                    stmt = connection.
                            prepareStatement(SQL_PROCURA_EMPRESA_RAZAO_SOCIAL);
                }

                stmt.setString(1, '%' + _conteudo_busca + '%');    
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Empresa _empresa = new Empresa();
                    _empresa.setCnpj(rs.getString("cnpj"));
                    _empresa.setRazao_social(rs.getString("razao_social"));
                    _empresa.setNome_fantasia(rs.getString("nome_fantasia"));
                    _empresa.setCep(rs.getString("cep"));
                    _empresa.setEndereco(rs.getString("endereco"));
                    _empresa.setEndereco_numero(rs.getString("endereco_numero"));
                    _empresa.setEndereco_complemento(rs.getString("endereco_complemento"));
                    _empresa.setBairro(rs.getString("bairro"));
                    _empresa.setCidade(rs.getString("cidade"));
                    _empresa.setEstado(rs.getString("estado"));
                    _empresa.setTelefone(rs.getString("telefone"));
                    _empresa.setProprietario(rs.getString("proprietario"));
                    _empresa.setEmail(rs.getString("email"));
                    _empresa.setId_criador(rs.getInt("id_criador"));
                    empresas.add(_empresa);
                }
                stmt.close();
                rs.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
        return empresas;
    }
    
    public List<Empresa> consultarSuasEmpresas(int _conteudo_busca) throws SQLException {
        List<Empresa> empresas = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = connection.
                            prepareStatement(SQL_LISTAR_SUAS_EMPRESAS);

                stmt.setInt(1, _conteudo_busca);    
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Empresa _empresa = new Empresa();
                    _empresa.setCnpj(rs.getString("cnpj"));
                    _empresa.setRazao_social(rs.getString("razao_social"));
                    _empresa.setNome_fantasia(rs.getString("nome_fantasia"));
                    _empresa.setCep(rs.getString("cep"));
                    _empresa.setEndereco(rs.getString("endereco"));
                    _empresa.setEndereco_numero(rs.getString("endereco_numero"));
                    _empresa.setEndereco_complemento(rs.getString("endereco_complemento"));
                    _empresa.setBairro(rs.getString("bairro"));
                    _empresa.setCidade(rs.getString("cidade"));
                    _empresa.setEstado(rs.getString("estado"));
                    _empresa.setTelefone(rs.getString("telefone"));
                    _empresa.setProprietario(rs.getString("proprietario"));
                    _empresa.setEmail(rs.getString("email"));
                    _empresa.setId_criador(rs.getInt("id_criador"));
                    empresas.add(_empresa);
                }
                stmt.close();
                rs.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
        return empresas;
    }
    
    public void alterar(Empresa empresa) throws SQLException {
        try {
            connection = ConnectionFactory.getConnection();
            try {
                System.out.println(empresa.getRazao_social());
                PreparedStatement stmt = connection.prepareStatement(SQL_ALTERAR_EMPRESA); 
                stmt.setString(1, empresa.getRazao_social());
                stmt.setString(2, empresa.getNome_fantasia());
                stmt.setString(3, empresa.getCep());
                stmt.setString(4, empresa.getEndereco());
                stmt.setString(5, empresa.getEndereco_numero());
                stmt.setString(6, empresa.getEndereco_complemento());
                stmt.setString(7, empresa.getBairro());
                stmt.setString(8, empresa.getCidade());
                stmt.setString(9, empresa.getEstado());
                stmt.setString(10, empresa.getTelefone());
                stmt.setString(11, empresa.getProprietario());
                stmt.setString(12, empresa.getEmail());
                stmt.setString(13, empresa.getCnpj());
                stmt.execute();
                stmt.close();
            } finally {
                connection.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    public void excluir(String cnpj) throws SQLException {
        try {
            connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(SQL_EXCLUIR_EMPRESA);
                stmt.setString(1, cnpj);
                stmt.execute();
                stmt.close();
            } finally {
                connection.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
