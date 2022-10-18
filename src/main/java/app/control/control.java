package app.control;

import java.util.List;

import app.Model.*;
import app.Model.dba.DAOCOUP;
import app.Model.dba.DAOJOUEUR;
import app.Model.dba.DAOPARTIE;
import app.vue.interfaceJoueur;
import app.vue.interfacePartie;
import app.vue.interfacePuissance;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class control {
	BorderPane fenetre = new BorderPane();
	Button[][] tabButton;
	Button saveButton;
	//Button precButton=new Button();
	HBox nav=new HBox();
	Joueur joueur1,joueur2;
	Partie partieJeu;
	int idJoueurCoup=1;
	interfacePuissance interfaceP ;
	DAOJOUEUR Djoueur=new DAOJOUEUR();
	Coup coupjeu;
	DAOCOUP dCoup= new DAOCOUP();
	DAOPARTIE dPartie=new DAOPARTIE();
	
	
	public control() {
		fenetre.setTop(getMenu());
	}

	public void puissanceControl() {
		int nbLigne = 6, nbColonne = 7;
		// partie vue
		joueur1 = Djoueur.FindAll().get(1);
		joueur2 = Djoueur.FindAll().get(2);
		
		partieJeu = new Partie(joueur1, joueur2);
		partieJeu.setJ1(joueur1);
		partieJeu.setJ2(joueur2);
		//vue
		
		interfaceP = new interfacePuissance(nbLigne, nbColonne);
		interfaceP.dessiner();
		fenetre.setCenter(interfaceP.getRoot());
		fenetre.setLeft(interfaceP.infoJoueur(partieJeu.getJ1()));
		fenetre.setRight(interfaceP.infoJoueur(partieJeu.getJ2()));
		fenetre.setBottom(interfaceP.getButton());
		

		// gestion d'action
		

		/*
		 * Button precButton=(Button)interfaceP.getBNav(); precButton.setOnAction(event
		 * ->{ this.suivant(this.getCoups(1));
		 * System.out.println(this.getCoups(1).size()); });
		 */
		
		Button bSave=new Button();
		bSave=interfaceP.getButtonS();
		
		  bSave.setOnAction(event -> { this.gestActionSave(dPartie);
		  System.out.println(this.partieJeu.toString());
		  
		  });
		 
		//
		this.tabButton = interfaceP.getTabButton();
		for (int i = 0; i < nbLigne; i++) {
			for (int j = 0; j < nbColonne; j++) {
				final int ii = i;
				final int jj = j;
				tabButton[i][j].setOnAction(event -> {
					this.gestionAction(jj);
				
				});
			}
		}

		
		// fenetre.setMargin(interfaceP.getRoot(), new Insets(10, 0, 10, 0));

	}
	
////////
	private List<Coup> getCoups(int id){
		return dCoup.FindBy(id);
		
	}
	private int compt=0;
	private void suivant(List<Coup> list) {
		
		String couleur="";
		if(list.get(compt).getIdj()==2) {
			couleur="green";
		
		}
		else {
			couleur="red";
		}
		
		interfaceP.setCouleurButon(list.get(compt).getPos().getPosX(), list.get(compt).getPos().getPosY(), couleur);
		compt++;
		
	}
	
////////
	private void gestionAction(int jj) {
		//view
		Alert xBox, iBox, cBox;
		xBox = new Alert(AlertType.ERROR);
		iBox = new Alert(AlertType.INFORMATION);
		cBox = new Alert(AlertType.CONFIRMATION, "Delete " + " ?", ButtonType.YES, ButtonType.CANCEL);
		
		// model
		boolean testGagnant;
		int numLigne = this.partieJeu.getPuissance().getLigneVideByColonne(jj);
		if (numLigne == -1) {
			xBox.setHeaderText("La colonne " + jj + " est remplie");
			xBox.showAndWait();
		} else {

			
			if(partieJeu.getRolejoueur()==partieJeu.getJ1().getId()) {
			//enregistrer coup
				
				coupjeu=new Coup(numLigne,jj,partieJeu.getRolejoueur());
				partieJeu.insertCoup(coupjeu);
				partieJeu.setScorej1();
				partieJeu.getJ1().incrementerScore();
			//
				testGagnant = this.partieJeu.getPuissance().setCoup(numLigne, jj, partieJeu.getJ1().getId());
				
				interfaceP.setCouleurButon(numLigne, jj, "green");
				if (testGagnant == true) {
					fenetre.setLeft(interfaceP.infoJoueur(partieJeu.getJ1()));
					iBox.setHeaderText("PARTIE FINIE");
					iBox.setContentText("Le joueur J1 est le gagant ");
					iBox.showAndWait();			
					partieJeu.getPuissance().initialiseGrille();
					
	
				}
				if (partieJeu.getPuissance().estRemplie()) {
					// view
					cBox.setHeaderText("PARTIE NULL");
					cBox.setContentText("La grille est remplie \n Voulez-vous rejouer?");
					cBox.showAndWait();
					if (cBox.getResult() == ButtonType.YES) {
						partieJeu.getPuissance().initialiseGrille();
						
					}
				}
				else{
					partieJeu.modifieRole();;
					
				}
				
		 }else{
			 //enregistrer partie
			 	
				coupjeu=new Coup(numLigne,jj,partieJeu.getRolejoueur());
				partieJeu.insertCoup(coupjeu);
				partieJeu.setScorej2();
				partieJeu.getJ2().incrementerScore();
			 testGagnant = this.partieJeu.getPuissance().setCoup(numLigne, jj, partieJeu.getJ2().getId());
				
				interfaceP.setCouleurButon(numLigne, jj, "red");
				if (testGagnant == true) {
					
					fenetre.setRight(interfaceP.infoJoueur(partieJeu.getJ2()));

					iBox.setHeaderText("PARTIE FINIE");
					iBox.setContentText("Le joueur J2 est le gagant ");
					iBox.showAndWait();			
					partieJeu.getPuissance().initialiseGrille();
					
	
				}
				if (partieJeu.getPuissance().estRemplie()) {
					// view
					cBox.setHeaderText("PARTIE NULL");
					cBox.setContentText("La grille est remplie \n Voulez-vous rejouer?");
					cBox.showAndWait();
					if (cBox.getResult() == ButtonType.YES) {
						partieJeu.getPuissance().initialiseGrille();
						
					}
				}
				else{
					partieJeu.modifieRole();
				}
				
				
			}

		}

	}
	
	private void gestActionSave(DAOPARTIE partie) {
		partie.create(partieJeu);
		
		  for(int i=0;i<partieJeu.getLisCoupJ1().size();i++) {
			  dCoup.create(partieJeu.getLisCoupJ1().get(i),15);
		  }
		 
		
		
	}
	
	public MenuBar getMenu() {
		MenuBar mBar= new MenuBar();
		Menu mGestionJeu= new Menu("Gestion Jeu");
		Menu mGestionPartie= new Menu("Gestion partie");
		
		Menu mstatique= new Menu("Statique");
		Menu mProfil= new Menu("Gestion Profil");
		
		Menu mHelp= new Menu("Help");
		mBar.getMenus().addAll(mGestionJeu,mGestionPartie,mstatique,mHelp);
		
		MenuItem mLPartie= new MenuItem("la list des partie");
		MenuItem mSPartie= new MenuItem("simulation d'une partie");
		MenuItem miPartie= new MenuItem("importer et exporter une partie");
		mGestionPartie.getItems().addAll(mLPartie,mSPartie, miPartie);

		mLPartie.setOnAction(event->{
			listePartie();
		});
		
		MenuItem mlance = new MenuItem("Lancer Jeu");
		MenuItem mlance2 = new MenuItem("Lancer Jeu contre ordinateur");
		MenuItem mQuitter = new MenuItem("Quitter");
		mQuitter.setOnAction(event -> {
			Platform.exit();
		});
		mlance.setOnAction(event -> {
			puissanceControl();
		});
		mGestionJeu.getItems().addAll(mlance,mlance2,mQuitter);
		MenuItem mlistejoueurs = new MenuItem("La liste des joueurs");
		MenuItem mlistejoueursscore = new MenuItem("La liste des joueurs selon score");
		mstatique.getItems().addAll(mlistejoueurs,mlistejoueursscore);
		
		mlistejoueurs.setOnAction(event -> {
			listeJoueur();
		});
		
		mlistejoueursscore.setOnAction(event -> {
			System.out.println("save");
		});

		return mBar;
		
	}
	private void listeJoueur() {
		///modele
		DAOJOUEUR daoJoueur=new DAOJOUEUR();
		List<Joueur> list=daoJoueur.FindAll();
		//System.out.println("nb element "+list.size());
		//view
		interfaceJoueur interfaceListJoueur=new interfaceJoueur();
		this.fenetre.setCenter(interfaceListJoueur.dessiner(list));
		
		
	}
	private void listePartie() {
		///modele
		DAOPARTIE daoPartie=new DAOPARTIE();
		List<Partie> list=daoPartie.FindAll();
		//System.out.println("nb element "+list.size());
		//view
		interfacePartie interfacePartie1=new interfacePartie();
		this.fenetre.setCenter(interfacePartie1.dessiner(list));
		
		
	}
	public BorderPane getFenetre() {
		return this.fenetre;
	}

}
