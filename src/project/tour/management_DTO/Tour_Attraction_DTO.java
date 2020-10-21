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
public class Tour_Attraction_DTO {
    private static String attractionsId;
    private static String attractionsName;
    private static String description;

    public Tour_Attraction_DTO() {
    }

    public Tour_Attraction_DTO(String id, String name, String description){
        this.attractionsId = id;
        this.attractionsName = name;
        this.description = description;
    }

    public Tour_Attraction_DTO(String id){
        this.attractionsId = id;
    }
    
    public static String getAttractionsId() {
        return attractionsId;
    }

    public void setAttractionsId(String attractionsId) {
        Tour_Attraction_DTO.attractionsId = attractionsId;
    }

    public static String getAttractionsName() {
        return attractionsName;
    }

    public void setAttractionsName(String attractionsName) {
        Tour_Attraction_DTO.attractionsName = attractionsName;
    }

    public static String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        Tour_Attraction_DTO.description = description;
    }
    
}
