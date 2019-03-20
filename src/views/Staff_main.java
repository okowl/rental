package views;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class Staff_main extends Main_frame{

    private JTabbedPane client_tabs;
    private JPanel jp1, jp2, jp3, jp4, jp5;



    public JPanel calendar_holder, make_booking_holder; //this two are public because it's easier like this
    // to make everything looks nice, and they hold private fields anyway



    public  Staff_main(){

        super();

        this.setLayout(new MigLayout("al center"));

        this.validate();
        this.repaint();

    }
}
