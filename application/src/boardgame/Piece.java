package boardgame;

public class Piece {
    protected Position position;
    private board board;

    public Piece(boardgame.board board) {
        this.board = board;
        position = null;
    }

    protected board getBoard() {
        return board;
    }


    
}
