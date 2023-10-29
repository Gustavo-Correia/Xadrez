package application;

import boardgame.Position;
import boardgame.board;
import chess.ChessMatch;
import chess.ChessPiece;

public class App {
    public static void main(String[] args) throws Exception {
        ChessMatch chessMatch = new ChessMatch();
        
        UI.printBoard(chessMatch.getpieces());

    }

    
}
