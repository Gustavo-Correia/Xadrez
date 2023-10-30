package chess;

import ChessPiece.King;
import ChessPiece.Rook;
import boardgame.Piece;
import boardgame.Position;
import boardgame.board;

public class ChessMatch {
    private int turn;
    private Color currentPlayer;
    private board board;





    

    

    public int getTurn() {
        return turn;
    }



    public Color getCurrentPlayer() {
        return currentPlayer;
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
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placepiece(p, target);
        return capturedPiece;
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
