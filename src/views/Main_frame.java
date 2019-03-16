package views;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class Main_frame extends JFrame {

    public static JButton log_out;

    public Main_frame(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new MigLayout("al center, gapy 20"));

        //settings related to all of the frames of this application
        this.getContentPane().setBackground(Color.DARK_GRAY);

        this.setVisible(true);
        this.setSize(1200, 900);
        this.setTitle("Ultra Vision");
        this.setResizable(false);


        this.validate();
        this.repaint();

    }



}
