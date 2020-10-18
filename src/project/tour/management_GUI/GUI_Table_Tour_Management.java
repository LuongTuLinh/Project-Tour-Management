/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.tour.management_GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Get_Tour;
import project.tour.management_Handle_API.Handle_API_Tour_Id;

/**
 *
 * @author DELL
 */
public class GUI_Table_Tour_Management extends JPanel{
    /*************DECLARE JPANEL********************/
        private JPanel panelHeader;
        private JPanel panelContent;
        private JPanel panelButtonHandleTour;

    /*************END DECLARE JPANEL********************/
        
    /*************DECLARE ELEMENT JPANEL HEADER********************/
        private JLabel labelSearch;
        private JLabel lbIconSearch;
        private JTextField txtSearch;
        private JComboBox<String> comboBoxCategoryTour;
        private JComboBox<String> comboBoxCharacteristicsTour;
        private JComboBox<String> comboBoxPriceTour;
    /*************END DECLARE ELEMENT JPANEL HEADER********************/
        
    /*************DECLARE ELEMENT JPANEL PANEL BUTTON HANDLE TOUR********************/
        private JButton btnEditTour;
        private JButton btnDeleteTour;
        private JButton btnAddTour;
        private JButton btnSaveTour;
    /*************END DECLARE ELEMENT JPANEL PANEL BUTTON HANDLE TOUR********************/
        
    /*************DECLARE ELEMENT JPANEL CONTENT********************/
        private JTable tableTour;
        private DefaultTableModel modelTable;
        private JScrollPane scrollPane;
    /*************DECLARE ELEMENT JPANEL CONTENT********************/
    public GUI_Table_Tour_Management(){
        init();
    }
    public void init(){
        setLayout(null);
        setBounds(0, 0, 990, 590);
        setBackground(Color.white);
        
          /*------------------------PANEL HEADER INCLUDE BUTTON AND SEARCH-----------------------------*/
            panelHeader = new JPanel();
            panelHeader.setLayout(null);
            panelHeader.setBounds(5, 10, 980, 70);
            panelHeader.setBackground(Color.white);
                Border blackline = BorderFactory.createTitledBorder("Tìm kiếm");
            panelHeader.setBorder(blackline);
            
                labelSearch = new JLabel("Tìm kiếm:");
                labelSearch.setBounds(30,19,80,25);

                txtSearch = new JTextField();
                txtSearch.setBounds(95,19,250,25);

                lbIconSearch = new JLabel();
                lbIconSearch.setBounds(360,18,25,25);
                lbIconSearch.setIcon(new ImageIcon(getClass().getResource("/image/icons8_Search_in_Browser_25px.png")));
                
                comboBoxCategoryTour = new JComboBox<>();
                comboBoxCategoryTour.setModel(new DefaultComboBoxModel<>(new String [] {
                    "Tour nước ngoài","Tên Tour"}));
                comboBoxCategoryTour.setBounds(420,16,130,30);
                comboBoxCategoryTour.setFont(new Font("Segoe",Font.BOLD,13));
                
                comboBoxCharacteristicsTour = new JComboBox<>();
                comboBoxCharacteristicsTour.setModel(new DefaultComboBoxModel<>(new String [] {
                    "Tour nước ngoài","Tour nước ngoài"}));
                comboBoxCharacteristicsTour.setBounds(620,16,130,30);
                comboBoxCharacteristicsTour.setFont(new Font("Segoe",Font.BOLD,13));
                
                comboBoxPriceTour = new JComboBox<>();
                comboBoxPriceTour.setModel(new DefaultComboBoxModel<>(new String [] {
                    "Tour nước ngoài","Đang Mở"}));
                comboBoxPriceTour.setBounds(810,16,130,30);
                comboBoxPriceTour.setFont(new Font("Segoe",Font.BOLD,13));
            /****************ADD ELEMENT FOR PANEL HEADER***********************/
                panelHeader.add(labelSearch);
                panelHeader.add(txtSearch);
                panelHeader.add(lbIconSearch);
                panelHeader.add(comboBoxCategoryTour);
                panelHeader.add(comboBoxCharacteristicsTour);
                panelHeader.add(comboBoxPriceTour);
            /***************END ADD ELEMENT FOR PANEL HEADER**********************/
          
          /*------------------------END PANEL HEADER INCLUDE BUTTON AND SEARCH-----------------------------*/
          
          /*------------------------PANEL BUTTON HANDLE TOUR(ADD, EDIT, DELETE, SAVE)-----------------------------*/
            panelButtonHandleTour = new JPanel();
            panelButtonHandleTour.setLayout(null);
            panelButtonHandleTour.setBounds(390, 90, 590, 70);
            panelButtonHandleTour.setBackground(Color.white);
                Border borderPanelButton = BorderFactory.createTitledBorder("Xử lý tour");
            panelButtonHandleTour.setBorder(borderPanelButton);
            
            
                btnEditTour = new JButton("Sửa Tour");
                btnEditTour.setBackground(new Color(239, 198, 74));
                btnEditTour.setFont(new Font("Segoe",Font.BOLD,13));
                btnEditTour.setForeground(Color.WHITE);
                btnEditTour.setBounds(20,20,115,30); 
                btnEditTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

                btnDeleteTour = new JButton("Xoá Tour");
                btnDeleteTour.setBackground(new Color(219, 50, 54));
                btnDeleteTour.setFont(new Font("Segoe",Font.BOLD,13));
                btnDeleteTour.setForeground(Color.WHITE);
                btnDeleteTour.setBounds(160,20,115,30); 
                btnDeleteTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

                btnAddTour = new JButton("Thêm Tour");
                btnAddTour.setBackground(new Color(41, 149, 85));
                btnAddTour.setFont(new Font("Segoe",Font.BOLD,13));
                btnAddTour.setForeground(Color.WHITE);
                btnAddTour.setBounds(310,20,115,30); 
                btnAddTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

                btnSaveTour = new JButton("Làm mới");
                btnSaveTour.setBackground(new Color(32, 171, 214));
                btnSaveTour.setFont(new Font("Segoe",Font.BOLD,13));
                btnSaveTour.setForeground(Color.WHITE);
                btnSaveTour.setBounds(450,20,115,30); 
                btnSaveTour.setCursor(new Cursor(Cursor.HAND_CURSOR));
            /****************ADD ELEMENT FOR PANEL BUTTON HANDLE TOUR***********************/
                panelButtonHandleTour.add(btnEditTour);
                panelButtonHandleTour.add(btnDeleteTour);
                panelButtonHandleTour.add(btnAddTour);
                panelButtonHandleTour.add(btnSaveTour);
            /****************END ADD ELEMENT FOR PANEL BUTTON HANDLE TOUR***********************/
          /*------------------------END PANEL BUTTON HANDLE TOUR(ADD, EDIT, DELETE, SAVE)-----------------------------*/
          
          /*------------------------PANEL CONTENT INCLUDE TABLE TOURS MANAGEMENT-----------------------------*/
            panelContent = new JPanel();
            panelContent.setLayout(null);
            panelContent.setBackground(Color.white);
            panelContent.setBounds(0, 175, 990, 420);
                
            LoadDataTable();
            
                tableTour.setRowHeight(25);
                tableTour.setSelectionBackground(new java.awt.Color(0,105,92, 180));
                tableTour.getTableHeader().setReorderingAllowed(false);
                tableTour.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
                tableTour.getTableHeader().setOpaque(false);
                tableTour.getTableHeader().setBackground(new Color(0,77,64));
                tableTour.getTableHeader().setForeground(new Color(255,255,255));
                tableTour.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                
                DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
                rightRenderer.setHorizontalAlignment(JLabel.CENTER);
                
                /****************SET SIZE COLUMN OF TABLE***********************/
                tableTour.getColumnModel().getColumn(0).setPreferredWidth(100);
                tableTour.getColumnModel().getColumn(1).setPreferredWidth(550);
                tableTour.getColumnModel().getColumn(2).setPreferredWidth(130);
                tableTour.getColumnModel().getColumn(3).setPreferredWidth(80);
                tableTour.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
                tableTour.getColumnModel().getColumn(4).setPreferredWidth(95);
                /****************SET SIZE COLUMN OF TABLE***********************/

                tableTour.setFont(new Font("Times New Roman",Font.PLAIN,15));

                scrollPane = new JScrollPane(tableTour);
                scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                    @Override
                    protected void configureScrollBarColors() {
                        this.thumbColor = new Color(19, 113, 106);
                    }
                });
                scrollPane.setBounds(20,0,955,400);
                
            /****************ADD ELEMENT FOR PANEL CONTENT**************************/
                panelContent.add(scrollPane);
            /***************END ADD ELEMENT FOR PANEL CONTENT*************************/
          /*------------------------END PANEL CONTENT INCLUDE TABLE TOURS MANAGEMENT-----------------------------*/
            
        /*******************ADD ELEMENT FOR PANEL MAIN***********************/
            add(panelHeader);
            add(panelContent);
            add(panelButtonHandleTour);
            
        /******************END ADD ELEMENT FOR PANEL MAIN************************/
        
        /*------------------------HANDLE EVENT ONCLICK MOUSE BUTTON-----------------------------*/
            btnEditTour.addMouseListener(new MouseAdapter() {
                @Override
                    public void mouseClicked(MouseEvent e){
                        int row = tableTour.getSelectedRow();

                        if(row == -1)
                        {
                            JOptionPane.showMessageDialog(null, "Vui lòng chọn Tour cần sửa");
                        }
                        else
                        {
                            String tourId = (tableTour.getModel().getValueAt(row, 0).toString());
                            Handle_API_Tour_Id tour = new Handle_API_Tour_Id();
                            User_DTO user = new User_DTO();
                            Handle_API_Tour_Id.Fetch_API_Tour_Id("tours/"+tourId, user.getToken());
                            removeAll();
                            add(new GUI_Edit_Tour());
                            repaint();
                        }
                    }
            });
            
            btnSaveTour.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    LoadDataTable();
                }
            });
            
            btnAddTour.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    removeAll();
                    add(new GUI_Add_Tour());
                    repaint();
                }
            });
        /*------------------------END HANDLE EVENT ONCLICK MOUSE BUTTON-----------------------------*/
    }
    
    public void LoadDataTable(){
                Handle_API_Get_Tour api_tour = new Handle_API_Get_Tour();
                User_DTO user = new User_DTO();
                JSONArray json = new JSONArray(Handle_API_Get_Tour.Fetch_API_Tour("tours?Page=1&Limit=100", user.getToken()));
                Vector<Vector<String>> dataList = new Vector<>();
                for (int i = 0; i < json.length(); i++) {

                    JSONObject jsonObj;
                    try {
                        jsonObj = json.getJSONObject(i);
                        Vector<String> data = new Vector<>();

                        data.add(jsonObj.get("id").toString());
                        data.add(jsonObj.get("name").toString());
                        data.add(jsonObj.get("tourCategoryId").toString());
                        data.add(jsonObj.get("status").toString());
                        data.add(jsonObj.get("price").toString());

                        dataList.add(data);
                    } catch (JSONException ex) {
                        Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                Vector<String> columnNames = new Vector<>();
                columnNames.add("Mã Tour");
                columnNames.add("Tên Tour");
                columnNames.add("Loại Tour");
                columnNames.add("Trạng Thái");
                columnNames.add("Giá Tour");

                 tableTour = new JTable(dataList, columnNames);
          }
}
