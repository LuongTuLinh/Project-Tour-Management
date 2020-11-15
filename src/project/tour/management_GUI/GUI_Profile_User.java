package project.tour.management_GUI;

import project.tour.management_DTO.User_DTO;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static project.tour.management_GUI.GUI_Tour_Management.signOutAccount;

public class GUI_Profile_User extends JPanel {
    User_DTO user_dto = new User_DTO();

    private JPanel panelProfile;

    private JLabel labelEmailUser;
    private JTextField txtEmailUser;
    private JSeparator sptEmailUser;

    private JLabel labelFirstName;
    private JTextField txtFirstName;
    private JSeparator sptFirstName;

    private JLabel labelLastName;
    private JTextField txtLastName;
    private JSeparator sptLastName;

    private JLabel labelPhoneNumber;
    private JTextField txtPhoneNumber;
    private JSeparator sptPhoneNumber;

    private JButton buttonSignOut;

    public GUI_Profile_User(){
        GUI();
    }
    public void GUI(){
        setLayout(null);
        setBounds(0, 0, 990, 590);
        setBackground(Color.white);

            panelProfile = new JPanel();
            panelProfile.setLayout(null);
            panelProfile.setBounds(200, 110, 500, 300);
            panelProfile.setBackground(Color.white);
            Border borderOfPanelSearchPrice = BorderFactory.createTitledBorder("Thông tin người dùng");
            panelProfile.setBorder(borderOfPanelSearchPrice);

                //**************TEXTFIELD EMAIL USER*******************//
                labelEmailUser = new JLabel("Email:",JLabel.CENTER);
                labelEmailUser.setFont(new Font("Segoe",Font.BOLD,12));
                labelEmailUser.setBounds(65,56,80,30);

                txtEmailUser = new JTextField();
                txtEmailUser.setBounds(145,54,200,30);
                txtEmailUser.setBorder(null);
                txtEmailUser.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                txtEmailUser.setText(user_dto.getEmail());
                txtEmailUser.setEditable(false);

                sptEmailUser = new JSeparator();
                sptEmailUser.setBounds(145,84,200,10);
                sptEmailUser.setBackground(new Color(0,0,0));
                //**************END TEXTFIELD EMAIL USER*******************//

                //**************TEXTFIELD FIRST USER*******************//
                labelFirstName = new JLabel("Họ:",JLabel.CENTER);
                labelFirstName.setFont(new Font("Segoe",Font.BOLD,12));
                labelFirstName.setBounds(65,110,80,30);

                txtFirstName = new JTextField();
                txtFirstName.setBounds(145,108,200,30);
                txtFirstName.setBorder(null);
                txtFirstName.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                txtFirstName.setText(user_dto.getLastName());
                txtFirstName.setEditable(false);

                sptFirstName = new JSeparator();
                sptFirstName.setBounds(145,138,200,10);
                sptFirstName.setBackground(new Color(0,0,0));
                //**************END TEXTFIELD FIRST USER*******************//

                //**************TEXTFIELD FIRST USER*******************//
                labelLastName = new JLabel("Tên:",JLabel.CENTER);
                labelLastName.setFont(new Font("Segoe",Font.BOLD,12));
                labelLastName.setBounds(65,160,80,30);

                txtLastName = new JTextField();
                txtLastName.setBounds(145,158,200,30);
                txtLastName.setBorder(null);
                txtLastName.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                txtLastName.setText(user_dto.getFirstName());
                txtLastName.setEditable(false);

                sptLastName = new JSeparator();
                sptLastName.setBounds(145,188,200,10);
                sptLastName.setBackground(new Color(0,0,0));
                //**************END TEXTFIELD FIRST USER*******************//

                //**************TEXTFIELD LAST NAME*******************//
                labelPhoneNumber = new JLabel("Số điện thoại:",JLabel.CENTER);
                labelPhoneNumber.setFont(new Font("Segoe",Font.BOLD,12));
                labelPhoneNumber.setBounds(50,210,100,30);

                txtPhoneNumber = new JTextField();
                txtPhoneNumber.setBounds(145,208,200,30);
                txtPhoneNumber.setBorder(null);
                txtPhoneNumber.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                txtPhoneNumber.setText(user_dto.getPhoneNumber());
                txtPhoneNumber.setEditable(false);

                sptPhoneNumber = new JSeparator();
                sptPhoneNumber.setBounds(145,238,200,10);
                sptPhoneNumber.setBackground(new Color(0,0,0));
                //**************END TEXTFIELD LAST NAME*******************//

                buttonSignOut = new JButton("Đăng xuất");
                buttonSignOut.setBackground(new Color(149, 148, 142));
                buttonSignOut.setFont(new Font("Segoe",Font.BOLD,13));
                buttonSignOut.setForeground(Color.WHITE);
                buttonSignOut.setBounds(185,260,115,30);
                buttonSignOut.setCursor(new Cursor(Cursor.HAND_CURSOR));

            panelProfile.add(labelEmailUser);
            panelProfile.add(txtEmailUser);
            panelProfile.add(sptEmailUser);

            panelProfile.add(labelFirstName);
            panelProfile.add(txtFirstName);
            panelProfile.add(sptFirstName);

            panelProfile.add(labelLastName);
            panelProfile.add(txtLastName);
            panelProfile.add(sptLastName);

            panelProfile.add(labelPhoneNumber);
            panelProfile.add(txtPhoneNumber);
            panelProfile.add(sptPhoneNumber);

            panelProfile.add(buttonSignOut);

        add(panelProfile);

        buttonSignOut.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                signOutAccount();
            }

            @Override
            public void mousePressed(MouseEvent e) {

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
    }
}
