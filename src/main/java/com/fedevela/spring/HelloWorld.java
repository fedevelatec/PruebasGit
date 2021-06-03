package com.fedevela.spring;

public class HelloWorld {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "HelloWorld! \n" + name;
    }

}
