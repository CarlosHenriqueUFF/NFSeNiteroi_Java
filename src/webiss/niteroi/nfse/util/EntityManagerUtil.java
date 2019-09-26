/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
public class EntityManagerUtil {
    
    private volatile static EntityManagerFactory emf = null;
    
    public static EntityManager getEntityManager(){
        boolean erro = false;
        synchronized (webiss.niteroi.nfse.util.EntityManagerUtil.class){
            if (emf == null){
                try {
                    emf = Persistence.createEntityManagerFactory("DrogavetBoleto2PU");
                }catch (PersistenceException ex){
                    erro = true;
                }
            }
        }
        if (erro){
            JOptionPane.showMessageDialog(null, "Falha para conectar ao banco de dados", "Falha de Conexão", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            return null;
        } else {
            return emf.createEntityManager();
        }
    }
    
}
