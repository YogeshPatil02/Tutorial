/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package my.pkg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author xoyal15
 */
@Entity
public class Agent_Information {
    
    @Id 
    @GeneratedValue  
    private int add_id;
    
    private String address;
    
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "agent_info")
    private Set<Agent> agent=new HashSet<Agent>(0);
    /**
     * @return the id
     */
    public int getAdd_id() {
        return add_id;
    }

    /**
     * @param add_id the id to set
     */
    public void setAdd_id(int add_id) {
        this.add_id = add_id;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the agent
     */
    public Set<Agent> getAgent() {
        return agent;
    }

    /**
     * @param agent the agent to set
     */
    public void setAgent(Set<Agent> agent) {
        this.agent = agent;
    }

    /**
     * @return the agent
     */
}