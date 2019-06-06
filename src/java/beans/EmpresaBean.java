package beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import model.Empresa;
import model.EmpresaDAO;


@Named(value="empresaBean")
@SessionScoped
public class EmpresaBean implements Serializable {
    @Inject
    private Empresa empresa;
    private List<Empresa> empresas;
    
    private String conteudo_busca;
    
    public EmpresaBean() {
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public String getConteudo_busca() {
        return conteudo_busca;
    }

    public void setConteudo_busca(String conteudo_busca) {
        this.conteudo_busca = conteudo_busca;
    }
    
    public List<SelectItem> listar_empresas() throws SQLException {
        EmpresaDAO dao = new EmpresaDAO();
        return dao.getEmpresas();
    }
    
    public String cadastrar(int criador) throws SQLException {
        EmpresaDAO dao = new EmpresaDAO();
        empresa.setId_criador(criador);
        if(dao.cadastraEmpresa(empresa)) {
            FacesMessage message = new FacesMessage("Empresa inserida no sistema com sucesso!");
            message.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        else {
           FacesMessage message = new FacesMessage("Empresa com cnpj " + empresa.getCnpj() + " já se encontra registrada no sistema.");
           message.setSeverity(FacesMessage.SEVERITY_INFO);
           FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return null;
    }
    
    public String consultar() throws SQLException {
        EmpresaDAO cdao = new EmpresaDAO();
        empresas = cdao.consultar(conteudo_busca);
        return null;
    }
    
    public String pag_view(Empresa _empresa) {
        empresa = _empresa;
        return "/protected/viewEmpresa";
    }
    
    public String pag_cadastra() {
        empresa = new Empresa();
        return "/protected/cadastrarEmpresa";
    }
    
    public void suas_empresas(int id) throws SQLException, Exception {
        EmpresaDAO dao = new EmpresaDAO();
        empresas = dao.consultarSuasEmpresas(id);
    }
    
    public String pag_buscar() throws SQLException, Exception{
        conteudo_busca = null;
        EmpresaDAO dao = new EmpresaDAO();
        empresas = dao.listar();
        return "/protected/buscarEmpresa";
    }
    
    public String retornar(int choose) {
        if(choose == 1)
            return "/protected/gerenciamento";
        else
            return "/protected/buscarEmpresa";
    }
    
    public String alterar() throws SQLException {
        EmpresaDAO edao = new EmpresaDAO();
        edao.alterar(empresa);
        return "/protected/viewEmpresa";
    }
    
    public String excluir(Empresa e) throws SQLException {
        EmpresaDAO edao = new EmpresaDAO();
        edao.excluir(e.getCnpj());
        empresas.remove(e);
        return "/protected/buscarEmpresa";
    }
    
}
