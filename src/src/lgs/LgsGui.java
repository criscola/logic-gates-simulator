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

import java.util.LinkedHashMap;
import javafx.application.Application;
import javafx.geometry.Orientation;
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
import lgs.utils.Component;

/**
 *
 * @author A4XX-COLCRI
 */
public class LgsGui extends Application {

    /**
     * This is the top-level container child of root.
     */
    BorderPane mainContainer = new BorderPane();

    /**
     * Contains the canvas and represents the drawing area.
     */
    ScrollPane canvasContainer = new ScrollPane();

    /**
     * Defines where all the shapes will be drawn.
     */
    Canvas canvas = new Canvas(1000, 700);

    /**
     * Contains all the left menu items (toolbox, ..).
     */
    Accordion leftMenu = new Accordion();

    /**
     * Defines the toolbox.
     */
    FlowPane toolbox = new FlowPane();

    /**
     * Defines the top bar menu.
     */
    MenuBar menu = new MenuBar();

    /**
     * Defines the circuit associated with a canvas.
     */
    Circuit circuit = new Circuit();

    /**
     * Defines the current dragged element.
     */
    Component currentDragged = null;
    
    LinkedList<Gate> gate = 

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

        LinkedHashMap<Component, ImageView> toolboxElements = new LinkedHashMap<>();

        // Porte logiche nella toolbox 
        toolboxElements.put(Component.AND, new ImageView(getClass().getResource("gates/images/and.png").toExternalForm()));
        toolboxElements.put(Component.NAND, new ImageView(getClass().getResource("gates/images/nand.png").toExternalForm()));
        toolboxElements.put(Component.OR, new ImageView(getClass().getResource("gates/images/or.png").toExternalForm()));
        toolboxElements.put(Component.NOR, new ImageView(getClass().getResource("gates/images/nor.png").toExternalForm()));
        toolboxElements.put(Component.XOR, new ImageView(getClass().getResource("gates/images/xor.png").toExternalForm()));
        toolboxElements.put(Component.XNOR, new ImageView(getClass().getResource("gates/images/xnor.png").toExternalForm()));
        toolboxElements.put(Component.NOT, new ImageView(getClass().getResource("gates/images/not.png").toExternalForm()));

        makeDraggable(toolboxElements);

        // Strutturazione
        circuit = new Circuit();
        mainContainer.setLeft(leftMenu);
        mainContainer.setCenter(canvasContainer);
        mainContainer.setTop(menu);
        
        // Aggiunge tutti gli elementi della hashmap alla toolbox
        toolboxElements.entrySet().stream().forEach((image) -> {
            toolbox.getChildren().add(image.getValue());
        });
        
        canvasContainer.setContent(canvas);

        canvas.setOnDragOver((DragEvent event) -> {
            System.out.println("onDragOver");
            if (event.getGestureSource() != canvasContainer) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }

            event.consume();
        });

        canvas.setOnDragDropped((DragEvent event) -> {
            System.out.println("onDragDropped");
            // Qui
            if (currentDragged == Component.AND) circuit.addCircuitComponent(new And(circuit));
            event.setDropCompleted(true);
            currentDragged = null;
            
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
        // Disegno porte logiche
        /*
        for (Gate element : circuit.getComponents().element().) {
            System.out.println("x: " + element.getOrigin().x);
            gc.fillRect(element.getOrigin().x, element.getOrigin().y, 60, 100);
        }*/
    }

    private void makeDraggable(LinkedHashMap<Component, ImageView> images) {
        images.entrySet().stream().forEach((image) -> {
            image.getValue().setOnDragDetected((MouseEvent event) -> {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");
                currentDragged = image.getKey();
                /* allow any transfer mode */
                Dragboard db = image.getValue().startDragAndDrop(TransferMode.ANY);

                /* put a image on dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putImage(image.getValue().getImage());
                db.setContent(content);

                event.consume();
            });
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}