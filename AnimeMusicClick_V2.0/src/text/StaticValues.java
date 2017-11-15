package text;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class StaticValues {

	public static BufferedImage StartBg=null;//启动时的背景图片初始化
	public static BufferedImage Title=null;//标题图
	public static BufferedImage SongChoice=null;//选歌
	public static List<BufferedImage> Allbgs=new ArrayList<BufferedImage>();//程序运行时的背景图片初始化
	public static List<BufferedImage> Allarrows=new ArrayList<BufferedImage>();//所有事件控件初始化
	public static List<BufferedImage> Allsongs=new ArrayList<BufferedImage>();//所有歌曲图片
	public static List<BufferedImage> AllFirstPageButtons=new ArrayList<BufferedImage>();//所有首页控件图片
	public static List<BufferedImage> AllSecondPageButtons=new ArrayList<BufferedImage>();//所有选歌界面控件图片
	public static List<BufferedImage> AllThirdPageButtons=new ArrayList<BufferedImage>();//所有运行界面控件图片
	public static BufferedImage BJL=null;
	public static BufferedImage BJR=null;
	public static String imagePath = System.getProperty("user.dir")+"/images/";//读取图片路径，use.dir到当前工作目录，即有CLASSPATH的目录
  
	public static void init() {
		
		try {
			StartBg=ImageIO.read(new File(imagePath+"StartBg.PNG"));
			Title=ImageIO.read(new File(imagePath+"Title.PNG"));
			SongChoice=ImageIO.read(new File(imagePath+"SongChoiceBg.PNG"));
			BJL=ImageIO.read(new File(imagePath+"BJ1.PNG"));
			BJR=ImageIO.read(new File(imagePath+"BJ2.PNG"));
			//1.初始化bg
			for(int i=1;i<=2;i++) {
				
				Allbgs.add(ImageIO.read(new File(imagePath+"bg"+i+".PNG")));
				
			}
			//2.初始化arrows
			for(int i=1;i<=6;i++) {
				
				Allarrows.add(ImageIO.read(new File(imagePath+"text"+i+".PNG")));
				
			}
			//3.初始化songs
			for(int i=1;i<=6;i++) {
				
				Allsongs.add(ImageIO.read(new File(imagePath+"SongBg"+i+".PNG")));
				
			}
			//4.初始化FirstPageButtons
			for(int i=1;i<=3;i++) {
				
				AllFirstPageButtons.add(ImageIO.read(new File(imagePath+"FB"+i+".PNG")));
				
			}
			//5.初始化SecondPageButtons
			for(int i=1;i<=7;i++) {
				
				AllSecondPageButtons.add(ImageIO.read(new File(imagePath+"S"+i+".PNG")));
				
			}
			//6.初始化ThirdPageButtons
			for(int i=1;i<=3;i++) {
				
				AllThirdPageButtons.add(ImageIO.read(new File(imagePath+"T"+i+".PNG")));
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
