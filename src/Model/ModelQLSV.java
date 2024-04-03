package Model;

import java.util.ArrayList;

public class ModelQLSV {
private ArrayList<ModelSInhVien> arrayListSv;



public ModelQLSV() {
this.arrayListSv = new ArrayList<ModelSInhVien>();
	
}
public ModelQLSV(ArrayList<ModelSInhVien> arrayListSv) {
	
	this.arrayListSv = arrayListSv;
}
public ArrayList<ModelSInhVien> getArrayListSv() {
	return arrayListSv;
}
public void setArrayListSv(ArrayList<ModelSInhVien> arrayListSv) {
	this.arrayListSv = arrayListSv;
}
public void save(ModelSInhVien sv) {
	this.arrayListSv.add(sv);
	
}

}
