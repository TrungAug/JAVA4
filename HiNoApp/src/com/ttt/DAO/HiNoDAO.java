/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.DAO;

import java.util.List;

/**
 *
 * @author ASUS
 * @param <EntityType>
 * @param <KeyType>
 */
abstract public class HiNoDAO<EntityType, KeyType> {

    abstract public void insert(EntityType e);

    abstract public void update(EntityType e);

    abstract public void delete(KeyType id);

    abstract public EntityType selectById(KeyType id);

    abstract public List<EntityType> selectAll();

    abstract protected List<EntityType> selectBySql(String sql, Object... args);

}
