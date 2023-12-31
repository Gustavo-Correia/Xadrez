package ChessPiece;

import boardgame.Position;
import boardgame.board;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "C";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMove() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		p.setvalues(position.getRow() - 1, position.getColumn() - 2);
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setvalues(position.getRow() - 2, position.getColumn() - 1);
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setvalues(position.getRow() - 2, position.getColumn() + 1);
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setvalues(position.getRow() - 1, position.getColumn() + 2);
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setvalues(position.getRow() + 1, position.getColumn() + 2);
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setvalues(position.getRow() + 2, position.getColumn() + 1);
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		p.setvalues(position.getRow() + 2, position.getColumn() - 1);
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setvalues(position.getRow() + 1, position.getColumn() - 2);
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		return mat;
	}
}
