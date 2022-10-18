package app.Model.dba;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.Model.Joueur;
import app.Model.Partie;

public class DAOPARTIE extends DAO<Partie>{
	
	public DAOPARTIE() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Partie create(Partie t) {
		int id1=t.getJ1().getId();
		int id2=t.getJ2().getId();
		int sj1=t.getScorej1();
		int sj2=t.getScorej2();
		try {
			Statement ps = conn.createStatement();
			
			String requete="insert into partie (puissanceid, joueur1, joueur2, score1, score2) values (1,"+id1+","+ id2+","+ +sj1+","+ sj2+") ";
			ps.executeUpdate(requete);
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Execption");
		}
		return t;
	}

	@Override
	public Partie Find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List FindAll() {
		// TODO Auto-generated method stub
		List<Partie> list=new ArrayList<Partie>();
		try {
		Statement ps = conn.createStatement();
		String requete="select * from partie ";
		ResultSet rs =ps.executeQuery(requete);
		ResultSetMetaData rsmd = rs.getMetaData();
		
		while (rs.next()) {
			Partie p1= new Partie(rs.getInt(1),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
			list.add(p1);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Execption");
	}
		return list;
	}
	



	@Override
	public Partie Delete(Partie t) {
		// TODO Auto-generated method stub
		return null;
	}

}
