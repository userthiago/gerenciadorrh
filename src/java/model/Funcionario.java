package model;

import java.io.Serializable;
import javax.enterprise.context.Dependent;
import java.util.Date;

@Dependent
public class Funcionario implements Serializable {

    private int matricula;
    // Variaveis dados pessoais.
    //private int foto; //Será implementado futuramente.
    private String nome;
    private String sobrenome;
    private String sexo;
    private String rg;
    private String cpf;
    private String nome_pai;
    private String nome_mae;
    private Date nascimento;
    private String estado_civil;
    private String nacionalidade;
    private String grau_instrucao;
    private String raca;

    // Variaveis local de moradia.
    private String cep;
    private String endereco;
    private String endereco_numero;
    private String endereco_complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone_celular;
    private String telefone_fixo;
    private String email;

    //Variaveis dados empresariais.
    private String cargo;
    private Date data_contratacao;
    private String tipo_contratacao;
    private String periodo_atuacao;
    private int id_empresa;
    private int id_criador;

    public Funcionario() {

    }
    
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

    public void setData_contratacao(Date emissao) {
        this.data_contratacao = emissao;
    }

    public String getTipo_contratacao() {
        return tipo_contratacao;
    }

    public void setTipo_contratacao(String contratacao) {
        this.tipo_contratacao = contratacao;
    }

    public String getPeriodo_atuacao() {
        return periodo_atuacao;
    }

    public void setPeriodo_atuacao(String periodo_atuacao) {
        this.periodo_atuacao = periodo_atuacao;
    }
    
    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }    

    public int getId_criador() {
        return id_criador;
    }

    public void setId_criador(int id_criador) {
        this.id_criador = id_criador;
    }
    
    
    
}
