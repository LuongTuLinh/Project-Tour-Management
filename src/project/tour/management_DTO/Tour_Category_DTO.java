/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.tour.management_DTO;

/**
 *
 * @author DELL
 */
public class Tour_Category_DTO {
    private static String categoryId;
    private static String categoryName;

    public Tour_Category_DTO() {
    }
    public Tour_Category_DTO(String id, String name){
        Tour_Category_DTO.categoryId = id;
        Tour_Category_DTO.categoryName = name;
        
    }
}

