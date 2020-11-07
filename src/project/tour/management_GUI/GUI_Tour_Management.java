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
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import project.tour.management_DTO.User_DTO;

/**
 *
 * @author BANANA_TEAM
 */
public class GUI_Tour_Management extends JFrame{
    private User_DTO user = new User_DTO();
    private JLabel labelImageLoading;
    /***********DECLARE JPANE*************/
        private JPanel panelMain;
        private JPanel panelHeader;
        private JPanel panelMenu;
        private static JPanel panelProcessFunction;
    /***********END DECLARE JPANE*************/
        
    /***********DECLARE COMPONENT JPANE HEADER*************/
        private JLabel lbTitle;
        private JLabel lbiconSetting;
        private JLabel lbiconUser;
        private JLabel lbUserName;
        private JLabel lbiconClose;
        private JLabel lbiconMinimize;
        private JSeparator sptAboveLeftInHeader;
        private JSeparator sptUnderLeftInHeader;
        private JSeparator sptAboveRightInHeader;
        private JSeparator sptUnderRightInHeader;
    /***********END DECLARE COMPONENT JPANE HEADER*************/
        
    /***********DECLARE COMPONENT JPANE MENU*************/
        private JLabel lbLogoBanana;
        private JSeparator sptUnderLogo;
        private JLabel labelMenu;
        private JButton btnTourManagement;
        private JButton btnAttractionManagement;
        private JButton btnCategoryManagement;
        private JButton btnCostTypeManagement;
        private JButton btnRoleManagement;
        private JButton btnThongKe;
        
        private JLabel labelSetting;
        private JButton btnUser;
        private JButton btnSetUp;
        private JLabel lbFacebook;
        private JLabel lbInstagram;
        private JLabel lbGmail;
        private JLabel lbDesign;
        private JLabel lbMessenger;
        private JLabel lbFollowUs;
        private JSeparator sptBelowMenu;
    /***********END DECLARE COMPONENT JPANE MENU*************/
    
    public GUI_Tour_Management(){
        init();
        
    }
    public void init(){
      /*------------------------SETUP JFRAME------------------------*/
        setSize(1200, 650);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
      /*-----------------------END SETUP JFRAME-----------------------*/
        
      /*------------------------PANEL MAIN OF JFRAME------------------------*/
        panelMain = new JPanel() ;
        panelMain.setLayout(null);
        panelMain.setBounds(new Rectangle(0,0,1200,650));
        
        /*------------------------PANEL HEADER OF JPANEL MAIN------------------------*/
            panelHeader = new JPanel();
            panelHeader.setBounds(200,0,1000,40);
            panelHeader.setLayout(null);
            panelHeader.setBackground(new Color(255,255,255));
                
                lbTitle = new JLabel("QUẢN LÝ TOUR DU LỊCH");
                lbTitle.setBounds(250,7,250,25);
                lbTitle.setForeground(new Color(102,102,102));
                lbTitle.setFont(new Font("Times New Roman",1,18));
            
                lbiconSetting = new JLabel();
                lbiconSetting.setBounds(740,7,25,25);
                lbiconSetting.setIcon(new ImageIcon(getClass().getResource("/image/icons8_settings_25px.png")));

                lbiconUser = new JLabel();
                lbiconUser.setBounds(785,7,25,25);
                lbiconUser.setIcon(new ImageIcon(getClass().getResource("/image/icons8_user_male_circle_filled_25px.png")));

                lbUserName = new JLabel("LinhLee");
                lbUserName.setText(user.getFirstName().toUpperCase()+" "+user.getLastName().toUpperCase());
                lbUserName.setBounds(820,7,100,25);
                lbUserName.setForeground(new Color(102,102,102));

                lbiconClose = new JLabel();
                lbiconClose.setBounds(968,7,25,25);
                lbiconClose.setIcon(new ImageIcon(getClass().getResource("/image/icons8_close_window_25px.png")));
                lbiconClose.setCursor(new Cursor(Cursor.HAND_CURSOR));

                lbiconMinimize = new JLabel();
                lbiconMinimize.setBounds(938,7,25,25);
                lbiconMinimize.setIcon(new ImageIcon(getClass().getResource("/image/icons8_minimize_window_25px.png")));
                lbiconMinimize.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                sptAboveLeftInHeader = new JSeparator();
                sptAboveLeftInHeader.setBounds(30,12,150,10);
                sptAboveLeftInHeader.setBackground(new Color(38,50,56));
                
                sptUnderLeftInHeader = new JSeparator();
                sptUnderLeftInHeader.setBounds(30,27,210,10);
                sptUnderLeftInHeader.setBackground(new Color(38,50,56));
                
                sptAboveRightInHeader = new JSeparator();
                sptAboveRightInHeader.setBounds(545,12,170,10);
                sptAboveRightInHeader.setBackground(new Color(38,50,56));
                
                sptUnderRightInHeader = new JSeparator();
                sptUnderRightInHeader.setBounds(485,27,230,10);
                sptUnderRightInHeader.setBackground(new Color(38,50,56));
                
            /********** ADD FOR JPANEL HEADER ************/
                panelHeader.add(lbTitle);
                panelHeader.add(lbiconSetting);
                panelHeader.add(lbiconUser);
                panelHeader.add(lbUserName);
                panelHeader.add(lbiconClose);
                panelHeader.add(lbiconMinimize);
                
                panelHeader.add(sptAboveLeftInHeader);
                panelHeader.add(sptUnderLeftInHeader);
                panelHeader.add(sptAboveRightInHeader);
                panelHeader.add(sptUnderRightInHeader);
            /********** END ADD FOR JPANEL HEADER ************/
            
        /*----------------------END PANEL HEADER OF JPANEL MAIN------------------------*/
        
            
        /*----------------------PANEL MENU OF JPANEL MAIN------------------------*/
            panelMenu = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {               
                   Paint p =
                      new GradientPaint(0.0f, 0.0f, new Color(0,77,64, 250),
                      getWidth(), getHeight(), new Color(0,105,92, 180), true);
                   Graphics2D g2d = (Graphics2D)g;
                   g2d.setPaint(p);
                   g2d.fillRect(0, 0, getWidth(), getHeight());
                   
                    super.paintComponent(g);
                    Dimension arcs = new Dimension(15,15);
                    int width = getWidth();
                    int height = getHeight();
                    g2d.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
                    g2d.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
                } else {
                   super.paintComponent(g);
                }
                
            }};
            panelMenu.setBounds(0,0,200,650);
            panelMenu.setLayout(null);
                
                lbLogoBanana = new JLabel("",JLabel.CENTER);
                lbLogoBanana.setBounds(10,-20,150,150);
                    BufferedImage image;
                    try {
                        image = ImageIO.read(new File("logo_banana.png"));
                        ImageIcon icon = new ImageIcon(image.getScaledInstance(150, 200, image.SCALE_SMOOTH));
                        lbLogoBanana.setIcon(icon);
                    } catch (IOException ex) {
                        java.util.logging.Logger.getLogger(GUI_Tour_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                
                sptUnderLogo = new JSeparator();
                sptUnderLogo.setBounds(20,130,160,10);
                sptUnderLogo.setBackground(new Color(255,255,255));
                
                labelMenu = new JLabel("Menu");
                labelMenu.setBounds(5,180,100,10);
                labelMenu.setForeground(new Color(255,255,255));

                btnTourManagement = new JButton("  Quản Lý Tours     ");
                btnTourManagement.setBackground(new Color(12, 109, 102));
                btnTourManagement.setBounds(5,200,190,30);
                btnTourManagement.setForeground(new Color(255,255,255));
                btnTourManagement.setIcon(new ImageIcon(getClass().getResource("/image/icons8_compass_20px.png")));
                btnTourManagement.setFont(new Font("Times New Roman",1,14));
                btnTourManagement.setHorizontalAlignment(SwingConstants.CENTER);
                btnTourManagement.setBorder(null);
                btnTourManagement.setFocusPainted(false);
                btnTourManagement.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnAttractionManagement = new JButton(" Quản Lý Địa Điểm ");
                btnAttractionManagement.setBackground(new Color(12, 109, 102));
                btnAttractionManagement.setBounds(5,230,190,30);
                btnAttractionManagement.setForeground(new Color(255,255,255));
                btnAttractionManagement.setIcon(new ImageIcon(getClass().getResource("/image/icons8_around_the_globe_filled_20px.png")));
                btnAttractionManagement.setFont(new Font("Times New Roman",1,14));
                btnAttractionManagement.setHorizontalAlignment(SwingConstants.CENTER);
                btnAttractionManagement.setBorder(null);
                btnAttractionManagement.setFocusPainted(false);
                btnAttractionManagement.setCursor(new Cursor(Cursor.HAND_CURSOR));

                btnCategoryManagement = new JButton(" Quản Lý Thể Loại ");
                btnCategoryManagement.setBackground(new Color(12, 109, 102));
                btnCategoryManagement.setBounds(5,260,190,30);
                btnCategoryManagement.setForeground(new Color(255,255,255));
                btnCategoryManagement.setIcon(new ImageIcon(getClass().getResource("/image/icons8_checklist_20px.png")));
                btnCategoryManagement.setFont(new Font("Times New Roman",1,14));
                btnCategoryManagement.setHorizontalAlignment(SwingConstants.CENTER);
                btnCategoryManagement.setBorder(null);
                btnCategoryManagement.setFocusPainted(false);
                btnCategoryManagement.setCursor(new Cursor(Cursor.HAND_CURSOR));

                btnCostTypeManagement = new JButton("  Quản Lý Chi Phí  ");
                btnCostTypeManagement.setBackground(new Color(12, 109, 102));
                btnCostTypeManagement.setBounds(5,290,190,30);
                btnCostTypeManagement.setForeground(new Color(255,255,255));
                btnCostTypeManagement.setIcon(new ImageIcon(getClass().getResource("/image/icons8_coin_in_hand_20px.png")));
                btnCostTypeManagement.setFont(new Font("Times New Roman",1,14));
                btnCostTypeManagement.setHorizontalAlignment(SwingConstants.CENTER);
                btnCostTypeManagement.setBorder(null);
                btnCostTypeManagement.setFocusPainted(false);
                btnCostTypeManagement.setCursor(new Cursor(Cursor.HAND_CURSOR));

                btnRoleManagement = new JButton("Quản Lý Nhiệm Vụ ");
                btnRoleManagement.setBackground(new Color(12, 109, 102));
                btnRoleManagement.setBounds(5,320,190,30);
                btnRoleManagement.setForeground(new Color(255,255,255));
                btnRoleManagement.setIcon(new ImageIcon(getClass().getResource("/image/icons8_passenger_with_baggage_20px.png")));
                btnRoleManagement.setFont(new Font("Times New Roman",1,14));
                btnRoleManagement.setHorizontalAlignment(SwingConstants.CENTER);
                btnRoleManagement.setBorder(null);
                btnRoleManagement.setFocusPainted(false);
                btnRoleManagement.setCursor(new Cursor(Cursor.HAND_CURSOR));

                btnThongKe = new JButton("  Thống Kê              ");
                btnThongKe.setBackground(new Color(12, 109, 102));
                btnThongKe.setBounds(5,350,190,30);
                btnThongKe.setForeground(new Color(255,255,255));
                btnThongKe.setIcon(new ImageIcon(getClass().getResource("/image/icons8_bullish_20px.png")));
                btnThongKe.setFont(new Font("Times New Roman",1,14));
                btnThongKe.setHorizontalAlignment(SwingConstants.CENTER);
                btnThongKe.setBorder(null);
                btnThongKe.setFocusPainted(false);
                btnThongKe.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                /********** TINH NANG THEM *********/
                /********** TINH NANG THEM *********/
                /********** TINH NANG THEM *********/
                /********** TINH NANG THEM *********/
                
                labelSetting = new JLabel("CMS Setting");
                labelSetting.setBounds(5,460,200,14);
                labelSetting.setForeground(new Color(255,255,255));

                btnUser = new JButton(" Người dùng   ");
                btnUser.setBackground(new Color(42, 127, 118));
                btnUser.setBounds(5,480,190,30);
                btnUser.setForeground(new Color(255,255,255));
                btnUser.setIcon(new ImageIcon(getClass().getResource("/image/icons8_user_male_circle_filled_20px.png")));
                btnUser.setFont(new Font("Times New Roman",1,14));
                btnUser.setHorizontalAlignment(SwingConstants.CENTER);
                btnUser.setBorder(null);
                btnUser.setFocusPainted(false);
                btnUser.setCursor(new Cursor(Cursor.HAND_CURSOR));

                btnSetUp = new JButton("  Thiết Lập     ");
                btnSetUp.setBackground(new Color(42, 127, 118));
                btnSetUp.setBounds(5,510,190,30);
                btnSetUp.setForeground(new Color(255,255,255));
                btnSetUp.setIcon(new ImageIcon(getClass().getResource("/image/icons8_settings_20px.png")));
                btnSetUp.setFont(new Font("Times New Roman",1,14));
                btnSetUp.setHorizontalAlignment(SwingConstants.CENTER);
                btnSetUp.setBorder(null);
                btnSetUp.setFocusPainted(false);
                btnSetUp.setCursor(new Cursor(Cursor.HAND_CURSOR));


                sptBelowMenu = new JSeparator();
                sptBelowMenu.setBounds(20,550,160,10);
                sptBelowMenu.setBackground(new Color(255,255,255));

                lbFollowUs = new JLabel("Follow Us");
                lbFollowUs.setBounds(5,560,100,10);
                lbFollowUs.setForeground(new Color(255,255,255));

                lbFacebook = new JLabel();
                lbFacebook.setBounds(45,580,20,20);
                lbFacebook.setIcon(new ImageIcon(getClass().getResource("/image/icons8_Facebook_Old_20px.png")));

                lbInstagram = new JLabel();
                lbInstagram.setBounds(75,580,20,20);
                lbInstagram.setIcon(new ImageIcon(getClass().getResource("/image/icons8_instagram_new_20px.png")));

                lbMessenger = new JLabel();
                lbMessenger.setBounds(105,580,20,20);
                lbMessenger.setIcon(new ImageIcon(getClass().getResource("/image/icons8_facebook_messenger_20px.png")));

                lbGmail = new JLabel();
                lbGmail.setBounds(135,580,20,20);
                lbGmail.setIcon(new ImageIcon(getClass().getResource("/image/icons8_google_plus_20px.png")));

                lbDesign = new JLabel("---Design by Banana Team---",JLabel.CENTER);
                lbDesign.setBounds(0,610,200,30);
                //lbDesign.setFont(new Font("Times New Roman",1,12));
                lbDesign.setForeground(Color.WHITE);
            
            /********** ADD FOR JPANEL MENU *********/
                panelMenu.add(lbLogoBanana);
                panelMenu.add(sptUnderLogo);
                panelMenu.add(labelMenu);
                panelMenu.add(btnTourManagement);
                panelMenu.add(btnAttractionManagement);
                panelMenu.add(btnCategoryManagement);
                panelMenu.add(btnCostTypeManagement);
                panelMenu.add(btnRoleManagement);
                panelMenu.add(btnThongKe);
                
                panelMenu.add(labelSetting);
                panelMenu.add(btnSetUp);
                panelMenu.add(btnUser);
                panelMenu.add(lbFollowUs);
                panelMenu.add(lbFacebook);
                panelMenu.add(lbInstagram);
                panelMenu.add(lbMessenger);
                panelMenu.add(lbGmail);
                panelMenu.add(lbDesign);
                panelMenu.add(sptBelowMenu);
            /********** END ADD FOR JPANEL MENU ************/
                
        /*----------------------PANEL MENU OF JPANEL MAIN------------------------*/
        
        /*----------------------PANEL PROCESSING FUNCTIONS OF JPANEL MAIN------------------------*/
            panelProcessFunction = new JPanel();
            panelProcessFunction.setLayout(null);
            panelProcessFunction.setBounds(205, 50, 990, 590);
            panelProcessFunction.setBackground(Color.white);
                labelImageLoading = new JLabel("",JLabel.CENTER);
                labelImageLoading.setBounds(340,120,250,250);
                ImageIcon imageIconLoading =
                new ImageIcon(GUI_Tour_Management.this.getClass().getResource("/image/Loading.gif"));
                labelImageLoading.setIcon(imageIconLoading);
            
        /*----------------------END PANEL PROCESSING FUNCTIONS OF JPANEL MAIN------------------------*/
        
        /********** ADD FOR JPANEL MAIN ************/
            panelMain.add(panelHeader);
            panelMain.add(panelMenu);
            panelMain.add(panelProcessFunction);
        /********** ADD FOR JPANEL MAIN ************/
      /*------------------------END PANEL MAIN OF JFRAME------------------------*/
        
      /********** ADD FOR JFRAME ************/
        add(panelMain);
      /********** END ADD FOR JFRAME ************/
        setVisible(true);
        
      /*------------------------HANDLE EVENT ONCLICK MOUSE------------------------*/
        /********** HANDLE SET COLOR FOR BUTTON ************/
            btnTourManagement.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    btnTourManagement.setBackground(new Color(25, 172, 158));
                }
                @Override
                public void mouseExited(MouseEvent e){
                    btnTourManagement.setBackground(new Color(12, 109, 102));
                }
                @Override
                public void mouseClicked(MouseEvent e){
                    panelProcessFunction.removeAll();
                    panelProcessFunction.add(new GUI_Table_Tour_Management());
                    repaint();
//                    try {
//                        for(int i = 0; i <= 100; i++){
//                            Thread.sleep(40);
//                            if(i == 100){
//                                panelProcessFunction.removeAll();
//                                panelProcessFunction.add(new Handle_Tour_Management());
//                                repaint();
//                            }
//                        }
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                }
            });

            btnAttractionManagement.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    panelProcessFunction.removeAll();
                    panelProcessFunction.add(new GUI_Attraction_Management());
                    repaint();
                }
                 @Override
                public void mouseEntered(MouseEvent e){
                     btnAttractionManagement.setBackground(new Color(25, 172, 158));
                }
                @Override
                public void mouseExited(MouseEvent e){
                    btnAttractionManagement.setBackground(new Color(12, 109, 102));
                }
            });

            btnCategoryManagement.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    panelProcessFunction.removeAll();
                    panelProcessFunction.add(new GUI_Category_Management());
                    repaint();
                }
                @Override
                public void mouseEntered(MouseEvent e){
                    btnCategoryManagement.setBackground(new Color(25, 172, 158));
                }
                @Override
                public void mouseExited(MouseEvent e){
                    btnCategoryManagement.setBackground(new Color(12, 109, 102));
                }
            });

            btnCostTypeManagement.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    panelProcessFunction.removeAll();
                    panelProcessFunction.add(new GUI_Cost_Type_Management());
                    validate();
                    repaint();
                }
                @Override
                public void mouseEntered(MouseEvent e){
                    btnCostTypeManagement.setBackground(new Color(25, 172, 158));
                }
                @Override
                public void mouseExited(MouseEvent e){
                    btnCostTypeManagement.setBackground(new Color(12, 109, 102));
            }
            });

            btnRoleManagement.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    panelProcessFunction.removeAll();
                    panelProcessFunction.add(new GUI_RoleGroup_Management());
                    validate();
                    repaint();
                }
                @Override
                public void mouseEntered(MouseEvent e){
                    btnRoleManagement.setBackground(new Color(25, 172, 158));
                }
                @Override
                public void mouseExited(MouseEvent e){
                    btnRoleManagement.setBackground(new Color(12, 109, 102));
                }
            });

            btnThongKe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                panelProcessFunction.removeAll();
                panelProcessFunction.add(new GUI_Statistical_Tour());
                validate();
                repaint();
            }
            @Override
            public void mouseEntered(MouseEvent e){
                btnThongKe.setBackground(new Color(25, 167, 159));
            }
            @Override
            public void mouseExited(MouseEvent e){
                btnThongKe.setBackground(new Color(12, 109, 102));
            }
        });
            
        /********** END HANDLE SET COLOR FOR BUTTON ************/
        
        /********** HANDLE ONCLICK CLOSE AND MINIMIZE PROGRAME ************/
            lbiconClose.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.exit(0);
                }
            });
            
            lbiconMinimize.addMouseListener(new MouseAdapter(){
               @Override
               public void mouseClicked(MouseEvent e) {
                   setState(JFrame.ICONIFIED);
               } 
            });
        /********** END HANDLE ONCLICK CLOSE AND MINIMIZE PROGRAME ************/
      /*------------------------END HANDLE EVENT ONCLICK MOUSE------------------------*/
    }
    public static void removeAllAndAddNewPanel(JPanel panel){
        panelProcessFunction.removeAll();
        panelProcessFunction.add(panel);
        panelProcessFunction.validate();
        panelProcessFunction.repaint();
    }
}
