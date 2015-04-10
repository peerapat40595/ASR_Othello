//Author: ^-^ Veerle ^-^
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class othello extends JPanel implements ActionListener, KeyListener
{

	private windowOthelloBoard mainOthelloBoard;
	private objCreateAppletImage createImage;
	private JButton cmdNewGame, cmdSetNames, cmdConfirm;
	private JTextField txtPlayerOne, txtPlayerTwo;
	private JLabel lblPlayerOne, lblPlayerTwo;
	private JPanel panBottomHalf, panNameArea, panPlayerOne, panPlayerTwo, panNameButton, panGameButtons;
	private Color clrBlue = new Color(75,141,221);

	public static void main(String[] args) //With applications, you have to specify a main method (not with applets)
	{

		JFrame.setDefaultLookAndFeelDecorated(true); //Make it look nice
        JFrame frame = new JFrame("Othello Game"); //Title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); //Stops the user resizing the window

        JComponent paneMain = new othello();
        paneMain.setOpaque(true);
		paneMain.setPreferredSize(new Dimension(550, 650));
        frame.setContentPane(paneMain);

        frame.pack();
        frame.setVisible(true);

    }

	public othello ()
	{

		this.setLayout(new BorderLayout());
		mainOthelloBoard = new windowOthelloBoard();
		createImage = new objCreateAppletImage();

		mainOthelloBoard.setSize(new Dimension(500, 500));

		cmdNewGame = new JButton("New Game");
		cmdSetNames = new JButton("Set Names");
		cmdConfirm = new JButton("Confirm Move");

		cmdNewGame.addActionListener(this);
		cmdSetNames.addActionListener(this);
		cmdConfirm.addActionListener(this);

		txtPlayerOne = new JTextField("Veerle", 10);
		txtPlayerTwo = new JTextField("Natasja", 10);

		txtPlayerOne.addKeyListener(this);
		txtPlayerTwo.addKeyListener(this);

		lblPlayerOne = new JLabel("----", JLabel.RIGHT);
		lblPlayerTwo = new JLabel("----", JLabel.RIGHT);

		try
		{

			Image imgRed = createImage.getImage(this, "coinRed.gif", 200);
			Image imgBlue = createImage.getImage(this, "coinBlue.gif", 200);
			Image imgTile = createImage.getImage(this, "tile.gif", 200);
			mainOthelloBoard.setupImages(imgRed, imgBlue, imgTile);

		}
		catch (NullPointerException e)
		{

			JOptionPane.showMessageDialog(null, "Unable to load images. There should be coinRed.gif and coinBlue.gif in the same folder.", "Unable to load images", JOptionPane.WARNING_MESSAGE);
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

		setBackground(clrBlue);
		panBottomHalf.setBackground(clrBlue);
		panNameArea.setBackground(clrBlue);
		panPlayerOne.setBackground(clrBlue);
		panPlayerTwo.setBackground(clrBlue);
		panNameButton.setBackground(clrBlue);
		panGameButtons.setBackground(clrBlue);

		lblPlayerOne.setBackground(new Color(236,17,17)); //red
		lblPlayerOne.setForeground(new Color(236,17,17));
		lblPlayerTwo.setBackground(new Color(17,27,237)); //blue
		lblPlayerTwo.setForeground(new Color(17,27,237));

		panGameButtons.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

	}

	public void actionPerformed(ActionEvent e)
	{

		if (e.getSource() == cmdSetNames)
		{

			if (txtPlayerOne.getText().equals(""))
			{
				txtPlayerOne.setText("Veerle");
			}

			if (txtPlayerTwo.getText().equals(""))
			{
				txtPlayerTwo.setText("Natasja");
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
