package com.nathan.example.explorecali.data.repo;

import com.nathan.example.explorecali.data.entity.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel="packages", path="packages")
public interface TourPackageRepository extends CrudRepository<TourPackage, Integer> {
    @Override
    @RestResource(exported=false)
    <S extends TourPackage> List<S> saveAll(Iterable<S> entities);

//    @Override
//    @RestResource(exported=false)
//    <S extends TourPackage> S saveAndFlush(S entity);

//    @Override
//    @RestResource(exported=false)
//    void deleteInBatch(Iterable<TourPackage> entities);
//
//    @Override
//    @RestResource(exported=false)
//    void deleteAllInBatch();

    @Override
    @RestResource(exported=false)
    <S extends TourPackage> S save(S entity);

    @Override
    @RestResource(exported=false)
    void deleteById(Integer integer);

    @Override
    @RestResource(exported=false)
    void delete(TourPackage entity);

    @Override
    @RestResource(exported=false)
    void deleteAll(Iterable<? extends TourPackage> entities);

    @Override
    @RestResource(exported=false)
    void deleteAll();
}
