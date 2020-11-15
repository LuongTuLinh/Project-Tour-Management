package project.tour.management_GUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import project.tour.management_API.APIRequester;
import project.tour.management_DTO.Tour_Category_DTO;
import project.tour.management_DTO.Tour_DTO;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Get_Tour;
import project.tour.management_Handle_API.Handle_API_Tour_Category;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

import static project.tour.management_GUI.GUI_Table_Tour_Management.LoadDataTable;

public class GUI_Add_New_Tour extends JFrame {
    Tour_DTO tour_dto;

    private JPanel panelAddNewTour;

    private JSeparator sptAboveLeftInHeader;
    private JSeparator sptUnderLeftInHeader;
    private JSeparator sptAboveRightInHeader;
    private JSeparator sptUnderRightInHeader;
    private JLabel lbTitle;

    private JLabel labelNameTour;
    private JTextField txtNameTour;
    private JSeparator sptNameTour;
    private JLabel labelVND;

    private JLabel labelPriceTour;
    private JTextField txtPriceTour;
    private JSeparator sptPriceTour;

    private JLabel labelSpecification;
    private JTextArea textAreaDescription;
    private JScrollPane scrollPaneDescription;

    private JLabel labelCategoryTour;
    private static JComboBox<Tour_Category_DTO> comboBoxCategoryTour;

    private JButton buttonSaveNewTour;
    private JButton buttonClearField;

    public GUI_Add_New_Tour(){
        GUI();
    }
    public void GUI(){
        setSize(450, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
            /************************************ PANEL ADD NEW TOUR **************************************/
                panelAddNewTour = new JPanel();
                panelAddNewTour.setLayout(null);
                panelAddNewTour.setBackground(Color.white);
                panelAddNewTour.setBounds(0,1, 450, 499);

                    sptAboveLeftInHeader = new JSeparator();
                    sptAboveLeftInHeader.setBounds(10,12,120,10);
                    sptAboveLeftInHeader.setBackground(new Color(23, 23, 23));

                    sptUnderLeftInHeader = new JSeparator();
                    sptUnderLeftInHeader.setBounds(10,27,80,10);
                    sptUnderLeftInHeader.setBackground(new Color(23, 23, 23));

                    sptAboveRightInHeader = new JSeparator();
                    sptAboveRightInHeader.setBounds(310,12,120,10);
                    sptAboveRightInHeader.setBackground(new Color(23, 23, 23));

                    sptUnderRightInHeader = new JSeparator();
                    sptUnderRightInHeader.setBounds(350,27,80,10);
                    sptUnderRightInHeader.setBackground(new Color(23, 23, 23));

                    lbTitle = new JLabel("THÊM TOUR");
                    lbTitle.setBounds(160,18,150,25);
                    lbTitle.setForeground(new Color(75, 165, 12));
                    lbTitle.setFont(new Font("Times New Roman",1,18));

                    /*========================= TEXTFIELD NAME TOUR ========================*/
                    labelNameTour = new JLabel("TÊN TOUR :",JLabel.CENTER);
                    labelNameTour.setFont(new Font("Segoe",Font.BOLD,12));
                    labelNameTour.setBounds(5,50,80,30);

                    txtNameTour = new JTextField();
                    txtNameTour.setBounds(90,48,300,30);
                    txtNameTour.setBorder(null);
                    txtNameTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

                    sptNameTour = new JSeparator();
                    sptNameTour.setBounds(90,78,300,10);
                    sptNameTour.setBackground(new Color(0,0,0));
                    /*=========================END TEXTFIELD NAME TOUR ================*/

                    /*========================= TEXTFIELD PRICE TOUR ===================*/
                    labelPriceTour = new JLabel("GIÁ TOUR :",JLabel.CENTER);
                    labelPriceTour.setFont(new Font("Segoe",Font.BOLD,12));
                    labelPriceTour.setBounds(5,100,80,30);

                    txtPriceTour = new JTextField();
                    txtPriceTour.setBounds(90,98,90,30);
                    //txtPriceTour.setBorder(null);
                    txtPriceTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

                    labelVND = new JLabel(" VND",JLabel.CENTER);
                    labelVND.setFont(new Font("Segoe",Font.BOLD,12));
                    labelVND.setBounds(180,100,30,30);

                    sptPriceTour = new JSeparator();
                    sptPriceTour.setBounds(90,128,120,10);
                    sptPriceTour.setBackground(new Color(0,0,0));
                    /*========================= END TEXTFIELD PRICE TOUR ===================*/

                    //=========================COMBOBOX CATEGORY TOUR=========================//
                    labelCategoryTour = new JLabel("THỂ LOẠI:",JLabel.CENTER);
                    labelCategoryTour.setFont(new Font("Segoe",Font.BOLD,12));
                    labelCategoryTour.setBounds(5,166,80,30);

                    comboBoxCategoryTour = new JComboBox<>();
                    loadCategoryTourComboBox();

                    comboBoxCategoryTour.setBounds(90,160,150,30);
                    comboBoxCategoryTour.setFont(new Font("Segoe",Font.BOLD,13));
                    //=====================END COMBOBOX CATEGORY TOUR=====================//

                    labelSpecification = new JLabel("MÔ TẢ ĐỊA ĐIỂM :",JLabel.CENTER);
                    labelSpecification.setFont(new Font("Segoe",Font.BOLD,12));
                    labelSpecification.setBounds(5,210,120,30);

                    textAreaDescription = new JTextArea(10, 10);
                    textAreaDescription.setLineWrap(true);
                    textAreaDescription.setWrapStyleWord(true);
                    textAreaDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    textAreaDescription.setFont(new Font("Arial, Helvetica, sans-serif", Font.PLAIN, 14));

                    scrollPaneDescription = new JScrollPane(textAreaDescription);
                    scrollPaneDescription.setBounds(45,245,360,150);

                    buttonSaveNewTour = new JButton("Tạo Mới");
                    buttonSaveNewTour.setBackground(new Color(41, 149, 85));
                    buttonSaveNewTour.setFont(new Font("Segoe",Font.BOLD,13));
                    buttonSaveNewTour.setForeground(Color.WHITE);
                    buttonSaveNewTour.setBounds(65,420,100,30);
                    buttonSaveNewTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    buttonClearField = new JButton(" Làm Mới ");
                    buttonClearField.setBackground(new Color(255, 255, 255));
                    buttonClearField.setFont(new Font("Segoe",Font.BOLD,13));
                    buttonClearField.setForeground(Color.BLACK);
                    buttonClearField.setBounds(270,420,100,30);
                    buttonClearField.setCursor(new Cursor(Cursor.HAND_CURSOR));

                /*****************ADD ELEMENT FOR PANEL ADD NEW TOUR*****************************/
                    panelAddNewTour.add(sptAboveLeftInHeader);
                    panelAddNewTour.add(sptUnderLeftInHeader);
                    panelAddNewTour.add(sptAboveRightInHeader);
                    panelAddNewTour.add(sptUnderRightInHeader);
                    panelAddNewTour.add(lbTitle);

                    panelAddNewTour.add(labelNameTour);
                    panelAddNewTour.add(txtNameTour);
                    panelAddNewTour.add(sptNameTour);

                    panelAddNewTour.add(labelPriceTour);
                    panelAddNewTour.add(txtPriceTour);
                    panelAddNewTour.add(sptPriceTour);
                    panelAddNewTour.add(labelVND);

                    panelAddNewTour.add(labelCategoryTour);
                    panelAddNewTour.add(comboBoxCategoryTour);

                    panelAddNewTour.add(labelSpecification);
                    panelAddNewTour.add(scrollPaneDescription);

                    panelAddNewTour.add(buttonClearField);
                    panelAddNewTour.add(buttonSaveNewTour);
                /*******************END ADD ELEMENT FOR PANEL ADD NEW TOUR**************************/
            /*********************************END PANEL ADD NEW TOUR*****************************************/
        add(panelAddNewTour);
        setVisible(true);

        /********************************* HANDLE BUTTON ADD NEW TOUR *****************************************/
            buttonClearField.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    clearTextField();
                }
            });

            buttonSaveNewTour.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    User_DTO user = new User_DTO();
                    Tour_Category_DTO category_dto = (Tour_Category_DTO) (comboBoxCategoryTour.getSelectedItem());
                    String categoryId = category_dto.getCategoryId();
                    String nameTour = txtNameTour.getText();
                    String priceTour = txtPriceTour.getText().replace(",","");
                    String specification = textAreaDescription.getText();
                    String price_PATTERN = "^[1-9]([0-9])*$";
                    if( !empty( nameTour ) && !empty( priceTour ) && !empty( specification ) ) {
                        if(Pattern.matches(price_PATTERN, priceTour)==false){
                            JOptionPane.showMessageDialog(null, "Lỗi! Giá tour không hợp lệ, và giá tour phải lớn hơn 0. ");
                        } else {
                            String parameter = "{\"name\":\"" + nameTour + "\",\"specification\":\""+specification+"\",\"tourCategoryId\":"+categoryId+",\"price\":"+priceTour+"}";
                            System.out.println(parameter);
                            String response = Handle_API_Get_Tour.sendPost_Add_New_Tour(parameter, "tours", user.getToken());
                            if(response.equals("success")==true){
                                JOptionPane.showMessageDialog(null, "Thêm thành công");
                                LoadDataTable();
                                dispose();
                            }else {
                                JOptionPane.showMessageDialog(null, "Thêm thất bại, vui lòng thử lại");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng nhập đầy đủ thông tin");
                    }
                }
            });

        txtPriceTour.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String price = txtPriceTour.getText();
                    long priceTour = Long.parseLong(price.replace(",",""));
                    String priceNewTour = java.text.NumberFormat.getIntegerInstance().format(priceTour);
                    txtPriceTour.setText(priceNewTour);
            }
        });
        /*********************************END HANDLE BUTTON ADD NEW TOUR *****************************************/
    }
    public static void loadCategoryTourComboBox(){
        User_DTO user = new User_DTO();
        JSONArray array = new JSONArray(Handle_API_Tour_Category.Fetch_API_Tour_Category("tourCategories?Page=1&Limit=100", user.getToken()));
        for(int i = 0; i < array.length(); i++){
            try {
                JSONObject jsonObject = (JSONObject) array.get(i);
                String id = jsonObject.get("id").toString();
                String name = jsonObject.get("name").toString();
                comboBoxCategoryTour.addItem(new Tour_Category_DTO(id, name));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
    public void clearTextField(){
        txtNameTour.setText("");
        txtPriceTour.setText("");
        textAreaDescription.setText("");
    }
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
}
