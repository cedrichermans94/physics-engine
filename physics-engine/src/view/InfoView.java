package view;

import javax.swing.*;
import java.awt.*;

public class InfoView extends JPanel {

    public InfoView(RootView rootView) {
        setPreferredSize(new Dimension(300, rootView.getHeight()));
        setBackground(Color.DARK_GRAY);
        JLabel heightLabel = new JLabel("Height: 100");
        heightLabel.setForeground(Color.WHITE);
        add(heightLabel);
    }
}
