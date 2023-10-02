package nye.progtech.sudoku.service.map;

import nye.progtech.sudoku.service.map.exception.MapReadException;

import java.util.List;

public interface MapReader {
    List<String> readMap() throws MapReadException;
}
