package br.com.atarashi.goldenRaspberryAwardsKotlin.controller;

@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping(value = {"films"})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lbr/com/atarashi/goldenRaspberryAwardsKotlin/controller/FilmPremiosConsecutivosController;", "", "filmService", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/service/FilmService;", "(Lbr/com/atarashi/goldenRaspberryAwardsKotlin/service/FilmService;)V", "premiosConsecutivos", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/controller/response/IntervaloPremioResponse;", "goldenRaspberryAwardsKotlin"})
public class FilmPremiosConsecutivosController {
    @org.jetbrains.annotations.NotNull
    private final br.com.atarashi.goldenRaspberryAwardsKotlin.service.FilmService filmService = null;
    
    public FilmPremiosConsecutivosController(@org.jetbrains.annotations.NotNull
    br.com.atarashi.goldenRaspberryAwardsKotlin.service.FilmService filmService) {
        super();
    }
    
    @org.springframework.web.bind.annotation.GetMapping(value = {"premios-consecutivos"})
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.jetbrains.annotations.NotNull
    public br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.IntervaloPremioResponse premiosConsecutivos() {
        return null;
    }
}