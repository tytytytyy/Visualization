package org.o7planning.javafx.piechart;

import java.sql.*;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Visualisierung extends Application { 
	
	static String query;
	static String query2;
	int informed;
	int not_informed;
	int anzahl;



	public static void main(String[] args) {
		launch(args);

	}
	
	 public void start(Stage primaryStage) throws Exception {
		 
		 	verbindungsaufbau();
		 
	        PieChart pieChart = new PieChart();
	 
	        PieChart.Data slice1 = new PieChart.Data("Informierte User", informed);
	        PieChart.Data slice2 = new PieChart.Data("Uninformierte User", not_informed);
	     
	        pieChart.getData().add(slice1);
	        pieChart.getData().add(slice2);
	    
	      
	        
	        pieChart.setPrefSize(400, 300);
	 
	        pieChart.setLegendSide(Side.BOTTOM);
	        pieChart.setStartAngle(30);
	 
	        final Label caption = new Label("Wie viele der User haben sich über den Great American Boykott infomiert?");
	        caption.setTextFill(Color.BLACK);
	        caption.setStyle("-fx-font: 12 arial;");
	 
	        for (final PieChart.Data data : pieChart.getData()) {
	            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
	                @Override
	                public void handle(MouseEvent e) {
	                    caption.setTranslateX(e.getSceneX());
	                    caption.setTranslateY(e.getSceneY());
	 
	                    caption.setText(String.valueOf(data.getPieValue()));
	                }
	            });
	        }
	 
	        primaryStage.setTitle("JavaFX PieChart (o7planning.org)");
	        AnchorPane root = new AnchorPane();
	        root.getChildren().addAll(pieChart, caption);
	        
	        
	        
	 
	        Scene scene = new Scene(root, 500, 500);
	 
	        primaryStage.setScene(scene);
	 
	        primaryStage.show();
	    }

	 public void verbindungsaufbau(){
		 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection my_con = DriverManager.getConnection("jdbc:oracle:thin:@dbl43.beuth-hochschule.de:1521:rispdb1", "s898676", "student");

				Statement my_stmt = my_con.createStatement();

				query = "SELECT Count(id) FROM aoldata.querydata";
				
				query2 = "SELECT Count(id) FROM aoldata.querydata Where query LIKE '%immigrant%boycot%' OR query LIKE '%migrant boycot%' OR query LIKE '%great american boycot%' OR query LIKE '%discrimination protest%'OR query LIKE '%migrant strike%'";


				ResultSet my_result = my_stmt.executeQuery(query2);			

				while (my_result.next()) {
					informed = my_result.getInt(1);

					System.out.println(informed);
										
				}
				
				ResultSet my_result2 = my_stmt.executeQuery(query);
		
				while (my_result2.next()) {
					not_informed = my_result2.getInt(1);
					System.out.println(not_informed);
										
					
				}
				
		
				
				my_con.close();

			}
			catch (Exception ex) {

				System.out.println("didnt work?"+ ex.getMessage());
				System.out.println(ex.getMessage());
				System.out.println(ex.getMessage());

			}
		 
	 }
}