package hu.jtechgroup.usermng.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * Csoport
 *
 */
@Entity
@Table(name="group")
public class Group {

	@Id
	@Column(name="groupcode", length=25, nullable=false, unique=true)
	private String code;
	
	@Column(name="segment", length=25, nullable=false)
	@Type(type="yes_no")
	private boolean vip;
	
	@Column(length=100, nullable=true)
	private String description;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="group2client", 
    		joinColumns={ @JoinColumn(name="userid") },
    		inverseJoinColumns={ @JoinColumn(name="groupcode") }
    )
    private Collection<Client> clients;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}
	
}
