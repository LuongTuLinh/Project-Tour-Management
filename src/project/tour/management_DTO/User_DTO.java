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
public class User_DTO {
    private static String email;
    private static String password;
    private static String firstName;
    private static String lastName;
    private static String token;
    
    public User_DTO(){
        
    }
    public User_DTO(String Email, String firstName, String lastName, String token){
        User_DTO.email = Email;
        User_DTO.firstName = firstName;
        User_DTO.lastName = lastName;
        User_DTO.token = token;
    }
    public User_DTO(String Email, String Password){
        User_DTO.email = Email;
        User_DTO.password = Password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        User_DTO.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        User_DTO.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        User_DTO.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        User_DTO.lastName = lastName;
    }
    
        public String getToken() {
        return token;
    }

    public void setToken(String token) {
        User_DTO.token = token;
    }   
    
    @Override
    public String toString() {
        return "User_DTO{" +
                "email='" + email + '\'' +
                ", password=" + password +
                '}';
    }
}
