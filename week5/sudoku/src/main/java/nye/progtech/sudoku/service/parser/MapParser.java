package nye.progtech.sudoku.service.parser;

import nye.progtech.sudoku.model.MapVO;

import java.util.List;
import java.util.Map;

public class MapParser {
    private int numberOfRows;
    private int numberOfColumns;

    public MapParser(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public MapVO parseMap(List<String> rawMap) {
        int[][] map = generateMap(rawMap);
        boolean[][] fixed = generateFixed(map);

        return new MapVO(numberOfRows, numberOfColumns, map, fixed);
    }

    private int[][] generateMap(List<String> rawMap) {
        int[][] result = new int[numberOfRows][];

        for (int i = 0; i < numberOfRows; i++) {
            result[i] = new int[numberOfColumns];
            String line = rawMap.get(i);
            String[] parts = line.split(""); // each character

            for (int j = 0; j < numberOfColumns; j++) {
                int parsed = Integer.parseInt(parts[j]);
                result[i][j] = parsed;
            }
        }

        return result;
    }

    private boolean[][] generateFixed(int[][] map) {
        boolean[][] result = new boolean[numberOfRows][];
        for (int i = 0; i < numberOfRows; i++) {
            result[i] = new boolean[numberOfColumns];
            for (int j = 0; j < numberOfColumns; j++) {
                result[i][j] = map[i][j] != 0;

            }
        }

        return result;
    }
}
