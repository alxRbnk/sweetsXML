package com.rubnikovich.candies.parser.jaxb;

import com.rubnikovich.candies.entity.CandyType;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EnumAdapter extends XmlAdapter<String, CandyType> {
    @Override
    public CandyType unmarshal(String v) {
        CandyType type = CandyType.valueOf(v.toUpperCase().replaceAll(" ", "_"));
        return type;
    }

    @Override
    public String marshal(CandyType v) {
        return v.toString();
    }
}
