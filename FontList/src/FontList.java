import java.awt.*;

public class FontList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicsEnvironment ge = null;
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] fonts = ge.getAllFonts();
		
		for(int i=0;i<fonts.length;i++){
			System.out.println(fonts[i].getFontName());
		}
	}

}
