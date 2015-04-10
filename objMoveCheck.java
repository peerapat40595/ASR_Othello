public class objMoveCheck extends objCellMatrix
{
	
	private boolean playerOneCanMove = true, playerTwoCanMove = true;
	
	public objMoveCheck ()
	{
	}
	
	private boolean checkNorthRoute (int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove)
	{
		
		int currentPiece = 0, squaresTakeOver = 0; //squaresTakeOver is a counter for how many squares to take over
		int row = placedRow - 1; //Gets a copy to be used to check the route
		boolean pairCoinFound = false; //True if a coin of yours was found along the route
		
		while (row >= 0 && !pairCoinFound) //While not beyond the top of the board and a pair coin has not been found
		{

			currentPiece = getPieceCell(row, placedColumn);	//Gets the coin that is in this cell (0 = empty, 1 = red, 2 = blue)
				
			if (currentPiece == 0) //If the current square is empty, since one of your own pieces was not found an overtake isn't possible
			{
				return false;
			}
			else if (currentPiece == enemy) //If the current square contains an enemy coin, increase the counter
			{
				squaresTakeOver++;
			}
			else //If the current square contains your coin
			{
				pairCoinFound = true;
			}
			
			row--; //Decrease row by one to check the next row in the route
			
		}
		
		if (pairCoinFound && squaresTakeOver > 0) //If a pair coin was found and at least one enemy exists between the coins
		{
			
			if (actualMove) //If this is an actual move, and not just testing if moves are possible
			{
				
				do //Does everything inside the loop before checking the condition
				{
					
					placedRow--; //Decrease the row number by 1 so doing each row in turn
					squaresTakeOver--; //Decrease number of squares to take over
					setPieceCell(placedRow, placedColumn, currentPlayer); //Change the current cell into the current player's coin
					
				}
				while (squaresTakeOver > 0); //Keep doing until all enemy coins between your coins have been taken 
			
			}
			
			return true; //Move was legal
			
		}
		else
		{
			return false;
		}
		
	}
	
	private boolean checkNorthWestRoute (int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove) //See north route for how this method works
	{
		
		int currentPiece = 0, squaresTakeOver = 0;
		int row = placedRow - 1;
		int column = placedColumn - 1;
		boolean pairCoinFound = false;
		
		while (row >= 0 && column >= 0 && !pairCoinFound)
		{
			
			currentPiece = getPieceCell(row, column);
			
			if (currentPiece == 0)
			{
				return false;
			}
			else if (currentPiece == enemy)
			{
				squaresTakeOver++;
			}
			else
			{
				pairCoinFound = true;
			}
			
			row--;
			column--;
			
		}
			
		if (pairCoinFound && squaresTakeOver > 0)
		{
						
			if (actualMove)
			{
				
				do
				{
					
					placedRow--;
					placedColumn--;
					squaresTakeOver--;
					setPieceCell(placedRow, placedColumn, currentPlayer);
					
				}
				while (squaresTakeOver > 0);
				
			}
			
			return true;
			
		}
		else
		{
			return false;
		}
		
	}
	
	private boolean checkWestRoute (int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove) //See north route for how this method works
	{
		
		int currentPiece = 0, squaresTakeOver = 0;
		int column = placedColumn - 1;
		boolean pairCoinFound = false;
		
		while (column >= 0 && !pairCoinFound)
		{
			
			currentPiece = getPieceCell(placedRow, column);
			
			if (currentPiece == 0)
			{
				return false;
			}
			else if (currentPiece == enemy)
			{
				squaresTakeOver++;
			}
			else
			{
				pairCoinFound = true;
			}
			
			column--;
			
		}
			
		if (pairCoinFound && squaresTakeOver > 0)
		{
				
			if (actualMove)
			{
			
				do
				{
					
					placedColumn--;
					squaresTakeOver--;
					setPieceCell(placedRow, placedColumn, currentPlayer);
					
				}
				while (squaresTakeOver > 0);
				
			}
			
			return true;
			
		}
		else
		{
			return false;
		}
		
	}
	
	private boolean checkSouthWestRoute (int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove) //See north route for how this method works
	{
		
		int currentPiece = 0, squaresTakeOver = 0;
		int row = placedRow + 1;
		int column = placedColumn - 1;
		boolean pairCoinFound = false;
		
		while (row <= 7 && column >= 0 && !pairCoinFound)
		{
			
			currentPiece = getPieceCell(row, column);
			
			if (currentPiece == 0)
			{
				return false;
			}
			else if (currentPiece == enemy)
			{
				squaresTakeOver++;
			}
			else
			{
				pairCoinFound = true;
			}
			
			row++;
			column--;
			
		}
			
		if (pairCoinFound && squaresTakeOver > 0)
		{
			
			if (actualMove)
			{
			
				do
				{
					
					placedRow++;
					placedColumn--;				
					squaresTakeOver--;
					setPieceCell(placedRow, placedColumn, currentPlayer);
					
				}
				while (squaresTakeOver > 0);
				
			}
			
			return true;
			
		}
		else
		{
			return false;
		}
		
	}
	
	private boolean checkSouthRoute (int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove) //See north route for how this method works
	{
		
		int currentPiece = 0, squaresTakeOver = 0;
		int row = placedRow + 1;
		boolean pairCoinFound = false;
		
		while (row <= 7 && !pairCoinFound)
		{
			
			currentPiece = getPieceCell(row, placedColumn);
			
			if (currentPiece == 0)
			{
				return false;
			}
			else if (currentPiece == enemy)
			{
				squaresTakeOver++;
			}
			else
			{
				pairCoinFound = true;
			}
			
			row++;
			
		}
			
		if (pairCoinFound && squaresTakeOver > 0)
		{
			
			if (actualMove)
			{
			
				do
				{
					
					placedRow++;				
					squaresTakeOver--;
					setPieceCell(placedRow, placedColumn, currentPlayer);
					
				}
				while (squaresTakeOver > 0);
				
			}
			
			return true;
			
		}
		else
		{
			return false;
		}
		
	}
	
	private boolean checkSouthEastRoute (int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove) //See north route for how this method works
	{
		
		int currentPiece = 0, squaresTakeOver = 0;
		int row = placedRow + 1;
		int column = placedColumn + 1;
		boolean pairCoinFound = false;
		
		while (row <= 7 && column <= 7 && !pairCoinFound)
		{
			
			currentPiece = getPieceCell(row, column);
			
			if (currentPiece == 0)
			{
				return false;
			}
			else if (currentPiece == enemy)
			{
				squaresTakeOver++;
			}
			else
			{
				pairCoinFound = true;
			}
			
			row++;
			column++;
			
		}
			
		if (pairCoinFound && squaresTakeOver > 0)
		{
			
			if (actualMove)
			{
				
				do
				{
					
					placedRow++;
					placedColumn++;				
					squaresTakeOver--;
					setPieceCell(placedRow, placedColumn, currentPlayer);
					
				}
				while (squaresTakeOver > 0);
				
			}
			
			return true;
			
		}
		else
		{
			return false;
		}
		
	}
	
	private boolean checkEastRoute (int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove) //See north route for how this method works
	{
		
		int currentPiece = 0, squaresTakeOver = 0;
		int column = placedColumn + 1;
		boolean pairCoinFound = false;
		
		while (column <= 7 && !pairCoinFound)
		{
			
			currentPiece = getPieceCell(placedRow, column);
			
			if (currentPiece == 0)
			{
				return false;
			}
			else if (currentPiece == enemy)
			{
				squaresTakeOver++;
			}
			else
			{
				pairCoinFound = true;
			}
			
			column++;
			
		}
			
		if (pairCoinFound && squaresTakeOver > 0)
		{
			
			if (actualMove)
			{
			
				do
				{
					
					placedColumn++;				
					squaresTakeOver--;
					setPieceCell(placedRow, placedColumn, currentPlayer);
					
				}
				while (squaresTakeOver > 0);
				
			}
			
			return true;
			
		}
		else
		{
			return false;
		}
		
	}
	
	private boolean checkNorthEastRoute (int placedRow, int placedColumn, int currentPlayer, int enemy, boolean actualMove) //See north route for how this method works
	{
		
		int currentPiece = 0, squaresTakeOver = 0;
		int row = placedRow - 1;
		int column = placedColumn + 1;
		boolean pairCoinFound = false;
		
		while (row >= 0 && column <= 7 && !pairCoinFound)
		{
			
			currentPiece = getPieceCell(row, column);
			
			if (currentPiece == 0)
			{
				return false;
			}
			else if (currentPiece == enemy)
			{
				squaresTakeOver++;
			}
			else
			{
				pairCoinFound = true;
			}
			
			row--;
			column++;
			
		}
			
		if (pairCoinFound && squaresTakeOver > 0)
		{
			
			if (actualMove)
			{
			
				do
				{
					
					placedRow--;
					placedColumn++;				
					squaresTakeOver--;
					setPieceCell(placedRow, placedColumn, currentPlayer);
					
				}
				while (squaresTakeOver > 0);
				
			}
			
			return true;
			
		}
		else
		{
			return false;
		}
		
	}			
	//Tests if a move is legal (if actualMove is false, it is the computer testing if there are any possible moves to be made)
	public boolean legalMove (int placedRow, int placedColumn, int currentPlayer, boolean actualMove)
	{
		
		boolean legalMove = false;
		int enemy = 0;
		
		if (currentPlayer == 1)
		{
			enemy = 2;
		}
		else
		{
			enemy = 1;
		}
		//Each possible direction is tested and any over takes possible are done. If at least one over take is possible, the move is legal
		if (checkNorthRoute(placedRow, placedColumn, currentPlayer, enemy, actualMove))
		{
			legalMove = true;
		}
		
		if (checkNorthWestRoute(placedRow, placedColumn, currentPlayer, enemy, actualMove))
		{
			legalMove = true;
		}
		
		if (checkWestRoute(placedRow, placedColumn, currentPlayer, enemy, actualMove))
		{
			legalMove = true;
		}
		
		if (checkSouthWestRoute(placedRow, placedColumn, currentPlayer, enemy, actualMove))
		{
			legalMove = true;
		}
		
		if (checkSouthRoute(placedRow, placedColumn, currentPlayer, enemy, actualMove))
		{
			legalMove = true;
		}
		
		if (checkSouthEastRoute(placedRow, placedColumn, currentPlayer, enemy, actualMove))
		{
			legalMove = true;
		}
		
		if (checkEastRoute(placedRow, placedColumn, currentPlayer, enemy, actualMove))
		{
			legalMove = true;
		}
		
		if (checkNorthEastRoute(placedRow, placedColumn, currentPlayer, enemy, actualMove))
		{
			legalMove = true;
		}
		
		if (legalMove && actualMove) //If the move was legal
		{
			setPieceCell(placedRow, placedColumn, currentPlayer); //Keep the placed coin
		}	
		
		return legalMove;
		
	}
	
	public void checkPossibleMoves () //Checks each square until a legal move is found
	{

		playerOneCanMove = false;
		playerTwoCanMove = false;
		
		for (int row = 0; row < 8; row++)
		{
			
			for (int column = 0; column < 8; column++)
			{
				
				if (getPieceCell(row, column) != 0)
				{
					continue;
				}
				else
				{
					
					if (!playerOneCanMove)
					{
						playerOneCanMove = legalMove(row, column, 1, false);
					}
					
					if (!playerTwoCanMove)
					{
						playerTwoCanMove = legalMove(row, column, 2, false);
					}
					
				}
				
				if (playerOneCanMove && playerTwoCanMove) //To save wasted cycles, once a legal move for both players has been found, exit
				{
					break;
				}
				
			}
			
			if (playerOneCanMove && playerTwoCanMove)
			{
				break;
			}			
			
		}
		
	}
	
	public boolean playerOneCanMove ()
	{
		return playerOneCanMove;
	}
	
	public boolean playerTwoCanMove ()
	{
		return playerTwoCanMove;
	}
	
}