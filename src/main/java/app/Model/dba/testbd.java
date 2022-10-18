/*
 * package app.Model.dba;
 * 
 * import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.ResultSet; import java.sql.ResultSetMetaData; import
 * java.sql.Statement; import java.util.List;
 * 
 * public class testbd {
 * 
 * public static void main(String[] args) {
 * 
 * // TODO Auto-generated method stub MYSQLCONNECT connection = null; Connection
 * conn;
 * 
 * 
 * 
 * try { DAOJOUEUR daoj=new DAOJOUEUR(); List l1=daoj.FindAll();
 * System.out.println("Ex "+l1.size());
 * 
 * Class.forName("com.mysql.cj.jdbc.Driver"); conn=connection.getInstance();
 * 
 * 
 * Connection conn = DriverManager .getConnection(
 * "jdbc:mysql://3306/puissance4?autoReconnect=true&useSSL=false", "cours",
 * "cours"); Statement ps = conn.createStatement(); String
 * requete="select * from joueur "; ResultSet rs =ps.executeQuery(requete);
 * ResultSetMetaData rsmd = rs.getMetaData();
 * System.out.println("La structure de la table joueur : nombre de champs: "
 * +rsmd.getColumnCount()); for (int i = 1; i <= rsmd.getColumnCount(); i++) {
 * //System.out.print(rsmd.getColumnName(i)+"    ");
 * System.out.print(" Type: "+rsmd.getColumnName(i));
 * System.out.print(" Type: "+rsmd.getColumnTypeName(i));
 * System.out.println(" Taille: "+rsmd.getColumnDisplaySize(i)); }
 * System.out.println(""); // Afficher tous les enregistrements du ResultSet rs
 * System.out.println("\n\nLe contenu de la table adherent : "); while
 * (rs.next()) { for (int i = 1; i <= rsmd.getColumnCount(); i++) {
 * System.out.print(" *** "+ rs.getString(i)); } System.out.println(""); } }
 * catch (Exception e) { e.printStackTrace(); System.out.println("Execption"); }
 * System.out.println("fin programme"); }
 * 
 * }
 */