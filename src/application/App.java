package application;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while(true){
            try {
            UI.clearScreen();
            UI.printMatch(chessMatch, captured);
            System.out.println();
            System.out.print("selecione a peça:");
            ChessPosition source = UI.readChessPosition(sc);
            boolean[][] possibleMove = chessMatch.possibleMove(source);
            UI.clearScreen();
            UI.printBoard(chessMatch.getpieces(), possibleMove);

            System.out.println();
            System.out.print("destino da peça:");
            ChessPosition target = UI.readChessPosition(sc);
            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            if(captured != null){
                captured.add(capturedPiece);
            }
        } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }

        }
       

    }

    
}
