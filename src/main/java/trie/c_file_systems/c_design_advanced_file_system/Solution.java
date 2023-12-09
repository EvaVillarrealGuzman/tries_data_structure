package trie.c_file_systems.c_design_advanced_file_system;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<String> respuestasContent = new ArrayList<>();

        FileSystem fileSystem = new FileSystem();

        respuestasContent.add( fileSystem.mkdir("home") );
        respuestasContent.add( fileSystem.ls().toString() );
        respuestasContent.add( fileSystem.cd("/home") );
        respuestasContent.add( fileSystem.pwd() );
        respuestasContent.add( fileSystem.touch("newFile.txt") );
        respuestasContent.add( fileSystem.touch("newFile.txt") );
        respuestasContent.add( fileSystem.touch("newFile.csv") );
        respuestasContent.add( fileSystem.ls().toString() );
        respuestasContent.add( fileSystem.mkdir("Ben") );
        respuestasContent.add( fileSystem.cd("/Ben") );
        respuestasContent.add( fileSystem.mkdir("Movies") );
        respuestasContent.add( fileSystem.mkdir("College") );
        respuestasContent.add( fileSystem.ls().toString() );
        respuestasContent.add( fileSystem.pwd() );
        respuestasContent.add( fileSystem.cd("/Movies") );
        respuestasContent.add( fileSystem.touch("HarryPotter.mp4") );
        respuestasContent.add( fileSystem.pwd() );
        respuestasContent.add( fileSystem.ls().toString() );
        respuestasContent.add( fileSystem.cd("/~") );
        respuestasContent.add( fileSystem.cd("/home/Ben/Movies") );
        respuestasContent.add( fileSystem.ls().toString() );
        respuestasContent.add( fileSystem.pwd() );
        respuestasContent.add( fileSystem.cd("/Narnia") );

        System.out.println(respuestasContent);

    }
}