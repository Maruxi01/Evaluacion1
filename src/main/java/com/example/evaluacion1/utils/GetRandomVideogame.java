package com.example.evaluacion1.utils;

import com.example.evaluacion1.models.Videogame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class GetRandomVideogame {

    static Random random = new Random();


    public List<Videogame> getRandomVideogame(List<Videogame> videogames, int amountRandom){
        ArrayList<Videogame> randomVideogames = new ArrayList<>();

        range(0, amountRandom).map(i -> random.nextInt(videogames.size())).forEach(randomIndex -> {
            randomVideogames.add(videogames.get(randomIndex));
            videogames.remove(randomIndex);
        });

        return randomVideogames;
    }

}
