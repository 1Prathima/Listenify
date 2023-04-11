import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    public String artistName;
    public String albumName;
    public List<Song> songList;

    public Album(String artistName, String albumName) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.songList = new ArrayList<>();
    }

    public boolean findSongInAlbum(String title){
        for(Song song : songList){
            if(song.title == title){
                return true;
            }
        }
        return false;
    }

    public String addSongToAlbum(String title, double duration){
        if(findSongInAlbum(title)){
            return "Song is already present in the album";
        }
        else{
            Song newSong = new Song(title, duration);
            songList.add(newSong);
            return "New song has been added to album successfully";
        }
    }

    public String addSongToPlaylist(int trackNo, LinkedList<Song> playlist){
        int index = trackNo - 1;
        //check for validity of index
        if(index >= 0 && index < songList.size()){
            Song song = songList.get(index);
            playlist.add(song);
            return "Song has been added to playlist successfully";
        }
        else{
            return "Invalid track number";
        }
    }

    public String addSongToPlaylist(String title, LinkedList<Song> playlist){
        for(Song song : songList){
            if(song.title == title){
                playlist.add(song);
                return "Song has been added to playlist successfully";
            }
        }
        return "Song does not exist";
    }
}
