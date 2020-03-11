package kg.attractor.musicplayer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Document(collection = "albums")
@Data
public class Album {

    @Id
    private String id;
    private String name;
    private static List<Album> albums = makeAlbums();
    @DBRef
    private List<Composition> compositions = new LinkedList<>();

    public Album( String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    private static List<Album> makeAlbums(){
        List<Album> albums = new LinkedList<>();
        albums.add(new Album("Justice"));
        albums.add(new Album("Equity"));
        albums.add(new Album("Ignorance"));
        return albums;
    }
    public void addComposition(Composition composition){
        getCompositions().add(composition);
        setCompositions(getCompositions());
    }
    public static List<Album> getAlbums(){
        return albums;
    }
}
