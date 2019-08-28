package net.autodata.linuxtest;

import javax.persistence.*;

//model+table
@Entity
@Table(name = "Contact")

public class Contact {
    //properties of a contact
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile")
    private String mobile;



    //constructor
    public Contact(){}
    public Contact(int id, String name, String mobile){
        this.setId(id);
        this.setName(name);
        this.setMobile(mobile);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getMobile(){
        return mobile;
    }

    @Override
    //toString method overrideee
    public String toString(){
        return "Contact{"+
                "id=" + id +
                ", name =' " + name + '\'' +
                ", mobile=' " + mobile
                +'\'' + '}';
         }
    }



