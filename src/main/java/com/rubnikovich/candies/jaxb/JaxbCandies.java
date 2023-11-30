package com.rubnikovich.candies.jaxb;

import com.rubnikovich.candies.entity.Candy;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class JaxbCandies {

    @XmlElement(name = "candy")
    private ArrayList<Candy> list = new ArrayList<>();

    public JaxbCandies() {
    }

    public void setList(ArrayList<Candy> list) {
        this.list = list;
    }

    public boolean add(Candy candy) {
        return list.add(candy);
    }

    @Override
    public String toString() {
        return "Candies list= " + list ;
    }
}

