import java.awt.*;
import java.awt.event.*;

public class CardLayoutTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Frame f = new Frame("CardLayoutTest");
		final CardLayout card = new CardLayout(10,10);
		f.setLayout(card);
		
		Panel card1 = new Panel();
		card1.setBackground(Color.lightGray);
		card1.add(new Label("Card 1"));
		Panel card2 = new Panel();
		card2.add(new Label("Card 2"));
		card2.setBackground(Color.orange);
		Panel card3 = new Panel();
		card3.add(new Label("Card 3"));
		card3.setBackground(Color.cyan);
		
		f.add(card1,"1");
		f.add(card2,"2");
		f.add(card3,"3");
		
		class Handler extends MouseAdapter {
			public void mouseClicked(MouseEvent e){
				if(e.getModifiers()==e.BUTTON3_MASK){
					card.previous(f);
				}else{
					card.next(f);
				
				}
			}
		}//class Handler
		card1.addMouseListener(new Handler());
		card2.addMouseListener(new Handler());
		card3.addMouseListener(new Handler());
		
		f.setSize(200,200);
		f.setLocation(200, 200);
		f.setVisible(true);
		
		card.show(f, "1");
	}

}
