package Model;

import java.io.Serializable;

public class ModelSInhVien implements Serializable{
private String name;
private int age;
private String Adress;
private String Masv;

//public ModelSInhVien(String name,int age,String Adress,String Masv) {
//	this.name = name;
//	this.age= age;
//	this.Adress= Adress;
//	this.Masv= Masv;
//}
public void setMasv(String masv) {
	Masv = masv;
}

public String getAdress() {
	return Adress;
}
public String getName() {
	return name;
}
public int getAge() {
	return age;
}
public void setAdress(String adress) {
	Adress = adress;
}
public void setAge(int age) {
	this.age = age;
}
public void setName(String name) {
	this.name = name;
}public String getMasv() {
	return Masv;
}

}
