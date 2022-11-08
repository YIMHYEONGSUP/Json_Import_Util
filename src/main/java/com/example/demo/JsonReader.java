package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.stream.Stream;

public class JsonReader {

    public static void main(String[] args) throws Exception {

        // [ResourceUtils] resources 폴더 내 Json 파일 값 가져오기
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "application_default_credentials.json");
        Stream<String> lines = Files.lines(file.toPath());
        lines.forEach(System.out::println);

        System.out.println("=================================");

        // [InputStream] resources 폴더 내 Json 파일 값 가져오기
        InputStream inputStream = new ClassPathResource("application_default_credentials.json").getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.lines()
                .forEach(System.out::println);

        System.out.println("=================================");

        // [File] resources 폴더 내 Json 파일 값 가져오기
        File file2 = new ClassPathResource("application_default_credentials.json").getFile();
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file2));
        bufferedReader1.lines()
                .forEach(System.out::println);


    }
}
