package br.com.atarashi.goldenRaspberryAwardsKotlin.controller;

@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping(value = {"films"})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0017J\u0012\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\nH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lbr/com/atarashi/goldenRaspberryAwardsKotlin/controller/FilmFetchController;", "", "filmService", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/service/FilmService;", "(Lbr/com/atarashi/goldenRaspberryAwardsKotlin/service/FilmService;)V", "fetch", "", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/controller/response/FilmResponse;", "fetchId", "id", "", "goldenRaspberryAwardsKotlin"})
public class FilmFetchController {
    @org.jetbrains.annotations.NotNull
    private final br.com.atarashi.goldenRaspberryAwardsKotlin.service.FilmService filmService = null;
    
    public FilmFetchController(@org.jetbrains.annotations.NotNull
    br.com.atarashi.goldenRaspberryAwardsKotlin.service.FilmService filmService) {
        super();
    }
    
    @org.springframework.web.bind.annotation.GetMapping
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.jetbrains.annotations.NotNull
    public java.util.List<br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.FilmResponse> fetch() {
        return null;
    }
    
    @org.springframework.web.bind.annotation.GetMapping(value = {"{id}"})
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.jetbrains.annotations.NotNull
    public br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.FilmResponse fetchId(@org.springframework.web.bind.annotation.PathVariable
    int id) {
        return null;
    }
}