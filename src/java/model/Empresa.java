package model;

import java.io.Serializable;
import javax.enterprise.context.Dependent;

@Dependent
public class Empresa implements Serializable{
    
    private Long id_empresa;
    private String cnpj;
    private String nome_fantasia;
    private String razao_social;
    private String cep;
    private String endereco;
    private String endereco_numero;
    private String endereco_complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;
    private String proprietario;
    private String email;
    private int id_criador;
    
    public Empresa() {
        
    }
    
    public Empresa(Long _id_empresa, String _razao_social) {
        this.id_empresa = _id_empresa;
        this.razao_social = _razao_social;
    }
    
    public Long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Long id) {
        this.id_empresa = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco_numero() {
        return endereco_numero;
    }

    public void setEndereco_numero(String endereco_numero) {
        this.endereco_numero = endereco_numero;
    }

    public String getEndereco_complemento() {
        return endereco_complemento;
    }

    public void setEndereco_complemento(String endereco_complemento) {
        this.endereco_complemento = endereco_complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_criador() {
        return id_criador;
    }

    public void setId_criador(int id_criador) {
        this.id_criador = id_criador;
    }  
}
