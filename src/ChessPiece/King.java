package ChessPiece;




import boardgame.Position;
import boardgame.board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
    public King(board board, Color color){
        super(board, color);
    }
    
    @Override
    public String toString() {
        return "R";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }


    @Override
    public boolean[][] possibleMove() {

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);
        // above
		p.setvalues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// below
		p.setvalues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// left
		p.setvalues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// right
		p.setvalues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// nw
		p.setvalues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// ne
		p.setvalues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// sw
		p.setvalues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// se
		p.setvalues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionexists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
        
        return mat;
    }
}
