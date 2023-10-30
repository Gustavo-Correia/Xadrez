package ChessPiece;


import boardgame.Position;
import boardgame.board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{
    public Rook(board board, Color color){
        super(board,color);
    }
    
    @Override
    public String toString() {
        return "T";
    }

    @Override
    public boolean[][] possibleMove() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        
        Position p = new Position(0, 0);
        
        //acima
        p.setvalues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionexists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionexists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
        //esquerda
        p.setvalues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionexists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionexists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
        //direita
        p.setvalues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionexists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionexists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
        
         //baixo
         p.setvalues(position.getRow() + 1, position.getColumn());
         while (getBoard().positionexists(p) && !getBoard().thereIsAPiece(p)) {
             mat[p.getRow()][p.getColumn()] = true;
             p.setRow(p.getRow() + 1);
         }
         if (getBoard().positionexists(p) && isThereOpponentPiece(p)) {
             mat[p.getRow()][p.getColumn()] = true;
         }
        return mat;

    }


}
