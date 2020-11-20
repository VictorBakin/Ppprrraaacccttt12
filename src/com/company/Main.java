package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class PlanetsGUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JMenuBar menuBar;
    private JMenu planets;
    private ArrayList<JMenuItem> planetNames = new ArrayList<>();
    private JMenuItem planetItem;
    private JLabel title;
    private JLabel forceLabel;

    public PlanetsGUI() {

        frame = new JFrame();
        panel = new JPanel();

        frame = new JFrame();
        panel = new JPanel();
        menuBar = new JMenuBar();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menuBar);
        frame.add(panel);

        planets = new JMenu("планеты");
        menuBar.add(planets);

        for (Planet p : Planet.values()) {
            planetItem = new JMenuItem(p.name());
            planetItem.addActionListener(this);
            planets.add(planetItem);
            planetNames.add(planetItem);
        }

        title = new JLabel("гравитационная сила Земли");
        title.setBounds(315,165,200,50);
        panel.add(title);

        forceLabel = new JLabel( Double.toString( Planet.Earth.gravForce() ).substring(0,4) );
        forceLabel.setBounds(380,180,100,50);
        panel.add(forceLabel);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (JMenuItem planetItem : planetNames) {
            if (e.getSource() == planetItem) {
                Planet currPlanet = Planet.valueOf(planetItem.getText());
                title.setText( "гравитационная сила на " + currPlanet.name() );
                forceLabel.setText( Double.toString( currPlanet.gravForce() ).substring(0,4) );
            }
        }
    }
    public static void main(String[] args)  {PlanetsGUI Planet = new PlanetsGUI();}
}