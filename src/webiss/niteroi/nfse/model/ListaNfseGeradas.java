/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
public class ListaNfseGeradas implements Serializable{
    
    private String mensagemErro;
    private List<Envio> listNfse;

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    public List<Envio> getListNfse() {
        return listNfse;
    }

    public void setListNfse(List<Envio> listNfse) {
        this.listNfse = listNfse;
    }
    
    public void addEnvio(Envio envio){
        if (this.listNfse == null){
            this.listNfse = new ArrayList<>();
        }
        this.listNfse.add(envio);
    }
}
