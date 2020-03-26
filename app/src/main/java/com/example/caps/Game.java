
//Student Name: Ivy Osei
//This lab was done individually

package com.example.caps;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game
{
    CountryDB db;



    public Game(){
        this.db = new CountryDB();
    }

    public String qa(){
        List<String> capitals = db.getCapitals();
        // Randomly Pick a country from data base of countries
        int n = capitals.size();
        int index = (int)(n*Math.random()) ;
        // from the randomly chosen capitals it makes c the name of the capital
        String c = capitals.get(index);
        //we get the refence data base for all the countries
        Map<String, Country> data = db.getData();
        Country ref = data.get(c);
        String question;


        if (Math.random() < 0.5){
            question =  "What is the capital of " + ref.getName() +"?" + "\n" + ref.getCapital();


        }
        else {
            question =  ref.getCapital() + " is the capital of?" + "\n" + ref.getName();
        }



        return question;
    }

    public static void main(String[] args) {
        Game myModel = new Game();
        System.out.println(myModel.qa());

    }
}
