package cn.edu.sdwu.schooldb.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ta_user_info")
public class TaUserInfo implements Serializable {
	private static final long serialVersionUID = 5273602021966685792L;
	
	private Integer id;
	private String userId;
	private String accountName;
	
	public TaUserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TaUserInfo(Integer id) {
		super();
		this.id = id;
	}

	public TaUserInfo(Integer id, String userId, String accountName) {
		super();
		this.id = id;
		this.userId = userId;
		this.accountName = accountName;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="user_id", nullable = false, length = 100)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name="account_name", nullable = false, length = 100)
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
