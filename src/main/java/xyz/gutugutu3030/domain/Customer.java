package xyz.gutugutu3030.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="customers")
public class Customer {
	@Id	//主キー
	@GeneratedValue	//autoIncrement
	private Integer id;
	@Column(nullable=false)	//名前や制約を書ける　今回はnotnull
	private String firstName;
	@Column(nullable=false)	//名前や制約を書ける　今回はnotnull
	private String lastName;
	public Customer(){

	}
	public Customer(Integer id, String firstName, String lastName) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public Integer getId() {
		// TODO 自動生成されたメソッド・スタブ
		return id;
	}
	public String toString(){
		return "id:"+id+" firstName:"+firstName+" lastName:"+lastName;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}

}
