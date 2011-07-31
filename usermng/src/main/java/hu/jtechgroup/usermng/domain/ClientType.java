package hu.jtechgroup.usermng.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Kliens tipus
 *
 */
@Entity
@Table(name="clienttype")
public class ClientType {

	@Id
	@Column(name="code", length=25, nullable=false, unique=true)
	private String code;
	
	@Column(name="segment", length=25, nullable=false)
	private String segment;
	
	@Column(name="description", length=100, nullable=true)
	private String description;

	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
