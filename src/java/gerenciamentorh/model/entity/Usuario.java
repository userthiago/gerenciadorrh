/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentorh.model.entity;

import javax.enterprise.context.Dependent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import model.TipoUsuario;

/**
 *
 * @author Thiago Henrique Santos
 */
@Dependent
@Entity
@Table(name = "Usuarios")
public class Usuario extends AbstractEntity {
    @Column(length = 10)
    private String rg;
    @Column(length = 60)
    private String nome;
    @Column(length = 20)
    private String cargo;
    @Column(length = 20)
    private String login;
    @Column(length = 20)
    private String senha;
    @Column(length = 10)
    private TipoUsuario tipo;

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "model.entity.Usuario[ id ]";
    }
    
}
