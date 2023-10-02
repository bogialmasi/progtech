package nye.progtech.sudoku.service.map.impl;

import nye.progtech.sudoku.service.map.exception.MapReadException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class BufferedReaderMapReaderTest {

    private BufferedReaderMapReader underTest;
    @Mock
    private BufferedReader bufferedReaderMock;

    @BeforeEach
    public void setUp() {
        underTest = new BufferedReaderMapReader(bufferedReaderMock);
    }

    @Test
    void testReadMapShouldReturnRowsReadFromBufferedReader() throws IOException, MapReadException {
        // -- given
        String LINE_1 = "Line 1";
        String LINE_2 = "Line 2";
        given(bufferedReaderMock.readLine()).willReturn("Line 1", "Line 2", null);
        // -- when
        List<String> result = underTest.readMap();
        // -- then
        assertEquals(List.of(LINE_1, LINE_2), result);
    }

    @Test
    void testReadMapWhenEncountersIOExceptionWillThrowCustomException() throws IOException {
        // -- given
        doThrow(IOException.class).when(bufferedReaderMock).readLine();
        // -- when -- then
        assertThrows(MapReadException.class, () -> {
            underTest.readMap();
        });

    }
}