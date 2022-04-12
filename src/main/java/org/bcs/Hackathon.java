package org.bcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hackathon {

    public static void main(String[] args) throws IOException {
        var picture = readPicture();

        var strokes = Solution.strokesRequired(picture);

        System.out.println("Strokes: " + strokes);
    }

    private static List<String> readPicture() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int pictureCount = Integer.parseInt(bufferedReader.readLine().trim());

        return IntStream.range(0, pictureCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }).collect(Collectors.toList());
    }

}
