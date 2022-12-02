package com.kb.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kb.lookify.models.Song;
import com.kb.lookify.services.SongService;

@Controller
public class PlaylistController {
    private final SongService songService;

    public PlaylistController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/dashboard")
    public String dash(Model model){
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "dashboard";
    }

    @GetMapping("/songs/new")
    public String newSong(@ModelAttribute ("song") Song song){
        return "newSong";
    }

    @PostMapping("/songs/new")
    public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result){
        if (result.hasErrors()) {
            return "newSong";
        } else {
            songService.addSong(song);
            return "redirect:/dashboard";
        }
    }

    @GetMapping("/songs/{id}")
    public String showSong(@PathVariable("id")Long id, Model model){
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "showSong";
    }

    @RequestMapping("/songs/{id}/delete")
    public String deleteSong(@PathVariable("id")Long id){
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }

    @GetMapping("/top")
    public String showTop(Model model){
        List<Song> songs = songService.findTop10();
        model.addAttribute("songs", songs);
        return "topSongs";
    }

    @PostMapping("/songs/search")
    public String searchSong(@RequestParam("search") String search, Model model){
        List<Song> songs = songService.findSongs(search);
        model.addAttribute("songs", songs);
        model.addAttribute("search", search);
        return "searchResults";
    }
}
