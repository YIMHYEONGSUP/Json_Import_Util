package com.example.demo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Stream;

public class JsonFileImportUtil {

    private static String CREDENTIAL = "application_default_credentials.json";
    public static String json = "";

    /*
    *   resources 폴더 내 json 파일을 불러
    *
    *
    * */
    public JsonFileImportUtil() throws Exception{

        CredentialInfo result = new CredentialInfo();
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> map = new LinkedHashMap<>();

        // [ResourceUtils] resources 폴더 내 Json 파일 값 가져오기
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + CREDENTIAL);
        Stream<String> lines = Files.lines(file.toPath());
        lines.forEach((val)->{

            String jsonValue = val;
            int i = jsonValue.indexOf(":");

            if (i > 0) {
                String key = jsonValue.substring(3, i-1);
                String value = jsonValue.substring(i+3, jsonValue.length()-2);
                map.put(key, value);
            }
        });

        json = mapper.writeValueAsString(map);
        System.out.println("json = " + json);

    }


    public static void main(String[] args) throws Exception {

        JsonFileImportUtil credentialFactory = new JsonFileImportUtil();
        String json = credentialFactory.json;
        System.out.println("main() => json = " + json);
    }

}
