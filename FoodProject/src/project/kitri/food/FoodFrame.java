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

	   public JPanel contentPane = new JPanel();;//�⺻panel
	   public JPanel mainPanel = new JPanel();//main panel
	   private JPanel panel_1 = new JPanel();//ȭ��ù��panel
	   private JLabel titleL;//ȭ��ù��panel�� title,date,time
	   private JLabel dateL;
	   private JLabel timeL;
	   
	   //////////////////////////////////////////////
	   //ī�װ� ��ư��
	   public JButton drinkBtn = new JButton("\uC74C\uB8CC");
	   public JButton snackBtn = new JButton("\uACFC\uC790");
	   public JButton noodleBtn = new JButton("\uB77C\uBA74");
	   public JButton instfoodBtn = new JButton("\uC74C\uC2DD");
	   
	   //�޴��� panel
	   JPanel menuPanel;
	   //�޴��� View
	   public DrinkView dv = new DrinkView();
	   public SnackView sv = new SnackView();
	   public NoodleView nv = new NoodleView();
	   public InstFoodView ifv = new InstFoodView();
	   
	   CardLayout card = new CardLayout();
	   //////////////////////////////////
	   //�ֹ����,�Ϸ��ư
	   JButton cancelBtn = new JButton("\uCDE8\uC18C");
	   JButton completeBtn = new JButton("\uC644\uB8CC");
	   ////////////////////////////////////
	   //�ֹ�list
	   public JPanel orderPanel = new JPanel();
	   public JScrollPane tableP;
	   public JTable listT;
	   public DefaultTableModel tM;
	   ///////////////////////////////////////////
	   //�ѱݾ� textfield
	   JTextField textField;
	   public JTextField sumprice;
	   //�ֹ�������ư
	   JButton plusBtn = new JButton("+");
	   JButton minusBtn = new JButton("-");
	   JButton oneCancel = new JButton("X");
	   JButton totalCancel = new JButton("\uC804\uCCB4 \uCDE8\uC18C");
	   /////////////////
	   public JRadioButton ice;
	   ///////////////////////////////////////
	   //Event Controller
	   public FoodController foodController;
	   
	   
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
	      drinkBtn.setForeground(Color.WHITE);
	      drinkBtn.setBackground(Color.DARK_GRAY);
	      //////////////////////////////////////////////
	      //ī�װ� ��ư��
	      drinkBtn.setBounds(1374, 71, 97, 50);
	      mainPanel.add(drinkBtn);
	      drinkBtn.setFont(new Font("���� ���", Font.BOLD, 20));
	      snackBtn.setForeground(Color.WHITE);
	      snackBtn.setBackground(Color.DARK_GRAY);
	      snackBtn.setBounds(1374, 131, 97, 50);
	      mainPanel.add(snackBtn);
	      snackBtn.setFont(new Font("���� ���", Font.BOLD, 20));
	      noodleBtn.setForeground(Color.WHITE);
	      noodleBtn.setBackground(Color.DARK_GRAY);
	      noodleBtn.setBounds(1374, 191, 97, 50);
	      mainPanel.add(noodleBtn);
	      noodleBtn.setFont(new Font("���� ���", Font.BOLD, 20));
	      instfoodBtn.setForeground(Color.WHITE);
	      instfoodBtn.setBackground(Color.DARK_GRAY);
	      instfoodBtn.setBounds(1374, 251, 97, 50);
	      mainPanel.add(instfoodBtn);
	      instfoodBtn.setFont(new Font("���� ���", Font.BOLD, 20));
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
	      cancelBtn.setBackground(new Color(52, 152, 219));
	      cancelBtn.setBounds(883, 708, 235, 47);
	      cancelBtn.setFont(new Font("���� ���", Font.BOLD, 30));
	      mainPanel.add(cancelBtn);
	      
	      completeBtn.setForeground(Color.WHITE);
	      completeBtn.setBackground(new Color(52, 152, 219));
	      completeBtn.setBounds(1138, 708, 235, 47);
	      completeBtn.setFont(new Font("���� ���", Font.BOLD, 30));
	      mainPanel.add(completeBtn);
	      //////////////////////////////////////
	      //�ֹ�list
	      orderPanel.setBounds(48, 67, 630, 583);
	      orderPanel.setLayout(new BorderLayout(0, 0));
	      //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	      //Jtable
	      //�÷� ��
	      Vector<String> column1 = new Vector<String>();
	      column1.addElement("No");

	      column1.addElement("ī�װ�");
	      column1.addElement("�޴�");
	      column1.addElement("����");
	      column1.addElement("����");
	      
	      //�߰��� �÷������� �� �����ϰ� ���� ����
	      tM = new DefaultTableModel(column1, 0);
	      
	      
	      //JTable�� ����.
	      listT = new JTable(tM);
	      listT.setFillsViewportHeight(true);
	      
	      //table ����
	      tableP = new JScrollPane(listT);
	      orderPanel.add(tableP);
	      
	      
	      mainPanel.add(orderPanel);
	      ///!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	      
	      textField = new JTextField();
	      textField.setBackground(new Color(52, 152, 219));
	      textField.setForeground(Color.WHITE);
	      textField.setHorizontalAlignment(SwingConstants.CENTER);
	      textField.setText("\uCD1D\uAE08\uC561");
	      textField.setBounds(48, 681, 225, 37);
	      mainPanel.add(textField);
	      textField.setColumns(10);
	      textField.setFont(new Font("���� ���", Font.BOLD, 25));
	      //�ѱݾ�
	      sumprice = new JTextField();
	      sumprice.setText("0");
	      sumprice.setHorizontalAlignment(SwingConstants.CENTER);
	      sumprice.setBounds(48, 718, 225, 37);
	      mainPanel.add(sumprice);
	      sumprice.setColumns(10);
	      sumprice.setFont(new Font("���� ���", Font.BOLD, 30));
	      plusBtn.setForeground(Color.WHITE);
	      plusBtn.setBackground(Color.DARK_GRAY);
	      
	      plusBtn.setBounds(285, 680, 75, 75);
	      mainPanel.add(plusBtn);
	      plusBtn.setFont(new Font("���� ���", Font.BOLD, 40));
	      minusBtn.setForeground(Color.WHITE);
	      minusBtn.setBackground(Color.DARK_GRAY);
	      minusBtn.setBounds(372, 680, 75, 75);
	      mainPanel.add(minusBtn);
	      minusBtn.setFont(new Font("���� ���", Font.BOLD, 40));
	      oneCancel.setForeground(Color.WHITE);
	      oneCancel.setBackground(Color.DARK_GRAY);
	      oneCancel.setBounds(459, 680, 75, 75);
	      mainPanel.add(oneCancel);
	      oneCancel.setFont(new Font("���� ���", Font.BOLD, 30));
	      totalCancel.setForeground(Color.WHITE);
	      totalCancel.setBackground(Color.DARK_GRAY);
	      totalCancel.setBounds(546, 680, 132, 75);
	      mainPanel.add(totalCancel);
	      totalCancel.setFont(new Font("���� ���", Font.BOLD, 20));
	      //////////////////////////////////////
	      //ice ��ư
	      ice = new JRadioButton("\uC544\uC774\uC2A4");
	      ice.setFont(new Font("���� ���", Font.BOLD, 18));
	      ice.setBounds(1252, 656, 121, 33);
	      mainPanel.add(ice);
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
	      
	      ice.addActionListener(foodController);
	      //DrinkView 
	      int drinklen = dv.drinkbtn.length;
	      for(int i=0;i<drinklen;i++) {
	    	   dv.drinkbtn[i].addActionListener(foodController);
	      }
	      //SnackView
	      int snacklen = sv.snackbtn.length;
	      for(int i=0;i<snacklen;i++) {
	    	   sv.snackbtn[i].addActionListener(foodController);
	      }
	      //NoodleView
	      int noodlelen = nv.noodlebtn.length;
	      for(int i=0;i<noodlelen;i++) {
	    	   nv.noodlebtn[i].addActionListener(foodController);
	      }
	      //InstFoodView
	      int instlen = ifv.instfoodbtn.length;
	      for(int i=0;i<instlen;i++) {
	    	  ifv.instfoodbtn[i].addActionListener(foodController);
	      }
	      
	      
	     
	      
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
