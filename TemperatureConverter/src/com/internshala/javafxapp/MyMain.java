package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	public static void main(String [] args){
		launch(args);
	}

	@Override
	public void init() throws Exception{
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter");
		primaryStage.show();
	}

	private MenuBar createMenu(){
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
		newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			System.out.println("Quit Menu Item Clicked");
			Platform.exit();
			System.exit(0);
		});
		fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		aboutApp.setOnAction(event -> aboutApp());
		helpMenu.getItems().addAll(aboutApp);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}

	private void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("About Temperature Converter Tool");
		alertDialog.setHeaderText("How to use?");
		alertDialog.setContentText("Just enter a valid temperature in the text area and choose your option from the dropdown list. " +
								"Developed by Gautam Balamurali.");
		alertDialog.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();
		if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
			System.out.println("Yes Button clicked");
		}
		else {
			System.out.println("No Button Clicked");
		}
	}

	@Override
	public void stop() throws Exception{
		super.stop();
	}
}
