/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testapp;

import my.pkg.Agent;
import my.pkg.Agent_Information;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author xoyal15
 */
public class TestApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Configuration cfg=new AnnotationConfiguration();
        cfg.configure();
        
        SessionFactory factory=cfg.buildSessionFactory();
        
        Session session=factory.openSession();
        
        Transaction ts=session.beginTransaction();
        
        
        Agent a1=new Agent();
        a1.setName("testRecord");
        
        Agent_Information ai1=new Agent_Information();
        ai1.setMobileno("9988776655");
        ai1.setAgent(a1);
        
        a1.setAgent_info(ai1);
        session.save(a1);
        ts.commit();
        
        session.close();
    }
    
}
