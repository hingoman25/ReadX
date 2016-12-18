import java.applet.Applet;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

import static java.awt.SystemColor.scrollbar;

/**
 * Created by nealsanghvi on 6/26/16.
 */
public class NysiisApplet extends Applet implements AdjustmentListener {
    Counter parse = new Counter();
    Nysiis ny = new Nysiis();
    List list = new List();
    Scrollbar scrollbar;
    TextField textField;

    //    ArrayList<String> arrname = new ArrayList<>();
//    ArrayList<Integer> arrnum = new ArrayList<>();

    public void init() {
        try {

            list.reader();
//        System.out.println(list.getAllNames().size());

            for (int i = 1; i < list.getAllNames().size(); i++) {
                parse.add(ny.sencode(list.getAllNames().get(i)).getEncoded(), ny.sencode(list.getAllNames().get(i)).getOG());

            }
        } catch (IOException e) {
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                NameClassifier nameClassifier = new NameClassifier(parse);
                JScrollPane scrollPane = new JScrollPane(nameClassifier);
                scrollPane.setVerticalScrollBarPolicy(
                        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                frame.add(scrollPane);
                // nameClassifier has already been added to the scroll pane.
                //frame.getContentPane().add(nameClassifier);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                System.out.println("exiting");
            }
        });

    }

    public void adjustmentValueChanged(AdjustmentEvent e) {
        textField.setText(scrollbar.getValue() + "");
    }

//    public void paint(Graphics g) {
//
//
//
//    }

//        for (int i = 1; i < list.getAllNames().size(); i++) {
//            arrname.add(ny.sencode(list.getAllNames().get(i)).getOG());
//        }
//        int i = 0;



//        g.drawString("Hello World", 25, 50);


    }
