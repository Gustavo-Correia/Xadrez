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

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placepiece(piece, new ChessPosition(column, row).toPosition());
    }


    private void initialSetup(){
        placeNewPiece('b',6,new Rook(board,Color.WHITE));
        placeNewPiece('f',6,new King(board,Color.WHITE));
        placeNewPiece('c',6,new King(board,Color.BLACK));
    }
}
