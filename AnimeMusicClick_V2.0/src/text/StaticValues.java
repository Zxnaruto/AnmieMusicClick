package text;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class StaticValues {

	public static BufferedImage StartBg=null;//����ʱ�ı���ͼƬ��ʼ��
	public static BufferedImage Title=null;//����ͼ
	public static BufferedImage SongChoice=null;//ѡ��
	public static List<BufferedImage> Allbgs=new ArrayList<BufferedImage>();//��������ʱ�ı���ͼƬ��ʼ��
	public static List<BufferedImage> Allarrows=new ArrayList<BufferedImage>();//�����¼��ؼ���ʼ��
	public static List<BufferedImage> Allsongs=new ArrayList<BufferedImage>();//���и���ͼƬ
	public static List<BufferedImage> AllFirstPageButtons=new ArrayList<BufferedImage>();//������ҳ�ؼ�ͼƬ
	public static List<BufferedImage> AllSecondPageButtons=new ArrayList<BufferedImage>();//����ѡ�����ؼ�ͼƬ
	public static List<BufferedImage> AllThirdPageButtons=new ArrayList<BufferedImage>();//�������н���ؼ�ͼƬ
	public static BufferedImage BJL=null;
	public static BufferedImage BJR=null;
	public static String imagePath = System.getProperty("user.dir")+"/images/";//��ȡͼƬ·����use.dir����ǰ����Ŀ¼������CLASSPATH��Ŀ¼
  
	public static void init() {
		
		try {
			StartBg=ImageIO.read(new File(imagePath+"StartBg.PNG"));
			Title=ImageIO.read(new File(imagePath+"Title.PNG"));
			SongChoice=ImageIO.read(new File(imagePath+"SongChoiceBg.PNG"));
			BJL=ImageIO.read(new File(imagePath+"BJ1.PNG"));
			BJR=ImageIO.read(new File(imagePath+"BJ2.PNG"));
			//1.��ʼ��bg
			for(int i=1;i<=2;i++) {
				
				Allbgs.add(ImageIO.read(new File(imagePath+"bg"+i+".PNG")));
				
			}
			//2.��ʼ��arrows
			for(int i=1;i<=6;i++) {
				
				Allarrows.add(ImageIO.read(new File(imagePath+"text"+i+".PNG")));
				
			}
			//3.��ʼ��songs
			for(int i=1;i<=6;i++) {
				
				Allsongs.add(ImageIO.read(new File(imagePath+"SongBg"+i+".PNG")));
				
			}
			//4.��ʼ��FirstPageButtons
			for(int i=1;i<=3;i++) {
				
				AllFirstPageButtons.add(ImageIO.read(new File(imagePath+"FB"+i+".PNG")));
				
			}
			//5.��ʼ��SecondPageButtons
			for(int i=1;i<=7;i++) {
				
				AllSecondPageButtons.add(ImageIO.read(new File(imagePath+"S"+i+".PNG")));
				
			}
			//6.��ʼ��ThirdPageButtons
			for(int i=1;i<=3;i++) {
				
				AllThirdPageButtons.add(ImageIO.read(new File(imagePath+"T"+i+".PNG")));
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
