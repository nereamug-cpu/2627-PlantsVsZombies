package utils;

import java.util.Objects;

public class Position {
	private int row;
	private int col;
	
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int row() {
		return row;
	}
	
	public int column() {
		return col;
	}
	
	// Revisar las alineaciones (diagrama clase)
	
	public boolean isHorizontallyAligned(Position p) {
		return p != null && row == p.row();
	}
	
	public boolean isVerticallyAligned(Position p) {
		return p != null && col == p.column();
	}
	
	@Override
	public String toString() {
		return "(" + this.row + ", " + this.col + ")";
	}

	@Override
	public boolean equals(Object o) {
		boolean eq = false;
		if (o != null && o.getClass() == this.getClass()) {
			Position other = (Position) o;
            eq = (other.row() == this.row) && (other.column() == this.col);		
        }
		return eq;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(row,col);
	}
	
	public Position left() {
		return new Position (row, col - 1);
	}
	public Position right() {
		return new Position(row, col + 1);
	}
	
	public Position up() {
		return new Position(row - 1, col);
	}
	
	public Position down() {
		return new Position(row + 1, col);
	}
	
	public Position upRight() {
		return new Position(row - 1, col + 1);
	}
	
	public Position upLeft() {
		return new Position(row - 1, col - 1);
	}
	
	public Position downRight() {
		return new Position(row + 1, col + 1);
	}
	
	public Position downLeft() {
		return new Position(row + 1, col - 1);
	}
}
