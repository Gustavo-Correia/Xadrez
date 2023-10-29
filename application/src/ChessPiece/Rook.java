package ChessPiece;


import boardgame.board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{
    public Rook(board board, Color color){
        super(board,color);
    }
    
    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMove() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
}
