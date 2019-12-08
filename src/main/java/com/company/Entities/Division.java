package com.company.Entities;

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


    public  void ToString() {
        System.out.println("Отдел");
        System.out.println(this.id);
        System.out.println(this.name);


    }
}
