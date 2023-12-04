package com.rubnikovich.candies.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = " candyValue ", propOrder = {"protein", "carbohydrates", "fats"})
public class CandyValue {
    private int protein;
    private int carbohydrates;
    private int fats;

    public CandyValue() {
    }

    public static BuilderValue newBuilderValue(){
        return new CandyValue().new BuilderValue();
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CandyValue that = (CandyValue) o;

        if (protein != that.protein) return false;
        if (carbohydrates != that.carbohydrates) return false;
        return fats == that.fats;
    }

    @Override
    public int hashCode() {
        int result = protein;
        result = 31 * result + carbohydrates;
        result = 31 * result + fats;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CandyValue{");
        sb.append("protein=").append(protein);
        sb.append(", carbohydrates=").append(carbohydrates);
        sb.append(", fats=").append(fats);
        sb.append('}');
        return sb.toString();
    }

    public class BuilderValue{

        private BuilderValue(){
        }

        public BuilderValue setProtein(int protein) {
            CandyValue.this.protein = protein;
            return this;
        }

        public BuilderValue setCarbohydrates(int carbohydrates) {
            CandyValue.this.carbohydrates = carbohydrates;
            return this;
        }

        public BuilderValue setFats(int fats) {
            CandyValue.this.fats = fats;
            return this;
        }

        public CandyValue buldCandyValue(){
            return CandyValue.this;
        }

    }
}
