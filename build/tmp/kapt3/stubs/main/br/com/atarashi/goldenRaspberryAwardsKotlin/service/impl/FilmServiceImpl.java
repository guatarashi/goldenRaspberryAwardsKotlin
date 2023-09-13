package br.com.atarashi.goldenRaspberryAwardsKotlin.service.impl;

@org.springframework.stereotype.Service
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lbr/com/atarashi/goldenRaspberryAwardsKotlin/service/impl/FilmServiceImpl;", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/service/FilmService;", "filmRepository", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/repository/FilmRepository;", "filmFacade", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/facade/FilmFacade;", "filmMapper", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/mapper/FilmMapper;", "(Lbr/com/atarashi/goldenRaspberryAwardsKotlin/repository/FilmRepository;Lbr/com/atarashi/goldenRaspberryAwardsKotlin/facade/FilmFacade;Lbr/com/atarashi/goldenRaspberryAwardsKotlin/mapper/FilmMapper;)V", "delete", "", "id", "", "findAll", "", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/controller/response/FilmResponse;", "findId", "insert", "filmRequest", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/controller/request/FilmRequest;", "premiosConsecutivos", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/controller/response/IntervaloPremioResponse;", "goldenRaspberryAwardsKotlin"})
public class FilmServiceImpl implements br.com.atarashi.goldenRaspberryAwardsKotlin.service.FilmService {
    @org.jetbrains.annotations.NotNull
    private final br.com.atarashi.goldenRaspberryAwardsKotlin.repository.FilmRepository filmRepository = null;
    @org.jetbrains.annotations.NotNull
    private final br.com.atarashi.goldenRaspberryAwardsKotlin.facade.FilmFacade filmFacade = null;
    @org.jetbrains.annotations.NotNull
    private final br.com.atarashi.goldenRaspberryAwardsKotlin.mapper.FilmMapper filmMapper = null;
    
    public FilmServiceImpl(@org.jetbrains.annotations.NotNull
    br.com.atarashi.goldenRaspberryAwardsKotlin.repository.FilmRepository filmRepository, @org.jetbrains.annotations.NotNull
    br.com.atarashi.goldenRaspberryAwardsKotlin.facade.FilmFacade filmFacade, @org.jetbrains.annotations.NotNull
    br.com.atarashi.goldenRaspberryAwardsKotlin.mapper.FilmMapper filmMapper) {
        super();
    }
    
    @java.lang.Override
    public void insert(@org.jetbrains.annotations.NotNull
    br.com.atarashi.goldenRaspberryAwardsKotlin.controller.request.FilmRequest filmRequest) {
    }
    
    @java.lang.Override
    public void delete(int id) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.util.List<br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.FilmResponse> findAll() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.FilmResponse findId(int id) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.IntervaloPremioResponse premiosConsecutivos() {
        return null;
    }
}