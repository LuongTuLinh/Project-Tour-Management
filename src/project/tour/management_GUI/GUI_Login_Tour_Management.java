/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.tour.management_GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Login;

/**
 *
 * @author LinhLee
 */
public class GUI_Login_Tour_Management extends JFrame {

    private JPanel panelLogin;
    private JLabel lbIconClose;
    private JLabel lbIconMinimize;

    private JLabel lbLogoAirplane;
    private JLabel lbImageTour_1;
    private JLabel lbImageTour_2;
    private JLabel lbImageTour_3;

    private JLabel lbUsername;
    private JLabel lbPassword;

    private JTextField txtUsername;
    private JPasswordField txtPassword;

    private JSeparator sptUsername;
    private JSeparator sptPassword;

    private JButton btnLogin;


    GUI_Login_Tour_Management() {
        GUI();
    }

    public void GUI() {
        setSize(745, 560);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*---------------------------------Panel Contains All Element--------------------------------------------------*/
        panelLogin = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D graphics2D) {
                    Paint p
                            = new GradientPaint(0.0f, 0.0f, new Color(0, 77, 64, 250),
                                    getWidth(), getHeight(), new Color(0, 105, 92, 180), true);
                    Graphics2D g2d = graphics2D;
                    Graphics2D d = (Graphics2D) g;
                    g2d.setPaint(p);
                    g2d.fillRect(0, 0, getWidth(), getHeight());

                    super.paintComponent(g);
                    Dimension arcs = new Dimension(15, 15);
                    int width = getWidth();
                    int height = getHeight();
                    g2d.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint background
                    g2d.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint border
                } else {
                    super.paintComponent(g);
                }

            }
        };
        panelLogin.setBounds(0, 0, 745, 560);
        panelLogin.setLayout(null);

        //------------Icon Minimize and Icon Close---------------//
        lbIconClose = new JLabel();
        lbIconClose.setBounds(717, 0, 25, 25);
        lbIconClose.setIcon(new ImageIcon(getClass().getResource("/image/icons8_close_window_25px_1.png")));
        lbIconClose.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lbIconMinimize = new JLabel();
        lbIconMinimize.setBounds(690, 0, 25, 25);
        lbIconMinimize.setIcon(new ImageIcon(getClass().getResource("/image/icons8_minimize_window_25px_1.png")));
        lbIconMinimize.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //------------End Icon Minimize and Icon Close---------------//

        //-------------------------Panel Form Login ------------------------------//
        lbLogoAirplane = new JLabel("", JLabel.CENTER);
        lbLogoAirplane.setBounds(420, 25, 250, 190);
        BufferedImage imageLogo;
        try {
            imageLogo = ImageIO.read(new File("logo_airplane.png"));
            ImageIcon icon = new ImageIcon(imageLogo.getScaledInstance(250, 190, BufferedImage.SCALE_SMOOTH));
            lbLogoAirplane.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(GUI_Login_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
        }

        //--------------------USERNAME---------------------//
        lbUsername = new JLabel("Tài khoản(Email)");
        lbUsername.setBounds(420, 250, 100, 20);
        lbUsername.setForeground(Color.WHITE);
        lbUsername.setFont(new Font("Calibri", Font.PLAIN, 14));

        txtUsername = new JTextField("");
        txtUsername.setBounds(420, 267, 260, 25);
        txtUsername.setBorder(null);
        txtUsername.setForeground(Color.WHITE);
        txtUsername.setBackground(new Color(46, 122, 111));
        txtUsername.setCaretColor(Color.WHITE);
        txtUsername.setFont(new Font("Calibri", Font.PLAIN, 17));

        sptUsername = new JSeparator();
        sptUsername.setBounds(420, 295, 260, 10);
        sptUsername.setBackground(Color.WHITE);
        //--------------------END USERNAME---------------------//

        //--------------------PASSWORD---------------------//
        lbPassword = new JLabel("Mật khẩu");
        lbPassword.setBounds(420, 320, 100, 20);
        lbPassword.setForeground(Color.WHITE);
        lbPassword.setFont(new Font("Calibri", Font.PLAIN, 14));

        txtPassword = new JPasswordField("");
        txtPassword.setBounds(420, 340, 260, 25);
        txtPassword.setBorder(null);
        txtPassword.setForeground(Color.WHITE);
        txtPassword.setBackground(new Color(49, 124, 114));
        txtPassword.setCaretColor(Color.WHITE);
        txtPassword.setFont(new Font("Calibri", Font.PLAIN, 17));

        sptPassword = new JSeparator();
        sptPassword.setBounds(420, 368, 260, 10);
        sptPassword.setBackground(Color.WHITE);
        //--------------------END PASSWORD---------------------//

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setBounds(460, 420, 180, 40);
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));


        //---------------------Panel Form Login ------------------------//
        //---------------------Panel Form Login ------------------------//
        lbImageTour_1 = new JLabel("", JLabel.CENTER);
        lbImageTour_1.setBounds(18, 18, 352, 170); //524
        BufferedImage imageTour1;
        try {
            imageTour1 = ImageIO.read(new File("image_panel_login.jpg"));
            ImageIcon iconAir = new ImageIcon(imageTour1.getScaledInstance(352, 170, imageTour1.SCALE_SMOOTH));
            lbImageTour_1.setIcon(iconAir);
        } catch (IOException ex) {
            Logger.getLogger(GUI_Login_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
        }

        lbImageTour_2 = new JLabel("", JLabel.CENTER);
        lbImageTour_2.setBounds(38, 180, 300, 175); //524
        BufferedImage imageTour2;
        try {
            imageTour2 = ImageIO.read(new File("image_panel_login_1.jpg"));
            ImageIcon iconAir = new ImageIcon(imageTour2.getScaledInstance(300, 170, imageTour2.SCALE_SMOOTH));
            lbImageTour_2.setIcon(iconAir);
        } catch (IOException ex) {
            Logger.getLogger(GUI_Login_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbImageTour_3 = new JLabel("", JLabel.CENTER);
        lbImageTour_3.setBounds(18, 355, 352, 185); //524
        BufferedImage imageTour3;
        try {
            imageTour3 = ImageIO.read(new File("image_panel_login_2.jpg"));
            ImageIcon iconAir = new ImageIcon(imageTour3.getScaledInstance(352, 183, imageTour3.SCALE_SMOOTH));
            lbImageTour_3.setIcon(iconAir);
        } catch (IOException ex) {
            Logger.getLogger(GUI_Login_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        //---------------------Panel Form Login ------------------------//
        panelLogin.add(lbIconClose);
        panelLogin.add(lbIconMinimize);
        panelLogin.add(lbLogoAirplane);
        panelLogin.add(lbUsername);
        panelLogin.add(txtUsername);
        panelLogin.add(sptUsername);
        panelLogin.add(lbPassword);
        panelLogin.add(txtPassword);
        panelLogin.add(sptPassword);
        panelLogin.add(btnLogin);

        panelLogin.add(lbImageTour_1);
        panelLogin.add(lbImageTour_2);
        panelLogin.add(lbImageTour_3);
//------------------End Panel Contains All Element------------------------//
        add(panelLogin);
        setVisible(true);

//---------------------------FUNCTION HANDLER BUTTON---------------------//
        lbIconClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        lbIconMinimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setState(JFrame.ICONIFIED);
            }
        });

        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String email = txtUsername.getText();
                String password = txtPassword.getText();

                String input = "{\"email\": \"" + email + "\",\"password\":\"" + password + "\"} ";

                Handle_API_Login login = new Handle_API_Login();
                Handle_API_Login.Login(input, "auth/login", "");
                User_DTO user = new User_DTO();
                if (user.getToken() != null) {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công");

                    GUI_Tour_Management tour_Management = new GUI_Tour_Management();
                    dispose();
                } else {
                    //JOptionPane.showMessageDialog(null, "Đăng nhập thất bại, vui lòng thử lại");
                }

            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    String email = txtUsername.getText();
                    String password = txtPassword.getText();

                    String input = "{\"email\": \"" + email + "\",\"password\":\"" + password + "\"} ";
                    //String input = "{\"email\":\"luongtulinh@gmail.com\",\"password\":\"12345678\"}";
                    Handle_API_Login login = new Handle_API_Login();
                    Handle_API_Login.Login(input, "auth/login","");
                    User_DTO user = new User_DTO();
                    if (user.getToken() != null) {
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công");

                        GUI_Tour_Management tour_Management = new GUI_Tour_Management();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Đăng nhập thất bại, vui lòng thử lại");
                    }
                }
            }
        });
//---------------------------FUNCTION HANDLER BUTTON---------------------//    
    }
}
