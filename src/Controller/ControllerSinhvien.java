package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

import Model.IOFile;
import Model.ModelSInhVien;
import View.EditorView;

public class ControllerSinhvien implements ActionListener {
private ModelSInhVien msv;
private EditorView view;

public ControllerSinhvien(EditorView view) {
	this.view = view;
	
	
}





@Override
public void actionPerformed(ActionEvent e) {
	
	String cm = e.getActionCommand();
	
	
	if(cm.equals("SaveFile")) {
		

		
	try {
		view.savetable();
		view.Xoa();
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	}else if(cm.equals("LoadFile")) {
		try {
			view.loadsv();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
}
