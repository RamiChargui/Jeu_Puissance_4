package app.Model;

public class Coup {
	private Position pos;
	private int idj;
	

	public int getIdj() {
		return idj;
	}
	public void setIdj(int idj) {
		this.idj = idj;
	}
	public Coup(int numlin,int numcol) {
		Position posD=new Position(numlin, numcol);
		this.pos = posD;
	}
	public Coup(int id,int numlin,int numcol) {
		Position posD=new Position(numlin, numcol);
		this.pos = posD;
		this.idj=id;
		
	}
	public Coup(Position posDepart) {
		this.pos = posDepart;
	}

	public Position getPos() {
		return pos;
	}

	public void setPosDepart(Position pos) {
		this.pos = pos;
	}


	@Override
	public String toString() {
		return "Coup [pos=" + pos +"]";
	}
	

}
