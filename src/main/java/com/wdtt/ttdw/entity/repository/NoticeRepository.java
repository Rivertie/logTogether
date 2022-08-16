package com.wdtt.ttdw.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wdtt.ttdw.entity.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
