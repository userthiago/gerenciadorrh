/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentorh.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thiago Henrique Santos
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Funcionario.listarPorConta", query = "select f from Funcionario f where f.nome = ?1")
})
public class Funcionario extends AbstractEntity {
    
    @Column(length = 20)
    private int matricula;
    
    // Variaveis dados pessoais.
    @Column(length = 20)
    private String nome;
    @Column(length = 60)
    private String sobrenome;
    @Column(length = 1)
    private String sexo;
    @Column(length = 10)
    private String rg;
    @Column(length = 12)
    private String cpf;
    @Column(length = 60)
    private String nome_pai;
    @Column(length = 60)
    private String nome_mae;
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @Column(length = 12)
    private String estado_civil;
    @Column(length = 20)
    private String nacionalidade;
    @Column(length = 30)
    private String grau_instrucao;
    @Column(length = 12)
    private String raca;

    // Variaveis local de moradia.
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
    private String telefone_celular;
    @Column(length = 10)
    private String telefone_fixo;
    @Column(length = 60)
    private String email;

    //Variaveis dados empresariais.
    @Column(length = 20)
    private String cargo;
    @Temporal(TemporalType.DATE)
    private Date data_contratacao;
    @Column(length = 10)
    private String tipo_contratacao;
    @Column(length = 12)
    private String periodo_atuacao;
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresa empresa;
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getGrau_instrucao() {
        return grau_instrucao;
    }

    public void setGrau_instrucao(String grau_instrucao) {
        this.grau_instrucao = grau_instrucao;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
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

    public String getTelefone_celular() {
        return telefone_celular;
    }

    public void setTelefone_celular(String telefone_celular) {
        this.telefone_celular = telefone_celular;
    }

    public String getTelefone_fixo() {
        return telefone_fixo;
    }

    public void setTelefone_fixo(String telefone_fixo) {
        this.telefone_fixo = telefone_fixo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getData_contratacao() {
        return data_contratacao;
    }

    public void setData_contratacao(Date data_contratacao) {
        this.data_contratacao = data_contratacao;
    }

    public String getTipo_contratacao() {
        return tipo_contratacao;
    }

    public void setTipo_contratacao(String tipo_contratacao) {
        this.tipo_contratacao = tipo_contratacao;
    }

    public String getPeriodo_atuacao() {
        return periodo_atuacao;
    }

    public void setPeriodo_atuacao(String periodo_atuacao) {
        this.periodo_atuacao = periodo_atuacao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "gerenciadorrh.model.entity.Funcionario[ id=]";
    }
    
}
