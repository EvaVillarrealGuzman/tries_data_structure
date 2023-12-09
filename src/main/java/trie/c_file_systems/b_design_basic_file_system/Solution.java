package trie.c_file_systems.b_design_basic_file_system;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<Boolean> respuestasInsert = new ArrayList<>();
        List<String> respuestasContent = new ArrayList<>();

        FileSystem fileSystem = new FileSystem();

        respuestasInsert.add( fileSystem.createFile("/home",  "home directory") );
        respuestasInsert.add( fileSystem.createFile("/home/ben",  "Ben’s home directory") );
        respuestasInsert.add( fileSystem.createFile("/home/ben/movies",  "Ben’s favorite movies") );
        respuestasInsert.add( fileSystem.createFile("/home/ben/college",  "Ben’s college books") );
        respuestasInsert.add( fileSystem.createFile("/home/ben/dance/videos",  "Ben’s dance video") );

        respuestasContent.add( fileSystem.getFileData("/home/ben/dance/videos") );
        respuestasContent.add( fileSystem.getFileData("/home/ben/") );
        respuestasContent.add( fileSystem.getFileData("/home/ben/movies") );

        respuestasInsert.add( fileSystem.appendContentToFile("/home/ben/movies", " includes Harry Potter") );

        respuestasContent.add( fileSystem.getFileData("/home/ben/movies") );

        System.out.println(respuestasInsert);
        System.out.println(respuestasContent);

    }
}