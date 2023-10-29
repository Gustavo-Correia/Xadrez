package boardgame;

public class board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public board(int rows, int columns) {
        if(rows < 1 || columns < 1){
            throw new boardException("Error ao criar o tabuleiro, é necessário que haja pelo menos 1 linha e 1 coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }



    public int getRows() {
        return rows;
    }


    public int getColumns() {
        return columns;
    }

    
    public Piece piece(int row, int column){
        if(!positionexists(row,column)){
            throw new boardException("esta posição não existe nesse Tabuleiro!");
        }
		return pieces[row][column];
    }
    public Piece piece(Position position){
        if(!positionexists(position)){
            throw new boardException("esta posição não existe nesse Tabuleiro!");
        }
        return piece(position.getRow(), position.getColumn());
    }

    public void placepiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new boardException("esta posição já esta sendo usada no tabuleiro!" + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;      
    }

    private boolean positionexists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionexists(Position position){
        return positionexists(position.getRow(), position.getColumn());
    }


    public boolean thereIsAPiece(Position position){
        if(!positionexists(position)){
            throw new boardException("esta posição não existe nesse Tabuleiro!");
        }
        return piece(position) != null;
    }
}
