package beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import model.DAO;
import model.Empresa;
import model.EmpresaDAO;
import tx.Transacional;


@Named(value="empresaBean")
@SessionScoped
public class EmpresaBean implements Serializable {
    @Inject
    private Empresa empresa;
    private List<Empresa> empresas;
    
    private String conteudo_busca;
    
    @Inject
    private DAO<Empresa> dao;
    
    public EmpresaBean() {
    }
    
    @PostConstruct
    public void init() {
        empresas = dao.listarGenerico("Empresa.listarTodas");
    }
    
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getConteudo_busca() {
        return conteudo_busca;
    }

    public void setConteudo_busca(String conteudo_busca) {
        this.conteudo_busca = conteudo_busca;
    }
    
    public String pag_cadastra() {
        empresa = new Empresa();
        return "/protected/cadastrarEmpresa";
    }
    
    @Transacional
    public String cadastrar(int criador) throws SQLException {
        dao.adicionar(empresa);
        empresa = new Empresa();
        return null;
    }
    
    @Transacional
    public String alterar() throws SQLException {
        dao.alterar(empresa);
        return "/protected/viewEmpresa";
    }   
    
    public List<SelectItem> listar_empresas() throws SQLException {
//        EmpresaDAO dao = new EmpresaDAO();
//        return dao.getEmpresas();
        List<SelectItem> lista = new ArrayList<>();
        empresas = dao.listarGenerico("Empresa.listarTodas");
        for (Empresa c : empresas) {
            lista.add(new SelectItem(c.getId_empresa(), c.getRazao_social()));
        }
        return lista;
    }

    public boolean isANumber(String strNum) {
        return strNum.matches("\\d+");    
    }
        
    public String consultar() throws SQLException {
        EmpresaDAO cdao = new EmpresaDAO();
        empresas = cdao.consultar(conteudo_busca);
        if(isANumber(conteudo_busca)) {
            empresas = dao.listarGenerico("Empresa.listarPorCNPJ", conteudo_busca);
        } else if(conteudo_busca.equals("getSuasEmpresas")) {
            empresas = dao.listarGenerico("Empresa.listarSuasEmpresas", empresas);
        }else {
            empresas = dao.listarGenerico("Empresa.listarPorRazaoSocial", conteudo_busca);
        }
        return null;
    }
    
    public String pag_view(Empresa _empresa) {
        empresa = _empresa;
        return "/protected/viewEmpresa";
    }
    
    public void suas_empresas(int id) throws SQLException, Exception {
        empresas = dao.listarGenerico("Empresa.listarSuasEmpresas", id);
    }
    
    public String pag_buscar() throws SQLException, Exception{
        conteudo_busca = null;
        empresas = dao.listarGenerico("Empresa.listarTodas", empresas);
        return "/protected/buscarEmpresa";
    }
    
    public String retornar(int choose) {
        if(choose == 1)
            return "/protected/gerenciamento";
        else
            return "/protected/buscarEmpresa";
    }
    
    public String excluir(Empresa e) throws SQLException {
        dao.excluir(e.getId_empresa());
        empresas.remove(e);
        return "/protected/buscarEmpresa";
    }
    
}
