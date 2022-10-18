package app.vue;

import java.util.List;

import app.Model.Joueur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class interfaceJoueur {
	private TableView<Joueur> table = new TableView<Joueur>();
	
	public Node dessiner(List<Joueur> list) {
		// Create column UserName (Data type of String).
	    TableColumn<Joueur, String> id //
	            = new TableColumn<Joueur, String>("id");

	    // Create column Email (Data type of String).
	    TableColumn<Joueur, String> nom//
	            = new TableColumn<Joueur, String>("Nom");

	    // Create column FullName (Data type of String).
	    TableColumn<Joueur, String> prenom//
	            = new TableColumn<Joueur, String>("Prenom");

	    // Create 2 sub column for FullName.
	    TableColumn<Joueur, String> score //
	            = new TableColumn<Joueur, String>("Score");

	    

	    table.getColumns().addAll(id, nom, prenom, score);
		////
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		score.setCellValueFactory(new PropertyValueFactory<>("score"));		
		///
		ObservableList<Joueur> list1 = FXCollections.observableArrayList(list);	
		table.setItems(list1);		
		//
		return table;
		
	}
	
	 

}
