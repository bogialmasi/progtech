package nye.progtech.sudoku.service;

import nye.progtech.sudoku.model.MapVO;
import nye.progtech.sudoku.service.map.MapReader;
import nye.progtech.sudoku.service.map.exception.MapReadException;
import nye.progtech.sudoku.service.map.impl.BufferedReaderMapReader;
import nye.progtech.sudoku.service.parser.MapParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws MapReadException{

        int[][] map = {
                {0, 1},
                {2, 3}
        };
        boolean[][] fixed = {
                {false, true},
                {true, true}
        };
        MapVO mapVO = new MapVO(2, 2, map, fixed);

        System.out.println(mapVO);

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("map/beginner.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        MapReader mapReader = new BufferedReaderMapReader(bufferedReader);
        try {
            List<String> strings = mapReader.readMap();
            System.out.println(strings);

            MapParser mapParser = new MapParser(9, 9);
            MapVO mapVO1 = mapParser.parseMap(strings);
            System.out.println(mapVO1);
        } catch (MapReadException e) {
            e.printStackTrace();
        }
    }
}
