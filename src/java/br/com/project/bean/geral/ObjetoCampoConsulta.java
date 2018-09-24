/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.project.bean.geral;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author Shall
 */
public class ObjetoCampoConsulta implements Serializable, Comparator<ObjetoCampoConsulta>{

    private static final long serialVersionUID = 1L;
    
    private String descricao;
    private String campoBanco;
    private Object tipoClasse;
    private Integer principal;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCampoBanco() {
        return campoBanco;
    }

    public void setCampoBanco(String campoBanco) {
        this.campoBanco = campoBanco;
    }

    public Object getTipoClasse() {
        return tipoClasse;
    }

    public void setTipoClasse(Object tipoClasse) {
        this.tipoClasse = tipoClasse;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public void setPrincipal(Integer principal) {
        this.principal = principal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.descricao);
        hash = 83 * hash + Objects.hashCode(this.campoBanco);
        hash = 83 * hash + Objects.hashCode(this.tipoClasse);
        hash = 83 * hash + Objects.hashCode(this.principal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ObjetoCampoConsulta other = (ObjetoCampoConsulta) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.campoBanco, other.campoBanco)) {
            return false;
        }
        if (!Objects.equals(this.tipoClasse, other.tipoClasse)) {
            return false;
        }
        if (!Objects.equals(this.principal, other.principal)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return getDescricao();
    }
    
    @Override
    public int compare(ObjetoCampoConsulta o1, ObjetoCampoConsulta o2) {
       return ((ObjetoCampoConsulta)o1).getPrincipal().compareTo(
               ((ObjetoCampoConsulta)o2).getPrincipal());
    }
    
}
