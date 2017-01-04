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

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author A4XX-COLCRI
 */
public class LogicGatesSimulator extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        /* Inizializzazione della scene*/
        Parent root = FXMLLoader.load(getClass().getResource("LgsGui.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

        /* Inizializzazione degli elementi della toolbox */
        // Caricamento delle immagini
        /*
        Image images[] = {
            new Image(new File("@images/and.png").toURI().toString()),
            new Image(new File("@images/or.png").toURI().toString()),
            new Image(new File("@images/not.png").toURI().toString()),
            new Image(new File("@images/nand.png").toURI().toString()),
            new Image(new File("@images/nor.png").toURI().toString()),
            new Image(new File("@images/xor.png").toURI().toString()),
            new Image(new File("@images/xnor.png").toURI().toString())
        };
        
        FlowPane toolbox = (FlowPane) scene.lookup("#toolbox");
        for (Image image : images) {
            // Inserisce le immagini in dei ImageView e li inserisce nella toolbox
            ImageView iv = new ImageView();
            iv.setImage(image);
            
        }*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
