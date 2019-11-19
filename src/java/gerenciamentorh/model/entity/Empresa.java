/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentorh.model.entity;

import javax.enterprise.context.Dependent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thiago Henrique Santos
 */
@Dependent
@Entity
@Table(name = "Empresa")
@NamedQueries({
    @NamedQuery(name = "Empresa.listarTodas", query = "SELECT * FROM empresas"),
    @NamedQuery(name = "Empresa.listarPorRazaoSocial", query = "SELECT e FROM Empresa e WHERE e.razao_social LIKE ?1"),
    @NamedQuery(name = "Empresa.listarPorCNPJ", query = "SELECT e FROM Empresa e WHERE e.cnpj LIKE ?1")
})
public class Empresa extends AbstractEntity {

    @Column(length = 15)
    private String cnpj;
    @Column(length = 60)
    private String nome_fantasia;
    @Column(length = 60)
    private String razao_social;
    @Column(length = 8)
    private String cep;
    @Column(length = 60)
    private String endereco;
    @Column(length = 10)
    private String endereco_numero;
    @Column(length = 10)
    private String endereco_complemento;
    @Column(length = 20)
    private String bairro;
    @Column(length = 30)
    private String cidade;
    @Column(length = 30)
    private String estado;
    @Column(length = 11)
    private String telefone;
    @Column(length = 60)
    private String proprietario;
    @Column(length = 60)
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "gerenciadorrh.model.entity.Empresa[ id=]";
    }
    
}
