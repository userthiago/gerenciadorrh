package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private static final String SQL_PROCURA_FUNCIONARIO = "SELECT * FROM funcionarios WHERE matricula = ? AND nome = ?";
    private static final String SQL_PROCURA_FUNCIONARIO_NOME = "SELECT * FROM funcionarios WHERE nome LIKE ?";
    private static final String SQL_PROCURA_FUNCIONARIO_MATRICULA = "SELECT * FROM funcionarios WHERE matricula LIKE ?";
    private static final String SQL_LISTAR_SEUS_FUNCIONARIOS = "SELECT * FROM funcionarios WHERE id_criador = ?";
    private static final String SQL_REGISTRA_FUNCIONARIO = "INSERT INTO funcionarios (matricula, nome, sobrenome, sexo, rg, cpf, nome_pai, nome_mae, nascimento, estado_civil, nacionalidade, grau_instrucao, raca, cep, endereco, endereco_numero, endereco_complemento, bairro, cidade, estado, telefone_celular, telefone_fixo, email, cargo, data_contratacao, tipo_contratacao, periodo_atuacao, id_empresa, id_criador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_LISTAR_FUNCIONARIOS = "SELECT * FROM funcionarios";
    private static final String SQL_ALTERAR_FUNCIONARIO = "UPDATE funcionarios set nome=?, sobrenome=?, sexo=?, rg=?, cpf=?, nome_pai=?, nome_mae=?, nascimento=?, estado_civil=?, nacionalidade=?, grau_instrucao=?, raca=?, cep=?, endereco=?, endereco_numero=?, endereco_complemento=?, bairro=?, cidade=?, estado=?, telefone_celular=?, telefone_fixo=?, email=?, cargo=?, data_contratacao=?, tipo_contratacao=?, periodo_atuacao=?, id_empresa=? where matricula=?";
    private static final String SQL_EXCLUIR_FUNCIONARIO = "DELETE FROM funcionarios WHERE matricula=?";
    
    private Connection connection;
    
    public boolean autenticar(int matricula, String nome) throws SQLException {
        boolean achou_funcionario = false;
        try {
            PreparedStatement stmt = connection.prepareStatement(SQL_PROCURA_FUNCIONARIO);
            stmt.setInt(1, matricula);
            stmt.setString(2, nome);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                achou_funcionario = true;
            }
            stmt.close();
            rs.close();  
        } catch(SQLException e) {
            throw e;
        }
        return achou_funcionario;
    }
    
    public boolean cadastrarFuncionario(Funcionario funcionario) throws SQLException {
        try {
            connection = ConnectionFactory.getConnection();
            try {
                if(!autenticar(funcionario.getMatricula(), funcionario.getNome())) {
                    PreparedStatement stmt = connection.prepareStatement(SQL_REGISTRA_FUNCIONARIO);
                    stmt.setInt(1, funcionario.getMatricula());
                    stmt.setString(2, funcionario.getNome());
                    stmt.setString(3, funcionario.getSobrenome());
                    stmt.setString(4, funcionario.getSexo());
                    stmt.setString(5, funcionario.getRg());
                    stmt.setString(6, funcionario.getCpf());
                    stmt.setString(7, funcionario.getNome_pai());
                    stmt.setString(8, funcionario.getNome_mae());
                    stmt.setDate(9, new java.sql.Date(funcionario.getNascimento().getTime()));
                    stmt.setString(10, funcionario.getEstado_civil());
                    stmt.setString(11, funcionario.getNacionalidade());
                    stmt.setString(12, funcionario.getGrau_instrucao());
                    stmt.setString(13, funcionario.getRaca());
                    stmt.setString(14, funcionario.getCep());
                    stmt.setString(15, funcionario.getEndereco());
                    stmt.setString(16, funcionario.getEndereco_numero());
                    stmt.setString(17, funcionario.getEndereco_complemento());
                    stmt.setString(18, funcionario.getBairro());
                    stmt.setString(19, funcionario.getCidade());
                    stmt.setString(20, funcionario.getEstado());
                    stmt.setString(21, funcionario.getTelefone_celular());
                    stmt.setString(22, funcionario.getTelefone_fixo());
                    stmt.setString(23, funcionario.getEmail());
                    stmt.setString(24, funcionario.getCargo());
                    stmt.setDate(25, new java.sql.Date(funcionario.getData_contratacao().getTime()));
                    stmt.setString(26, funcionario.getTipo_contratacao());
                    stmt.setString(27, funcionario.getPeriodo_atuacao());
                    stmt.setInt(28, funcionario.getId_empresa());
                    stmt.setInt(29, funcionario.getId_criador());
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
    
    public List<Funcionario> listar() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(SQL_LISTAR_FUNCIONARIOS);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()) {
                    Funcionario _funcionario = new Funcionario();
                    
                    _funcionario.setMatricula(rs.getInt("matricula"));
                    _funcionario.setNome(rs.getString("nome"));
                    _funcionario.setSobrenome(rs.getString("sobrenome"));
                    _funcionario.setSexo(rs.getString("sexo"));
                    _funcionario.setRg(rs.getString("rg"));
                    _funcionario.setCpf(rs.getString("cpf"));
                    _funcionario.setNome_pai(rs.getString("nome_pai"));
                    _funcionario.setNome_mae(rs.getString("nome_mae"));
                    _funcionario.setNascimento(rs.getDate("nascimento"));
                    _funcionario.setEstado_civil(rs.getString("estado_civil"));
                    _funcionario.setNacionalidade(rs.getString("nacionalidade"));
                    _funcionario.setGrau_instrucao(rs.getString("grau_instrucao"));
                    _funcionario.setRaca(rs.getString("raca"));
                    _funcionario.setCep(rs.getString("cep"));
                    _funcionario.setEndereco(rs.getString("endereco"));
                    _funcionario.setEndereco_numero(rs.getString("endereco_numero"));
                    _funcionario.setEndereco_complemento(rs.getString("endereco_complemento"));
                    _funcionario.setBairro(rs.getString("bairro"));
                    _funcionario.setCidade(rs.getString("cidade"));
                    _funcionario.setEstado(rs.getString("estado"));
                    _funcionario.setTelefone_celular(rs.getString("telefone_celular"));
                    _funcionario.setTelefone_fixo(rs.getString("telefone_fixo"));
                    _funcionario.setEmail(rs.getString("email"));
                    _funcionario.setCargo(rs.getString("cargo"));
                    _funcionario.setData_contratacao(rs.getDate("data_contratacao"));
                    _funcionario.setTipo_contratacao(rs.getString("tipo_contratacao"));
                    _funcionario.setPeriodo_atuacao(rs.getString("periodo_atuacao"));
                    _funcionario.setId_empresa(rs.getInt("id_empresa"));
                    _funcionario.setId_criador(rs.getInt("id_criador"));
                    
                    funcionarios.add(_funcionario);
                }
                stmt.close();
                rs.close();
            } finally {
                connection.close();
            }
        } catch(SQLException e) {
            throw e;
        }
        return funcionarios;
    }
    
    public boolean isANumber(String strNum) {
        return strNum.matches("\\d+");    
    }
    
    public List<Funcionario> consultar(String _conteudo_busca) throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt;
                if(isANumber(_conteudo_busca)) {
                    stmt = connection.
                            prepareStatement(SQL_PROCURA_FUNCIONARIO_MATRICULA);
                } else {
                    stmt = connection.
                            prepareStatement(SQL_PROCURA_FUNCIONARIO_NOME);
                }
                
                System.out.println(_conteudo_busca);
                stmt.setString(1, '%' + _conteudo_busca + '%');    
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Funcionario _funcionario = new Funcionario();
                    _funcionario.setMatricula(rs.getInt("matricula"));
                    _funcionario.setNome(rs.getString("nome"));
                    _funcionario.setSobrenome(rs.getString("sobrenome"));
                    _funcionario.setSexo(rs.getString("sexo"));
                    _funcionario.setRg(rs.getString("rg"));
                    _funcionario.setCpf(rs.getString("cpf"));
                    _funcionario.setNome_pai(rs.getString("nome_pai"));
                    _funcionario.setNome_mae(rs.getString("nome_mae"));
                    _funcionario.setNascimento(rs.getDate("nascimento"));
                    _funcionario.setEstado_civil(rs.getString("estado_civil"));
                    _funcionario.setNacionalidade(rs.getString("nacionalidade"));
                    _funcionario.setGrau_instrucao(rs.getString("grau_instrucao"));
                    _funcionario.setRaca(rs.getString("raca"));
                    _funcionario.setCep(rs.getString("cep"));
                    _funcionario.setEndereco(rs.getString("endereco"));
                    _funcionario.setEndereco_numero(rs.getString("endereco_numero"));
                    _funcionario.setEndereco_complemento(rs.getString("endereco_complemento"));
                    _funcionario.setBairro(rs.getString("bairro"));
                    _funcionario.setCidade(rs.getString("cidade"));
                    _funcionario.setEstado(rs.getString("estado"));
                    _funcionario.setTelefone_celular(rs.getString("telefone_celular"));
                    _funcionario.setTelefone_fixo(rs.getString("telefone_fixo"));
                    _funcionario.setEmail(rs.getString("email"));
                    _funcionario.setCargo(rs.getString("cargo"));
                    _funcionario.setData_contratacao(rs.getDate("data_contratacao"));
                    _funcionario.setTipo_contratacao(rs.getString("tipo_contratacao"));
                    _funcionario.setPeriodo_atuacao(rs.getString("periodo_atuacao"));
                    _funcionario.setId_empresa(rs.getInt("id_empresa"));
                    _funcionario.setId_criador(rs.getInt("id_criador"));
                    System.out.println(_funcionario.getNome());
                    funcionarios.add(_funcionario);
                }
                stmt.close();
                rs.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
        return funcionarios;
    }
        
    public List<Funcionario> consultarSeusFuncionarios(int id) throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(SQL_LISTAR_SEUS_FUNCIONARIOS);
                
                stmt.setInt(1, id);    
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Funcionario _funcionario = new Funcionario();
                    _funcionario.setMatricula(rs.getInt("matricula"));
                    _funcionario.setNome(rs.getString("nome"));
                    _funcionario.setSobrenome(rs.getString("sobrenome"));
                    _funcionario.setSexo(rs.getString("sexo"));
                    _funcionario.setRg(rs.getString("rg"));
                    _funcionario.setCpf(rs.getString("cpf"));
                    _funcionario.setNome_pai(rs.getString("nome_pai"));
                    _funcionario.setNome_mae(rs.getString("nome_mae"));
                    _funcionario.setNascimento(rs.getDate("nascimento"));
                    _funcionario.setEstado_civil(rs.getString("estado_civil"));
                    _funcionario.setNacionalidade(rs.getString("nacionalidade"));
                    _funcionario.setGrau_instrucao(rs.getString("grau_instrucao"));
                    _funcionario.setRaca(rs.getString("raca"));
                    _funcionario.setCep(rs.getString("cep"));
                    _funcionario.setEndereco(rs.getString("endereco"));
                    _funcionario.setEndereco_numero(rs.getString("endereco_numero"));
                    _funcionario.setEndereco_complemento(rs.getString("endereco_complemento"));
                    _funcionario.setBairro(rs.getString("bairro"));
                    _funcionario.setCidade(rs.getString("cidade"));
                    _funcionario.setEstado(rs.getString("estado"));
                    _funcionario.setTelefone_celular(rs.getString("telefone_celular"));
                    _funcionario.setTelefone_fixo(rs.getString("telefone_fixo"));
                    _funcionario.setEmail(rs.getString("email"));
                    _funcionario.setCargo(rs.getString("cargo"));
                    _funcionario.setData_contratacao(rs.getDate("data_contratacao"));
                    _funcionario.setTipo_contratacao(rs.getString("tipo_contratacao"));
                    _funcionario.setPeriodo_atuacao(rs.getString("periodo_atuacao"));
                    _funcionario.setId_empresa(rs.getInt("id_empresa"));
                    _funcionario.setId_criador(rs.getInt("id_criador"));
                    System.out.println(_funcionario.getNome());
                    funcionarios.add(_funcionario);
                }
                stmt.close();
                rs.close();
            } finally {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
        return funcionarios;
    }
    
    public void alterar(Funcionario funcionario) throws SQLException {
        try {
            connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(SQL_ALTERAR_FUNCIONARIO); 
                stmt.setString(1, funcionario.getNome());
                stmt.setString(2, funcionario.getSobrenome());
                stmt.setString(3, funcionario.getSexo());
                stmt.setString(4, funcionario.getRg());
                stmt.setString(5, funcionario.getCpf());
                stmt.setString(6, funcionario.getNome_pai());
                stmt.setString(7, funcionario.getNome_mae());
                stmt.setDate(8, new java.sql.Date(funcionario.getNascimento().getTime()));
                stmt.setString(9, funcionario.getEstado_civil());
                stmt.setString(10, funcionario.getNacionalidade());
                stmt.setString(11, funcionario.getGrau_instrucao());
                stmt.setString(12, funcionario.getRaca());
                stmt.setString(13, funcionario.getCep());
                stmt.setString(14, funcionario.getEndereco());
                stmt.setString(15, funcionario.getEndereco_numero());
                stmt.setString(16, funcionario.getEndereco_complemento());
                stmt.setString(17, funcionario.getBairro());
                stmt.setString(18, funcionario.getCidade());
                stmt.setString(19, funcionario.getEstado());
                stmt.setString(20, funcionario.getTelefone_celular());
                stmt.setString(21, funcionario.getTelefone_fixo());
                stmt.setString(22, funcionario.getEmail());
                stmt.setString(23, funcionario.getCargo());
                stmt.setDate(24, new java.sql.Date(funcionario.getData_contratacao().getTime()));
                stmt.setString(25, funcionario.getTipo_contratacao());
                stmt.setString(26, funcionario.getPeriodo_atuacao());
                stmt.setInt(27, funcionario.getId_empresa());
                stmt.setInt(28, funcionario.getMatricula());
                stmt.execute();
                stmt.close();
            } finally {
                connection.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }
    
    public void excluir(int matricula) throws SQLException {
        try {
            connection = ConnectionFactory.getConnection();
            try {
                PreparedStatement stmt = connection.prepareStatement(SQL_EXCLUIR_FUNCIONARIO);
                stmt.setInt(1, matricula);
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
