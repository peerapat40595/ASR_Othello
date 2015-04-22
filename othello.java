
import com.sun.org.apache.xml.internal.utils.StringComparable;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.util.Scanner;


public class othello extends JPanel implements ActionListener, KeyListener
{

	private windowOthelloBoard mainOthelloBoard;
	private objCreateAppletImage createImage;
	private JButton cmdNewGame, cmdSetNames, cmdConfirm;
	private JTextField txtPlayerOne, txtPlayerTwo;
	private JLabel lblPlayerOne, lblPlayerTwo;
	private JPanel panBottomHalf, panNameArea, panPlayerOne, panPlayerTwo, panNameButton, panGameButtons;
	private Color clr = new Color(255,209,170);

	public static void main(String[] args) //With applications, you have to specify a main method (not with applets)
	{


		//JFrame.setDefaultLookAndFeelDecorated(false); //Make it look nice
        JFrame frame = new JFrame("ASR Othello Game"); //Title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); //Stops the user resizing the window

        JComponent paneMain = new othello();
        paneMain.setOpaque(true);
		paneMain.setPreferredSize(new Dimension(550, 650));
        frame.setContentPane(paneMain);

        frame.pack();
        frame.setVisible(true);


    }
	int state=0;
	int row=0;
	int column=0;
	private void HTK(final windowOthelloBoard mainOthelloBoard) {

		new Thread(new Runnable() {
			public void run() {
				while (true) {

					Scanner kb = new Scanner(System.in);
					String a = kb.nextLine();
					if(state == 0)
					{
						if (a.compareTo("reum") == 0) {
							mainOthelloBoard.newGame();
							state=1;
						}

					}
					else if(state == 1)
					{
						row = 0; column = 0;
						String[] parts = a.split(" ");
						String c = parts[0];
						String d = parts[1];
						if (c.compareTo("one") == 0) {
							row = 1;
						}
						else if(c.compareTo("two") == 0) {
						    row = 2;
						}
						else if(c.compareTo("three") == 0) {
							row = 3;
						}
						else if(c.compareTo("foure") == 0) {
							row = 4;
						}
						else if(c.compareTo("five") == 0) {
							row = 5;
						}
						else if(c.compareTo("six") == 0) {
							row = 6;
						}
						else if(c.compareTo("seven") == 0) {
							row = 7;
						}
						else if(c.compareTo("eight") == 0) {
							row = 8;
						}
						if (d.compareTo("one") == 0) {
							column = 1;
						}
						else if(d.compareTo("two") == 0) {
							column = 2;
						}
						else if(d.compareTo("three") == 0) {
							column = 3;
						}
						else if(d.compareTo("foure") == 0) {
							column = 4;
						}
						else if(d.compareTo("five") == 0) {
							column = 5;
						}
						else if(d.compareTo("six") == 0) {
							column = 6;
						}
						else if(d.compareTo("seven") == 0) {
							column = 7;
						}
						else if(d.compareTo("eight") == 0) {
							column = 8;
						}
						if(row>=1 && column >=1)
						{state=2;}

					}
					else if(state == 2)
					{

						if (a.compareTo("") == 0) {
							mainOthelloBoard.newGame();
							state = 2;
						}
					}

				}
			}
		}).start();

	}

	public othello ()
	{

		this.setLayout(new BorderLayout());
		mainOthelloBoard = new windowOthelloBoard();
		HTK(mainOthelloBoard);
		createImage = new objCreateAppletImage();

		mainOthelloBoard.setSize(new Dimension(500, 500));

		cmdNewGame = new JButton("New Game");
		cmdSetNames = new JButton("Set Names");
		cmdConfirm = new JButton("Confirm Move");

		cmdNewGame.addActionListener(this);
		cmdSetNames.addActionListener(this);
		cmdConfirm.addActionListener(this);

		txtPlayerOne = new JTextField("CP38", 10);
		txtPlayerTwo = new JTextField("CP39", 10);

		txtPlayerOne.addKeyListener(this);
		txtPlayerTwo.addKeyListener(this);

		lblPlayerOne = new JLabel("----", JLabel.RIGHT);
		lblPlayerTwo = new JLabel("----", JLabel.RIGHT);

		try
		{

			Image imgBlack = createImage.getImage(this, "coinBlack.gif", 10000);
			Image imgWhite = createImage.getImage(this, "coinWhite.gif", 10000);
			Image imgTile = createImage.getImage(this, "tile.gif", 200);
			mainOthelloBoard.setupImages(imgBlack, imgWhite, imgTile);

		}
		catch (NullPointerException e)
		{

			JOptionPane.showMessageDialog(null, "Unable to load images. There should be coinBlack.gif and coinWhite.gif in the same folder.", "Unable to load images", JOptionPane.WARNING_MESSAGE);
			cmdNewGame.setEnabled(false);
			cmdSetNames.setEnabled(false);
			cmdConfirm.setEnabled(false);

		}

		panBottomHalf = new JPanel(new BorderLayout());
		panNameArea = new JPanel(new GridLayout(3,1,2,2));
		panPlayerOne = new JPanel();
		panPlayerTwo = new JPanel();
		panNameButton = new JPanel();
		panGameButtons = new JPanel();

		add(mainOthelloBoard, BorderLayout.NORTH);
		add(panBottomHalf, BorderLayout.SOUTH);
			panBottomHalf.add(panNameArea, BorderLayout.WEST);
				panNameArea.add(panPlayerOne);
					panPlayerOne.add(lblPlayerOne);
					panPlayerOne.add(txtPlayerOne);
				panNameArea.add(panPlayerTwo);
					panPlayerTwo.add(lblPlayerTwo);
					panPlayerTwo.add(txtPlayerTwo);
				panNameArea.add(panNameButton);
					panNameButton.add(cmdSetNames);
			panBottomHalf.add(panGameButtons, BorderLayout.SOUTH);
				panGameButtons.add(cmdConfirm);
				panGameButtons.add(cmdNewGame);

		setBackground(clr);
		panBottomHalf.setBackground(clr);
		panNameArea.setBackground(clr);
		panPlayerOne.setBackground(clr);
		panPlayerTwo.setBackground(clr);
		panNameButton.setBackground(clr);
		panGameButtons.setBackground(clr);

		lblPlayerOne.setBackground(new Color(0,0,0)); //white
		lblPlayerOne.setForeground(new Color(0,0,0));
		lblPlayerTwo.setBackground(new Color(255,255,255)); //black
		lblPlayerTwo.setForeground(new Color(255,255,255));

		panGameButtons.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

	}

	public void actionPerformed(ActionEvent e)
	{

		if (e.getSource() == cmdSetNames)
		{

			if (txtPlayerOne.getText().equals(""))
			{
				txtPlayerOne.setText("Player 1");
			}

			if (txtPlayerTwo.getText().equals(""))
			{
				txtPlayerTwo.setText("Player 2");
			}

			mainOthelloBoard.setNames(txtPlayerOne.getText(), txtPlayerTwo.getText());

		}
		else if (e.getSource() == cmdNewGame)
		{
			mainOthelloBoard.newGame();
		}
		else if (e.getSource() == cmdConfirm)
		{
			mainOthelloBoard.confirm();
		}

	}

	public void keyTyped(KeyEvent e)
	{

		String strBuffer = "";
		char c = e.getKeyChar();

		if (e.getSource() == txtPlayerOne)
		{
			strBuffer = txtPlayerOne.getText();
		}
		else
		{
			strBuffer = txtPlayerTwo.getText();
		}

		if (strBuffer.length() > 10 && !((c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))
		{
			e.consume();
		}

	}

	public void keyPressed(KeyEvent e)
	{
	}

	public void keyReleased(KeyEvent e)
	{
	}

}
