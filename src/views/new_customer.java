package views;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class new_customer extends Main_frame {

    private JPasswordField passw, pass_2;
    private JTextField email, phone, first_name, last_name, salon_name;
    private JTextArea address;
    private JButton complete_reg, cancel;


    public new_customer(){

    //title of the window
    JLabel title = new JLabel("<html><span style='color: white;' >Join us now</span></html>", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(32.0f));

    //panel to hold the short form for users
    JPanel user_form = new JPanel(new MigLayout());

    //all labels for each field
    JLabel pass = new JLabel("Password:");
    JLabel pass_c = new JLabel("Confirm password:");
    JLabel l_name = new JLabel("Last name:");
    JLabel f_name = new JLabel("First name:");
    JLabel u_mail = new JLabel("Email:");
    JLabel u_phone = new JLabel("Contact number:");
    JLabel s_name = new JLabel("Salon name:");
    JLabel s_address = new JLabel("Salon address: ");
    JLabel choose = new JLabel("Choose your city:");

    //all fields
    email = new JTextField(50);
    phone = new JTextField(50);
    first_name = new JTextField(50);
    last_name = new JTextField(50);
    salon_name = new JTextField(50);

    address = new JTextArea(4, 54);


    passw = new JPasswordField(54);
    pass_2 = new JPasswordField(54);

    //buttons
    complete_reg = new JButton("Complete");
        complete_reg.setPreferredSize(new Dimension(150, 60));

    cancel = new JButton("Cancel");
        cancel.setPreferredSize(new Dimension(150, 60));


        this.add(title, "grow, wrap");
        this.add(user_form, "wrap");

        //user panel
        user_form.add(f_name);
        user_form.add(first_name, "span, wrap");
        user_form.add(l_name);
        user_form.add(last_name, "span, wrap");
        user_form.add(u_phone);
        user_form.add(phone, "span, wrap");
        user_form.add(u_mail);
        user_form.add(email, "span, wrap");
        user_form.add(pass);
        user_form.add(passw, "span, wrap");
        user_form.add(pass_c);
        user_form.add(pass_2, "span, wrap");

    }

}
