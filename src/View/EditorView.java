package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerSinhvien;
import Model.IOFile;
import Model.ModelQLSV;
import Model.ModelSInhVien;

public class EditorView extends JFrame {
 ModelQLSV model;
	private static final long serialVersionUID = 1L;
	private JButton Save;
	private JPanel contentPane;
	private JTextField tfhoten;
	private JTextField tfage;
	private JTextField tfqq;
	private JLabel lblHTn;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton load;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblHTn_1;
	private JTextField tfmasv;
	
ArrayList<ModelSInhVien> lists = new ArrayList<ModelSInhVien>();
	/**
	 * Launch the application.
	 */



	/**
	 * Create the frame.
	 */
	public EditorView() {
		IOFile f = new IOFile();
		  lists = f.docbt();
		this.model = new ModelQLSV();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 250, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setSize(1000,600);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Khai bao ActionListener
		ActionListener al = new ControllerSinhvien(this);
			
		
		JLabel lblNewLabel = new JLabel("Sinh Viên");
		lblNewLabel.setBounds(389, 10, 201, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(lblNewLabel);
		
		tfhoten = new JTextField();
		tfhoten.setBounds(251, 180, 387, 45);
		contentPane.add(tfhoten);
		tfhoten.setColumns(10);
		
		tfage = new JTextField();
		tfage.setColumns(10);
		tfage.setBounds(251, 270, 387, 45);
		contentPane.add(tfage);
		
		tfqq = new JTextField();
		tfqq.setColumns(10);
		tfqq.setBounds(251, 353, 387, 45);
		contentPane.add(tfqq);
		
		lblHTn = new JLabel("Họ Tên :");
		lblHTn.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblHTn.setBounds(10, 180, 201, 45);
		contentPane.add(lblHTn);
		
		lblNewLabel_2 = new JLabel("Tuổi:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_2.setBounds(10, 270, 201, 45);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Quê Quán:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_3.setBounds(3, 353, 238, 45);
		contentPane.add(lblNewLabel_3);
		
		Save = new JButton("SaveFile");
		
		
		
		Save.setFont(new Font("Tahoma", Font.BOLD, 19));
		Save.addActionListener(al);
		Save.setBounds(234, 441, 180, 62);
		contentPane.add(Save);
		
		load = new JButton("LoadFile");
		load.addActionListener(al);
		load.setFont(new Font("Tahoma", Font.BOLD, 19));
		load.setBounds(458, 441, 180, 62);
		contentPane.add(load);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(669, 106, 307, 347);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Sv", "H\u1ECD V\u00E0 T\u00EAn", "Age", "Qu\u00EA Qu\u00E1n"
			}
		));
		scrollPane.setViewportView(table);
		
		lblHTn_1 = new JLabel("Mã sv:");
		lblHTn_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblHTn_1.setBounds(10, 112, 201, 45);
		contentPane.add(lblHTn_1);
		
		tfmasv = new JTextField();
		tfmasv.setColumns(10);
		tfmasv.setBounds(251, 112, 387, 45);
		contentPane.add(tfmasv);
		//sư dung lambda
		JButton btnDeleteAll = new JButton("DeleteALL");
		
		btnDeleteAll.addActionListener(e->{
			DefaultTableModel model = new DefaultTableModel();
			xoaALL("Bt.DAT");
			
		});
		
		
		btnDeleteAll.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeleteAll.setBounds(669, 466, 127, 62);
		contentPane.add(btnDeleteAll);
	}
	public void Xoa() {
		tfage.setText("");
		tfhoten.setText("");
		tfqq.setText("");
		tfmasv.setText("");
	}
	public void addSv(ModelSInhVien sv) {
	
		if(tfmasv.getText().equals("")||tfhoten.getText().equals("")||tfage.getText().equals("")||tfqq.getText().equals("")) {
	JOptionPane.showMessageDialog(contentPane, "bạn chưa nhập dữ liệu");		
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(
				new Object[] {
						sv.getMasv()+"",sv.getName(),sv.getAge()+"",sv.getAdress()
				}
				);
		
	}
	public void savetable() throws FileNotFoundException {
		
		if(tfmasv.getText().equals("")||tfhoten.getText().equals("")||tfage.getText().equals("")||tfqq.getText().equals(""))
		{
			JOptionPane.showMessageDialog(contentPane, "error");
		}else{
			IOFile f = new IOFile();
			  lists = f.docbt();
		
			ModelSInhVien s = new ModelSInhVien(); 
			
			s.setMasv(tfmasv.getText());
			s.setName(tfhoten.getText());
			s.setAdress(tfqq.getText());
			
			s.setAge(Integer.parseInt(tfage.getText()));
		DefaultTableModel t = (DefaultTableModel) table.getModel();
		t.addRow(new Object[]{tfmasv.getText(), tfhoten.getText(), tfage.getText(), tfqq.getText()});
		lists.add(s);
		
		f.ghibt(lists);
	}
		
	}
	public void loadsv() throws IOException {
		File file = new File("Bt.DAT");
if(file.exists()) {
	  if(file.length()==0) {
		  JOptionPane.showMessageDialog(Save, "rỗng");
	  }else {
		  try {
			  
	          
	            FileReader fileReader = new FileReader(file);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            String line;
	            String[] headers = {"Mã Sinh Viên","Name","Age","Quê Quán"}; // Dòng đầu tiên là tiêu đề cột
	            DefaultTableModel model = new DefaultTableModel(0, 4);
	            model.setColumnIdentifiers(headers);
	            while ((line = bufferedReader.readLine()) != null) {
	            	 String[] data =line.split(",");
		                	 
		                
	            	 model.addRow(data);
	            }
	            table.setModel(model);
	            JOptionPane.showMessageDialog(Save, "Load file thành công");
	            bufferedReader.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	  }
}else {
	JOptionPane.showMessageDialog(contentPane, "file ko tồn tại");
}
	}
	
	
	public void xoaALL(String path) {
        File file = new File(path);
        
DefaultTableModel model = new DefaultTableModel();
        if (file.exists()) {
            if (file.delete()) {
            	
                JOptionPane.showMessageDialog(this, "Đã xóa thành công file.");
            } else {
                JOptionPane.showMessageDialog(this, "Không thể xóa file.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "File không tồn tại.");
        }}
	

}
