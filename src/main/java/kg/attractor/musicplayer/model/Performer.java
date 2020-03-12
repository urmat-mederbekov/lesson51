package kg.attractor.musicplayer.model;

import kg.attractor.musicplayer.Util.Generator;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Document(collection = "performers")
@Data
public class Performer {

    @Id
    private String id;
    @Indexed
    private String name;
    private static List<Performer> performers = makePerformers();
    @DBRef
    private List<Album> albums = new LinkedList<>();

    public Performer(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    private static List<Performer> makePerformers(){
        List<Performer> performers = new LinkedList<>();
        performers.add(new Performer("Adam"));
        performers.add(new Performer("Dandelion"));
        performers.add(new Performer("Eve"));
        return performers;
    }
    public void addAlbum(Album album){
        getAlbums().add(album);
        setAlbums(getAlbums());
    }
    public static List<Performer> getPerformers(){
        return performers;
    }
}
