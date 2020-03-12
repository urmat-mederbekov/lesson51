package kg.attractor.musicplayer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Document(collection = "compositions")
@Data
public class Composition {

    @Id
    private String id;
    @Indexed
    private String name;
    private LocalDate releaseDate;
    private static List<Composition> compositions = makeComposition();

    public Composition(String name, LocalDate releaseDate) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.releaseDate = releaseDate;
    }

    private static List<Composition> makeComposition(){
        List<Composition> compositions = new LinkedList<>();
        LocalDate localDate  = LocalDate.now();
        Random r = new Random();
        compositions.add(new Composition("Warrior",localDate.minusYears(r.nextInt(10)+1)));
        compositions.add(new Composition("Darkness",localDate.minusYears(r.nextInt(10)+1)));
        compositions.add(new Composition("Madness",localDate.minusYears(r.nextInt(10)+1)));
        return  compositions;
    }
    public static List<Composition> getCompositions(){
        return compositions;
    }
}
