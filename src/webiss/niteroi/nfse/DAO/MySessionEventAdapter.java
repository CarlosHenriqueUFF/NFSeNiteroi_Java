/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webiss.niteroi.nfse.DAO;

/**
 *
 * @author Carlos Henrique Carvalho da Silva <carlos_henrique@id.uff.br>
 */
import org.eclipse.persistence.sessions.SessionEvent;
import org.eclipse.persistence.sessions.SessionEventAdapter;

public class MySessionEventAdapter extends SessionEventAdapter {

    @Override
    public void postAcquireClientSession(SessionEvent event) {

        event.getSession().executeNonSelectingSQL("PRAGMA foreign_keys=ON");

        super.postAcquireClientSession(event);

    }
}
