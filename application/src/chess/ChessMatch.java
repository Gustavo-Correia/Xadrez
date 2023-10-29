package chess;

import ChessPiece.King;
import ChessPiece.Rook;
import boardgame.Position;
import boardgame.board;

public class ChessMatch {
    private board board;

    public ChessMatch() {
        board = new board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getpieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for(int x=0; x<board.getRows(); x++){
            for(int i=0; i<board.getColumns(); i++){
                mat[x][i] = (ChessPiece) board.piece(x,i);
            }
        }

        return mat;
    }

    private void initialSetup(){
        board.placepiece(new Rook(board,chess.Color.WHITE), new Position(2, 1));
        board.placepiece(new King(board,chess.Color.WHITE), new Position(0, 4));

    }
}
