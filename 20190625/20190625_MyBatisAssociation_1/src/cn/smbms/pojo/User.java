package cn.smbms.pojo;

import java.util.Date;
import java.util.List;

public class User {
	private Integer id;
	private String userCode;
	private String userName;
	private String userPassword;
	private Integer gender;
	private Date birthday;
	private String phone;
	private String address;
	private Integer userRole;
	private Integer createdBy;
	private Date creationDate;
	private Integer modifBy;
	private Date modifyDate;

	// private String userRoleName;// smbms_role����RoleName�ֶ�

	private Role role;

	// 1->N Collaction
	private List<Address> addressList;
	// public String getUserRoleName() {
	// return userRoleName;
	// }
	//
	// public void setUserRoleName(String userRoleName) {
	// this.userRoleName = userRoleName;
	// }

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getModifBy() {
		return modifBy;
	}

	public void setModifBy(Integer modifBy) {
		this.modifBy = modifBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}
