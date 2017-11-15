package text;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class mainFrame extends JFrame implements KeyListener,Runnable  {

	private JPanel AnimeMusicClick;//定义容器
	JMenuBar bar;//定义窗体控件，加入窗体选项栏（选项、游戏设置等）
	JMenu menu1,menu2,menu3,menu4; //定义菜单
	JMenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9,item10;//定义菜单选项
	final JButton GameStart = new JButton("");
	final JButton SongChoice = new JButton("");
	final JButton Exit = new JButton("");
	final JButton TStart = new JButton("");
	final JButton TStop = new JButton("");
	final JButton TReturn = new JButton("");
	final JButton SSong1 = new JButton("");
	final JButton SSong2 = new JButton("");
	final JButton SSong3 = new JButton("");
	final JButton SSong4 = new JButton("");
	final JButton SSong5 = new JButton("");
	final JButton SSong6 = new JButton("");
	final JButton SReturn = new JButton("");
	final JButton Score=new JButton("");
	final JButton Scoretext=new JButton("Score:");
	//final JButton BJL=new JButton();
	//final JButton BJR=new JButton();
	Thread t=new Thread(this);//创建线程
	Thread bj=new Thread(this);
	//Thread t1=new Thread(this);
	//Thread t2=new Thread(this);
	//Thread t3=new Thread(this);
	//Thread t4=new Thread(this);
	//Thread t5=new Thread(this);
	private int s=0;//控制输出分数的时间
	private int MoveX=0;//横向移动
	private int BJLX1=-350;
	private int BJLY=70;
	private int BJRX1=1200;
	private int BJRY=70;
	private int BJLX=-250;
	private int BJRX=1100;
	boolean text=true;
	@SuppressWarnings("deprecation")
	public int getBJLX() {
	do {
		BJLX+=2;
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(BJLX==950) {
			bj.stop();
			flag=false;
		}
		return BJLX;
	}while(flag);
		
	}
	@SuppressWarnings("deprecation")
	public int getBJRX() {
		 do{
			BJRX-=2;
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(BJRX==0) {
			bj.stop();
				flag=false;
			}
		return BJRX;
		}while(flag);
	}
	
	public int getBJLX1() {
		do {
			BJLX1+=2;
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(BJLX1==520) {
				text=false;
			}
		return BJLX1;
		}while(text);
	}
	public int getBJRX1() {
		do {
			BJRX1-=2;
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(BJRX1==360) {
				text=false;
			        
			}
		return BJRX1;
		}while(text);
	}

	
	@SuppressWarnings("deprecation")//t.stop加的
	public int getMoveX() {
		
		do {
			
	    MoveX+=3;
		if(MoveX==48990) {//48990
			
			t.stop();
			
			flag=false;
		}
		return MoveX;
		}while(flag);
		
	}
	private int choice;//switch 选择
	
	private boolean flag=true;//while判断
	String str;
	private int score0=0;
	private int score1=0;
	
	//加入背景音乐所需
   	File file;
   	URI uri;
    URL url; 
    private AudioClip aau; //歌曲开关
    public static String songPath=System.getProperty("user.dir")+"/song/";//song的路径
	
	public static void main(String[] args) {
		new mainFrame();
		
	}
	public mainFrame() {
		
        bar=new JMenuBar();//声明窗体标题栏
		menu1=new JMenu("  选项");//标题栏内容
		menu2=new JMenu("游戏设置");
		menu3=new JMenu("音乐选择");
		menu4=new JMenu("帮助");
		item1=new JMenuItem(" 开始");//下拉菜单内容
		item2=new JMenuItem(" 暂停");
		item3=new JMenuItem(" 返回");
		item4=new JMenuItem(" 退出");
		item5=new JMenuItem("关闭背景音乐");
	    item6=new JMenuItem("打开背景音乐"); 
	    item7=new JMenuItem("音量调整");
	    item8=new JMenuItem("速度调整");
	    item9=new JMenuItem("跳转选择界面");
	    item10=new JMenuItem("关于游戏");
		menu1.add(item1);//将下拉菜单选项加入menu
		menu1.add(item2);
		menu1.add(item3);
		menu1.add(item4);//将下拉菜单选项加入menu1
		menu2.add(item5);//将下拉菜单选项加入menu2
		menu2.add(item6);
		menu2.add(item7);
		menu2.add(item8);
		menu3.add(item9);
		menu4.add(item10);
		bar.add(menu1);//将menu添加到窗体
		bar.add(menu2);
		bar.add(menu3);
		bar.add(menu4);
		
		this.setJMenuBar(bar);//窗体控件调用
		this.setTitle("AnimeMusicClick V2.0");//标题
		this.setSize(1200, 800);//窗口大小
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕宽度
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕长度
		this.setLocation((width-1200)/2, (height-800)/2);//计算屏幕正中间，将窗口显示在屏幕中间
		this.setResizable(false);//窗口设置为不可改变大小
		StaticValues.init();//初始化图片
		choice=7;
		bj.start();
		this.setIconImage(StaticValues.Title);
		
		ItemAction();//标题栏事件响应
		BackGroundMusic();//播放背景音乐
		SongChoiceButtonAction();//选歌界面事件响应
		StartGameButton();//运行界面事件响应
		setFocusable(true);
		this.addKeyListener(this);//键盘相应事件
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
		this.setVisible(true);//窗口可见
		
	}
	//绘制背景图片
public void paintbackground(int bjlx,int bjrx,int bjlx1,int bjrx1) {
	
		//初始化所有静态变量
		//StaticValues.init();
		
		//定义容器
		AnimeMusicClick = new JPanel() {
	    private static final long serialVersionUID = 1L;
		@Override
		//导入背景图片
	    protected void paintComponent(Graphics g) {
		super.paintComponent(g);//继承JComponent类
						
		g.drawImage(new ImageIcon(StaticValues.StartBg).getImage(), 0,0, getWidth(), getHeight(), null);//添加图片
		g.drawImage(new ImageIcon(StaticValues.BJL).getImage(), bjlx,BJLY, 350, 58, null);	
		g.drawImage(new ImageIcon(StaticValues.BJR).getImage(), bjrx,BJRY, 350, 58, null);	
		g.drawImage(new ImageIcon(StaticValues.BJL).getImage(), bjlx1,120, 350, 58, null);//520
	    g.drawImage(new ImageIcon(StaticValues.BJR).getImage(), bjrx1,120, 350, 58, null);//360	
			
		
			}
	 };
	 AnimeMusicClick.setBorder(new EmptyBorder(5, 5, 5, 5));//设置面板边界
	 setContentPane(AnimeMusicClick);//把contentPane设置为JFrame的内容面板
	 AnimeMusicClick.setLayout(null);//为了不影响其他控件的布局大小
	this.setVisible(true);
	 //导入选项按钮GameStart
	 GameStart.setBorder(null);//去边框
	 GameStart.setContentAreaFilled(false);//使Button透明
	 GameStart.setIcon(new ImageIcon(StaticValues.AllFirstPageButtons.get(3)));//3
	 GameStart.setBounds(100, 400, 200, 40);
	 AnimeMusicClick.add(GameStart);
	 
	 //导入选项按钮SongChoice
	 SongChoice.setBorder(null);//去边框
	 SongChoice.setContentAreaFilled(false);//使Button透明
	 SongChoice.setIcon(new ImageIcon(StaticValues.AllFirstPageButtons.get(1)));//1
	 SongChoice.setBounds(100, 500, 200, 40);
	 AnimeMusicClick.add(SongChoice);
	
	 //导入退出按钮Exit
	 Exit.setBorder(null);//去边框
	 Exit.setContentAreaFilled(false);//使Button透明
	 Exit.setIcon(new ImageIcon(StaticValues.AllFirstPageButtons.get(2)));//2
	 Exit.setBounds(100, 600, 200, 40);
	 AnimeMusicClick.add(Exit);
	
	
						
}
public void ItemAction() {

	//开始
	item1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			GameStart.doClick();
			
		}
	});
	//暂停
	item2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		
		}
	});
	//返回
	item3.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")//t.stop加的
		public void actionPerformed(ActionEvent e) {
			
		 item5.doClick();//关闭背景音乐
		 t.stop();
		 //t1.stop();
		 //t2.stop();
		// t3.stop();
		// t4.stop();
		// t5.stop();
		 new mainFrame();
		
		}
	});
	//退出
	item4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		  System.exit(0);
		
		}
	});
	//关闭背景音乐
	/*item5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		
		}
	});*/
	//打开背景音乐
	/*item6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		
		}
	});*/
	//音量调整
	item7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		
		}
	});
	//速度调整
	item8.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
		
		}
	});
	//跳转选择界面
	item9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		SongChoice.doClick();
		
		}
	});
	//关于游戏
	item10.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			JOptionPane.showMessageDialog(mainFrame.this, "这是一个通过上下左右Space来控制的键盘音乐游戏！(AnimeMusicClick_V2.0)","关于游戏",JOptionPane.PLAIN_MESSAGE);
		}
	});
	 //1.GameStart监听
	 GameStart.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			
			 item5.doClick();	
			 choice=1;	
		     t.start();
			 
		
			}
	 });
	 
	 //2.SongChoice监听
	 SongChoice.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
				
			 SongChoiceAction();
			}
	 });
						
	 //3.Exit监听
	Exit.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
									
			    System.exit(0);//退出
			}
	});
	//结果输出
	Score.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	
   JOptionPane.showMessageDialog(mainFrame.this, "你获得的分数："+str,"结果",JOptionPane.PLAIN_MESSAGE);
    new mainFrame();
		}
	});
}

//GameStart响应事件
public void GameStartAction(int i,int movex) {
	  
		 
	       //定义容器
			AnimeMusicClick = new JPanel() {
				
		    private static final long serialVersionUID = 1L;
			@Override
			//导入背景图片
		    protected void paintComponent(Graphics g) {
			super.paintComponent(g);//继承JComponent类
			g.drawImage(new ImageIcon(StaticValues.Allsongs.get(i)).getImage(), 0,0, getWidth(), getHeight(), null);//添加图片
			g.drawImage(new ImageIcon(StaticValues.Allbgs.get(1)).getImage(), 0,600, 1200, 40, null);//添加图片背景长条
			g.drawImage(new ImageIcon(StaticValues.Allbgs.get(2)).getImage(), 800,568, 100, 100, null);//添加图片背景圆环
			//前奏
			
				
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-680,600, 40, 40, null);
		    g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-720,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-760,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-800,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-840,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-880,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-935,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-985,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-1035,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-1085,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-1135,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-1185,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-1235,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-1285,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-1335,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-1385,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-1435,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-1485,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-1535,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-1585,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-1635,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-1685,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-1735,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-1785,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-1835,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-1885,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-1935,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-1985,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-2035,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-2085,600, 40, 40, null);
			//下一段///////////////////////
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-2565,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-2620,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-2675,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-2730,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-2915,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-2970,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-3025,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-3080,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-3135,600, 40, 40, null);
			//下一段
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-3335,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-3390,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-3690,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-3730,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-3770,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-3810,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-3850,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-3890,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-3930,600, 40, 40, null);
			//下一段
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-4400,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-4440,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-4480,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-4520,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-4700,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-4750,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-4800,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-4850,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-5260,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-5310,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-5360,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-5410,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-5700,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-5750,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-5800,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-5850,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-6600,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-6650,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-6700,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-7180,600, 40, 40, null);//你的头发
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-7230,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-7280,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-7330,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-7380,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-7430,600, 40, 40, null);//你的头发
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-7480,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-7530,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-7580,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-7630,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-7690,600, 40, 40, null);
			
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-8000,600, 40, 40, null);//同时
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-8050,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-8100,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-8150,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-8200,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-8250,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-8300,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-8350,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-8400,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-8450,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-8510,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-9800,600, 40, 40, null);//生
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-9850,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-9900,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-9950,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-10000,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-10050,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-10100,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-10150,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-11140,600, 40, 40, null);//从你的前前前世
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-11180,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-11220,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11260,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11300,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11340,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11380,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11420,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11460,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11500,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11540,600, 40, 40, null);
			
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11660,600, 40, 40, null);//找你
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11700,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11740,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11780,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11820,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11860,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11900,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11940,600, 40, 40, null);
			//g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11980,600, 40, 40, null);
			//g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-12020,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-12700,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-12740,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-12780,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-12820,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-12990,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-13030,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-13070,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-13110,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-13150,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-13190,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-13230,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-13270,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-13310,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-13350,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-13450,600, 40, 40, null);//激励激励
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-13490,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-13530,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-13570,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-17600,600, 40, 40, null);//多嘎啦
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-17650,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-17700,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-17800,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-17840,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-17880,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-17920,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-17960,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-18200,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-18300,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-18340,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-18400,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-18440,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-18480,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-18520,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-18700,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-18750,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-18800,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-18850,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-18900,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-18950,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-19020,600, 40, 40, null);//何亿
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-19070,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-19130,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-19180,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-19230,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-19280,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-19330,600, 40, 40, null);
			//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-20000,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-20050,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-20100,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-20150,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-20200,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-20250,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-20300,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-20350,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-20400,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-20450,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-20500,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-20550,600, 40, 40, null);
			//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-21000,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-21550,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-22200,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-22800,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-23500,600, 40, 40, null);
			
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-23600,600, 40, 40, null);//从你的前前前世
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-23640,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-23680,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-23720,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-23760,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-23800,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-23840,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-23880,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-23920,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-23960,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-24000,600, 40, 40, null);
			
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-24140,600, 40, 40, null);//找你
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-24180,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-24220,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-24260,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-24300,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-24340,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-24380,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-24420,600, 40, 40, null);
			
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-26000,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-27000,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-28000,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-29000,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-30000,600, 40, 40, null);
			
			//daozhe
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-30040,600, 40, 40, null);//从你的前前前世
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-30080,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-30120,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30160,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30200,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30240,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30280,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30320,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30360,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30400,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30440,600, 40, 40, null);
			
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30540,600, 40, 40, null);//找你
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30580,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30620,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30660,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30700,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30740,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30780,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-30820,600, 40, 40, null);
			
			/////////////////////////////
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-39000,600, 40, 40, null);//从你的前前前世
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-39040,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-39080,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-39120,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-39160,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-39200,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-39240,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-39280,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-39320,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-39360,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-39400,600, 40, 40, null);
			
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-40000,600, 40, 40, null);//找你
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-40040,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-40080,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-40120,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-40160,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-40200,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-40240,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-40280,600, 40, 40, null);
			//g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-11980,600, 40, 40, null);
			//g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-12020,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-41000,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-41040,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-41080,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-41120,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-41160,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-41200,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-41240,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-41280,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-41320,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-41360,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-41400,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-41440,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-41480,600, 40, 40, null);
			//g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-41830,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-41700,600, 40, 40, null);//激励激励
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-41740,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-41780,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-41820,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-45000,600, 40, 40, null);//多嘎啦
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-45040,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-45080,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-45120,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-45160,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-45200,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-45240,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-45280,600, 40, 40, null);
			/*g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-46000,600, 40, 40, null);//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-46040,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-46080,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-46120,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-46160,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-46200,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-46240,600, 40, 40, null);*/
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-46500,600, 40, 40, null);//
			/*g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-46540,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-46580,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-46620,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-46660,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-46700,600, 40, 40, null);*/
			/*g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-46740,600, 40, 40, null);//何亿
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-46780,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-46820,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(3)).getImage(), movex-46860,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(2)).getImage(), movex-46900,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(1)).getImage(), movex-46940,600, 40, 40, null);
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(6)).getImage(), movex-46980,600, 40, 40, null);
			//
			g.drawImage(new ImageIcon(StaticValues.Allarrows.get(4)).getImage(), movex-47020,600, 40, 40, null);*/
			
			
			
			
			
				}
		 };
	  
		 AnimeMusicClick.setBorder(new EmptyBorder(5, 5, 5, 5));//设置面板边界
		 setContentPane(AnimeMusicClick);//把contentPane设置为JFrame的内容面板
		 AnimeMusicClick.setLayout(null);//为了不影响其他控件的布局大小
		 this.setVisible(true);
		//计分器
			//左上角的Score标注
			 Scoretext.setBorder(null);//去边框
			 Scoretext.setContentAreaFilled(false);//使Button透明
			 Scoretext.setFont(new Font("黑体",Font.BOLD,30));
			 Scoretext.setForeground(Color.BLACK);
			 Scoretext.setBounds(0, 0, 120, 60);
			  //  getRootPane().setDefaultButton(Scoretext);
			    AnimeMusicClick.add(Scoretext);	
			    
			    str=String.valueOf(score0+score1);
		        Score.setBorder(null);//去边框
		        Score.setContentAreaFilled(false);//使Button透明
		        Score.setText(str);
		        Score.setFont(new Font("黑体",Font.BOLD,30));
		        Score.setForeground(Color.BLACK);
		        Score.setBounds(120,0, 60, 65);
				AnimeMusicClick.add(Score);
				
				
		//TStart
		/* TStart.setBorder(null);//去边框
		 TStart.setContentAreaFilled(false);//使Button透明
		 TStart.setIcon(new ImageIcon(StaticValues.AllThirdPageButtons.get(3)));
		 TStart.setBounds(1100, 0, 100, 40);
		 AnimeMusicClick.add(TStart);
		
		 //TStop
		 TStop.setBorder(null);//去边框
		 TStop.setContentAreaFilled(false);//使Button透明
		 TStop.setIcon(new ImageIcon(StaticValues.AllThirdPageButtons.get(1)));
		 TStop.setBounds(1100, 30, 100, 40);
		 AnimeMusicClick.add(TStop);*/
		
		 //TReturn
		 TReturn.setBorder(null);//去边框
		 TReturn.setContentAreaFilled(false);//使Button透明
		 TReturn.setIcon(new ImageIcon(StaticValues.AllThirdPageButtons.get(2)));
		 TReturn.setBounds(1100, 0, 100, 40);
		 AnimeMusicClick.add(TReturn);
		 
	   
		 
	   }
		 

//
//SongChoice选歌界面
public void SongChoiceAction() {
	 //初始化图片
    //StaticValues.init();
    //定义容器
		AnimeMusicClick = new JPanel() {
	    private static final long serialVersionUID = 1L;
		@Override
		//导入背景图片
	    protected void paintComponent(Graphics g) {
		super.paintComponent(g);//继承JComponent类
		g.drawImage(new ImageIcon(StaticValues.SongChoice).getImage(), 0,0, getWidth(), getHeight(), null);//添加图片
			}
	 };
	 AnimeMusicClick.setBorder(new EmptyBorder(5, 5, 5, 5));//设置面板边界
	 setContentPane(AnimeMusicClick);//把contentPane设置为JFrame的内容面板
	 AnimeMusicClick.setLayout(null);//为了不影响其他控件的布局大小
	 this.setVisible(true);
	 
	 //song1
	 SSong1.setBorder(null);//去边框
	 SSong1.setContentAreaFilled(false);//使Button透明
	 SSong1.setIcon(new ImageIcon(StaticValues.AllSecondPageButtons.get(1)));
	 SSong1.setBounds(60, 60, 200, 40);
	 AnimeMusicClick.add(SSong1);
	 //song2
	 SSong2.setBorder(null);//去边框
	 SSong2.setContentAreaFilled(false);//使Button透明
	 SSong2.setIcon(new ImageIcon(StaticValues.AllSecondPageButtons.get(2)));
	 SSong2.setBounds(60, 140, 200, 40);
	 AnimeMusicClick.add(SSong2);
	 //song3
	 SSong3.setBorder(null);//去边框
	 SSong3.setContentAreaFilled(false);//使Button透明
	 SSong3.setIcon(new ImageIcon(StaticValues.AllSecondPageButtons.get(3)));
	 SSong3.setBounds(60, 220, 200, 40);
	 AnimeMusicClick.add(SSong3);
	 //song4
	 SSong4.setBorder(null);//去边框
	 SSong4.setContentAreaFilled(false);//使Button透明
	 SSong4.setIcon(new ImageIcon(StaticValues.AllSecondPageButtons.get(4)));
	 SSong4.setBounds(60, 300, 200, 40);
	 AnimeMusicClick.add(SSong4);
	 //song5
	 SSong5.setBorder(null);//去边框
	 SSong5.setContentAreaFilled(false);//使Button透明
	 SSong5.setIcon(new ImageIcon(StaticValues.AllSecondPageButtons.get(5)));//2
	 SSong5.setBounds(60, 380, 200, 40);
	 AnimeMusicClick.add(SSong5);
	 //song6
	 SSong6.setBorder(null);//去边框
	 SSong6.setContentAreaFilled(false);//使Button透明
	 SSong6.setIcon(new ImageIcon(StaticValues.AllSecondPageButtons.get(7)));//2
	 SSong6.setBounds(60, 460, 200, 40);
	 AnimeMusicClick.add(SSong6);
	 //return
	 SReturn.setBorder(null);//去边框
	 SReturn.setContentAreaFilled(false);//使Button透明
	 SReturn.setIcon(new ImageIcon(StaticValues.AllSecondPageButtons.get(6)));//2
	 SReturn.setBounds(950, 650, 200, 40);
	 AnimeMusicClick.add(SReturn);
	 
}

//背景音乐
public void BackGroundMusic() {
	try {
    	
    	file = new File(songPath+"4"+".wav"); //绝对路径
        uri = file.toURI(); //解析路径
		url = uri.toURL();
        aau = Applet.newAudioClip(url);
        aau.loop();  //循环播放
        item5.addActionListener(new ActionListener() {//关闭背景音乐
			public void actionPerformed(ActionEvent e) {
		
			aau.stop();
				 
			}
		});
        item6.addActionListener(new ActionListener() {//打开背景音乐
			public void actionPerformed(ActionEvent e) {
		
			aau.loop();
				 
			}
		});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//选歌事件响应
public void SongChoiceButtonAction() {
	 SSong1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item5.doClick();
				choice=2;
				t.start();
				 
			}
		});
	 SSong2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item5.doClick();
			choice=3;
			t.start();
				 
			}
		});
	 SSong3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item5.doClick();
				choice=4;
				t.start();
				 
			}
		});
	 SSong4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item5.doClick();
				choice=5;
				t.start();
				 
			}
		});
	 SSong5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item5.doClick();
				choice=6;
				t.start();
				 
			}
		});
	 SSong6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				//GameStartAction(6);//
				item5.doClick();	
				choice=1;	
				t.start();
				 
			}
		});
	 SReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			item5.doClick();
			new mainFrame();
				 
			}
		});
	
	
}

//游戏开始后界面上的按钮事件响应
public void StartGameButton() {
 /*TStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//MoveX=0;
				
			choice=1;
			t1.start();
		
				 
			}
		});
	 TStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
		t.stop();
			
			}
		});*/
	 TReturn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				t.stop();
				item5.doClick();
		        new mainFrame();
				 
			}
		});
	
	 
}

//游戏运行方法
@Override
public void run() {
	// TODO Auto-generated method stub
	StaticValues.init();
	//
	while(true) {
	switch(getChoice()) {
	case 1:
		try {
			    	
			    	file = new File(songPath+1+".wav"); //绝对路径
			        uri = file.toURI(); //解析路径
					url = uri.toURL();
			        aau= Applet.newAudioClip(url);
			        aau.play();  //播放一次
			      
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			        while(flag) {
			        	s+=3;
			        	if(s==48990) {
			        		Score.doClick();
			        	}
			    		GameStartAction(6,getMoveX());
			    		
			    			
			    			try {
			    				Thread.sleep(15);//15
			    			} catch (InterruptedException e) {
			    				// TODO Auto-generated catch block
			    				e.printStackTrace();
			    			}
			    		} 
			       
	             break;
	case 2://恋
		try {
	    	
	    	file = new File(songPath+2+".wav"); //绝对路径
	        uri = file.toURI(); //解析路径
			url = uri.toURL();
	        aau= Applet.newAudioClip(url);
	        aau.play();  //播放一次
	      
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	        while(flag) {
	        	s+=3;
	        	if(s==48990) {
	        		Score.doClick();
	        	}
	    		GameStartAction(3,getMoveX());
	    		
	    			
	    			try {
	    				Thread.sleep(15);//15
	    			} catch (InterruptedException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    		} 
		break;
	case 3://请问钻石
try {
	    	
	    	file = new File(songPath+3+".wav"); //绝对路径
	        uri = file.toURI(); //解析路径
			url = uri.toURL();
	        aau= Applet.newAudioClip(url);
	        aau.play();  //播放一次
	      
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	        while(flag) {
	        	s+=3;
	        	if(s==48990) {
	        		Score.doClick();
	        	}
	    		GameStartAction(1,getMoveX());
	    		
	    			
	    			try {
	    				Thread.sleep(15);//15
	    			} catch (InterruptedException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    		} 
		break;
	case 4://夕晖
try {
	    	
	    	file = new File(songPath+4+".wav"); //绝对路径
	        uri = file.toURI(); //解析路径
			url = uri.toURL();
	        aau= Applet.newAudioClip(url);
	        aau.play();  //播放一次
	      
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	        while(flag) {
	        	s+=3;
	        	if(s==48990) {
	        		Score.doClick();
	        	}
	    		GameStartAction(5,getMoveX());
	    		
	    			
	    			try {
	    				Thread.sleep(15);//15
	    			} catch (InterruptedException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    		} 
		break;
	case 5://月亮
try {
	    	
	    	file = new File(songPath+5+".wav"); //绝对路径
	        uri = file.toURI(); //解析路径
			url = uri.toURL();
	        aau= Applet.newAudioClip(url);
	        aau.play();  //播放一次
	      
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	        while(flag) {
	        	s+=3;
	        	if(s==48990) {
	        		Score.doClick();
	        	}
	    		GameStartAction(2,getMoveX());
	    		
	    			
	    			try {
	    				Thread.sleep(15);//15
	    			} catch (InterruptedException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    		} 
		break;
	case 6://brave
try {
	    	
	    	file = new File(songPath+6+".wav"); //绝对路径
	        uri = file.toURI(); //解析路径
			url = uri.toURL();
	        aau= Applet.newAudioClip(url);
	        aau.play();  //播放一次
	      
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	        while(flag) {
	        	s+=3;
	        	if(s==48990) {
	        		Score.doClick();
	        	}
	    		GameStartAction(4,getMoveX());
	    		
	    			
	    			try {
	    				Thread.sleep(15);//15
	    			} catch (InterruptedException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    		} 
		break;
	case 7:
		while(flag) {
			paintbackground(getBJLX(),getBJRX(),getBJLX1(),getBJRX1());
		
		}
		break;
			}
	
	}
	

}

	  
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>1480&&MoveX<1580)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>1520&&MoveX<1600)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>1560&&MoveX<1600)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>1600&&MoveX<1640)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>1640&&MoveX<1700)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>1680&&MoveX<1740)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>1735&&MoveX<1795)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>1785&&MoveX<1845)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>1835&&MoveX<1895)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>1885&&MoveX<1945)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>1935&&MoveX<1995)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>1985&&MoveX<2045)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>2035&&MoveX<2095)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>2085&&MoveX<2145)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>2135&&MoveX<2195)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>2185&&MoveX<2245)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>2235&&MoveX<2295)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>2285&&MoveX<2345)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>2335&&MoveX<2395)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>2385&&MoveX<2445)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>2435&&MoveX<2495)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>2485&&MoveX<2545)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>2535&&MoveX<2595)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>2585&&MoveX<2645)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>2635&&MoveX<2695)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>2685&&MoveX<2745)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>2735&&MoveX<2795)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>2785&&MoveX<2845)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>2835&&MoveX<2895)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>2885&&MoveX<2945)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>3365&&MoveX<3425)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>3420&&MoveX<3480)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>3475&&MoveX<3535)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>3530&&MoveX<3590)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>3715&&MoveX<3775)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>3770&&MoveX<3830)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>3825&&MoveX<3885)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>3880&&MoveX<3940)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>3935&&MoveX<3995)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>4135&&MoveX<4195)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>4190&&MoveX<4250)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>4490&&MoveX<4550)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>4530&&MoveX<4590)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>4570&&MoveX<4630)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>4610&&MoveX<4670)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>4650&&MoveX<4710)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>4690&&MoveX<4750)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>4730&&MoveX<4790)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>5200&&MoveX<5260)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>5240&&MoveX<5300)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>5280&&MoveX<5340)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>5320&&MoveX<5380)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>5500&&MoveX<5560)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>5550&&MoveX<5610)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>5600&&MoveX<5660)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>5650&&MoveX<5710)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>6060&&MoveX<6120)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>6110&&MoveX<6170)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>6160&&MoveX<6220)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>6210&&MoveX<6270)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>6500&&MoveX<6560)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>6550&&MoveX<6610)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>6600&&MoveX<6660)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>6650&&MoveX<6710)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>7400&&MoveX<7460)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>7450&&MoveX<7510)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>7500&&MoveX<7560)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>7980&&MoveX<8040)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>8030&&MoveX<8090)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>8080&&MoveX<8140)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>8130&&MoveX<8190)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>8180&&MoveX<8240)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>8230&&MoveX<8290)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>8280&&MoveX<8340)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>8330&&MoveX<8390)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>8380&&MoveX<8440)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>8430&&MoveX<8490)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>8490&&MoveX<8550)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>8800&&MoveX<8860)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>8850&&MoveX<8910)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>8900&&MoveX<8960)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>8950&&MoveX<9010)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>9000&&MoveX<9060)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>9050&&MoveX<9110)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>9100&&MoveX<9160)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>9150&&MoveX<9210)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>9200&&MoveX<9260)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>9250&&MoveX<9310)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>9310&&MoveX<9370)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>10600&&MoveX<10660)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>10650&&MoveX<10710)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>10700&&MoveX<10760)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>10750&&MoveX<10810)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>10800&&MoveX<10860)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>10850&&MoveX<10910)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>10900&&MoveX<10960)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>10950&&MoveX<11010)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>11940&&MoveX<12000)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>11980&&MoveX<12040)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>12020&&MoveX<12080)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12040&&MoveX<12120)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12080&&MoveX<12140)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12140&&MoveX<12200)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12180&&MoveX<12240)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12220&&MoveX<12280)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12260&&MoveX<12320)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12300&&MoveX<12360)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12340&&MoveX<12400)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12460&&MoveX<12520)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12500&&MoveX<12560)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12540&&MoveX<12600)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12580&&MoveX<12640)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12620&&MoveX<12680)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12660&&MoveX<12720)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12700&&MoveX<12760)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>12740&&MoveX<12800)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>13500&&MoveX<13560)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>13540&&MoveX<13600)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>13580&&MoveX<13640)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>13620&&MoveX<13680)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>13790&&MoveX<13850)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>13830&&MoveX<13890)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>13870&&MoveX<13930)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>13910&&MoveX<13970)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>13950&&MoveX<14010)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>13990&&MoveX<14050)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>14030&&MoveX<14090)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>14070&&MoveX<14130)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>14110&&MoveX<14170)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>14150&&MoveX<14210)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>14250&&MoveX<14310)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>14250&&MoveX<14310)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>14290&&MoveX<14350)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>14330&&MoveX<14390)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>14370&&MoveX<14430)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>18400&&MoveX<18460)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>18450&&MoveX<18510)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>18500&&MoveX<18560)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>18600&&MoveX<18660)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>18640&&MoveX<18700)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>18680&&MoveX<18740)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>18720&&MoveX<18780)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>18760&&MoveX<18820)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>19000&&MoveX<19060)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>19100&&MoveX<19160)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>19140&&MoveX<19200)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>19200&&MoveX<19260)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>19240&&MoveX<19300)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>19280&&MoveX<19340)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>19320&&MoveX<19380)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>19500&&MoveX<19560)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>19550&&MoveX<19610)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>19600&&MoveX<19660)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>19650&&MoveX<19710)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>19800&&MoveX<19860)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>19850&&MoveX<19910)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>19820&&MoveX<19880)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>19870&&MoveX<19930)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>19930&&MoveX<19990)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>19980&&MoveX<20040)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>20030&&MoveX<20090)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>20080&&MoveX<20140)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>20130&&MoveX<20190)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>20800&&MoveX<20860)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>20850&&MoveX<20910)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>20900&&MoveX<20960)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>20950&&MoveX<20110)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>21000&&MoveX<21060)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>21050&&MoveX<21110)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>21100&&MoveX<21160)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>21150&&MoveX<21210)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>21200&&MoveX<21260)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>21250&&MoveX<21310)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>21300&&MoveX<21360)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>21350&&MoveX<21410)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>21800&&MoveX<21860)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>22350&&MoveX<22410)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>23000&&MoveX<23060)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>23600&&MoveX<23660)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>24300&&MoveX<24360)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>24400&&MoveX<24460)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>24440&&MoveX<24500)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>24480&&MoveX<24540)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>24520&&MoveX<24580)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>24560&&MoveX<24620)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>24600&&MoveX<24660)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>24640&&MoveX<24700)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>24680&&MoveX<24740)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>24720&&MoveX<24780)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>24760&&MoveX<24820)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>24940&&MoveX<25000)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>24980&&MoveX<25040)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>25020&&MoveX<25080)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>25060&&MoveX<25120)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>25100&&MoveX<25160)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>25140&&MoveX<25200)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>25180&&MoveX<25240)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>25220&&MoveX<25280)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>26800&&MoveX<26860)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>27800&&MoveX<27860)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>28800&&MoveX<28860)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>29800&&MoveX<29860)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>30800&&MoveX<30860)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>30840&&MoveX<30900)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>30880&&MoveX<30940)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>30920&&MoveX<30980)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>30960&&MoveX<31020)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>31000&&MoveX<31060)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>31040&&MoveX<31100)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>31080&&MoveX<31140)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>31120&&MoveX<31180)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>31160&&MoveX<31220)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>31200&&MoveX<31260)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>31240&&MoveX<31300)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>31340&&MoveX<31400)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>31380&&MoveX<31440)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>31420&&MoveX<31480)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>31460&&MoveX<31520)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>31500&&MoveX<31560)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>31540&&MoveX<31600)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>31580&&MoveX<31640)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>31620&&MoveX<31680)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>39800&&MoveX<39860)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>39840&&MoveX<39900)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>39880&&MoveX<39940)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>39920&&MoveX<39980)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>39960&&MoveX<40020)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>40000&&MoveX<40060)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>40040&&MoveX<40100)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>40080&&MoveX<40140)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>40120&&MoveX<40180)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>40160&&MoveX<40220)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>40200&&MoveX<40260)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>40800&&MoveX<40860)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>40840&&MoveX<40900)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>40880&&MoveX<40940)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>40920&&MoveX<40980)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>40960&&MoveX<41020)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>41000&&MoveX<41060)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>41040&&MoveX<41100)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>41080&&MoveX<41140)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>41800&&MoveX<41860)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>41840&&MoveX<41900)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>41880&&MoveX<41940)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>41920&&MoveX<41980)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>41960&&MoveX<42020)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>42000&&MoveX<42060)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>42040&&MoveX<42100)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>42080&&MoveX<42140)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>42120&&MoveX<42180)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>42160&&MoveX<42220)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>42200&&MoveX<42260)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>42240&&MoveX<42300)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>42280&&MoveX<42340)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>42500&&MoveX<42560)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>42540&&MoveX<42600)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>42580&&MoveX<42640)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>42620&&MoveX<52680)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>45800&&MoveX<45860)) {
	    	   score0++;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>45840&&MoveX<45900)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>45880&&MoveX<45940)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>45920&&MoveX<45980)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(MoveX>45960&&MoveX<46020)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_LEFT&&(MoveX>46000&&MoveX<46060)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_UP&&(MoveX>46040&&MoveX<46100)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_DOWN&&(MoveX>46080&&MoveX<46140)) {
	    	   score0+=2;
	       }else if(e.getKeyCode()==KeyEvent.VK_SPACE&&(MoveX>47300&&MoveX<47360)) {
	    	   score0++;
	       }//
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public int getChoice() {
		return choice;
	}
	


}
