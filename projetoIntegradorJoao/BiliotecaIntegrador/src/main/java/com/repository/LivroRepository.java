package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.model.Livro;

@Repository                                            
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
