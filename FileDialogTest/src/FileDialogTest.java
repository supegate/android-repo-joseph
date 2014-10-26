import java.awt.*;

public class FileDialogTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("Parent");
		f.setSize(300, 200);
		
		FileDialog fileOpen = new FileDialog(f,"파일열기",FileDialog.LOAD);
		
		f.setVisible(true);
		fileOpen.setDirectory("C:\\Program Files\\Java\\jre7");
		fileOpen.setVisible(true);
		
		System.out.println(fileOpen.getDirectory()+fileOpen.getFile());
	}

}
