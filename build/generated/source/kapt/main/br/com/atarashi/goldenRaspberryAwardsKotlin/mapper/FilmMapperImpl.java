package br.com.atarashi.goldenRaspberryAwardsKotlin.mapper;

import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.request.FilmRequest;
import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.FilmResponse;
import br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.Film;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-12T20:36:33-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from kotlin-annotation-processing-gradle-1.9.10.jar, environment: Java 17.0.8.1 (Private Build)"
)
@Component
public class FilmMapperImpl implements FilmMapper {

    @Override
    public FilmResponse filmToFilmResponse(Film film) {
        if ( film == null ) {
            return null;
        }

        int id = 0;
        String year = null;
        String title = null;
        String studios = null;
        String producers = null;
        String winner = null;

        id = film.getId();
        year = film.getYear();
        title = film.getTitle();
        studios = film.getStudios();
        producers = film.getProducers();
        winner = film.getWinner();

        FilmResponse filmResponse = new FilmResponse( id, year, title, studios, producers, winner );

        return filmResponse;
    }

    @Override
    public List<FilmResponse> filmListToFilmResponseList(List<Film> film) {
        if ( film == null ) {
            return null;
        }

        List<FilmResponse> list = new ArrayList<FilmResponse>( film.size() );
        for ( Film film1 : film ) {
            list.add( filmToFilmResponse( film1 ) );
        }

        return list;
    }

    @Override
    public Film filmRequestToFilm(FilmRequest filmRequest) {
        if ( filmRequest == null ) {
            return null;
        }

        String year = null;
        String title = null;
        String studios = null;
        String producers = null;
        String winner = null;

        year = filmRequest.getYear();
        title = filmRequest.getTitle();
        studios = filmRequest.getStudios();
        producers = filmRequest.getProducers();
        winner = filmRequest.getWinner();

        int id = 0;

        Film film = new Film( id, year, title, studios, producers, winner );

        return film;
    }
}
