package app.Model.dba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.Model.Joueur;

public class DAOJOUEUR extends DAO<Joueur>{
	public DAOJOUEUR() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Joueur create(Joueur t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Joueur Find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Joueur Delete(Joueur t) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Joueur> FindAll() {
		// TODO Auto-generated method stub
		List<Joueur> list=new ArrayList<Joueur>();
		try {
		Statement ps = conn.createStatement();
		String requete="select * from joueur ";
		ResultSet rs =ps.executeQuery(requete);
		ResultSetMetaData rsmd = rs.getMetaData();
		
		while (rs.next()) {
			Joueur j1= new Joueur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
			list.add(j1);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Execption");
	}
		return list;
	}
	


}
