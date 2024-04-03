package test;

import java.awt.EventQueue;

import View.EditorView;

public class test {
	public static void main(String[] args) {
		//sử dụng lambda :)))
		EventQueue.invokeLater(()->{
				try {
					EditorView frame = new EditorView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		});
	}
}

