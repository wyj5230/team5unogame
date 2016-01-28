package uno.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;

@RequestScoped
public class card implements Serializable{
    private String cid;
    private String function;
    private String color;
    private String number;
    private int points;
    
    //constructor
    public card(String cid,String function,String color,String number,int points){
        this.cid=cid;
        this.function=function;
        this.color=color;
        this.number=number;
        this.points=points;    
    }
    
    public JsonObject toJson() {
        return (Json.createObjectBuilder()
                .add("cid", cid)
                .add("function", function)
                .add("color", color)
                .add("number", number)
                .add("points", points)
                .build());
    }
    
    //getters and setters
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }   
}
