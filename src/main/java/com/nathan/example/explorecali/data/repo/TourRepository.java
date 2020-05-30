package com.nathan.example.explorecali.data.repo;

import com.nathan.example.explorecali.data.entity.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel="tours", path="tours")
public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {

    /**
     * Lookup a Page of Tours associated with a TourPackage
     *
     * @param id the tour Package code.
     * @param pageable details for finding the correct page.
     * @return A page of tours if found, empty otherwise.
     */
    Page<Tour> findByTourPackageId(@Param("id") Integer id, Pageable pageable);

    @Override
    @RestResource(exported=false)
    <S extends Tour> S save(S entity);

    @Override
    @RestResource(exported=false)
    <S extends Tour> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    @RestResource(exported=false)
    void deleteById(Integer integer);

    @Override
    @RestResource(exported=false)
    void delete(Tour entity);

    @Override
    @RestResource(exported=false)
    void deleteAll(Iterable<? extends Tour> entities);

    @Override
    @RestResource(exported=false)
    void deleteAll();
}
