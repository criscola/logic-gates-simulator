/*
 * The MIT License
 *
 * Copyright 2016 A4XX-COLCRI.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package logicgatessimulator;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 *
 * @author A4XX-COLCRI
 */
public class LogicGatesSimulator extends Application {
    /**
     * The root node of the application.
     */
    Group root;
    /**
     * This is the top-level container child of root.
     */
    BorderPane mainContainer;
    /**
     * Contains the canvas and represents the drawing area.
     */
    Pane canvasContainer;
    /**
     * Defines where all the shapes will be drawn.
     */
    Canvas canvas;
    /**
     * Defines the toolbox.
     */
    FlowPane toolbox;
    /**
     * Defines the top bar menu.
     */
    MenuBar menu;
    
    
    @Override
    public void start(Stage primaryStage) {
        /*
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        */
        // Inizializzazione degli elementi grafici
        root = new Group();
        mainContainer = new BorderPane();
        canvasContainer = new Pane();
        canvas = new Canvas();
        toolbox = new FlowPane(Orientation.VERTICAL);
        toolbox.setPrefWrapLength(250);
        toolbox.minWidth(Region.USE_COMPUTED_SIZE);
        toolbox.minHeight(Region.USE_COMPUTED_SIZE);
        toolbox.maxWidth(Region.USE_COMPUTED_SIZE);
        toolbox.maxHeight(Region.USE_COMPUTED_SIZE);
        toolbox.prefHeight(Region.USE_COMPUTED_SIZE);
        toolbox.setStyle("-fx-background-color: red;");
        
        // Inizializzazione scena
        Scene scene = new Scene(root, 1280, 800);
        primaryStage.setTitle("Logic Gates Simulator");
        primaryStage.setScene(scene);
        
        // Menu
        menu = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");
        Menu menuAbout = new Menu("About");
        menu.getMenus().addAll(menuFile, menuEdit, menuView, menuAbout);
        
        // Porte logiche nella toolbox 
        ImageView andImage = new ImageView(getClass().getResource("images/and.png").toExternalForm());
        ImageView nandImage = new ImageView(getClass().getResource("images/nand.png").toExternalForm());
        ImageView orImage = new ImageView(getClass().getResource("images/or.png").toExternalForm());
        ImageView norImage = new ImageView(getClass().getResource("images/nor.png").toExternalForm());
        ImageView xorImage = new ImageView(getClass().getResource("images/xor.png").toExternalForm());
        ImageView xnorImage = new ImageView(getClass().getResource("images/xnor.png").toExternalForm());
        ImageView notImage = new ImageView(getClass().getResource("images/not.png").toExternalForm());
        
        // Strutturazione
        mainContainer.setLeft(toolbox);
        mainContainer.setRight(canvasContainer);
        toolbox.getChildren().addAll(andImage, nandImage, orImage, norImage, xorImage, xnorImage, notImage);
        canvasContainer.getChildren().add(canvas);
        root.getChildren().add(mainContainer);

        // Mostra la scena
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}