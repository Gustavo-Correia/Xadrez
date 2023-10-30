package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ChessPiece.King;
import ChessPiece.Rook;
import boardgame.Piece;
import boardgame.Position;
import boardgame.board;

public class ChessMatch {
    private int turn;
    private Color currentPlayer;
    private board board;
    private boolean check;

    private List<Piece> piecesontheboard = new ArrayList<>();
    private List<Piece> capturedpieces = new ArrayList<>();

    

    

    public int getTurn() {
        return turn;
    }



    public Color getCurrentPlayer() {
        return currentPlayer;
    }



    public boolean getCheck() {
        return check;
    }



    public ChessMatch() {
        board = new board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
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
        piecesontheboard.add(piece);
   
   
    }


    public boolean[][] possibleMove(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validadeSourcePosition(position);
        return board.piece(position).possibleMove();
    }

    public ChessPiece performChessMove(ChessPosition sourceChessPosition, ChessPosition targetPosition){
        Position source = sourceChessPosition.toPosition();
        Position target = targetPosition.toPosition();
        validadeSourcePosition(source);
        validateTargetPosition(source,target);
        Piece capturedPiece = makeMove(source,target);
        if(testCheck(currentPlayer)){
            undoMove(source, target, capturedPiece);
            throw new ChessException("Voce não pode se colocar em cheque!");
            }
        check = (testCheck(opponent(currentPlayer))) ? true : false;
        nextTurn();
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placepiece(p, target);
        if(capturedpieces != null){
            piecesontheboard.remove(capturedPiece);
            capturedpieces.add(capturedPiece);
        }
        return capturedPiece;

    }

    private void undoMove(Position source, Position target, Piece capturedPiece){
        Piece p = board.removePiece(target);
        board.placepiece(p, source);

        if(capturedPiece != null){
            board.placepiece(capturedPiece, target);
            capturedpieces.remove(capturedPiece);
            piecesontheboard.add(capturedPiece);

        }
    }

    private void validadeSourcePosition(Position position){
        if(!board.thereIsAPiece(position)){
            throw new ChessException("Não existe peças na posição de origem");
        }
        if(currentPlayer != ((ChessPiece)board.piece(position)).getColor()){
            throw new ChessException("A peça escolhida não é sua!");
        }
        if(!board.piece(position).isthereanypossiblemove()){
            throw new ChessException("NÃO EXISTE MOVIMENTOS POSSIVEIS PARA A PEÇA ESCOLHIDA!");
        }
    }

    private void validateTargetPosition(Position source, Position target){
        if(!board.piece(source).possibleMove(target)){
            throw new ChessException("A peça escolhida não pode se mover para posição de destino!");
        }

    }

    private void nextTurn(){
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private Color opponent(Color color){
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private ChessPiece King(Color color){
        List<Piece> list = piecesontheboard.stream().filter(x ->((ChessPiece)x).getColor() == color).collect(Collectors.toList());
        for(Piece p : list){
            if(p instanceof King){
                return (ChessPiece)p;
            }
        }
        throw new IllegalStateException("não existe um rei da cor " + color + "no tabuleiro");
    }

    private boolean testCheck(Color color) {
		Position kingPosition = King(color).getChessPosition().toPosition();
		List<Piece> opponentPieces = piecesontheboard.stream().filter(x -> ((ChessPiece)x).getColor() == opponent(color)).collect(Collectors.toList());
		for (Piece p : opponentPieces) {
			boolean[][] mat = p.possibleMove();
			if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
				return true;
			}
		}
		return false;
	}
	
	private boolean testCheckMate(Color color) {
		if (!testCheck(color)) {
			return false;
		}
		List<Piece> list = piecesontheboard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());
		for (Piece p : list) {
			boolean[][] mat = p.possibleMove();
			for (int i=0; i<board.getRows(); i++) {
				for (int j=0; j<board.getColumns(); j++) {
					if (mat[i][j]) {
						Position source = ((ChessPiece)p).getChessPosition().toPosition();
						Position target = new Position(i, j);
						Piece capturedPiece = makeMove(source, target);
						boolean testCheck = testCheck(color);
						undoMove(source, target, capturedPiece);
						if (!testCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}	

    private void initialSetup(){
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));
        
        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }
}
