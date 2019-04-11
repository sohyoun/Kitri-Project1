package project.kitri.food;

import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class FoodFrame extends JFrame{

	   JPanel contentPane = new JPanel();;//�⺻panel
	   JPanel mainPanel = new JPanel();//main panel
	   private JPanel panel_1 = new JPanel();//ȭ��ù��panel
	   private JLabel titleL;//ȭ��ù��panel�� title,date,time
	   private JLabel dateL;
	   private JLabel timeL;
	   
	   //////////////////////////////////////////////
	   //ī�װ� ��ư��
	   JButton drinkBtn = new JButton("\uC74C\uB8CC");
	   JButton snackBtn = new JButton("\uACFC\uC790");
	   JButton noodleBtn = new JButton("\uB77C\uBA74");
	   JButton instfoodBtn = new JButton("\uC74C\uC2DD");
	   
	   //�޴��� panel
	   JPanel menuPanel;
	   //�޴��� View
	   DrinkView dv = new DrinkView();
	   SnackView sv = new SnackView();
	   NoodleView nv = new NoodleView();
	   InstFoodView ifv = new InstFoodView();
	   
	   CardLayout card = new CardLayout();
	   //////////////////////////////////
	   //�ֹ����,�Ϸ��ư
	   JButton cancelBtn = new JButton("\uCDE8\uC18C");
	   JButton completeBtn = new JButton("\uC644\uB8CC");
	   ////////////////////////////////////
	   //�ֹ�list
	   JPanel orderPanel = new JPanel();
	   
	   //�ѱݾ� textfield
	   JTextField textField;
	   JTextField sumprice;
	   //�ֹ�������ư
	   JButton plusBtn = new JButton("+");
	   JButton minusBtn = new JButton("-");
	   JButton oneCancel = new JButton("X");
	   JButton totalCancel = new JButton("\uC804\uCCB4 \uCDE8\uC18C");
	   
	   ///////////////////////////////////////
	   //Event Controller
	   FoodController foodController;
	   
	   
	   /**
	    * Create the frame.
	    */
	   public FoodFrame() {
	      /////////////////////////////////////////////////
	      //ȭ��ù�� : panel_1
	      titleL = new JLabel("//��ũ��ũ// 1ȣ��"); //�����̸�
	      titleL.setHorizontalAlignment(SwingConstants.CENTER);
	      titleL.setFont(new Font("���� ��� Semilight", Font.BOLD, 16));
	      titleL.setToolTipText("");
	      titleL.setBorder(new LineBorder(new Color(200, 200, 200)));
	      
	      dateL = new JLabel(new SimpleDateFormat("yyyy/MM/dd").format(new Date())); //��¥
	      dateL.setBorder(new LineBorder(new Color(200, 200, 200)));
	      dateL.setHorizontalAlignment(SwingConstants.CENTER);
	      dateL.setFont(new Font("���� ��� Semilight", Font.BOLD, 16));
	      
	      timeL = new JLabel(new SimpleDateFormat("HH:mm").format(new Date()) + "(����ð�)"); //�ð�
	      timeL.setBorder(new LineBorder(new Color(200, 200, 200)));
	      timeL.setHorizontalAlignment(SwingConstants.CENTER);
	      timeL.setFont(new Font("���� ��� Semilight", Font.BOLD, 16));
	      
	      panel_1.setLayout(new GridLayout(0, 3, 0, 0));
	      panel_1.add(titleL);
	      panel_1.add(dateL);
	      panel_1.add(timeL);
	      
	      panel_1.setBorder(new LineBorder(SystemColor.scrollbar, 2));
	      panel_1.setBackground(SystemColor.controlHighlight);
	      panel_1.setBounds(0, 0, 1494, 35);
	      contentPane.add(panel_1);
	      
	      /////////////////////////////////////////////////////////////////
	      //main panel
	      mainPanel.setBackground(Color.WHITE);
	      mainPanel.setBounds(0, 36, 1494, 835); // �� ũ���� �г� �����ؼ� cardLayout���� ����~~
	      mainPanel.setLayout(null);
	      //////////////////////////////////////////////
	      //ī�װ� ��ư��
	      drinkBtn.setBounds(1374, 67, 97, 85);
	      mainPanel.add(drinkBtn);
	      drinkBtn.setFont(new Font("����", Font.BOLD, 20));
	      snackBtn.setBounds(1374, 162, 97, 85);
	      mainPanel.add(snackBtn);
	      snackBtn.setFont(new Font("����", Font.BOLD, 20));
	      noodleBtn.setBounds(1374, 257, 97, 85);
	      mainPanel.add(noodleBtn);
	      noodleBtn.setFont(new Font("����", Font.BOLD, 20));
	      instfoodBtn.setBounds(1374, 352, 97, 85);
	      mainPanel.add(instfoodBtn);
	      instfoodBtn.setFont(new Font("����", Font.BOLD, 20));
	      ///////////////////////////////////////////////
	      //menu�� ��ư�� ���� panel : menuPanel
	      menuPanel = new JPanel();
	      menuPanel.setBounds(717, 67, 656, 583);
	            
	      menuPanel.setLayout(card);//menuPanel�� cardLayout �����
	      
	      dv.setLocation(715, 67);//�� ī�װ� panel
	      menuPanel.add("drinkview",dv);
	      sv.setLocation(715, 67);
	      menuPanel.add("snackview",sv);
	      nv.setLocation(715, 67);
	      menuPanel.add("noodleview",nv);
	      ifv.setLocation(715, 67);
	      menuPanel.add("instfoodview",ifv);
	      
	      card.show(menuPanel, "drinkview");//ù�������� ���̴� panel : drink
	      
	      mainPanel.add(menuPanel);
	      //////////////////////////////////////////////
	      //�ֹ� ���,�Ϸ� ��ư
	      cancelBtn.setForeground(Color.WHITE);
	      cancelBtn.setBackground(Color.DARK_GRAY);
	      cancelBtn.setBounds(883, 680, 235, 75);
	      cancelBtn.setFont(new Font("����", Font.BOLD, 30));
	      mainPanel.add(cancelBtn);
	      
	      completeBtn.setForeground(Color.WHITE);
	      completeBtn.setBackground(Color.DARK_GRAY);
	      completeBtn.setBounds(1138, 680, 235, 75);
	      completeBtn.setFont(new Font("����", Font.BOLD, 30));
	      mainPanel.add(completeBtn);
	      //////////////////////////////////////
	      //�ֹ�list
	      orderPanel.setBounds(48, 67, 630, 583);
	      orderPanel.setLayout(new BorderLayout(0, 0));
	      //table
	      String[] header = {" ","No","ī�װ�","�޴�","����","����","���"};
	      String[][] contents = null;
	      DefaultTableModel tM = new DefaultTableModel(contents, header);
	      JTable listT = new JTable(tM);
	      listT.setFillsViewportHeight(true);
	      
	      //table ����
	      JScrollPane tableP = new JScrollPane(listT);
	      orderPanel.add(tableP);
	      
	      
	      mainPanel.add(orderPanel);
	      ///////////////////////////////////////////////////////
	      
	      textField = new JTextField();
	      textField.setHorizontalAlignment(SwingConstants.CENTER);
	      textField.setText("\uCD1D\uAE08\uC561");
	      textField.setBounds(48, 681, 225, 37);
	      mainPanel.add(textField);
	      textField.setColumns(10);
	      textField.setFont(new Font("����", Font.BOLD, 30));
	      
	      sumprice = new JTextField();
	      sumprice.setText("0");
	      sumprice.setHorizontalAlignment(SwingConstants.CENTER);
	      sumprice.setBounds(48, 718, 225, 37);
	      mainPanel.add(sumprice);
	      sumprice.setColumns(10);
	      sumprice.setFont(new Font("����", Font.BOLD, 30));
	      
	      plusBtn.setBounds(285, 680, 75, 75);
	      mainPanel.add(plusBtn);
	      plusBtn.setFont(new Font("����", Font.BOLD, 40));
	      minusBtn.setBounds(372, 680, 75, 75);
	      mainPanel.add(minusBtn);
	      minusBtn.setFont(new Font("����", Font.BOLD, 40));
	      oneCancel.setBounds(459, 680, 75, 75);
	      mainPanel.add(oneCancel);
	      oneCancel.setFont(new Font("����", Font.BOLD, 30));
	      totalCancel.setBounds(546, 680, 132, 75);
	      mainPanel.add(totalCancel);
	      totalCancel.setFont(new Font("����", Font.BOLD, 20));
	      ////////////////////////////////////
	     
	      contentPane.add(mainPanel);
	      
	      contentPane.setLayout(null);
	      setContentPane(contentPane);
	      setBounds(100, 100, 1500, 900);
	      setResizable(false);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      /////////////////////////////
	      //Event Listener
	      foodController = new FoodController(this);
	      
	      drinkBtn.addActionListener(foodController);
	      snackBtn.addActionListener(foodController);
	      noodleBtn.addActionListener(foodController);
	      instfoodBtn.addActionListener(foodController);
	      
	      plusBtn.addActionListener(foodController);
	      minusBtn.addActionListener(foodController);
	      oneCancel.addActionListener(foodController);
	      totalCancel.addActionListener(foodController);
	      
	      cancelBtn.addActionListener(foodController);
	      completeBtn.addActionListener(foodController);
	      
	      //DrinkView 
	      int drinklen = dv.drinkbtn.length;
	      for(int i=0;i<drinklen;i++) {
	    	   dv.drinkbtn[i].addActionListener(foodController);
	      }
	      //SnackView
	      int snacklen = sv.snackbtn.length;
	      for(int i=0;i<drinklen;i++) {
	    	   dv.drinkbtn[i].addActionListener(foodController);
	      }
	      //NoodleView
	      //InstFoodView
	      ////////////////////////////////
	   }
	    
	   

	   /**
	    * Launch the application.
	    */
	   public static void main(String[] args) {
	      EventQueue.invokeLater(new Runnable() {
	         public void run() {
	            try {
	               FoodFrame frame = new FoodFrame();
	               frame.setVisible(true);
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         }
	      });
	   }

	   
}
