package ua.nure.danylenko.practice6.part6;

import java.io.File;
import java.io.IOException;

public class Part6 {

    public static void main(String[] args) throws IOException {
        String instruction1 = args[0];
        if("-i".equals(instruction1)||"--input".equals(instruction1)){
            String path = args[1];
            File file = new File(path);
            if(file.exists()){
                String instruction2 = args[2];
                if("-t".equals(instruction2)||"--task".equals(instruction2)){
                    String task = args[3];
                    switch (task){
                        case "frequency":
                            Part61.main(args);
                            break;
                        case "length":
                            Part62.main(args);
                            break;
                        case "duplicates":
                            Part63.main(args);
                            break;
                            default:
                                break;
                    }
                }
            }
        }
    }
}
