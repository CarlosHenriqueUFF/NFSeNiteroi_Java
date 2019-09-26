/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse.rmi;

import java.rmi.*;
import java.util.List;
import webiss.niteroi.nfse.model.ListaNfseGeradas;
import webiss.niteroi.nfse.model.Venda;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
public interface GeradorNfseRemote extends Remote {
    
    public ListaNfseGeradas gerarNotaFiscal(Venda venda) throws RemoteException;
    
    public ListaNfseGeradas gerarNotaFiscalEmLote(List<Venda> vendas) throws RemoteException;
}
