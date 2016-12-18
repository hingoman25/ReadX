import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by nealsanghvi on 6/26/16.
 */
//
public class NameClassifier extends JPanel {
    HashMap<String, HashMap<String, Integer>> temp;

    NameClassifier(Counter count) {
        super(new GridLayout(0, 1, 2, 2));
        temp = count.getHasher();
        meth();
    }

    public void meth() {
        for (String key : temp.keySet()) {
            HashMap<String, Integer> x = temp.get(key);
            for (String og : x.keySet()) {
                Integer y = x.get(og);
//                    g.drawString(og + " occurs " + y + " time(s) in the set", 25, i);
//                    i += 20;
                add(new JLabel(og + " occurs " + y + " time(s) in the set"));
            }
            add(new JMenuBar());
        }
    }

//            int i = 50;

}

//public class NameClassifier extends JPanel {
//     NameClassifier() {
//            super(new GridLayout(0,1,2,2));
//            for (int ii=1; ii<=100; ii++) {
//                add(new JButton("Button " + ii));
//            }
//        }
//    }

