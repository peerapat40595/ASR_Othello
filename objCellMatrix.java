//Author: ^-^ Veerle ^-^
public class objCellMatrix
{
	
	private int[][] pieceMatrix = new int[8][8]; //Stores which piece is in a cell. 0 empty, 1 red, 2 blue
	private int winningNumber = 0;
	
	public void objCellMatrix ()
	{
	}
	
	public void resetMatrix ()
	{
		
		for (int row = 0; row < 8; row++)
		{
			
			for (int column = 0; column < 8; column++)
			{
				
				if (row <= 2 || row >= 5) //row 0,1,2 or 5,6,7
				{
					pieceMatrix[row][column] = 0;
				}
				else
				{
					
					if (column <= 2 || column >= 5) //column 0,1,2 or 5,6,7
					{
						pieceMatrix[row][column] = 0;
					}
					else
					{

						if ((row == 3 && column == 3) || (row == 4 && column == 4)) //NW and SE of middle
						{
							pieceMatrix[row][column] = 2;
						}
						else
						{
							pieceMatrix[row][column] = 1;
						}
						
					}
				
				}				
				
			}
			
		}
		
	}
	
	public int getPieceCell (int row, int column)
	{
		return pieceMatrix[row][column];
	}
	
	public void setPieceCell (int row, int column, int piece)
	{
		pieceMatrix[row][column] = piece;
	}
	
	public String calculateWinner (String[] strPlayerName)
	{
		
		int red = 0;
		int blue = 0;
		int currentCell = 0;
		
		for (int row = 0; row < 8; row++)
		{
			
			for (int column = 0; column < 8; column++)
			{
				
				currentCell = pieceMatrix[row][column];
				
				if (currentCell == 0)
				{
					continue;
				}
				else if (currentCell == 1)
				{
					red++;
				}
				else
				{
					blue++;
				}
				
			}
			
		}
		
		if (red > blue)
		{
			return strPlayerName[0] + " has won, with a score of " + red + ". " + strPlayerName[1] + " got " + blue;
		}		
		else if (blue > red)
		{
			return strPlayerName[1] + " has won, with a score of " + blue + ". " + strPlayerName[0] + " got " + red;			
		}
		else
		{
			return "this game was a draw with both players getting a score of " + blue;
		}
		
	}
	
}