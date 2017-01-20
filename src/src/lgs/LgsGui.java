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

import java.awt.Rectangle;
import java.util.LinkedHashMap;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Accordion;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import lgs.graphics.CircuitComponentG;
import lgs.model.Circuit;
import lgs.graphics.CircuitG;
import lgs.graphics.InputG;
import lgs.graphics.OutputG;
import lgs.graphics.PinG;
import lgs.graphics.Selector;
import lgs.graphics.WireG;
import lgs.graphics.gates.AndG;
import lgs.graphics.gates.NandG;
import lgs.graphics.gates.NorG;
import lgs.graphics.gates.NotG;
import lgs.graphics.gates.OrG;
import lgs.graphics.gates.XnorG;
import lgs.graphics.gates.XorG;
import lgs.model.Input;
import lgs.model.Output;
import lgs.utils.Component;
import static lgs.utils.GraphicElement.DOT_SIZE;
import static lgs.utils.GraphicElement.SELECTOR_PADDING;

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
    Canvas canvas;

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

    /**
     * Defines the drawable circuit.
     */
    CircuitG gCircuit = new CircuitG();

    PinG currentSelectedPin = null;

    Selector currentSelector = null;

    Image plus = null;

    Image minus = null;

    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        // Inizializzazione degli elementi grafici
        // Main container
        mainContainer = new BorderPane();

        // Canvas container
        canvasContainer = new ScrollPane();
        canvasContainer.setStyle("-fx-background-color: lightblue;  -fx-border-color: e6e6e6; -fx-border-width: 2px;");
        canvas = new Canvas(1500, 1000);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Toolbox
        toolbox = new FlowPane(Orientation.HORIZONTAL);
        toolbox.setPrefWrapLength(177);
        toolbox.setVgap(5);
        toolbox.setStyle("-fx-background-color: white; -fx-padding: 2px;");
        // Left menu
        leftMenu = new Accordion(new TitledPane("Toolbox", toolbox));
        //leftMenu.setStyle("-fx-border-color: black; -fx-border-width: 0px 1px 0px 0px;");
        leftMenu.setExpandedPane(leftMenu.getPanes().get(0));

        // Inizializzazione scena
        Scene scene = new Scene(mainContainer, 1280, 800);
        scene.getStylesheets().add(getClass().getResource("style/stylesheet.css").toExternalForm());
        primaryStage.setTitle("Logic Gates Simulator");
        primaryStage.setScene(scene);

        // Menu
        menu = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");
        Menu menuAbout = new Menu("About");
        menu.getMenus().addAll(menuFile, menuEdit, menuView, menuAbout);

        // Toolbox
        LinkedHashMap<Component, ImageView> toolboxElements = new LinkedHashMap<>();

        toolboxElements.put(Component.AND, new ImageView(getClass().getResource("gates/images/and.png").toExternalForm()));
        toolboxElements.put(Component.NAND, new ImageView(getClass().getResource("gates/images/nand.png").toExternalForm()));
        toolboxElements.put(Component.OR, new ImageView(getClass().getResource("gates/images/or.png").toExternalForm()));
        toolboxElements.put(Component.NOR, new ImageView(getClass().getResource("gates/images/nor.png").toExternalForm()));
        toolboxElements.put(Component.XOR, new ImageView(getClass().getResource("gates/images/xor.png").toExternalForm()));
        toolboxElements.put(Component.XNOR, new ImageView(getClass().getResource("gates/images/xnor.png").toExternalForm()));
        toolboxElements.put(Component.NOT, new ImageView(getClass().getResource("gates/images/not.png").toExternalForm()));

        toolboxElements.entrySet().stream().forEach((image) -> {
            image.getValue().setOnDragDetected((MouseEvent event) -> {
                currentDragged = image.getKey();
                Dragboard db = image.getValue().startDragAndDrop(TransferMode.ANY);
                ClipboardContent content = new ClipboardContent();
                content.putImage(image.getValue().getImage());
                db.setContent(content);

                event.consume();
            });
            image.getValue().setOnMouseEntered((MouseEvent event) -> {
                primaryStage.getScene().setCursor(Cursor.OPEN_HAND);
                event.consume();
            });
            image.getValue().setOnMouseExited((MouseEvent event) -> {
                primaryStage.getScene().setCursor(Cursor.DEFAULT);
                event.consume();
            });
        });

        // Strutturazione
        mainContainer.setLeft(leftMenu);
        mainContainer.setCenter(canvasContainer);
        mainContainer.setTop(menu);

        // Aggiunge tutti gli elementi della hashmap alla toolbox
        toolboxElements.entrySet().stream().forEach((image) -> {
            toolbox.getChildren().add(image.getValue());
        });

        canvasContainer.setContent(canvas);

        canvas.setOnDragOver((DragEvent event) -> {
            if (event.getGestureSource() != canvasContainer) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }

            event.consume();
        });

        canvas.setOnDragDropped((DragEvent event) -> {
            addToCircuit(currentDragged, event);

            currentDragged = null;
            repaint(canvas.getGraphicsContext2D());
            event.setDropCompleted(true);

            event.consume();

        });

        canvas.setOnMouseClicked((MouseEvent event) -> {
            int componentCount = gCircuit.getComponents().size();
            for (int i = 0; i < componentCount; i++) {
                int childrenCount = gCircuit.getComponents().get(i).getChildren().size();
                // Selettore
                CircuitComponentG gate = gCircuit.getComponents().get(i);
                Rectangle gateArea = new Rectangle(gate.getOrigin(), gate.getSize());
                if (event.getClickCount() == 2) {
                    if (gateArea.contains(event.getX(), event.getY())) {
                        currentSelector = new Selector(gate.getOrigin().x - PinG.WIDTH - DOT_SIZE,
                            gate.getOrigin().y - SELECTOR_PADDING, gate.getSize().width + 2 * (PinG.WIDTH + DOT_SIZE),
                            gate.getSize().height + 2 * SELECTOR_PADDING, gate);
                    } else {
                        currentSelector = null;
                    }
                }

                for (int j = 0; j < childrenCount; j++) {
                    PinG pin = (PinG) gCircuit.getComponents().get(i).getChildren().get(j);
                    // L'utente ha premuto sul pin di una porta logica?
                    if (pin.getDot().contains(event.getX(), event.getY())) {
                        // L'utente premeva anche il tasto control?
                        if (event.isControlDown()) {
                            InputG inputPin = null;
                            OutputG outputPin = null;
                            //  Codice per eliminare i wire
                            if (pin.isWired()) {
                                for (int k = 0; k < gCircuit.getWires().size(); k++) {
                                    if (gCircuit.getWires().get(k).input.equals(pin) || gCircuit.getWires().get(k).output.equals(pin)) {
                                        Input inputComponent;
                                        Output outputComponent;
                                        if (pin.getClass().isInstance(new InputG())) {
                                            inputPin = (InputG) pin;
                                            inputComponent = inputPin.getComponent();
                                            outputComponent = inputComponent.getOutputComponent();
                                            gCircuit.getCircuit().deattachInput(outputComponent, inputComponent);
                                            
                                        } else if (pin.getClass().isInstance(new OutputG())) {
                                            outputPin = (OutputG) pin;
                                            outputComponent = outputPin.getComponent();
                                            inputComponent = outputComponent.getInputComponent();
                                            gCircuit.getCircuit().deattachInput(outputComponent, inputComponent);
                                        }
                                        gCircuit.getWires().get(k).input.setWired(false);
                                        gCircuit.getWires().get(k).output.setWired(false);
                                        gCircuit.getWires().remove(k);
                                        currentSelectedPin = null;
                                        repaint(gc);
                                        return;
                                    }
                                }
                            }
                            
                            // Se l'utente ha già selezionato un pin in precedenza e non ha selezionato lo stesso
                            // e inoltre se l'utente non ha cliccato su pin già collegati
                            if (currentSelectedPin != null && !currentSelectedPin.equals(pin) && !currentSelectedPin.isWired()
                                    && !pin.isWired()) {
                                if (currentSelectedPin.getClass().isInstance(new InputG()) && pin.getClass().isInstance(new OutputG())) {
                                    inputPin = (InputG) currentSelectedPin;
                                    outputPin = (OutputG) pin;
                                } else if (currentSelectedPin.getClass().isInstance(new OutputG()) && pin.getClass().isInstance(new InputG())) {
                                    inputPin = (InputG) pin;
                                    outputPin = (OutputG) currentSelectedPin;
                                }
                                // Collega insieme i 2 pin
                                if (inputPin != null && outputPin != null
                                        && inputPin.getComponent().getAttachedTo() != outputPin.getComponent().getAttachedTo()) {
                                    inputPin.getComponent().setOutputComponent(outputPin.getComponent());
                                    outputPin.getComponent().setInputComponent(inputPin.getComponent());
                                    outputPin.getComponent().addObserver(inputPin.getComponent());
                                    int x1 = inputPin.getOrigin().x - PinG.WIDTH;
                                    int y1 = inputPin.getOrigin().y;
                                    int x2 = outputPin.getOrigin().x;
                                    int y2 = outputPin.getOrigin().y;
                                    // Controlla che l'utente non abbia già creato un collegamento identico in precedenza
                                    WireG wire = new WireG(x1, y1, x2, y2, inputPin, outputPin);
                                    if (!gCircuit.getWires().contains(wire)) {
                                        gCircuit.getWires().add(wire);
                                        inputPin.setWired(true);
                                        outputPin.setWired(true);
                                    }
                                }
                                currentSelectedPin = null;
                            } else {
                                currentSelectedPin = pin;
                            }
                            if (inputPin != null && outputPin != null) {
                                inputPin.getComponent().setData(outputPin.getComponent().getData());
                            }
                        } else if (!pin.isWired() && pin.getClass().isInstance(new InputG())) {
                            InputG inputPin = (InputG) pin;
                            inputPin.getComponent().setData(!inputPin.getComponent().getData());
                        }
                    }
                }
            }

            repaint(gc);
            event.consume();
        });

        scene.setOnKeyPressed((KeyEvent key) -> {
            if (key.isControlDown()) {
                scene.setCursor(Cursor.CROSSHAIR);
            }
        });

        scene.setOnKeyReleased((KeyEvent key) -> {
            scene.setCursor(Cursor.DEFAULT);
        });

        // Mostra la scena
        primaryStage.show();

    }

    private void addToCircuit(Component componentType, DragEvent event) {
        switch (componentType) {
            case AND:
                gCircuit.addComponent(new AndG((int) event.getX(), (int) event.getY()));
                break;
            case OR:
                gCircuit.addComponent(new OrG((int) event.getX(), (int) event.getY()));
                break;
            case NOT:
                gCircuit.addComponent(new NotG((int) event.getX(), (int) event.getY()));
                break;
            case XOR:
                gCircuit.addComponent(new XorG((int) event.getX(), (int) event.getY()));
                break;
            case NAND:
                gCircuit.addComponent(new NandG((int) event.getX(), (int) event.getY()));
                break;
            case NOR:
                gCircuit.addComponent(new NorG((int) event.getX(), (int) event.getY()));
                break;
            case XNOR:
                gCircuit.addComponent(new XnorG((int) event.getX(), (int) event.getY()));
                break;
        }
    }

    private void repaint(GraphicsContext gc) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // Disegno porte logiche
        for (CircuitComponentG element : gCircuit.getComponents()) {
            element.drawShape(gc);
        }
        for (WireG element : gCircuit.getWires()) {
            element.drawShape(gc);
        }
        if (currentSelector != null) {
            currentSelector.drawShape(gc);
            if (currentSelector.getComponent().isInputModifiable()) {
                plus = new Image(getClass().getResourceAsStream("utils/Plus-48.png"));
                gc.drawImage(plus,
                        currentSelector.getOrigin().x + currentSelector.getSize().width + 10,
                        currentSelector.getOrigin().y);
                minus = new Image(getClass().getResourceAsStream("utils/Minus-48.png"));
                gc.drawImage(minus,
                        currentSelector.getOrigin().x + currentSelector.getSize().width + 10,
                        currentSelector.getOrigin().y + 48);
            }   
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
