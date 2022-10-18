package app.vue;

import java.util.List;

import app.Model.Coup;
import app.Model.Joueur;
import app.Model.Partie;
import app.Model.Puissance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class interfacePartie {
	
private TableView<Partie> table = new TableView<Partie>();
	
	public Node dessiner(List<Partie> list) {
		// Create column UserName (Data type of String).
	   
	    // Create column Email (Data type of String).
	    TableColumn<Partie, String> id//
	            = new TableColumn<Partie, String>("id ");

	    // Create column FullName (Data type of String).
	    TableColumn<Partie, String> idj1//
	            = new TableColumn<Partie, String>("joueur 1");

	    // Create 2 sub column for FullName.
	    TableColumn<Partie, String> idj2 //
	            = new TableColumn<Partie, String>("joueur 2");

	 // Create 2 sub column for FullName.
	    TableColumn<Partie, String> scorej1 //
	            = new TableColumn<Partie, String>("score joueur 2");
	    
	 // Create 2 sub column for FullName.
	    TableColumn<Partie, String> scorej2 //
	            = new TableColumn<Partie, String>("score joueur 2");
	    
	    TableColumn<Partie, Button> detail //
        = new TableColumn<Partie, Button>();

	    table.getColumns().addAll(id, idj1, idj2,scorej1,scorej2,detail);
		////
	    id.setCellValueFactory(new PropertyValueFactory<>("id"));
		idj1.setCellValueFactory(new PropertyValueFactory<>("idj1"));
		idj2.setCellValueFactory(new PropertyValueFactory<>("idj2"));
		scorej1.setCellValueFactory(new PropertyValueFactory<>("scorej1"));
		scorej2.setCellValueFactory(new PropertyValueFactory<>("scorej2"));
		///
		ObservableList<Partie> list1 = FXCollections.observableArrayList(list);	
		table.setItems(list1);		
		//
		return table;
		
	}

}
