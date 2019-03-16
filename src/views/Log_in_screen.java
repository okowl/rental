package views;

import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Log_in_screen extends Main_frame{

    //TO DO
    /**
    * Check how automativally change all font in Jframe
    * And set default font color to white
     * Probably will be @override
    * */

    private JTextField email;
    private JPasswordField u_password;
    private JButton log_in;

    public Log_in_screen() {

        super();


        Font f = new Font("Helvetica", Font.PLAIN, 16);

        email = new JTextField(20);
        u_password = new JPasswordField(20);

        log_in = new JButton("Log in");
        log_in.setPreferredSize(new Dimension(150, 60));


        //labels for the text fields
        JLabel details = new JLabel("Enter your details");
        JLabel pass = new JLabel("Password:");
        JLabel u_mail = new JLabel("Email:");

        details.setFont(f);
        pass.setFont(f);
        u_mail.setFont(f);

        details.setForeground(Color.WHITE);
        pass.setForeground(Color.WHITE);
        u_mail.setForeground(Color.WHITE);


        this.add(details, "wrap");

        this.add(u_mail);
        this.add(email, "wrap");
        this.add(pass);
        this.add(u_password, "wrap");

        this.add(log_in);

        this.validate();
        this.repaint();


        //button listener
        //
        log_in.addActionListener(new ActionListener() {
            //redirect to controller
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //controller.check_it(email.getText(), new String(u_password.getPassword()));
            }
        });
    }


}
