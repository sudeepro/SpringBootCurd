package com.sudeep.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudeep.app.entity.RegisterEntity;

public interface RegisterDao extends JpaRepository<RegisterEntity,Serializable> {
}
