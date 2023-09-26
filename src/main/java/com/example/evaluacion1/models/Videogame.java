package com.example.evaluacion1.models;

import lombok.Data;

import java.util.Arrays;

@Data
public class Videogame {
    private String name;
    private String video_console;
    private String[] genres;


    /**
     * This method returns a string with the information of the videogames
     *
     * @return A string with the information of the videogames
     */
    @Override
    public String toString() {
        return name + " - " +
                  video_console + " - " +
                 Arrays.toString(genres) ;
    }
    /**
     * This method returns a string with the information of the videogames without the name
     *
     * @return A string with the information of the videogames
     */
    public String toStringWithoutName() {
        return video_console + " - " +
                Arrays.toString(genres);
    }

}
