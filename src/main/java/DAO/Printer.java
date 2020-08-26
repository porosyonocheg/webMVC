package DAO;

import javax.persistence.*;

@Entity
@Table(name = "printertest")
@NamedQueries({@NamedQuery(name = "printertest.findAll", query = "select c from Printer c")})
public class Printer {
    private int code;
    private int model;
    private char color;
    private String type;
    private double price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    @Column(name = "model")
    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }
    @Column(name = "color")
    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Принтер {" +
                "код = " + code +
                ", модель = " + model +
                ", цветной = " + color +
                ", тип = '" + type + '\'' +
                ", цена = " + price +
                '}';
    }
}

