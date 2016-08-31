/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package my.pkg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author xoyal15
 */
@Entity
public class Agent_Information {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "my2")
    @SequenceGenerator(name = "my2" , sequenceName = "agentinfoseq" , allocationSize = 20 , initialValue = 1)
    private int certi_id;
    
    private String certi_name;

    /**
     * @return the certi_id
     */
    public int getCerti_id() {
        return certi_id;
    }

    /**
     * @param certi_id the certi_id to set
     */
    public void setCerti_id(int certi_id) {
        this.certi_id = certi_id;
    }

    /**
     * @return the certi_name
     */
    public String getCerti_name() {
        return certi_name;
    }

    /**
     * @param certi_name the certi_name to set
     */
    public void setCerti_name(String certi_name) {
        this.certi_name = certi_name;
    }
    
}