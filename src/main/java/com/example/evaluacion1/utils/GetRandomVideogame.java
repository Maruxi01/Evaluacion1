package com.example.evaluacion1.utils;

import com.example.evaluacion1.models.Videogame;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class GetRandomVideogame {

    static Random random = new Random();

    public ArrayList<Videogame> getRandomVideogame(ArrayList<Videogame> videogames, int amountRandom){

        ArrayList<Videogame> randomVideogames = new ArrayList<>();

        IntStream.range(0, amountRandom).map(i -> random.nextInt(videogames.size())).forEach(randomIndex -> {
            randomVideogames.add(videogames.get(randomIndex));
            videogames.remove(randomIndex);
        });

        return randomVideogames;
    }

}
