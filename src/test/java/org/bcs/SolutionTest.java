package org.bcs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SolutionTest {

    private final ClassLoader classLoader = getClass().getClassLoader();

    @ParameterizedTest
    @ValueSource(strings = {
            "input000.txt", "input001.txt",
            "input002.txt", "input003.txt",
            "input004.txt", "input005.txt",
            "input006.txt", "input007.txt"
    })
    void testExpectedStrokes(String input) throws IOException {
        File file = new File(classLoader.getResource(input).getFile());
        int lineCount = 0;
        int expectedResult = 0;
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();

            if (line != null) {
                String[] initialLineSplit = line.split(",", 2);
                lineCount = Integer.parseInt(initialLineSplit[0]);
                expectedResult = Integer.parseInt(initialLineSplit[1]);
            }

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }

        assertEquals(lineCount, lines.size());
        assertEquals(expectedResult, Solution.strokesRequired(lines));
    }
    
}
