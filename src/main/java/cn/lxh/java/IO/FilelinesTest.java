package cn.lxh.java.IO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by starlin
 * on 2020/9/21 22:01.
 */
public class FilelinesTest {
    private static final Logger log = LoggerFactory.getLogger(FilelinesTest.class);

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        IntStream.rangeClosed(1, 1000000).forEach(i -> {
            try (Stream<String> lines = Files.lines(Paths.get("src/main/resources/demo.txt"))) {
                lines.forEach(line -> longAdder.increment());
            } catch (IOException e) {

                e.printStackTrace();
            }

        });
        log.info("total : {}", longAdder.longValue());
    }

}
