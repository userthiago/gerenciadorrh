package beans;

import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.Funcionario;
import model.FuncionarioDAO;
import session.SessionContext;

@Named(value = "funcionarioBean")
@SessionScoped
public class FuncionarioBean implements Serializable{
    @Inject
    private Funcionario funcionario;
    private List<Funcionario> funcionarios;
    
    private String conteudo_busca;

    public FuncionarioBean() {
        
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getConteudo_busca() {
        return conteudo_busca;
    }

    public void setConteudo_busca(String conteudo_busca) {
        this.conteudo_busca = conteudo_busca;
    }
    
    public String cadastrar(int criador) throws SQLException {
        funcionario.setId_criador(criador);
        FuncionarioDAO dao = new FuncionarioDAO();
        if(dao.cadastrarFuncionario(funcionario)) {
            FacesMessage message = new FacesMessage("Usuario inserido com sucesso!");
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        else {
           FacesMessage message = new FacesMessage("Matricula " + funcionario.getMatricula() + " de nome " + funcionario.getNome() + " já se encontra registrado no sistema.");
           message.setSeverity(FacesMessage.SEVERITY_INFO);
           FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return null;
    }
    
    public String consultar() throws SQLException {
        FuncionarioDAO cdao = new FuncionarioDAO();
        funcionarios = cdao.consultar(conteudo_busca);
        return null;
    }
    
    public String retornar(int choose) {
        if(choose == 1)
            return "/protected/gerenciamento";
        else
            return "/protected/buscarFuncionario";
    }
    
    public String pag_view(Funcionario _funcionario) {
        funcionario = _funcionario;
        return "/protected/viewFuncionario";
    }
    
    public String pag_cadastra() {
        funcionario = new Funcionario();
        return "/protected/cadastrarFuncionario";
    }
    
    public void seus_funcionarios(int id) throws SQLException, Exception{
        FuncionarioDAO dao = new FuncionarioDAO();
        funcionarios = dao.consultarSeusFuncionarios(id);
    }
    
    public String pag_buscar() throws SQLException, Exception{
        conteudo_busca = null;
        FuncionarioDAO dao = new FuncionarioDAO();
        funcionarios = dao.listar();
        return "/protected/buscarFuncionario";
    }
    
    public String alterar() throws SQLException {
        FuncionarioDAO edao = new FuncionarioDAO();
        edao.alterar(funcionario);
        return "/protected/viewFuncionario";
    }
    
    public String excluir(Funcionario f) throws SQLException {
        FuncionarioDAO edao = new FuncionarioDAO();
        edao.excluir(f.getMatricula());
        funcionarios.remove(f);
        return "/protected/buscarFuncionario";
    }
    
    public String sair() {
        SessionContext session = SessionContext.getInstance();
        session.encerrarSessao();
        return "/index";
    }
}
