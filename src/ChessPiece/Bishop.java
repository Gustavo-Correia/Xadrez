package ChessPiece;
import boardgame.Position;
import boardgame.board;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public boolean[][] possibleMove() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// nw
		p.setvalues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionexists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setvalues(p.getRow() - 1, p.getColumn() - 1);
		}
		if (getBoard().positionexists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// ne
		p.setvalues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionexists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setvalues(p.getRow() - 1, p.getColumn() + 1);
		}
		if (getBoard().positionexists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// se
		p.setvalues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionexists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setvalues(p.getRow() + 1, p.getColumn() + 1);
		}
		if (getBoard().positionexists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// sw
		p.setvalues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionexists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setvalues(p.getRow() + 1, p.getColumn() - 1);
		}
		if (getBoard().positionexists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
	}
}
