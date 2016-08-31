/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package my.pkg;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author xoyal15
 */
@Entity
public class Agent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "my1")
    @SequenceGenerator(name = "my1" , sequenceName = "agentseq" , allocationSize = 20 ,initialValue = 1)
    private int id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Agent_Information> agent_info=new HashSet<Agent_Information>(0);
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the agent_info
     */
    public Set<Agent_Information> getAgent_info() {
        return agent_info;
    }

    /**
     * @param agent_info the agent_info to set
     */
    public void setAgent_info(Set<Agent_Information> agent_info) {
        this.agent_info = agent_info;
    }
}