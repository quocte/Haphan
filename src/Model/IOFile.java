package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class IOFile{


public void ghibt(ArrayList<ModelSInhVien> list)  {
try (PrintWriter pw = new PrintWriter(new FileOutputStream("Bt.DAT", true))){
	for (ModelSInhVien s : list) {
		
		pw.print(s.getMasv()+",");
		pw.print(s.getName()+",");
		pw.print(s.getAge()+",");
		pw.print(s.getAdress()+", \n");
		

	}
	

}catch (Exception e) {
e.printStackTrace();
}
	
	
}
public ArrayList docbt() {
	ArrayList<ModelSInhVien> list = new ArrayList<>();
	try (Scanner sc  = new Scanner(new File("Bt.DAT"))){
		while(sc.hasNext()) {
	ModelSInhVien b = new ModelSInhVien();
	b.setAge(Integer.parseInt(sc.nextLine()));
	b.setMasv(sc.nextLine());
	b.setName(sc.nextLine());
	b.setAdress(sc.nextLine());
	list.add(b);
	
	
	
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return list;
}

//public void doc() throws IOException {
//	FileInputStream fis = null;
//	ObjectInputStream o = null;
//	try {
//		fis = new FileInputStream("Bt.DAT");
//		
//		o =new ObjectInputStream(fis);
//	
//		ArrayList<ModelSInhVien> list = (ArrayList<ModelSInhVien>)o.readObject();
//	}catch (Exception e) {
//		// TODO: handle exception
//	}finally {
//		if(o!=null &&fis!=null) {
//		fis.close();
//		o.close();
//	}

}