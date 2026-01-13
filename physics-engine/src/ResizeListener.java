import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class ResizeListener implements ComponentListener {
    JPanel panel;

    public ResizeListener(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        SimulationPanel panel = (SimulationPanel) e.getComponent();
        panel.recalculateScale();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
