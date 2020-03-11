package kg.attractor.musicplayer.Util;

import kg.attractor.musicplayer.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initCompositionDatabase(CompositionRepository compositionRepo){
        compositionRepo.deleteAll();

        Album.getAlbums().get(0).addComposition(Composition.getCompositions().get(2));
        Album.getAlbums().get(1).addComposition(Composition.getCompositions().get(0));
        Album.getAlbums().get(1).addComposition(Composition.getCompositions().get(1));
        return args -> Stream.of(Composition.getCompositions())
                .peek(compositions -> compositions.forEach(System.out::println))
                .forEach(compositionRepo::saveAll);
    }
    @Bean
    CommandLineRunner initAlbumDatabase(AlbumRepository albumRepo){
        albumRepo.deleteAll();

        Performer.getPerformers().get(2).addAlbum(Album.getAlbums().get(1));
        Performer.getPerformers().get(1).addAlbum(Album.getAlbums().get(0));

        return args -> Stream.of(Album.getAlbums())
                .peek(compositions -> compositions.forEach(System.out::println))
                .forEach(albumRepo::saveAll);
    }
    @Bean
    CommandLineRunner initPerformerDatabase(PerformerRepository performerRepo){
        performerRepo.deleteAll();

        return args -> Stream.of(Performer.getPerformers())
                .peek(compositions -> compositions.forEach(System.out::println))
                .forEach(performerRepo::saveAll);
    }
}
