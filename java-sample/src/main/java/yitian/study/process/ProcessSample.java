package yitian.study.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ProcessSample {
    public static void main(String[] args) throws Exception {
        //ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ver");
        //ProcessBuilder pb = new ProcessBuilder("java", "-version");
        ProcessBuilder pb = new ProcessBuilder("python", "--version");
        pb.redirectErrorStream(true);
        Process process = pb.start();
        process.waitFor();
        System.out.println(process.exitValue());

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"))) {
            String result = reader.lines()
                    .collect(Collectors.joining("\n"));
            System.out.println(result);
        }
    }
}
