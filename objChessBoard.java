//Author: ^-^ Veerle ^-^
//Standard chess board which can be used for chess, draughts etc
import java.awt.*;

public class objChessBoard extends Canvas
{
	
	protected Image imgTile = null;
	
	public void chessBoard ()
	{
	}
	
	public void paint (Graphics g)
	{

		g.setColor(new Color(255,209,170)); //Light blue
		g.fillRect(0, 0, 500, 50); //North border
		g.fillRect(0,0,50,500); //West border
		g.fillRect(0,450,500,50); //South border
		g.fillRect(450, 0, 50, 500); //East border
		
		for (int row = 0; row < 8; row++)
		{
			
			for (int column = 0; column < 8; column++)
			{
				g.drawImage(imgTile, ((column + 1) * 50), ((row + 1) * 50), this);
			}
			
		}
		
		drawExtra(g);
		
	}	
	//Protected means it can only be used by this class, and classes extending it
	protected void drawExtra (Graphics g) //Any class extending the chess board can use this method to add extra things like player pieces
	{
	}
	
	protected int findWhichTileSelected (int coor) //Finds which tile the mouse is over
	{
		
		for (int i = 0; i < 8; i++)
		{
			
			if (coor > (i + 1) * 50 && coor < (i + 2) * 50)
			{
				return i;
			}
			
		}
		
		return -1;
		
	}
	
}