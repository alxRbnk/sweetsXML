package com.rubnikovich.candies.parser.jaxb;


import com.rubnikovich.candies.entity.Candy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@XmlRootElement
public class Candies {
    @XmlElement(name = "candy")
    private ArrayList<Candy> list = new ArrayList<>();

    public Candies() {
    }

    public void setList(ArrayList<Candy> list) {
        this.list = list;
    }

    public boolean add(Candy candy) {
        return list.add(candy);
    }

    public List<Candy> getCandies() {
        return Collections.unmodifiableList(list);
    }
}

