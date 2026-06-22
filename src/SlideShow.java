import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class SlideShow extends JFrame {
	/* My image credits are from unsplash.com
	 * grandcanyon.jpg - Grand Canyon image
	 * hawaii.jpg - Hawaii waterfall image
	 * miami.jpg - Miami Beach image
	 * newyork.jpg - New York City skyline image
	 * orlando.jpg - Orlando / Walt Disney World castle image
	 * 
	 * May 2026
	 */
	
	
	//Declare variables used for the slide show panels, buttons, and labels.
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private JPanel southPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	
	private void initComponent() {
		//Initialize CardLayouts so the image and text can change together
		card = new CardLayout();
		cardText = new CardLayout();
		
		slidePane = new JPanel();
		textPane = new JPanel();
		buttonPane = new JPanel();
		southPane  = new JPanel();
		
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup up the main frame for the slide show 
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations Slide Show");
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// The slide panel holds the destination pictures
		slidePane.setLayout(card);
		
		// The text panel holds the matching description for each destination
		textPane.setLayout(cardText);
		textPane.setBackground(Color.BLUE);
		
		// Add each destination image and its matching text description
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			
			lblSlide.setHorizontalAlignment(SwingConstants.CENTER);
			lblTextArea.setHorizontalAlignment(SwingConstants.CENTER);
			lblTextArea.setForeground(Color.white);
			
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
			
		}
		
		// Add the image panel to the center of the frame
		getContentPane().add(slidePane, BorderLayout.CENTER);
		
		// Add the text panel above the navigation buttons so both remain visible
		southPane.setLayout(new BorderLayout());
		southPane.add(textPane, BorderLayout.CENTER);
		
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		
		// Previous button moves the slide show back one card
		btnPrev.setText("Previous");
		btnPrev.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);
		
		// Next button moves the slide show forward one card
		btnNext.setText("Next");
		btnNext.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);
		
		southPane.add(buttonPane, BorderLayout.SOUTH);
		getContentPane().add(southPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		
		// Each case connects a destination slide to the image stored in resources
		if (i == 1){
			image = "<html><body><img width= '800' height='450' src='" + getClass().getResource("/resources/grandcanyon.jpg") + "'</body></html>";
		} else if (i == 2){
			image = "<html><body><img width= '800' height='450' src='" + getClass().getResource("/resources/hawaii.jpg") + "'</body></html>";
		} else if (i == 3){
			image = "<html><body><img width= '800' height='450' src='" + getClass().getResource("/resources/miami.jpg") + "'</body></html>";
		} else if (i == 4){
			image = "<html><body><img width= '800' height='450' src='" + getClass().getResource("/resources/newyork.jpg") + "'</body></html>";
		} else if (i == 5){
			image = "<html><body><img width= '800' height='450' src='" + getClass().getResource("/resources/orlando.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		String text = "";
		
		// These descriptions were updated to match the new top five travel destinations
		if (i == 1){
			text = "<html><body><font size='5'>#1 Grand Canyon.</font> <br>Known for canyon views, hiking trails, and outdoor adventure.</body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>#2 Hawaii</font> <br>Popular for waterfalls, beaches, tropical scenery, and relaxing vacations.</body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>#3 Miami</font> <br>A warm beach destination with ocean views, nightlife, and city attractions.</body></html>";
		} else if (i==4){
			text = "<html><body><font size='5'>#4 New York City</font> <br>Known for sightseeing, entertainment, restaurants, and famous landmarks.</body></html>";
		} else if (i==5){
			text = "<html><body><font size='5'>#5 Orlando</font> <br>A family friendly destination known for theme parks and vacation activities.</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}