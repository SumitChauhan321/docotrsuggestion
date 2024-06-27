package com.cetpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cetpa.entities.DoctorEntity;

public interface DoctorRepository extends JpaRepository<DoctorEntity,Integer>
{
   @Query("from DoctorEntity where city=:arg1 and speciality=:arg2")
   List<DoctorEntity> getDoctorList(@Param("arg1") String city,@Param("arg2") String speciality);
   @Query("from DoctorEntity")
   List<DoctorEntity> doctorList();
}
