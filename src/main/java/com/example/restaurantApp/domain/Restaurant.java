package com.example.restaurantApp.domain;


import javax.persistence.*;

@Entity
@Table(name="restaurant")
public class Restaurant {
    @Id
    @Column(name = "restaurantId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "restaurantName" )
    private String name;

    @Column(name="address")
    private String address;

    @Column(name = "description")
    private String description;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }



    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
