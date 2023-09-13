package br.com.atarashi.goldenRaspberryAwardsKotlin.repository;

@org.springframework.stereotype.Repository
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\'J\u0012\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002H\'\u00a8\u0006\u000e"}, d2 = {"Lbr/com/atarashi/goldenRaspberryAwardsKotlin/repository/FilmRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lbr/com/atarashi/goldenRaspberryAwardsKotlin/repository/model/Film;", "", "delete", "", "id", "", "findAll", "", "findByWinner", "findId", "insert", "film", "goldenRaspberryAwardsKotlin"})
public abstract interface FilmRepository extends org.springframework.data.jpa.repository.JpaRepository<br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.Film, java.lang.Long> {
    
    @org.springframework.data.jpa.repository.Modifying
    @jakarta.transaction.Transactional
    @org.springframework.data.jpa.repository.Query(value = "INSERT INTO film (`year`, title, studios, producers, winner) VALUES (:#{#film.year},:#{#film.title},:#{#film.studios},:#{#film.producers},:#{#film.winner})", nativeQuery = true)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.Film film);
    
    @org.springframework.data.jpa.repository.Modifying
    @jakarta.transaction.Transactional
    @org.springframework.data.jpa.repository.Query(value = "delete from film where id = :id", nativeQuery = true)
    public abstract void delete(@org.springframework.data.repository.query.Param(value = "id")
    int id);
    
    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM film f order by `year`", nativeQuery = true)
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.Film> findAll();
    
    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM film f where id = :id order by `year`", nativeQuery = true)
    @org.jetbrains.annotations.NotNull
    public abstract br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.Film findId(@org.springframework.data.repository.query.Param(value = "id")
    int id);
    
    @org.springframework.data.jpa.repository.Query(value = "SELECT * FROM film f where winner = \'yes\'", nativeQuery = true)
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.Film> findByWinner();
}