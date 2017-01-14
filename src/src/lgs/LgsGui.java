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
package lgs;

import java.awt.Dimension;
import java.awt.Point;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Accordion;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import lgs.gates.And;
import lgs.model.Circuit;
import lgs.model.CircuitComponent;
import lgs.model.Input;

/**
 *
 * @author A4XX-COLCRI
 */
public class LgsGui extends Application {

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
    ScrollPane canvasContainer;
    /**
     * Defines where all the shapes will be drawn.
     */
    Canvas canvas;
    /**
     * Contains all the left menu items (toolbox, ..).
     */
    Accordion leftMenu;
    /**
     * Defines the toolbox.
     */
    FlowPane toolbox;
    /**
     * Defines the top bar menu.
     */
    MenuBar menu;

    Circuit circuit = new Circuit();

    @Override
    public void start(Stage primaryStage) {
        // Inizializzazione degli elementi grafici
        // Main container
        mainContainer = new BorderPane();

        // Canvas container
        canvasContainer = new ScrollPane();
        canvasContainer.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 1px;");
        canvas = new Canvas(1000, 700);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Toolbox
        toolbox = new FlowPane(Orientation.HORIZONTAL);
        toolbox.setPrefWrapLength(177);
        toolbox.setStyle("-fx-background-color: e6e6e6; -fx-padding: 2px;");

        // Left menu
        leftMenu = new Accordion(new TitledPane("Toolbox", toolbox));
        leftMenu.setStyle("-fx-border-color: black; -fx-border-width: 0px 1px 0px 0px;");
        leftMenu.setExpandedPane(leftMenu.getPanes().get(0));

        // Inizializzazione scena
        Scene scene = new Scene(mainContainer, 1280, 800);
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

        makeDraggable(andImage);
        makeDraggable(nandImage);
        makeDraggable(orImage);
        makeDraggable(norImage);
        makeDraggable(xorImage);
        makeDraggable(xnorImage);
        makeDraggable(notImage);

        // Strutturazione
        mainContainer.setLeft(leftMenu);
        mainContainer.setCenter(canvasContainer);
        mainContainer.setTop(menu);
        toolbox.getChildren().addAll(andImage, nandImage, orImage, norImage, xorImage, xnorImage, notImage);
        canvasContainer.setContent(canvas);

        canvas.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                System.out.println("onDragOver");
                if (event.getGestureSource() != canvasContainer) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });

        canvas.setOnDragDropped((DragEvent event) -> {
            System.out.println("onDragDropped");
            System.out.println("1");
            And and = new And();
            and.setOrigin(new Point((int) event.getX(), (int) event.getY()));
            and.setDimension(new Dimension(60, 110));
            circuit.addCircuitComponent(and);

            repaint(gc);

            event.setDropCompleted(true);
            event.consume();

        });
        
        canvas.setOnMouseClicked((MouseEvent event) -> {
            for (CircuitComponent element : circuit.getComponents()) {
                //for (inp : element.getInputs()) {
                    
                //}
            }
            event.consume();
        });
        
        // Mostra la scena
        primaryStage.show();
    }

    private void repaint(GraphicsContext gc) {
        for (CircuitComponent element : circuit.getComponents()) {
            System.out.println("x: " + element.getOrigin().x);
            gc.fillRect(element.getOrigin().x, element.getOrigin().y, 60, 100);
        }
    }

    private void makeDraggable(ImageView image) {
        image.setOnDragDetected((MouseEvent event) -> {
            /* drag was detected, start drag-and-drop gesture*/
            System.out.println("onDragDetected");

            /* allow any transfer mode */
            Dragboard db = image.startDragAndDrop(TransferMode.ANY);

            /* put a image on dragboard */
            ClipboardContent content = new ClipboardContent();
            content.putImage(image.getImage());
            db.setContent(content);

            event.consume();
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
