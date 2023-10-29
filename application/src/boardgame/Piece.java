package boardgame;

public abstract class Piece {
    protected Position position;
    private board board;

    public Piece(boardgame.board board) {
        this.board = board;
        position = null;
    }

    protected board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMove();
    
    public boolean possibleMove(Position position){
        return possibleMove()[position.getRow()][position.getColumn()];
    }
    public boolean isthereanypossiblemove(){
        boolean[][] mat = possibleMove();
        for(int x=0; x<mat.length; x++){
            for (int i=0; i<mat.length; i++){
                if(mat[x][i]){
                    return true;
                }
            }
        }
        return false;
    }
}
