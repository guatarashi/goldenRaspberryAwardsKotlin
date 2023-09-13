package br.com.atarashi.goldenRaspberryAwardsKotlin.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lbr/com/atarashi/goldenRaspberryAwardsKotlin/service/FilmService;", "", "delete", "", "id", "", "findAll", "", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/controller/response/FilmResponse;", "findId", "insert", "filmRequest", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/controller/request/FilmRequest;", "premiosConsecutivos", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/controller/response/IntervaloPremioResponse;", "goldenRaspberryAwardsKotlin"})
public abstract interface FilmService {
    
    public abstract void insert(@org.jetbrains.annotations.NotNull
    br.com.atarashi.goldenRaspberryAwardsKotlin.controller.request.FilmRequest filmRequest);
    
    public abstract void delete(int id);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.FilmResponse> findAll();
    
    @org.jetbrains.annotations.NotNull
    public abstract br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.FilmResponse findId(int id);
    
    @org.jetbrains.annotations.NotNull
    public abstract br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.IntervaloPremioResponse premiosConsecutivos();
}