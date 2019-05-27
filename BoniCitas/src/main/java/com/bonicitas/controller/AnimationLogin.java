package com.bonicitas.controller;

import com.bonicitas.Main;

import javafx.animation.FadeTransition;

import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class AnimationLogin {
	
	private Pane p1;
	private Pane p2;
	private Pane p3;
	private Pane p4;

	
	/**
	 * Constructor de la ventana de Login, se cargan los Pane para la transicion
	 * de imagenes
	 * @param p1 Sera contenedor de imagenes para presentar en la ventana de Login p1, p2, p3, p4
	 * @author cmcgrath
	 * */
	public AnimationLogin(Pane pane1, Pane pane2, Pane pane3, Pane pane4) {
		

		
		this.p1 = pane1;
		this.p2 = pane2;
		this.p3 = pane3;
		this.p4 = pane4;
		
		String image1 = Main.class.getResource("images/logintest1.jpg").toExternalForm();
		String image2 = Main.class.getResource("images/logintest2.jpg").toExternalForm();
		String image3 = Main.class.getResource("images/logintest3.jpg").toExternalForm();
		String image4 = Main.class.getResource("images/logintest4.jpg").toExternalForm();
		
		p1.setStyle("-fx-background-image: url('"+image1+"')");
		p2.setStyle("-fx-background-image: url('"+image2+"')");
		p3.setStyle("-fx-background-image: url('"+image3+"')");
		p4.setStyle("-fx-background-image: url('"+image4+"')");
		
		backgoundAnimation();
	}
	

	/**
	 * Metodo el cual realiza la presentacion de imagenes
	 * @author cmcgrath
	 **/
	private void backgoundAnimation() {
			
			FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5),p4);
			fadeTransition.setFromValue(1); 
			fadeTransition.setToValue(0);
			fadeTransition.play();
			
			fadeTransition.setOnFinished(event ->{
				
				FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(5),p3);
				fadeTransition1.setFromValue(1);
				fadeTransition1.setToValue(0);
				fadeTransition1.play();
				
				
				fadeTransition1.setOnFinished(event1 ->{
					FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(5),p2);
					fadeTransition2.setFromValue(1);
					fadeTransition2.setToValue(0);
					fadeTransition2.play();
					
					fadeTransition2.setOnFinished(event2 ->{
						FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(3),p2);
						fadeTransition3.setToValue(1);
						fadeTransition3.setFromValue(0);
						fadeTransition3.play();
						
						fadeTransition3.setOnFinished(event3 ->{
							FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(3),p3);
							fadeTransition4.setToValue(1);
							fadeTransition4.setFromValue(0);
							fadeTransition4.play();
							
							
							fadeTransition4.setOnFinished(event4 ->{
								FadeTransition fadeTransition5 = new FadeTransition(Duration.seconds(3),p4);
								fadeTransition5.setToValue(1);
								fadeTransition5.setFromValue(0);
								fadeTransition5.play();
								
								fadeTransition5.setOnFinished(event5 ->{
									
									backgoundAnimation();
									
								});
								
							});
							
						});
						
					});
					
				});
				
			});
	}
	


}
