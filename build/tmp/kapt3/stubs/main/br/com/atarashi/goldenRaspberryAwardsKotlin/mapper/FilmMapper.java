package br.com.atarashi.goldenRaspberryAwardsKotlin.mapper;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lbr/com/atarashi/goldenRaspberryAwardsKotlin/mapper/FilmMapper;", "", "filmListToFilmResponseList", "", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/controller/response/FilmResponse;", "film", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/repository/model/Film;", "filmRequestToFilm", "filmRequest", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/controller/request/FilmRequest;", "filmToFilmResponse", "goldenRaspberryAwardsKotlin"})
@org.mapstruct.Mapper(componentModel = "spring")
public abstract interface FilmMapper {
    
    @org.jetbrains.annotations.NotNull
    public abstract br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.FilmResponse filmToFilmResponse(@org.jetbrains.annotations.NotNull
    br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.Film film);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.FilmResponse> filmListToFilmResponseList(@org.jetbrains.annotations.NotNull
    java.util.List<br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.Film> film);
    
    @org.jetbrains.annotations.NotNull
    public abstract br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.Film filmRequestToFilm(@org.jetbrains.annotations.NotNull
    br.com.atarashi.goldenRaspberryAwardsKotlin.controller.request.FilmRequest filmRequest);
}