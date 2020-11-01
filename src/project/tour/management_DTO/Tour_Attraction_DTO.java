/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.tour.management_DTO;

import javax.swing.*;
import javax.swing.event.ListDataListener;

/**
 *
 * @author DELL
 */
public class Tour_Attraction_DTO {
    private String attractionsId;
    private String attractionsName;
    private String description;
    private int index;

    public Tour_Attraction_DTO() {
    }

    public Tour_Attraction_DTO(String id, String name, String description){
        this.attractionsId = id;
        this.attractionsName = name;
        this.description = description;
        this.index = index;
    }
    public Tour_Attraction_DTO(String id){
        this.attractionsId = id;
    }

    public Tour_Attraction_DTO(String id, String name, int index){
        this.attractionsId = id;
        this.attractionsName = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return attractionsName;
    }

    public String getAttractionsId() {
        return attractionsId;
    }

    public void setAttractionsId(String attractionsId) {
        this.attractionsId = attractionsId;
    }

    public String getAttractionsName() {
        return attractionsName;
    }

    public void setAttractionsName(String attractionsName) {
        this.attractionsName = attractionsName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
