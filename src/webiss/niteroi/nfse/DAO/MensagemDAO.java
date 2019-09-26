/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse.DAO;

import javax.persistence.Query;
import webiss.niteroi.nfse.model.Mensagem;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
public class MensagemDAO extends DAOModelo<Mensagem> {

    public MensagemDAO() {
        super();
    }

    public void deleteMensagensAnteriores(String eventoGerador, Long idEventoGerador) {
        try {
            entityManager.getTransaction().begin();
            Query query = super.entityManager.createQuery(""
                    + "delete from Mensagem m "
                    + " where m.eventoGerador = '" + eventoGerador + "'"
                    + "   and m.idEventoGerador = " + idEventoGerador);
            query.executeUpdate();
            super.entityManager.getTransaction().commit();
        }catch(Exception e){
            super.entityManager.getTransaction().rollback();
        } finally {
            super.entityManager.close();
    }
    }

}
