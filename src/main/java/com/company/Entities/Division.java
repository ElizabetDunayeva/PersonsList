package com.company.Entities;
import ru.vsu.lab.entities.IDivision;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Division implements IDivision {

    Integer id;

    String name;
    public Integer getId(){

        return id;
    }

    public void setId(Integer id){

        this.id = id;

    }

    public String getName(){

        return name;

    }

    public void setName(String name){

        this.name = name;

    }

    @Override
    public String toString() {
        return "Division{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
