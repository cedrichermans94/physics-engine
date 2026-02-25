package controller;

import model.Cube;
import model.Simulation;
import view.RootView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller {
    private Simulation simulation;
    private RootView view;

    public Controller(Simulation simulation, RootView view) {
        this.simulation = simulation;
        this.view = view;
    }

    public void init() {
        this.simulation.init(this.view.getSimulationView().getHeight());
        this.view.getSimulationView().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                simulation.setVelocity(0);
                int deadSpace = 50;
                if (e.getY() >= deadSpace / 2 &&
                        e.getY() <= view.getSimulationView().getHeight() - (float) deadSpace / 2 - simulation.getScaledCubeSize() &&
                        e.getX() >= deadSpace / 2 &&
                        e.getX() <= view.getSimulationView().getWidth() - (float) deadSpace / 2 - simulation.getScaledCubeSize()) {
                    float relativePosition = simulation.getWorldHeight() - ((float) e.getY() / (view.getSimulationView().getHeight() - (float) deadSpace / 2 - simulation.getScaledCubeSize())) * simulation.getWorldHeight();
                    simulation.setCube(new Cube(e.getX(), e.getY(), simulation.getCubeSize(), relativePosition));
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.view.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'i') {
                    JSplitPane pane = view.getInfoSimulationContainer();
                    boolean isHidden = view.getInfoView().isHidden();
                    Timer timer = new Timer(5, null);
                    timer.addActionListener(e1 -> {
                        int current = pane.getDividerLocation();
                        if (isHidden) {
                            current -= 5;
                            if (current <= pane.getWidth() - 300) {
                                current = pane.getWidth() - 300;
                                timer.stop();
                                view.getInfoView().setHidden(false);
                            }
                        } else {
                            current += 5;
                            if (current >= pane.getWidth()) {
                                current = pane.getWidth();
                                timer.stop();
                                view.getInfoView().setHidden(true);
                            }
                        }
                        pane.setDividerLocation(current);
                    });
                    timer.start();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void start() {
        int ups = 60;
        this.simulation.start();
        long previousTime = System.currentTimeMillis();
        long wait = 0;
        while (this.simulation.isStarted()) {
            long currentTime = System.currentTimeMillis();
            long deltaTime = currentTime - previousTime;
            previousTime = currentTime;
            wait += deltaTime;
            while (wait >= 1000/ups) {
                this.simulation.update(wait);
                this.view.render();
                wait = 0;
            }
        }
    }

    public Simulation getSimulation() {
        return this.simulation;
    }

    public RootView getView() {
        return this.view;
    }
}
