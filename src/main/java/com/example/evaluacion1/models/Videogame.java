package com.example.evaluacion1.models;

import lombok.Data;

import java.util.Arrays;

@Data
public class Videogame {
    private String name;
    private String video_console;
    private String[] genres;

    @Override
    public String toString() {
        return name + '-' +
                  video_console + '-' +
                 Arrays.toString(genres) ;
    }

}
