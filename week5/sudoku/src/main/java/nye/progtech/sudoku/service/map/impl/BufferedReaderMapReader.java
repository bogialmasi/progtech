package nye.progtech.sudoku.service.map.impl;

import nye.progtech.sudoku.service.map.MapReader;
import nye.progtech.sudoku.service.map.exception.MapReadException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BufferedReaderMapReader implements MapReader {

    private BufferedReader bufferedReader;

    public BufferedReaderMapReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public List<String> readMap() throws MapReadException {
        String line;
        List<String> result = new ArrayList<>();
        //InputStream inputStream = null;
        try {
            //inputStream = Main.class.getClassLoader().getResource("map/beginner.txt").openStream();
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while ((line = bufferedReader.readLine())!=null){
                result.add(line);
            }
        } catch (IOException e) {
            throw new MapReadException("Failed to read Map.");
        }
        return result;
    }
}
