import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Album> albums = new ArrayList<>();
        Album album = new Album("BlackPink", "Born Pink");
        album.addSongToAlbum("Pink Venom", 3.6);
        album.addSongToAlbum("Shut down", 2.55);
        album.addSongToAlbum("Typa Girl", 3.0);

        albums.add(album);

        album = new Album("Kai", "Rover");
        album.addSongToAlbum("Bomba", 3.07);
        album.addSongToAlbum("Peaches", 3.18);

        albums.add(album);

        LinkedList<Song> playlist_1 = new LinkedList<>();

        albums.get(0).addSongToPlaylist("Pink Venom", playlist_1);
        albums.get(0).addSongToPlaylist("Typa Girl", playlist_1);
        albums.get(1).addSongToPlaylist("Bomba", playlist_1);

        play(playlist_1);
    }

    public static void play(LinkedList<Song> playlist){
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size() == 0){
            return;
        }

        Scanner sc = new Scanner(System.in);
        printMenu();
        System.out.println("Now playing : "+ listIterator.next());

        boolean forward = true;
        boolean quit = false;

        while(quit == false){
            int choice = sc.nextInt();
            switch (choice){
                case 0 :
                    quit = true;
                    break;
                case 1 :
                    if(forward == false){
                        listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println(listIterator.next().toString());
                    }
                    else{
                        System.out.println("You are at the last song");
                    }
                    break;
                case 2 :
                    if(forward == true){
                        listIterator.previous();
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println(listIterator.previous().toString());
                    }
                    else{
                        System.out.println("You are at the first song");
                    }
                    break;
                case 3 :
                    if(forward == true){
                        System.out.println(listIterator.previous().toString());
                        forward = false;
                    }
                    else{
                        System.out.println(listIterator.next().toString());
                        forward = true;
                    }
                    break;
                case 4 :
                    printAllSongs(playlist);
                    break;
                case 5 :
                    printMenu();
                    break;
                case 6 :
                    if(playlist.size() > 0){
                        System.out.println(listIterator.previous() + " has been removed from the playlist");
                        listIterator.remove();
                        if(playlist.size() > 0 && listIterator.hasPrevious()){
                            System.out.println("Now playing : "+listIterator.next().toString());
                        }
                        else if(playlist.size() > 0 && listIterator.hasNext()){
                            System.out.println("Now playing : "+listIterator.previous().toString());
                        }
                    }
                    else{
                        System.out.println("Playlist is empty");
                    }
                    break;
            }
        }
    }

    public static void printAllSongs(LinkedList<Song> playlist){
        ListIterator<Song> listIterator = playlist.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - Quit\n" +
                "1 - Play next song\n" +
                "2 - Play previous song\n" +
                "3 - Replay the current song\n" +
                "4 - Print all songs\n" +
                "5 - Print all available options\n" +
                "6 - Delete current song");
    }
}