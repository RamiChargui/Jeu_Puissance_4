package app.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.Model.dba.DAOJOUEUR;


public class Partie {
	
	private Joueur j1, j2;
	private ArrayList<Coup> lisCoupJ1=new ArrayList();
	private ArrayList<Coup> lisCoupJ2=new ArrayList();
	private int scorej1;
	private int scorej2;
	private int idj1;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int idj2;
	private int rolejoueur;
	private Puissance puissance;
	public int getIdj1() {
		return idj1;
	}
	public void setIdj1(int idj1) {
		this.idj1 = idj1;
	}
	public int getIdj2() {
		return idj2;
	}
	public void setIdj2(int idj2) {
		this.idj2 = idj2;
	}
	public Partie(int id, int id1, int id2, int s1, int s2){
		this.id=id;
		this.idj1=id1;
		this.idj2=id2;
		this.scorej1=s1;
		this.scorej2=s2;
	}
	public Partie(){
		DAOJOUEUR daoJoueur = new DAOJOUEUR();
		j1 = daoJoueur.FindAll().get(0);
		j2 = daoJoueur.FindAll().get(1);
		idj1=j1.getId();
		idj2=j2.getId();
		this.rolejoueur=j1.getId();
		puissance = new Puissance(j1.getId(), j2.getId());
	}
	
	public Partie(Joueur j1, Joueur j2) {
		this.j1=j1;
		this.j2=j2;
		idj1=j1.getId();
		idj2=j2.getId();
		puissance = new Puissance(j1.getId(), j2.getId());
		this.scorej1=j1.getScore();
		this.scorej2=j2.getScore();
		this.rolejoueur=j1.getId();
		
	}
	@Override
	public String toString() {
		String ch="Partie entre Joueur: " + j1 + " et Joueur: " + j2 ;
		switch(scorej1) {
		case 0 : ch=ch+"  est null";break;
		case 1 :ch=ch+"\n"+j1+" est gagnant";break;
		case -1 : ch=ch+"\n"+j2+" est gagnant";break;
		}
		ch=ch+ lisCoupJ1.toString(); 
		return ch ;
	}

	public void modifieRole() {
		if(this.rolejoueur==this.j1.getId())
			this.rolejoueur=this.j2.getId();
		
		else
			this.rolejoueur=this.j1.getId();
	}
	public int getRolejoueur() {
		return rolejoueur;
	}
	public void setRole(int id) {
		this.rolejoueur = id;
	}
	public void insertCoup(Coup coup){
			this.lisCoupJ1.add(coup);
			
		
	}
	public int getScorej1() {
		return scorej1;
	}
	public void setScorej2() {
		this.scorej2 += 1;
	}
	public int getScorej2() {
		return scorej2;
	}
	public void setScorej1() {
		this.scorej1 += 1;
	}

	public Puissance getPuissance() {
		return puissance;
	}
	public void setPuissance(Puissance p) {
		this.puissance = p;
	}
	public Joueur getJ1() {
		return j1;
	}
	public void setJ1(Joueur j1) {
		this.j1 = j1;
	}
	public ArrayList<Coup> getLisCoupJ1() {
		return lisCoupJ1;
	}
	public void setLisCoupJ1(ArrayList lisCoupJ1) {
		this.lisCoupJ1 = lisCoupJ1;
	}
	public ArrayList<Coup> getLisCoupJ2() {
		return lisCoupJ2;
	}
	public void setLisCoupJ2(ArrayList lisCoupJ2) {
		this.lisCoupJ2 = lisCoupJ2;
	}
	public Joueur getJ2() {
		return j2;
	}
	public void setJ2(Joueur j2) {
		this.j2 = j2;
	}	
}

