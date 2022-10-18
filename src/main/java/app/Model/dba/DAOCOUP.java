package app.Model.dba;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.Model.Coup;
import app.Model.Joueur;

public class DAOCOUP extends DAO<Coup>{

	public DAOCOUP() {
		super();
	}
	
	public Coup create(Coup t,int idp) {
		// TODO Auto-generated method stub
		int x=t.getPos().getPosX();
		int y=t.getPos().getPosY();
		
		
		try {
			Statement ps = conn.createStatement();
			
			String requete="insert into coup (idpartie, numCol, numLin, idJ) values ("+idp+","+ x+","+ y+","+ t.getIdj()+") ";
			ps.executeUpdate(requete);
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Execption");
		}
		return t;
	}

	
	public List FindBy(int id){
		
		List<Coup> list=new ArrayList<Coup>();
		try {
		Statement ps = conn.createStatement();
		String requete="select * from coup where idpartie="+id+" ";
		ResultSet rs =ps.executeQuery(requete);
		ResultSetMetaData rsmd = rs.getMetaData();
		
		while (rs.next()) {
			Coup c1= new Coup(rs.getInt(5),rs.getInt(3),rs.getInt(4));
			list.add(c1);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Execption");
	}
		return list;
	}

	@Override
	public Coup Delete(Coup t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coup> FindAll() {
		List<Coup> list=new ArrayList<Coup>();
		try {
		Statement ps = conn.createStatement();
		String requete="select * from coup ";
		ResultSet rs =ps.executeQuery(requete);
		ResultSetMetaData rsmd = rs.getMetaData();
		
		while (rs.next()) {
			Coup c1= new Coup(rs.getInt(1),rs.getInt(2));
			list.add(c1);
			
		}
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Execption");
	}
		return list;
	}

	@Override
	public Coup create(Coup t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coup Find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
