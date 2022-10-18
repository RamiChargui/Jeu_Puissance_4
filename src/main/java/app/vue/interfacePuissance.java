package app.vue;

import app.Model.Joueur;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class interfacePuissance {
	private GridPane root = new GridPane();
	private int nbLigne, nbColonne;
	private Button[][] tabButton;
	private Button saveButton;
	private Button precedant;
	private Button suivant;
	private Button play;
	private Button stop;
	private HBox nav=new HBox();
	
	public interfacePuissance(int nbLigne, int nbColonne) {
		this.nbColonne = nbColonne;
		this.nbLigne = nbLigne;
		tabButton = new Button[nbLigne][nbColonne];
	}
	
	public HBox getNav() {
		precedant = new Button("coup precedant");
		play = new Button("play");
		stop = new Button("stop");
		suivant = new Button("coup suivant");
		
		nav.getChildren().addAll(precedant ,play,stop, suivant  );
		nav.setAlignment(Pos.CENTER);
		return nav;
	}
	public Button getBNav() {
	 return (Button)nav.getChildren().get(3);
	}
	public Button getButton() {
		saveButton = new Button("save partie");
		
		return saveButton;
	}
	
	public Button getButtonS() {
		return saveButton;
	}
	
	public void dessiner() {
		for(int i=0;i<nbLigne;i++) {
			for(int j=0;j<nbColonne;j++) {
				tabButton[i][j] = new Button("0");
				root.add(tabButton[i][j], j, i);
				
			}
		}
		root.setAlignment(Pos.CENTER);
		root.setHgap(5);
		root.setVgap(5);
	}
	public Label infoJoueur(Joueur j1) {
		Label lbl = new Label(""+j1.toString());
		lbl.setAlignment(Pos.CENTER);
		return lbl;
	}
	
	public Button[][] getTabButton(){
		return this.tabButton;
	}
	
	public GridPane getRoot(){
		
		return this.root;
	}
	
	public void setCouleurButon(int numLigne,int numColonne, String couleur) {
		tabButton[numLigne][numColonne].setStyle("-fx-background-radius: 150em; " +
                "-fx-min-width: 20px;" +
	                "-fx-min-height: 20px; " +
	                "-fx-max-width: 20px; " +
                "-fx-max-height: 20px;"+
             "-fx-background-color:"+couleur+";");
	}

}
