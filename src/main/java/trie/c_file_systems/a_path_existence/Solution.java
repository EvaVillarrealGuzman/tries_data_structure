package trie.c_file_systems.a_path_existence;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<Boolean> respuestas = new ArrayList<>();

        FileSystem fileSystem = new FileSystem();

        respuestas.add( fileSystem.directoryInsert("/home/ben/files/movies") );
        respuestas.add( fileSystem.directoryInsert("/home/mike/profile") );
        respuestas.add( fileSystem.directoryExists("/home/ben/files") );
        respuestas.add( fileSystem.directoryInsert("/home/arnold/profile") );
        respuestas.add( fileSystem.directoryExists("/home/arnold/files") );

        System.out.println(respuestas);
    }
}