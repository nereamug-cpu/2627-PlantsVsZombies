package pvz.utils;

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
		if (o == null) {
			return false;
		}
		else if (o.getClass() == this.getClass()){
			return ((Position) o).row() == (this.row()) && ((Position) o).column() == (this.column());		}
		else {
			return false;
		}
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
}
