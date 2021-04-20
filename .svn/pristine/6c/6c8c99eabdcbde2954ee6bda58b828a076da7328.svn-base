package ua.nure.danylenko.practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Part1 {
    private static final String CHARSET = "Cp1251";
    private static final InputStream STD_IN = System.in;

    public static void main(String[] args) throws IOException {
        StringBuilder str = new StringBuilder();
        str.append("asd 43 asdf asd 43^").append("434 asdf^").
                append("kasdf asdf stop asdf^").append("aha ahaha fuck you");
        System.setIn(new ByteArrayInputStream(str.toString().replace(
                "^",System.lineSeparator()).getBytes(CHARSET)));
        WordContainer.main(args);
        System.setIn(STD_IN);

    }
}
