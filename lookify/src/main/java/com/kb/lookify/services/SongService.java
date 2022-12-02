package com.kb.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kb.lookify.models.Song;
import com.kb.lookify.repositories.SongRepository;

@Service
public class SongService {
    private SongRepository songRepo;

    public SongService(SongRepository songRepo) {
        this.songRepo = songRepo;
    }

    // Busca todas las canciones
    public List<Song> allSongs(){
        return (List<Song>) songRepo.findAll();
    }

    // crea una nueva cancion
    public void addSong(Song song){
        songRepo.save(song);
    }

    // busca una cancion por id
    public Song findSong(Long id){
        Optional<Song> optionalSong = songRepo.findById(id);
        if (optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }

    // Muesta el Top10
    public List<Song> findTop10(){
        return songRepo.findTop10ByOrderByRatingDesc();
    }

    // busca las canciones por artista
    public List<Song> findSongs(String search){
        return songRepo.findByArtistContaining(search);
    }

    // Borrar una canción
    public void deleteSong(Long id){
        Song song = findSong(id);
        if (song != null) {
            songRepo.deleteById(id);
        }
    }
}
